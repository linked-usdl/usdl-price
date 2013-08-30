/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: Attribute.java, Project: CloudGen, 17 Apr 2013 Author: Jorge Araújo
*/
package data.input;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * @author Jorge
 *
 */
@XStreamAlias("attribute")
public class Attribute {
	
	@XStreamImplicit
	private ArrayList<String> attrtype;
	private String optional;
	private ArrayList<Option> options;
	
	public ArrayList<String> getAttrtype() {
		return attrtype;
	}
	public void setAttrtype(ArrayList<String> attrtype) {
		this.attrtype = attrtype;
	}
	public String getOptional() {
		return optional;
	}
	public void setOptional(String optional) {
		this.optional = optional;
	}
	public ArrayList<Option> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}
	
	
	
	
}
