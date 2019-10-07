package com.aureole.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.aureole.entity.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
	
	@Query(
			  value = "SELECT * FROM MEMBER", 
			  nativeQuery = true)
	List<MemberEntity> findAllMember();

	@Query(
			  value = "SELECT * FROM MEMBER WHERE ID = ?", 
			  nativeQuery = true)
	MemberEntity findMemberByID(int id);
	
	@Modifying
	@Query(
			  value = "DELETE FROM MEMBER WHERE id = ?", 
			  nativeQuery = true)
	void deleteOneById(int id);
}
