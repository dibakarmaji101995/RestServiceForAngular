package com.tyss.candidateservice.main.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tyss.candidateservice.main.entity.CandidateEntity;

@Repository(value="candidateRepo")
public interface CandidateRepository extends JpaRepository<CandidateEntity,Serializable>{
	@Modifying
    @Query(value="UPDATE CandidateEntity SET name=:name,currentCompany=:currentCompany,salary=:salary,expectedSalary=:expectedSalary where candidateId=:id")
	public Integer updateCandidateByCandidateId(String name,String currentCompany,Double salary,Double expectedSalary,Integer id);
	
	@Transactional
	@Modifying
	@Query(value="DELETE from CandidateEntity where candidateId=:id")
	public Integer deleteCandidateByCandidateId(Integer id);
}
