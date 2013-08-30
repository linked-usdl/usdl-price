/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: ServiceGenerator.java, Project: CloudGen, 17 Apr 2013 Author: Jorge Araújo
*/
package generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import rdf.ServicePopulator;
import uk.co.jemos.podam.api.RandomDataProviderStrategy;
import data.input.Attribute;
import data.input.GenData;
import data.input.Option;
import data.servicedata.Enumerator.UNIT_OF_MEASUREMENT;
import data.servicedata.Offering;
import data.servicedata.Price;
import data.servicedata.QualitativeFeature;
import data.servicedata.QuantitativeFeature;
import data.servicedata.ServiceData;
import data.servicedata.Enumerator.QUAL_FEATURE;
import data.servicedata.Enumerator.QUANT_FEATURE;

/**
 * @author Jorge
 *
 */
public class ServiceGenerator {
	
	private final String servicePath = "./Services/";
	private static int featureCount = 0;
	
	private ServicePopulator populator;

	public ServiceGenerator(){
		this.populator = new ServicePopulator();
	}
	
	public void generate(int nrServices, GenData data){
		ServiceData service;
		boolean errors = false;
		int services = 0;
		ArrayList<ArrayList<Option>> serviceCombinations = new ArrayList<ArrayList<Option>>();
		ArrayList<ArrayList<Option>> offeringsCombinations = new ArrayList<ArrayList<Option>>();
		
		
		System.out.println("->Starting generation of "+nrServices+" service(s) of the "+ data.getServicename() +" type");
		//generate all possible combinations
		Combinations combinator = new Combinations(data);
		serviceCombinations = combinator.getServiceCombinations();
		offeringsCombinations = combinator.getOfferingsCombinations();
		
		for(int i=0; i<nrServices;i++){
			
			//we first generate offerings since they will be the same for all the variations of the service in one generation iteration
			ArrayList<Offering> offerings = this.generateOfferings(data.getServicename(), data, offeringsCombinations);
			
			for(ArrayList<Option> serviceOptions : serviceCombinations){
				//now we generate one service for each combination of service options. Each service has all the offering combinations.
				service = this.generateService(services, data, serviceOptions, offerings);
				//store service in XML
				if(service == null)
					errors = true;
				else{
					services++;
					//this.dumpToXML(service);
					//generate the Linked-USDL Description
					populator.populate(service);
				}
			}
		}
		if(errors)
			System.out.println("->Finished with errors. Generated "+services+ "/"+nrServices +" services");
		else
			System.out.println("->Finished without errors");
	}
	
	private ServiceData generateService(int count, GenData data, ArrayList<Option> serviceOptions, ArrayList<Offering> offerings){
		String defaultURL = "http://genssiz.dei.uc.pt/";
		ServiceData service = new ServiceData();
		
		//generate service general info
		service.setName("Service_" + data.getServicename() + "_" + count);
		service.setProvider_name("Provider_"+count);
		service.setProvider_url(defaultURL + service.getProvider_name());
		service.setLogo(service.getProvider_url() + "/logo");
		service.setDescription(RandomDataProviderStrategy.getInstance().getStringOfLength(50, null));
		
		service = this.addFreeFeatures(service, data, serviceOptions);
		
		//attach the offerings to the service
		service.setOfferings(offerings);
		
		return service;
	}
	
