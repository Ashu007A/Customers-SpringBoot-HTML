package com.assignment.customers.repositories;
import com.assignment.customers.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom query method for searching customers based on a keyword
    @Query("SELECT c FROM Customer c " +
            "WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.email) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.phone) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Customer> findByKeyword(@Param("keyword") String keyword, Pageable pageable);

    Customer findByUsername(String username);

    Customer findByUuid(String uuid);
}

