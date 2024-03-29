package com.targetindia.miniproject.dao;

public class DaoException extends Exception{
    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String errorFetchingCustomerByEmail, Exception e) {
    }
}
