package com.sid.dao;

import com.sid.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
