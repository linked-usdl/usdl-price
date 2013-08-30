/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: Service.java, Project: CloudGen, 17 Apr 2013 Author: Jorge Araújo
*/
package data.input;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Jorge
 *
 */
@XStreamAlias("service")
public class GenData {
	
	private String servicename;
	private ArrayList<Attribute> freeattributes;
	private ArrayList<Attribute> paidattributes;
	
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public ArrayList<Attribute> getFreeattributes() {
		return freeattributes;
	}
	public void setFreeattributes(ArrayList<Attribute> freeattributes) {
		this.freeattributes = freeattributes;
	}
	public ArrayList<Attribute> getPaidattributes() {
		return paidattributes;
	}
	public void setPaidattributes(ArrayList<Attribute> paidattributes) {
		this.paidattributes = paidattributes;
	}
	
	

}
