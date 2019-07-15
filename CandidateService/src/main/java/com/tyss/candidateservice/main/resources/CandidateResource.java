package com.tyss.candidateservice.main.resources;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.candidateservice.main.binding.Candidate;
import com.tyss.candidateservice.main.entity.CandidateEntity;
import com.tyss.candidateservice.main.service.CandidateService;


@RestController
public class CandidateResource {
	 @Autowired
     private CandidateService service;
	 
	 @GetMapping(value="/getAll",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	 public ResponseEntity<List<Candidate>> getAllCandidate() {
		 List<Candidate> candidateList=null;
		 //invoke service class method
		 candidateList=service.getAllCandidateDetails();
		 //return response object with list object
		 return new ResponseEntity<List<Candidate>>(candidateList, HttpStatus.OK);
	 }
     
     @GetMapping(value="/candidateByID/{id}",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
     public ResponseEntity<Candidate> getCandidateById(@PathVariable Integer id){
    	 CandidateEntity entity=null;
    	 Candidate candidate=null;
    	 //get candidate details by id
    	 entity=service.getCandidateDetailsById(id);
    	 //convert entity to candidate object
    	 candidate=new Candidate();
    	 BeanUtils.copyProperties(entity, candidate);
    	 //return response object with candidate object
    	 return new ResponseEntity<Candidate>(candidate,HttpStatus.OK);
     }
     
     @PostMapping(value="/saveCandidate",consumes=MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<String> insertCandidateDetails(@RequestBody Candidate candidate){
    	 Integer count=0;
    	 String msg=null;
    	 //invoke service class method
    	 count=service.saveCandidateDetails(candidate);
    	 //return resonse object with msg
    	 msg=count==0?"Candidate details are not saved":"Candidate details are saved";
    	 return new ResponseEntity<String>(msg,HttpStatus.OK);
     }
     @PutMapping(value="/updateCandidate/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<String> updateCandidateDetailsById(@RequestBody Candidate candidate,@PathVariable Integer id){
    	 Integer count=0;
    	 String msg=null;
    	 //invoke service class method
    	 count=service.saveCandidateDetails(candidate);
    	 //return resonse object with msg
    	 msg=count==0?"Candidate details are not updated":"Candidate details are updated";
    	 return new ResponseEntity<String>(msg,HttpStatus.OK);
     }
     @DeleteMapping(value="/deleteCandidate/{id}")
     public ResponseEntity<String> deleteCandidateDetailsById(@PathVariable Integer id){
    	 Integer count=0;
    	 String msg=null;
    	    // invoke service class method
    	    count=service.deleteCandidateById(id);
    	    //return response object with msg
    	    msg=count==0?"Candidate details are not deleted":"Candidate details are deleted";
    	    return new ResponseEntity<String>(msg, HttpStatus.OK);
     }
}
