package com.aureole.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.aureole.entity.BookMemberEntity;

@Repository
public interface BookMemberRepository extends JpaRepository<BookMemberEntity, Integer> {
	
	@Query(
			  value = "SELECT * FROM borrow_info", 
			  nativeQuery = true)
	List<BookMemberEntity> findAllInfo();

	@Query(
			  value = "SELECT * FROM borrow_info WHERE ID = ?", 
			  nativeQuery = true)
	BookMemberEntity findInfoByID(int id);
	
	@Modifying
	@Query(
			  value = "DELETE FROM borrow_info WHERE id = ?", 
			  nativeQuery = true)
	void deleteOneById(int id);
}
