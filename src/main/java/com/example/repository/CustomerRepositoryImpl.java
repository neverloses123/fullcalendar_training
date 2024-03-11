package com.example.repository;

import com.example.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

/**
 * @author 2400048
 */
public class CustomerRepositoryImpl implements CustomerRepositoryCustomized{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAllDetail(Customer customer)
    {

        StringBuilder sb = new StringBuilder();
        sb.append(
                "select * from customer where 1=1"
        );

        Query query = (Query) entityManager.createNativeQuery(sb.toString());
        List<Customer> result =query.getResultList();

        return result;
    }

}
