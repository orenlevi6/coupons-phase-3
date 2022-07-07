package com.jb.couponsphase3.services.serviceDAO;

import com.jb.couponsphase3.beans.Company;
import com.jb.couponsphase3.beans.Customer;
import com.jb.couponsphase3.exceptions.NotExistException;

import java.util.List;

public interface AdminService {

    int addCompany(Company company) throws NotExistException;

    void updateCompany(Company company) throws NotExistException;

    void deleteCompany(int companyID) throws NotExistException;

    List<Company> getAllCompanies() throws NotExistException;

    Company getCompanyByID(int companyID) throws NotExistException;

    int addCustomer(Customer customer) throws NotExistException;

    void updateCustomer(Customer customer) throws NotExistException;

    void deleteCustomer(int customerID) throws NotExistException;

    List<Customer> getAllCustomers() throws NotExistException;

    Customer getCustomerByID(int customerID) throws NotExistException;
}
