package com.aureole.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aureole.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> { //<bảng dữ liệu muốn thao tác, kiểu dữ liệu của khóa chính>
	
	@Query(
			  value = "SELECT * FROM Book ORDER BY bookname ASC ", 
			  nativeQuery = true)
	List<BookEntity> findAll();
	@Query(
			  value = "SELECT * FROM Book WHERE id = ?", 
			  nativeQuery = true)
	BookEntity findOneByID(int id);
	
	@Modifying
	@Query(
			  value = "DELETE FROM Book WHERE id = ?", 
			  nativeQuery = true)
	void deleteOneById(int id);
	
	@Query(
			  value = "SELECT * FROM Book WHERE bookname LIKE %?1% ", 
			  nativeQuery = true)
	List<BookEntity> findBookByName(String name);
	
	
}
