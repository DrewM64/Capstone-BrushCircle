package com.BrushCircle.model;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecification implements Specification<User> {
    private User filter;

    public UserSpecification(User filter) {
        super();
        this.filter = filter;
    }

    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq,
                                 CriteriaBuilder cb) {

        Predicate p = cb.disjunction();

        if (filter.getEmail() != null) {
            p.getExpressions().add(cb.equal(root.get("email"), filter.getEmail()));
        }

        if (filter.getFirstName() != null) {
            p.getExpressions().add(cb.equal(root.get("firstName"), filter.getFirstName()));
        }

        if (filter.getLastName() != null) {
            p.getExpressions().add(cb.equal(root.get("lastName"), filter.getLastName()));
        }

        return p;

    }
}
