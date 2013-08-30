/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: GeneralGenerator.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/

package generator;

import generator.strategies.DependentValues;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import rdf.ServicePopulator;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import data.servicedata.ServiceData;

public class GeneralGenerator {
	
	private final String servicePath = "./Services/";
	
	private ServicePopulator populator;
	
	public GeneralGenerator(){
		populator = new ServicePopulator();
	}
	
	public void start(int nrServices){
		ServiceData service;
		boolean errors = false;
		int services = 0;
		
		System.out.println("->Starting full service generation of "+nrServices+" service(s)");
		for(int i=0; i<nrServices;i++){
			service = this.generateFullRandomService();
			//store service in XML
			if(!this.dumpToXML(service))
				errors = true;
			else
				services++;
			
			//generate the Linked-USDL Description
			populator.populate(service);
			
		}
		if(errors)
			System.out.println("->Finished with errors. Generated "+services+ "/"+nrServices);
		else
			System.out.println("->Finished without errors");
	}
	
	private ServiceData generateFullRandomService(){
		ServiceData service = new ServiceData();
		PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
		service = factory.manufacturePojo(ServiceData.class);
		service = DependentValues.generateDependentValues(service);
		//service.getPrice().printPrice();
		
		
		return service;
	}
	
	private boolean dumpToXML(ServiceData service){
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter(this.servicePath+ service.getName() + ".xml"));
	        out.write(service.printData());
	        out.close();
	        return true;
	    } 
	    catch (IOException e) 
	    { 
	    	e.printStackTrace();
	    	return false;
	    }
	}

}
