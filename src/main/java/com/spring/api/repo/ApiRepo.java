package com.spring.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.api.entity.StdApi;

public interface ApiRepo extends JpaRepository<StdApi, Long> {

}