	private ServiceData addFreeFeatures(ServiceData service, GenData data, ArrayList<Option> serviceOptions){
		ArrayList<QualitativeFeature> freeQualFeat = new ArrayList<QualitativeFeature>();
		ArrayList<QuantitativeFeature> freeQuantFeat = new ArrayList<QuantitativeFeature>();
		
		ArrayList<Attribute> attributes = data.getFreeattributes();
		
		for(int i = 0; i < attributes.size(); i++){
			Attribute attr = attributes.get(i);
			//check if the atribute is present in the current options list
			Option option = serviceOptions.get(i);
			if(option != null){
				//the attribute can be added to the offering features
				for(String type : option.getAttrtype()){
					//System.out.println(type);
					if(QUAL_FEATURE.get(type) != null){
						QualitativeFeature qf = new QualitativeFeature();
						qf.setType(QUAL_FEATURE.get(type));
						qf.setName("Feature_"+data.getServicename()+"_"+type+"_"+featureCount++);
						qf.setDescription(RandomDataProviderStrategy.getInstance().getStringOfLength(30, null));
						qf.setName(option.getOptionvalue());
						freeQualFeat.add(qf);
					}else if(QUANT_FEATURE.get(type) != null){
						QuantitativeFeature qf = new QuantitativeFeature();
						qf.setType(QUANT_FEATURE.get(type));
						qf.setName("Feature_"+data.getServicename()+"_"+type+"_"+featureCount++);
						qf.setDescription(RandomDataProviderStrategy.getInstance().getStringOfLength(30, null));  
						qf.setUnitOfMeasurement(UNIT_OF_MEASUREMENT.get(option.getUnit()));
						qf.setValueFloat(Float.parseFloat(option.getOptionvalue()));
						freeQuantFeat.add(qf);
					}else{
						System.out.println("The feature ["+type+"] is not recognized");
					}
				}
			}
		}
		service.setFreeQualitativeFeatures(freeQualFeat);
		service.setFreeQuantitativeFeatures(freeQuantFeat);
		
		return service;
	}
	
	private ArrayList<Offering> generateOfferings(String id, GenData data, ArrayList<ArrayList<Option>> offeringCombinations ){
		
		ArrayList<Offering> offerings = new ArrayList<Offering>();
		
		//generate features and prices
		
		ArrayList<Attribute> attributes = data.getPaidattributes();
		int count = 0;
		
		for(ArrayList<Option> options : offeringCombinations){
			Offering offering = new Offering(id);
			ArrayList<QualitativeFeature> paidQualFeat = new ArrayList<QualitativeFeature>();
			ArrayList<QuantitativeFeature> paidQuantFeat = new ArrayList<QuantitativeFeature>();
			ArrayList<Price> prices = new ArrayList<Price>();
			
			System.out.println("Generating offering "+count++);
			for(int i = 0; i < attributes.size(); i++){
				Attribute attr = attributes.get(i);
				//check if the atribute is present in the current options list
				Option option = options.get(i);
				if(option != null){
					//the attribute can be added to the offering features
					for(String type : option.getAttrtype()){
						//System.out.println(type);
						if(QUAL_FEATURE.get(type) != null){
							QualitativeFeature qf = new QualitativeFeature();
							qf.setType(QUAL_FEATURE.get(type));
							qf.setName("Feature_"+id+"_"+type+"_"+featureCount++);
							qf.setDescription(RandomDataProviderStrategy.getInstance().getStringOfLength(30, null));
							qf.setName(option.getOptionvalue());
							paidQualFeat.add(qf);
						}else if(QUANT_FEATURE.get(type) != null){
							QuantitativeFeature qf = new QuantitativeFeature();
							qf.setType(QUANT_FEATURE.get(type));
							qf.setName("Feature_"+id+"_"+type+"_"+featureCount++);
							qf.setDescription(RandomDataProviderStrategy.getInstance().getStringOfLength(30, null));  
							qf.setUnitOfMeasurement(UNIT_OF_MEASUREMENT.get(option.getUnit()));
							qf.setValueFloat(Float.parseFloat(option.getOptionvalue()));
							paidQuantFeat.add(qf);
						}else{
							System.out.println("The feature ["+type+"] is not recognized");
						}
					}
					//get the price
					//if there is a tag named free there is no component added
					if(!option.getAvgprice().equalsIgnoreCase("free")){
						Float avg = Float.parseFloat(option.getAvgprice());					
						prices.add(new Price(avg, UNIT_OF_MEASUREMENT.get(option.getUnit())));
						//for random price
						//Float diff = Float.parseFloat(option.getDiffprice());
						//Float randPrice = RandomDataProviderStrategy.getInstance().getFloatInRange((avg-diff), (avg+diff), null);
						//prices.add(new Price(avg, UNIT_OF_MEASUREMENT.get(option.getUnit())));
					}
				}
			}
			offering.setQualitativeFeature(paidQualFeat);
			offering.setQuantitativefeatures(paidQuantFeat);
			offering.setPrice(prices);
			//offering.print();
			
			//add to the final list of offerings
			offerings.add(offering);
			//break;
		}
		
		return offerings;
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
