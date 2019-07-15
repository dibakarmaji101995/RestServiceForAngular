package com.tyss.candidateservice.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.candidateservice.main.binding.Candidate;
import com.tyss.candidateservice.main.entity.CandidateEntity;
import com.tyss.candidateservice.main.repository.CandidateRepository;

@Service(value="candidateService")
public class CandidateServiceImpl implements CandidateService {
	@Autowired
    private CandidateRepository repo;
	@Override
	public CandidateEntity getCandidateDetailsById(Integer id) {
		Optional<CandidateEntity> opt=null;
		CandidateEntity entity=null;
		//get candidate details by id
		opt=repo.findById(id);
		//get candidateEntity object from Optional object
		entity=opt.get();
		//return entity object
		return entity;
	}
	@Override
	public Integer saveCandidateDetails(Candidate candidate) {
		CandidateEntity entity=null;
		Integer count=0;
		//convert candidate object to entity object
		entity=new CandidateEntity();
		BeanUtils.copyProperties(candidate, entity);
		//save candidate details
		entity=repo.save(entity);
		count=entity==null?0:1;
		//return the count
		return count;
	}
	@Override
	public Integer updateCandidateDetailsById(Candidate candidate, Integer id) {
		Integer count=0;
		// update candidate details
		count=repo.updateCandidateByCandidateId(candidate.getName(),candidate.getCurrentCompany(),candidate.getSalary(),candidate.getExpectedSalary(),id);
		//return count
		return count;
	}
	@Override
	public Integer deleteCandidateById(Integer id) {
		Integer count=0;
		// delete candidate details by id
		count=repo.deleteCandidateByCandidateId(id);
		//return count
		return count;
	}
	@Override
	public List<Candidate> getAllCandidateDetails() {
		List<Candidate> candidateList=new ArrayList<Candidate>();
		List<CandidateEntity> entityList=null;
		// get all candidate details
		entityList=repo.findAll();
		//convert entityList to candidateList
		entityList.forEach(entity->{
			//crete candidate class object
			Candidate candidate=new Candidate();
			BeanUtils.copyProperties(entity, candidate);
			//add cadidate object to list object
			candidateList.add(candidate);
		});
		//return candidateList
		return candidateList;
	}

}
