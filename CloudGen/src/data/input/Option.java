/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: Value.java, Project: CloudGen, 17 Apr 2013 Author: Jorge Araújo
*/
package data.input;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * @author Jorge
 *
 */
@XStreamAlias("option")
public class Option {
	
	@XStreamImplicit
	private ArrayList<String> attrtype;
	private String optionvalue;
	private String avgprice;
	private String diffprice;
	private Float max;
	private Float min;
	private String unit;

	public ArrayList<String> getAttrtype() {
		return attrtype;
	}
	public void setAttrtype(ArrayList<String> attrtype) {
		this.attrtype = attrtype;
	}
	
	public String getOptionvalue() {
		return optionvalue;
	}
	public void setOptionvalue(String optionvalue) {
		this.optionvalue = optionvalue;
	}
	public String getAvgprice() {
		return avgprice;
	}
	public void setAvgprice(String avgprice) {
		this.avgprice = avgprice;
	}
	public String getDiffprice() {
		return diffprice;
	}
	public void setDiffprice(String diffprice) {
		this.diffprice = diffprice;
	}
	public Float getMax() {
		return max;
	}
	public void setMax(Float max) {
		this.max = max;
	}
	public Float getMin() {
		return min;
	}
	public void setMin(Float min) {
		this.min = min;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	

}
