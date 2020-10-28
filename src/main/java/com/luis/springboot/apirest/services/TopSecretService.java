package com.luis.springboot.apirest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luis.springboot.apirest.models.CoordinateModel;
import com.luis.springboot.apirest.models.ResponseModel;
import com.luis.springboot.apirest.models.SatelliteModel;
import com.luis.springboot.apirest.repositories.SatelliteRepository;

@Service
public class TopSecretService {
	
	@Autowired
    SatelliteRepository satelliteRepository;
	
	public ArrayList<SatelliteModel> obtenerSatellite(){
		return (ArrayList<SatelliteModel>)satelliteRepository.findAll();
	}
	
	public SatelliteModel findById(String id) {  
		return satelliteRepository.findById(id).orElse(null);
		}
	
	public ResponseModel guardarSatellite(List<SatelliteModel> satelliteModel) {
		
		SatelliteModel satellite1 = satelliteModel.get(0);
		satelliteRepository.save(satellite1);
        SatelliteModel satellite2 = satelliteModel.get(1);
        satelliteRepository.save(satellite2);
        SatelliteModel satellite3 = satelliteModel.get(2);
        satelliteRepository.save(satellite3);
        ResponseModel responseModel= new ResponseModel(getLocation (satellite1,satellite2,satellite3),getMessage(satellite1,satellite2,satellite3));
		return responseModel;
	}
	
	public static String getMessage(SatelliteModel Kenobi,SatelliteModel Skywalker,SatelliteModel Sato){
		
        List<String> messageFull = new ArrayList<String>();
        List<String> Message = new ArrayList<String>();
        String text="";
        int  size=((Kenobi.getMessage().length+Skywalker.getMessage().length+Sato.getMessage().length)/3); 
        for(int i=0;i<=size;i++){
            System.out.println(i);
            if(i<Kenobi.getMessage().length && !Kenobi.getMessage()[i].equals(""))messageFull.add(Kenobi.getMessage()[i]);
            if(i<Skywalker.getMessage().length && !Skywalker.getMessage()[i].equals(""))messageFull.add(Skywalker.getMessage()[i]);
            if(i<Sato.getMessage().length &&!Sato.getMessage()[i].equals(""))messageFull.add(Sato.getMessage()[i]);
        }
        for(int i=0;i<messageFull.size();i++){
           if((i+1)<messageFull.size() && messageFull.get(i).equals(messageFull.get(i+1)))i++;
           if((i+1)<messageFull.size() && messageFull.get(i).equals(messageFull.get(i+1)))i++;
           if((i+2)<messageFull.size() && messageFull.get(i).equals(messageFull.get(i+2))){i++;}
           else Message.add(messageFull.get(i));
        }
        for(int i=0;i<Message.size();i++)text=text+Message.get(i)+" ";
     return text;
    }
    
    public static CoordinateModel getLocation (SatelliteModel Kenobi,SatelliteModel Skywalker,SatelliteModel Sato){
    	CoordinateModel location = new CoordinateModel();        
        double r1=Kenobi.getDistance();
        double x1=-500;
        double y1=-200;
        
        double r2=Skywalker.getDistance();
        double x2=100;
        double y2=-100;
        
        double r3=Sato.getDistance();
        double x3=500;
        double y3=100;
        
        double a=2*x2 - 2*x1;
        double b=2*y2 - 2*y1;
        double c=Math.pow(r1,2) - Math.pow(r2,2) - Math.pow(x1,2) + Math.pow(x2,2) - Math.pow(y1,2) + Math.pow(y2,2);
        double d=2*x3 - 2*x2;
        double e=2*y3 - 2*y2;
        double f=Math.pow(r2,2) - Math.pow(r3,2) - Math.pow(x2,2) + Math.pow(x3,2) - Math.pow(y2,2) + Math.pow(y3,2);
        location.setX((c*e - f*b) / (e*a - b*d));
        location.setY((c*d - a*f) / (b*d - a*e));
     return location;
    }
}








