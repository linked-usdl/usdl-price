/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: Items.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/

package scrappers.findthebest;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.*;

@XStreamAlias("items")
public class Items {
	
	@XStreamImplicit
    private List<Item> cloudProviders = new ArrayList<Item>();

	public List<Item> getCloudProviders() {
		return cloudProviders;
	}

	public void setCloudProviders(List<Item> cloudProviders) {
		this.cloudProviders = cloudProviders;
	}

	
}
