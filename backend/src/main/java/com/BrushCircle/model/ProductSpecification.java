package com.BrushCircle.model;

import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification implements Specification<Product> {
    private Product filter;

    public ProductSpecification(Product filter) {
        super();
        this.filter = filter;
    }

    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> cq,
                                 CriteriaBuilder cb) {

        Predicate p = cb.disjunction();

        if (filter.getTitle() != null) {
            p.getExpressions().add(cb.equal(root.get("title"), filter.getTitle()));
        }

        if (filter.getDate() != null) {
            p.getExpressions().add(cb.equal(root.get("date"), filter.getDate()));
        }

//        if (filter.getPrice() != 0) {
//            p.getExpressions().add(cb.equal(root.get("price"), filter.getPrice()));
//        }

        if (filter.getStyle() != null) {
            p.getExpressions().add(cb.equal(root.get("style"), filter.getStyle()));
        }

//        if (filter.isFeatured() != NO) {
//            p.getExpressions().add(cb.equal(root.get("featured"), filter.getTitle()));
//        }

//        if (filter.getDescription() != null) {
//            p.getExpressions().add(cb.equal(root.get("description"), filter.getDescription()));
//        }

//        if (filter.getWidth() != null) {
//            p.getExpressions().add(cb.equal(root.get("width"), filter.getTitle()));
//        }

//        if (filter.getTitle() != null) {
//            p.getExpressions().add(cb.equal(root.get("length"), filter.getTitle()));
//        }

        if (filter.getTags() != null) {
            p.getExpressions().add(cb.equal(root.get("tags"), filter.getTags()));
        }

        if (filter.getFilename() != null) {
            p.getExpressions().add(cb.equal(root.get("filename"), filter.getFilename()));
        }

        if (filter.getUser() != null) {
            p.getExpressions().add(cb.equal(root.get("user"), filter.getUser()));
        }


        return p;

    }
}
