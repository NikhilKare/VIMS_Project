package com.app.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Policy;
import com.app.repository.IPolicyRepository;

@Service
@Transactional
public class ProviderService implements IProviderService{
	@Autowired
	private IPolicyRepository policyRepo;
	
	@Override
	public boolean addPolicy(Policy policy){
		try {
			policy.setPolicyDate(LocalDate.now());
			policyRepo.save(policy);
			
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
