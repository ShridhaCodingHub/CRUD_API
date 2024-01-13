package com.spring.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.entity.StdApi;
import com.spring.api.service.ApiService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	ApiService service;

	@RequestMapping("/sayhello")
	public String sayhello() {
		return "hello shubh";
	}

	@PostMapping("/")
	public StdApi UserApi(@RequestBody StdApi api) {
		StdApi sApi = service.UserApi(api);
		return sApi;

	}

	@GetMapping("/{id}")
	public StdApi getApiById(@PathVariable("id") Long id) {
		StdApi api = service.getApiById(id);
		return api;

	}

	@GetMapping("/")
	public List<StdApi> getAllApis() {
		List<StdApi> stdApis = service.getall();
		return stdApis;
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/{id}")
	public List<StdApi> updateApi(@PathVariable("id") Long userId, @RequestBody StdApi stdApi) {

		stdApi.setId(userId);
		StdApi updateStdApi = service.updateApis(stdApi);
		return (List<StdApi>) updateStdApi;
		// return new List<StdApi>(updateStdApi ,HttpStatus.OK);
	}

}
