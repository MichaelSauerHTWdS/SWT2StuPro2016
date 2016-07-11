package hanse.kontor2016.lokalitaeten;

import java.util.LinkedList;

import hanse.kontor2016.kontor.Kontor;

public class Lokalitaeten {
	private GeoObjekt bruegge = new GeoObjekt("Bruegge", GeoObjekt.STADT, new Kontor(), new Hafen(), new Werft());
	private static Lokalitaeten instance = null;
	LinkedList<GeoObjekt> loklist = new LinkedList<GeoObjekt>();
	protected Lokalitaeten(){
		
	}
	public static Lokalitaeten getInstance(){
		if(instance == null){
			return new Lokalitaeten();
		}
		return instance;
	}
}
