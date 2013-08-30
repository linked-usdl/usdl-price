/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: Price.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/

package data.servicedata;

import data.servicedata.Enumerator.UNIT_OF_MEASUREMENT;


public class Price {
	
	private final String currency = "EUR";
	
	private Float price;
	private UNIT_OF_MEASUREMENT pricingUnit;
	
	public Price(){
		
	}
	
	public Price(Float price, UNIT_OF_MEASUREMENT pricingUnit){
		this.price = price;
		this.pricingUnit = pricingUnit;
	}
	

	public String getCurrency() {
		return currency;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public UNIT_OF_MEASUREMENT getPricingUnit() {
		return pricingUnit;
	}

	public void setPricingUnit(UNIT_OF_MEASUREMENT pricingUnit) {
		this.pricingUnit = pricingUnit;
	}

	@Override
	public String toString() {
		return "Price [currency=" + currency + ", price=" + price
				+ ", pricingUnit=" + pricingUnit + "]";
	}
	
	


}
