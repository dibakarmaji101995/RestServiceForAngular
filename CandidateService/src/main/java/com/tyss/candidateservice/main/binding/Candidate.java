package com.tyss.candidateservice.main.binding;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement(name="candidate")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Candidate {
     private Integer candidateId;
     private String name;
     private String currentCompany;
     private Double salary;
     private Double expectedSalary;
}
