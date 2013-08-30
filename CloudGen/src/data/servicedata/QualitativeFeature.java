/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: QualitativeFeature.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/
package data.servicedata;

import data.servicedata.Enumerator.QUAL_FEATURE;

public class QualitativeFeature {
	private String name;
	private String description;
	private QUAL_FEATURE type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Enumerator.QUAL_FEATURE getType() {
		return type;
	}
	public void setType(Enumerator.QUAL_FEATURE type) {
		this.type = type;
	}
	
	public String getNoSpaceName(){
		String noSpaceName = this.name;

		return noSpaceName.replace(" ", "_");
	}
	
	@Override
	public String toString() {
		return "QualitativeFeature [name=" + name + ", description="
				+ description + ", type=" + type + "]";
	}
	
	

}
