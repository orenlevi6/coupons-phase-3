package com.jb.couponsphase3.repositories;

import com.jb.couponsphase3.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmailAndPassword(String email, String password);
}
