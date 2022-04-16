package tn.dari.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Property;
@Repository
public interface PropertyRepository  extends JpaRepository<Property, Long>{

}
