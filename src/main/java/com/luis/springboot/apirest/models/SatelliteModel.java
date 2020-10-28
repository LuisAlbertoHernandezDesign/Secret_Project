package com.luis.springboot.apirest.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="satellite")
public class SatelliteModel {
	
	@Id
	private String name;
    private double distance;
    private String[] message;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    
	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SatelliteModel [name=" + name + ", distance=" + distance + ", message=" + message + "]";
	}
    

}