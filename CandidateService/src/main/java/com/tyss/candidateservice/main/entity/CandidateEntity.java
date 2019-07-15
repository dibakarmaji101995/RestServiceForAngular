package com.tyss.candidateservice.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CANDIDATE")
public class CandidateEntity {
     @Id	
     @Column(name="CANDIDATE_ID",length=5)
     private Integer candidateId;
     
     @Column(name="NAME",length=30)
     private String name;
     
     @Column(name="CURRENT_COMPANY",length=30)
     private String currentCompany;
     
     @Column(name="SALARY",length=10)
     private Double salary;
     
     @Column(name="EXPECTED_SALARY",length=10)
     private Double expectedSalary;
}
