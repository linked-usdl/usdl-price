/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: ServiceData.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/

package data.servicedata;

import java.util.ArrayList;

import uk.co.jemos.podam.annotations.*;

import generator.strategies.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/*NOTE: All fields in this class have the following units of measurement when applicable:
 * 	- GB
 * 	- per second
 *  - GHz
 *  - miliseconds
 *  - GB/s*/

public class ServiceData {
	
	//service Info
	@PodamStrategyValue(NameStrategy.class)
	private String name;
	private String category;
	private String description;

	
	//provider info
	@PodamStrategyValue(ProviderStrategy.class)
	private String provider_name;
	@PodamExclude
	private String provider_url;
	@PodamExclude
	private String logo;
	
	@PodamStrategyValue(QualitativeFeatureStrategy.class)
	//qualitative properties
	private ArrayList<QualitativeFeature> freeQualitativeFeatures;
	
	//quantitative properties
	@PodamStrategyValue(QuantitativeFeatureStrategy.class)
	private ArrayList<QuantitativeFeature> freeQuantitativeFeatures;
	
	private ArrayList<Offering> offerings;
	
	
	public String printData(){
		XStream s = new XStream(new DomDriver());
		
		String xml = s.toXML(this);
		return xml;
	}
	
	
	public String getProvider_name() {
		return provider_name;
	}

	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProvider_url() {
		return provider_url;
	}

	public void setProvider_url(String provider_url) {
		this.provider_url = provider_url;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public ArrayList<QualitativeFeature> getFreeQualitativeFeatures() {
		return freeQualitativeFeatures;
	}


	public void setFreeQualitativeFeatures(
			ArrayList<QualitativeFeature> freeQualitativeFeatures) {
		this.freeQualitativeFeatures = freeQualitativeFeatures;
	}


	public ArrayList<QuantitativeFeature> getFreeQuantitativeFeatures() {
		return freeQuantitativeFeatures;
	}


	public void setFreeQuantitativeFeatures(
			ArrayList<QuantitativeFeature> freeQuantitativeFeatures) {
		this.freeQuantitativeFeatures = freeQuantitativeFeatures;
	}


	public ArrayList<Offering> getOfferings() {
		return offerings;
	}


	public void setOfferings(ArrayList<Offering> offerings) {
		this.offerings = offerings;
	}

	
	
}
