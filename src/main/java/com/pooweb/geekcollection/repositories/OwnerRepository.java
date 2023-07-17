package com.pooweb.geekcollection.repositories;

import com.pooweb.geekcollection.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
