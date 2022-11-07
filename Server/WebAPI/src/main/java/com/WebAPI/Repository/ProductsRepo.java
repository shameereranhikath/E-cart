package com.WebAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.WebAPI.entity.Products;

@Repository
@EnableJpaRepositories
public interface ProductsRepo extends JpaRepository<Products, Integer> 
{
//	@Query(value= "{call findproductinbetween(:max, :min)}",nativeQuery=true)
//	public List<Products> findallproductbetween(@Param("min")int pr1,@Param("max")int pr2);
	
	
}