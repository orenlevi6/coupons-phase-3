package com.jb.couponsphase3.repositories;

import com.jb.couponsphase3.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

    Optional<Company> findByIdAndName(int id, String name);

    Optional<Company> findByEmailAndPassword(String email, String password);
}
