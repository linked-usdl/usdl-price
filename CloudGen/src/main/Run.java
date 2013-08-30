/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: Run.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/

package main;

import generator.GeneralGenerator;
import generator.ServiceGenerator;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import data.input.InputReader;
import data.input.GenData;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		URL location = Run.class.getProtectionDomain().getCodeSource().getLocation();
		String path = location.getFile();
        path = new File(path).getParent();
		
		//first step is to test the folders necessary
		ArrayList<File> folders = new ArrayList<File>();
		File inputDir = new File("./input");
		File serviceDir = new File("./Services"); 
		folders.add(inputDir);
		folders.add(serviceDir);
		
		for(File folder : folders){
			System.out.println(inputDir.getAbsolutePath());
		  // if the directory does not exist, create it
		  if (!folder.exists()){
		    System.out.println("creating directory: " + folder.getName());
		    boolean result = folder.mkdir();  
		    if(result){    
		       System.out.println("DIR created");  
		     }
		  }else{
			  System.out.println("Folder exists"); 
		  }
		}
		
		ServiceGenerator generator = new ServiceGenerator();
		
		int nrServices = 0;
		ArrayList<GenData> generationData = new ArrayList<GenData>();
		
		System.out.println("Starting ServiceSet Generator...");
		InputReader inReader = new InputReader();
		generationData = inReader.loadData();
		
		for(GenData data : generationData){
			while(true){
				System.out.println("How many generation interations of the Service Family: "+ data.getServicename()+" do you want to run?");
				Scanner in = new Scanner(System.in);
				String s = in.nextLine();
				try{
					nrServices = Integer.parseInt(s);
					break;
				}catch(Exception ex){
					System.out.println("Please insert a numerical value");
				}
			}
			
			generator.generate(nrServices, data);
			
		}
		
		//full generator
		//GeneralGenerator gen = new GeneralGenerator();
		//gen.start(nrServices);
		System.out.println("ServiceSet generated. Exiting...");
		
		//tests
		/*PriceComponent comp = new PriceComponent(false);

		QuantitativeProperty test = new QuantitativeProperty("test", 12.0, "testType");
		System.out.println(test.getType());
		comp.addisLinkedTo(test);
		System.out.println(comp.getIsLinkedTo().get(0).getType());*/
		
		
		//populator.populate(serv);

	}

}
