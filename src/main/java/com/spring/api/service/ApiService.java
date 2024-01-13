package com.spring.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.entity.StdApi;
import com.spring.api.repo.ApiRepo;

@Service
public class ApiService {

	@Autowired
	ApiRepo re;

	// create api
	public StdApi UserApi(StdApi api) {
		return re.save(api);
	}

	// get single api
	public List<StdApi> getall() {
		return re.findAll();
	}

	// get all apis
	public StdApi getApiById(Long id) {
		Optional<StdApi> optionalApi = re.findById(id);
		return optionalApi.get();
	}

	// update apis 
	public StdApi updateApis(StdApi stdApi) {
		StdApi exitingStdApi  = re.findById(stdApi.getId()).get();
		exitingStdApi.setFirstName(stdApi.getFirstName());
		exitingStdApi.setLastName(stdApi.getLastName());
		exitingStdApi.setEmail(stdApi.getEmail());
		
		StdApi updatedApi = re.save(exitingStdApi);
		return updatedApi;
	}
	
}
