package hanse.kontor2016.lokalitaeten;

import java.util.Iterator;
import java.util.LinkedList;

public class Weg extends LinkedList<GeoObjekt>{

	private static final long serialVersionUID = -3213490638622796832L;
	
	public Weg rueckWeg(){
		Weg rueckweg = new Weg();
		for (Iterator<GeoObjekt> gOIterator = descendingIterator();gOIterator.hasNext();){
			rueckweg.add(gOIterator.next());
		}
		return rueckweg;
	}
}
