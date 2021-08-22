package com.app.identity.repository;

import com.app.identity.model.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentityRepository extends JpaRepository<Identity, Long> {
    Identity findByFirstName (String FirstName);
    List<Identity> findAll();
    Identity findByIdentityId(String identityId);
}
