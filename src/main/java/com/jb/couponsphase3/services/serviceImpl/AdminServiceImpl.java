package com.jb.couponsphase3.services.serviceImpl;

import com.jb.couponsphase3.beans.Company;
import com.jb.couponsphase3.beans.Customer;
import com.jb.couponsphase3.exceptions.ExceptionType;
import com.jb.couponsphase3.exceptions.NotExistException;
import com.jb.couponsphase3.services.ClientService;
import com.jb.couponsphase3.services.serviceDAO.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl extends ClientService implements AdminService {
    /**
     * Performs a login check for admin
     *
     * @param email    Login email
     * @param password Login password
     * @return boolean that determines if the login was successful
     */
    @Override
    public boolean login(String email, String password) {
        return email.equals("admin@admin.com") && password.equals("admin");
    }

    /**
     * Adds a company to the database
     *
     * @param company Full company instance that will be added to the database
     * @return company ID in order to assign to company in redux
     */
    @Override
    public int addCompany(Company company) throws NotExistException {
        companyRepo.save(company);

        Optional<Company> optionalCompany = companyRepo.findById(company.getId());
        if (optionalCompany.isEmpty()) {
            throw new NotExistException(ExceptionType.COMPANY);
        }
        return optionalCompany.get().getId();
    }

    /**
     * Updates a company in the database
     *
     * @param company Full company instance that updated be updated in the database
     * @throws NotExistException If the company's ID and name does not exist in the database
     */
    @Override
    public void updateCompany(Company company) throws NotExistException {
        Optional<Company> optionalCompany = companyRepo.findByIdAndName(company.getId(), company.getName());
        if (optionalCompany.isEmpty()) {
            throw new NotExistException(ExceptionType.COMPANY);
        }
        optionalCompany.get().setEmail(company.getEmail());
        companyRepo.save(optionalCompany.get());
    }

    /**
     * Deletes a company from the database
     *
     * @param companyID The ID of the company that will be deleted
     * @throws NotExistException If the company's ID does not exist in the database
     */
    @Override
    public void deleteCompany(int companyID) throws NotExistException {
        if (!companyRepo.existsById(companyID)) {
            throw new NotExistException(ExceptionType.COMPANY);
        }
        couponRepo.deleteCompanyCoupons(companyID);
        companyRepo.deleteById(companyID);
    }

    /**
     * Gets all companies from the database
     *
     * @return A list of all the companies that exist in the database
     * @throws NotExistException If no companies exist in the database
     */
    @Override
    public List<Company> getAllCompanies() throws NotExistException {
        List<Company> companies = companyRepo.findAll();
        if (companies.isEmpty()) {
            throw new NotExistException(ExceptionType.COMPANY);
        }
        return companies;
    }

    /**
     * Gets a single company from the database by ID
     *
     * @param companyID The ID of the company that will be retrieved from the database
     * @return The details of the company that will be retrieved from the database
     * @throws NotExistException If the company's ID does not exist in the database
     */
    @Override
    public Company getCompanyByID(int companyID) throws NotExistException {
        return companyRepo.findById(companyID)
                .orElseThrow(() -> new NotExistException(ExceptionType.COMPANY));
    }

    /**
     * Adds a customer to the database
     *
     * @param customer Full customer instance that will be added to the database
     * @return customer ID in order to assign to customer in redux
     */
    @Override
    public int addCustomer(Customer customer) throws NotExistException {
        customerRepo.save(customer);

        Optional<Customer> optionalCustomer = customerRepo.findById(customer.getId());
        if (optionalCustomer.isEmpty()) {
            throw new NotExistException(ExceptionType.CUSTOMER);
        }
        return optionalCustomer.get().getId();
    }

    /**
     * Updates a customer in the database
     *
     * @param customer Full customer instance that will be updated in the database
     * @throws NotExistException If the customer's ID does not exist in the database
     */
    @Override
    public void updateCustomer(Customer customer) throws NotExistException {
        Optional<Customer> optionalCustomer = customerRepo.findById(customer.getId());
        if (optionalCustomer.isEmpty()) {
            throw new NotExistException(ExceptionType.CUSTOMER);
        }

        optionalCustomer.get().setFirstName(customer.getFirstName());
        optionalCustomer.get().setLastName(customer.getLastName());
        optionalCustomer.get().setEmail(customer.getEmail());
        customerRepo.save(optionalCustomer.get());
    }

    /**
     * Deletes a customer from the database
     *
     * @param customerID The ID of the customer that will be deleted
     * @throws NotExistException If the customer's ID does not exist in the database
     */
    @Override
    public void deleteCustomer(int customerID) throws NotExistException {
        if (!customerRepo.existsById(customerID)) {
            throw new NotExistException(ExceptionType.CUSTOMER);
        }
        couponRepo.deleteCouponPurchaseByCustomerID(customerID);
        customerRepo.deleteById(customerID);
    }

    /**
     * Gets all customers from the database
     *
     * @return A list of all the customers that exist in the database
     * @throws NotExistException If no customers exist in the database
     */
    @Override
    public List<Customer> getAllCustomers() throws NotExistException {
        List<Customer> customers = customerRepo.findAll();
        if (customers.isEmpty()) {
            throw new NotExistException(ExceptionType.CUSTOMER);
        }
        return customers;
    }

    /**
     * Gets a single customer from the database by ID
     *
     * @param customerID The ID of the customer that will be retrieved from the database
     * @return The details of the customer that will be retrieved from the database
     * @throws NotExistException If the customer's ID does not exist in the database
     */
    @Override
    public Customer getCustomerByID(int customerID) throws NotExistException {
        return customerRepo.findById(customerID)
                .orElseThrow(() -> new NotExistException(ExceptionType.CUSTOMER));
    }

}
