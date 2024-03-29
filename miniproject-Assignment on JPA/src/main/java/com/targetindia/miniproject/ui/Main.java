package com.targetindia.miniproject.ui;

import com.targetindia.miniproject.model.Customer;
import com.targetindia.miniproject.service.CustomerManager;
import com.targetindia.miniproject.service.ServiceException;
import com.targetindia.miniproject.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.InputMismatchException;
import java.util.List;
@Slf4j
public class Main {

    // this has a dependency on the CustomerManager
    CustomerManager cm;

    public Main()  {
        try {
            cm = new CustomerManager();
        } catch (ServiceException e) {
            log.warn("error while creating CustomerManager", e);
            System.out.println("Sorry. There wan an error. Please check logs.");
            System.exit(1);
        }
    }


    int menu(){
        System.out.println("==== Main Menu ====");
        System.out.println("0. Exit");
        System.out.println("1. List all customers");
        System.out.println("2. Add a new customer");
        System.out.println("3. Search customer by id");
        System.out.println("4. Search customer by email");
        System.out.println("5. Search customer by phone");
        System.out.println("6. Search customers by city");
        try {
            return KeyboardUtil.getInt("Enter your choice: ");
        }
        catch(InputMismatchException e){
            log.warn("There wan error while accepting the menu choice", e);
            return -1;
        }
    }

    void start(){
        int choice;

        while((choice=menu())!=0){
            log.trace("user made a choice {}", choice);

            switch (choice){
                case 1:
                    displayCustomerList();
                    break;
                case 2:
                    addNewCustomerData();
                    break;
                case 3:
                    searchAndDisplayCustomerByID();
                    break;
                case 4:
                    searchAndDisplayCustomerByEmail();
                    break;
                case 5:
                    searchAndDisplayCustomerByPhone();
                    break;
                case 6:
                    searchAndDisplayCustomerByCity();
                    break;
                default:
                    System.out.println("Invalid choice. Please retry.");
            }
        }
    }



    private void searchAndDisplayCustomerByCity() {
        try {
            System.out.println("Enter city of customers to be searched: ");
            String city = KeyboardUtil.getString("City:  ");
            List<Customer> customers = cm.getCustomerByCity(city);
            if (!customers.isEmpty()) {
                System.out.println("Customers found in " + city + ":");
                for (Customer c : customers) {
                    System.out.println(c); // Assuming Customer class has a proper toString() method
                }
            } else {
                System.out.println("No customers found in " + city + ".");
            }
        } catch (ServiceException e) {
            throw new RuntimeException("Error while searching for customers by city", e);
        }
    }


    private void searchAndDisplayCustomerByPhone() {
        try {
            System.out.println("Enter phone number of customer to be searched: ");
            String phone = KeyboardUtil.getString("Phone:  ");
            Customer c = cm.getCustomerByPhone(phone);
            if (c != null) {
                System.out.println("Customer found:");
                System.out.println(c);
            } else {
                System.out.println("Customer with phone " + phone + " not found.");
            }
        } catch (ServiceException e) {
            throw new RuntimeException("Error while searching for customer", e);
        }
    }

    private void searchAndDisplayCustomerByEmail() {
        try {
            System.out.println("Enter Email of customer to be searched: ");
            String email = KeyboardUtil.getString("Email:  ");
            Customer c = cm.getCustomerByEmail(email);
            if (c != null) {
                System.out.println("Customer found:");
                System.out.println(c);
            } else {
                System.out.println("Customer with email " + email + " not found.");
            }
        } catch (ServiceException e) {
            throw new RuntimeException("Error while searching for customer", e);
        }
    }

    private void searchAndDisplayCustomerByID() {
        try {
            System.out.println("Enter ID of customer to be searched: ");
            int id = KeyboardUtil.getInt("ID:  ");
            Customer c = cm.getCustomerById(id);
            if (c != null) {
                System.out.println("Customer found:");
                System.out.println(c);
            } else {
                System.out.println("Customer with ID " + id + " not found.");
            }
        } catch (ServiceException e) {
            throw new RuntimeException("Error while searching for customer", e);
        }
    }



    void addNewCustomerData() {
        try{
            System.out.println("Enter new customer details: ");
            // accept data from the user: name, city, email, phone
            String name = KeyboardUtil.getString("Name  : ");
            String city = KeyboardUtil.getString("City  : ");
            String email = KeyboardUtil.getString("Email : ");
            String phone = KeyboardUtil.getString("Phone : ");

            // create customer object
            Customer customer = new Customer(null, name, city, email, phone);

            // call the service method to add new customer
            customer = cm.addNewCustomer(customer);
            System.out.println("New customer added successfully with id: " + customer.getId());
        }
        catch(ServiceException e){
            // show errors to user in a user friendly manner
            log.warn("error while adding new user in the UI", e);
            System.out.println("Something went wrong. Please check logs.");
        }
    }

    void displayCustomerList() {
        try {
            var customers = cm.getAll();
            System.out.printf("%4s|%-20s|%-15s|%-25s|%-15s\n", "ID", "Name", "City", "Email", "Phone");
            System.out.println("-----------------------------------------------------------------------------------");
            for(var c: customers){
                System.out.printf("%4d|%-20s|%-15s|%-25s|%-15s\n",
                        c.getId(),
                        c.getName(),
                        c.getCity(),
                        c.getEmail(),
                        c.getPhone());
            }
            System.out.println("-----------------------------------------------------------------------------------");


        } catch (ServiceException e) {
            System.out.println("Something went wrong. Check the logs or contact tech support");
            log.warn("there was an error while calling cm.getAll()", e);
        }
    }

    public static void main(String[] args) {
        log.trace("starting the app...");
        new Main().start();
        log.trace("ending the app.");
    }

}
