package com.luis.springboot.apirest.models;

public class ResponseModel {
	
	CoordinateModel coordinate;
	String mensaje;
	
	public ResponseModel (){
		this.coordinate=null;
		this.mensaje="Error: Verificar si ha sido ingresada la información correcta de los tres satélites.";
	}
	
	public ResponseModel (CoordinateModel coordinate,String mensaje){
		this.coordinate=coordinate;
		this.mensaje=mensaje;
	}

	public CoordinateModel getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(CoordinateModel coordinate) {
		this.coordinate = coordinate;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
