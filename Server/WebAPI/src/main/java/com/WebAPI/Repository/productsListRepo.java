package com.WebAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import com.WebAPI.entity.productsList;

@Repository
@EnableJpaRepositories
public interface productsListRepo extends JpaRepository<productsList, Integer> 
{
//	@Query(value= "{call findproductinbetween(:max, :min)}",nativeQuery=true)
//	public List<Products> findallproductbetween(@Param("min")int pr1,@Param("max")int pr2);
	
	
}