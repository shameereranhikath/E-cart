package com.WebAPI.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.WebAPI.entity.Productimages;

@Repository
@EnableJpaRepositories
public interface  ProductimagesRepo  extends JpaRepository<Productimages,Integer>  
{
	Optional<Productimages> findByName(String name);
}
