package com.luis.springboot.apirest.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.luis.springboot.apirest.models.ResponseModel;
import com.luis.springboot.apirest.models.SatelliteModel;
import com.luis.springboot.apirest.models.WrapperSatelliteModel;
import com.luis.springboot.apirest.services.TopSecretService;
import com.luis.springboot.apirest.services.Topsecret_splitService;

@RestController
@RequestMapping("")
public class SatelliteController {
	
	@Autowired
	TopSecretService topSecretService;
	@Autowired
	Topsecret_splitService topsecret_splitService;
	
	@GetMapping("/topsecret")
	public ArrayList<SatelliteModel> obtenerSatellite(){
		return this.topSecretService.obtenerSatellite();
	}
	
	@PostMapping("/topsecret")
	public ResponseModel saveSatellite(@RequestBody WrapperSatelliteModel listaSatelliteModel) {
		return this.topSecretService.guardarSatellite(listaSatelliteModel.getSatellites());
	}
	
	@GetMapping("/topsecret_split")
	public ResponseModel findCoordinate() {
		ResponseModel a = new ResponseModel();
		try {
			SatelliteModel satellite1 = this.topsecret_splitService.findById("kenobi");
	        SatelliteModel satellite2 = this.topsecret_splitService.findById("skywalker");
	        SatelliteModel satellite3 = this.topsecret_splitService.findById("sato");
	        a=this.topsecret_splitService.findCordinate(satellite1,satellite2,satellite3);
		    return a;
		}catch(Exception e){
			return a;
		}
	}
	
	@PostMapping("/topsecret_split/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public SatelliteModel update(@RequestBody SatelliteModel satelliteUpdate, @PathVariable String id) {
	satelliteUpdate.setName(id);
	return this.topsecret_splitService.guardarSatellite(satelliteUpdate);
	}
	
	@DeleteMapping("/topsecret_split/{id}")
	public String delete (@PathVariable String id) {
		boolean result=this.topsecret_splitService.delete(id);
		if(result==true) {
			return "Se elimino el satélite "+ id;
		}else return "No es posible eliminar el satellite "+ id +", o el satélite ya fue eliminado.";
	}
	
	
}