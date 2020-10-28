package com.luis.springboot.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luis.springboot.apirest.models.SatelliteModel;

@Repository
public interface SatelliteRepository extends CrudRepository<SatelliteModel,String>{
	
	

}