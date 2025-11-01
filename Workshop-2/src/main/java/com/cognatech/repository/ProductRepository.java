package com.cognatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognatech.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	//JpaRepository -> LISTCRUDREPO -> CrudRepository
	
	
}
