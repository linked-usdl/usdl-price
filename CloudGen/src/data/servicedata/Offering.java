/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: GroupedPrice.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/

package data.servicedata;

import java.util.ArrayList;

public class Offering {
	private static int offeringCount = 0;
	
	private final String id;
	private ArrayList<QuantitativeFeature> quantitativefeatures;
	private ArrayList<QualitativeFeature> qualitativeFeature;
	private ArrayList<Price> price;
	
	
	public Offering(String serviceName){
		this.id = serviceName +"_"+ offeringCount++;
		this.qualitativeFeature = new ArrayList<QualitativeFeature>();
		this.quantitativefeatures = new ArrayList<QuantitativeFeature>();
		this.price = new ArrayList<Price>();
	}


	public ArrayList<QuantitativeFeature> getQuantitativefeatures() {
		return quantitativefeatures;
	}



	public void setQuantitativefeatures(
			ArrayList<QuantitativeFeature> quantitativefeatures) {
		this.quantitativefeatures = quantitativefeatures;
	}



	public ArrayList<QualitativeFeature> getQualitativeFeature() {
		return qualitativeFeature;
	}



	public void setQualitativeFeature(
			ArrayList<QualitativeFeature> qualitativeFeature) {
		this.qualitativeFeature = qualitativeFeature;
	}

	public ArrayList<Price> getPrice() {
		return price;
	}



	public void setPrice(ArrayList<Price> price) {
		this.price = price;
	}



	public String getId() {
		return id;
	}


	public void print() {
		 System.out.println("   - ID = "+ this.id);
		 System.out.println("   - QuantitativeFeatures " + this.quantitativefeatures);
		 System.out.println("   - QualitativeFeatures " + this.qualitativeFeature);
		 System.out.println("   - Price = "+ this.price);
	}
	
	

}
