package com.aureole.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aureole.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
	CategoryEntity findOneById(int id);
	@Query(
			  value = "SELECT * FROM CATEGORY WHERE TYPENAME = ?", 
			  nativeQuery = true)
	CategoryEntity findOneByName(String name);
	
	@Query(
			  value = "SELECT * FROM CATEGORY", 
			  nativeQuery = true)
	List<CategoryEntity> findAllCategory();
}
