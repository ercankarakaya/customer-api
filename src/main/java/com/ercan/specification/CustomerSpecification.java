package com.ercan.specification;

import com.ercan.entity.Customer;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;


public class CustomerSpecification {

    public static Specification<Customer> searchCustomer(String search) {
        return (root, query, criteriaBuilder) -> {
            Predicate customerNumberPredicate = criteriaBuilder.like(root.get("customerNumber"), likePattern(search));
            Predicate fullNamePredicate = criteriaBuilder.like(root.get("fullName"), likePattern(search));
            return criteriaBuilder.or(fullNamePredicate, customerNumberPredicate);
        };
    }

    public static Specification<Customer> hasCustomerNumber(Long customerNumber) {
        return (root, query, criteriaBuilder) -> {
            Predicate customerNumberPredicate = criteriaBuilder.equal(root.get("customerNumber"), customerNumber);
            return criteriaBuilder.and(customerNumberPredicate);
        };
    }

    private static String likePattern(String val) {
        return "%" + val + "%";
    }
}
