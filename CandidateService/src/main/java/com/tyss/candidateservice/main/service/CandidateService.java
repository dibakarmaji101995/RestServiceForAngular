package com.tyss.candidateservice.main.service;


import java.util.List;

import com.tyss.candidateservice.main.binding.Candidate;
import com.tyss.candidateservice.main.entity.CandidateEntity;



public interface CandidateService {
	
	public List<Candidate> getAllCandidateDetails();
     
	public CandidateEntity getCandidateDetailsById(Integer id);
	
	public Integer saveCandidateDetails(Candidate candidate);
	
	public Integer updateCandidateDetailsById(Candidate candidate,Integer id);
	
	public Integer deleteCandidateById(Integer id);
}
