/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: DataReader.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/

package scrappers.findthebest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class DataReader {
	
	private final String findTheBestData = "./Scrappers/providers.xml";
	private Items cloudProviders;
	
	public DataReader(){
		//this.cloudProviders = this.readXMLData();
		this.cloudProviders = this.readXMLData();
		//this.printData(cloudProviders);
		this.printProvidersName(cloudProviders);
	}
	
	private Items readXMLData(){
		
		File file = new File(this.findTheBestData);
		InputStream instream;
		try {
			instream = new FileInputStream(file);
			XStream s = new XStream(new DomDriver());
			s.processAnnotations(Items.class);
			Items root = (Items) s.fromXML(instream);

			return root;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	private void printProvidersName(Items providers){
		for(Item provider : providers.getCloudProviders()){
			System.out.println("PROVIDER: "+ provider.getName());
		}
	}
	
	private void printData(Items providers){
		for(Item provider : providers.getCloudProviders()){
			System.out.println("PROVIDER: "+ provider.getName());
			System.out.println("    - Category: "+ provider.getCategory());
			System.out.println("    - license: "+ provider.getLicense());
			System.out.println("    - monitoring: "+ provider.getMonitoring());
			System.out.println("    - availability: "+ provider.getAvailability());
			System.out.println("    - load_balancing: "+ provider.getLoad_balancing());
			System.out.println("    - autoscaling: "+ provider.getAutoscaling());
			System.out.println("    - logo: "+ provider.getLogo());
			System.out.println("    - provider_url: "+ provider.getProvider_url());
			System.out.println("    - control_Interface: ");
			if (provider.getControl_Interface() != null){
				for(String s : provider.getControl_Interface().getValue()){
					System.out.println("          - "+ s);
				}
			}
			System.out.println("    - languages: ");
			if (provider.getLanguages() != null){
				for(String s : provider.getLanguages().getValue()){
					System.out.println("          - "+ s);
				}
			}
			System.out.println("    - support_features: ");
			if (provider.getSupport_features() != null){
				for(String s : provider.getSupport_features().getValue()){
					System.out.println("          - "+ s);
				}
			}
			System.out.println("    - free_security_features: ");
			if (provider.getFree_security_features() != null){
				for(String s : provider.getFree_security_features().getValue()){
					System.out.println("          - "+ s);
				}
			}
			
			System.out.println("______________#########____________");
		}
		System.out.println("STATS:");
		System.out.println("Number of Providers Imported: "+ providers.getCloudProviders().size());
	}
	
	
	public static void main(String[] args) {
		DataReader test = new DataReader();

	}

}
