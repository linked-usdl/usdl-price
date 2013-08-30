/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: DependentValues.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/

package generator.strategies;

import data.servicedata.Price;
import data.servicedata.ServiceData;

public class DependentValues {
	
	
	
	public static ServiceData generateDependentValues(ServiceData service){
		
		service.setProvider_url("http://genssiz.dei.uc.pt/"+service.getProvider_name());
		service.setLogo("http://genssiz.dei.uc.pt/"+service.getName()+"_logo.jpg");
		
		Price price = new Price();
		//price.generateRandomIndividualPrices(service);
		//service.setPrice(price);
		
		return service;
	}
	
	
}
