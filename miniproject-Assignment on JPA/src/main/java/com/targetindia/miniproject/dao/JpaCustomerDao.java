package com.targetindia.miniproject.dao;

import com.targetindia.miniproject.model.Customer;
import com.targetindia.miniproject.utils.JpaUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class JpaCustomerDao implements CustomerDao {
    @Override
    public Customer save(Customer customer) throws DaoException {
        try (var em = JpaUtil.createEntityManager()) {
            var tx = em.getTransaction();
            tx.begin();
            try {
                em.persist(customer);
                tx.commit();
                return customer;
            } catch (Exception e) {
                tx.rollback();
                throw new DaoException(e);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getById(int id) throws DaoException {
        try (var em = JpaUtil.createEntityManager()) {
            var tx = em.getTransaction();
            tx.begin();
            try {
                var c = em.find(Customer.class, id);
                if (c != null) {
                    tx.commit();
                    return c;
                } else {
                    throw new EntityNotFoundException("Customer with id " + id + " not found");
                }
            } catch (Exception e) {
                tx.rollback();
                throw new DaoException(e);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }


    @Override
    public void update(Customer customer) throws DaoException {

    }

    @Override
    public Customer deleteById(int id) throws DaoException {
        return null;
    }

    @Override
    public List<Customer> getAll() throws DaoException {
        try (var em = JpaUtil.createEntityManager()) {
            return em.createQuery("from Customer", Customer.class)
                    .getResultList();
        } catch (Exception e) {
            log.warn("error while calling JpaCustomerDao.getAll()", e);
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getByEmail(String email) throws DaoException {
        try (var em = JpaUtil.createEntityManager()) {
            var tx = em.getTransaction();
            tx.begin();
            try {
                var c = em.find(Customer.class, email);
                if (c != null) {
                    tx.commit();
                    return c;
                } else {
                    throw new EntityNotFoundException("Customer with email " + email + " not found");
                }
            } catch (Exception e) {
                tx.rollback();
                throw new DaoException(e);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer getByPhone(String phone) throws DaoException {
        try (var em = JpaUtil.createEntityManager()) {
            var tx = em.getTransaction();
            tx.begin();
            try {
                var c = em.find(Customer.class, phone);
                if (c != null) {
                    tx.commit();
                    return c;
                } else {
                    throw new EntityNotFoundException("Customer with phone number " + phone + " not found");
                }
            } catch (Exception e) {
                tx.rollback();
                throw new DaoException(e);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override


    public List<Customer> getByCity(String city) throws DaoException {
        try (var em = JpaUtil.createEntityManager()) {
            var tx = em.getTransaction();
            tx.begin();
            try {
                // Use JPQL to query for customers by city
                String jpql = "SELECT c FROM Customer c WHERE c.city = :city";
                TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
                query.setParameter("city", city);
                List<Customer> customers = query.getResultList();

                tx.commit();
                return customers;
            } catch (Exception e) {
                tx.rollback();
                throw new DaoException(e);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

}
