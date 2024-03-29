package com.targetindia.miniproject.service;

import com.targetindia.miniproject.dao.CustomerDao;
import com.targetindia.miniproject.dao.DaoException;
import com.targetindia.miniproject.dao.DaoFactory;
import com.targetindia.miniproject.model.Customer;

import java.util.List;

public class CustomerManager {

    // this class has a dependency on an object of CustomerDao
    private CustomerDao dao;

    public CustomerManager() throws ServiceException {
        // tight coupling of dependency
        // must be converted to a loose coupling
        // this.dao = new CsvFileCustomerDao();
        // this.dao = new ArrayListCustomerDao();

        // here is the solution; loose coupling;
        // CustomerManager asks somebody to give an object of CustomerDao
        try {
            this.dao = DaoFactory.getCustomerDao();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Customer> getAll() throws ServiceException {
        try {
            return dao.getAll();
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public Customer addNewCustomer(Customer customer) throws ServiceException{
        try{
            // we can do some validation here before saving.

            return dao.save(customer);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public Customer getCustomerById(int id) throws ServiceException{
        try{
            return dao.getById(id);
        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
    }
    public Customer getCustomerByPhone(String phone) throws ServiceException{
        try{
            return dao.getByPhone(phone);
        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
    }
    public Customer getCustomerByEmail(String email) throws ServiceException{
        try{
            return dao.getByEmail(email);
        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
    }
    public List<Customer> getCustomerByCity(String city) throws ServiceException{
        try{
            return dao.getByCity(city);
        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
    }
}
