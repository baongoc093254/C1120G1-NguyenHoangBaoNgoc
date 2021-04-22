package com.management.repository.repos_impl;

import com.management.model.Product;
import com.management.repository.ProductRepos;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductReposImpl implements ProductRepos {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        String queryStr = "SELECT p FROM Product AS p";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
    }

    @Override
    public void create(Product product) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void updateById(Product product) {


    }

    @Override
    public void deleteById(Integer id) {
        Product product = entityManager.find(Product.class,id);
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public Product showDetailInfo(Integer id) {
        return null;
    }

    @Override
    public Product findById(Integer id) {
        String queryStr = "SELECT p FROM Product AS p WHERE p.id = :id";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public int getIdProduct() {
        return 0;
    }
}
