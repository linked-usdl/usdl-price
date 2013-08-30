/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: Combinations.java, Project: CloudGen, 17 Apr 2013 Author: Jorge Araújo
*/
package generator;

import java.util.ArrayList;

import data.input.Attribute;
import data.input.GenData;
import data.input.Option;

/**
 * @author Jorge
 *
 */
public class Combinations {
	
	private ArrayList<ArrayList<Option>> serviceCombinations;
	private ArrayList<ArrayList<Option>> offeringsCombinations;

	public Combinations(GenData data){
		this.serviceCombinations = new ArrayList<ArrayList<Option>>(); 
		this.offeringsCombinations = new ArrayList<ArrayList<Option>>();
		
		this.computeCombinations(data);
	}
	
	private void computeCombinations(GenData data){
		
		System.out.println("Computing Service combinations...");
		//combinations for the service
		ArrayList<ArrayList<Option>> serviceOptions = new ArrayList<ArrayList<Option>>();
		
		for(Attribute attr : data.getFreeattributes()){
			//get all possible options for this attribute
			ArrayList<Option> options = attr.getOptions();
			
			//if the attribute is optional it can be null (not present in the service)
			if(attr.getOptional().equalsIgnoreCase("yes"))
				options.add(null);
			
			serviceOptions.add(options);		
		}
		
		System.out.println("OPTIONS");
		this.printResult(serviceOptions);
		
		this.permute(serviceOptions, 0, new ArrayList<Option>(), this.serviceCombinations);
		
		System.out.println("COMBINATIONS");
		this.printResult(serviceCombinations);
		System.out.println(this.serviceCombinations.size());
		
		
		System.out.println("Computing offering combinations...");
		//combinations for the offering
		ArrayList<ArrayList<Option>> offeringOptions = new ArrayList<ArrayList<Option>>();
		
		for(Attribute attr : data.getPaidattributes()){
			//get all possible options for this attribute
			ArrayList<Option> options = attr.getOptions();
			
			//if the attribute is optional it can be null (not present in the service)
			if(attr.getOptional().equalsIgnoreCase("yes"))
				options.add(null);
			
			offeringOptions.add(options);		
		}
		
		System.out.println("OPTIONS");
		this.printResult(offeringOptions);
		
		this.permute(offeringOptions, 0, new ArrayList<Option>(), this.offeringsCombinations);
		
		System.out.println("COMBINATIONS");
		this.printResult(offeringsCombinations);
		System.out.println(this.offeringsCombinations.size());
	}

	
	public ArrayList<ArrayList<Option>> getServiceCombinations() {
		return serviceCombinations;
	}

	public void setServiceCombinations(
			ArrayList<ArrayList<Option>> serviceCombinations) {
		this.serviceCombinations = serviceCombinations;
	}

	public ArrayList<ArrayList<Option>> getOfferingsCombinations() {
		return offeringsCombinations;
	}

	public void setOfferingsCombinations(
			ArrayList<ArrayList<Option>> offeringsCombinations) {
		this.offeringsCombinations = offeringsCombinations;
	}

	private void permute(ArrayList<ArrayList<Option>> array, int index, ArrayList<Option> output, ArrayList<ArrayList<Option>> results){
		
	    if(index == array.size()){
	    	ArrayList<Option> temp = (ArrayList<Option>) output.clone();
	    	results.add(temp);
	        //this.printResult(serviceCombinations);
	    }
	    else{
	        for(int i=0 ; i<array.get(index).size() ; i++){
	            output.add(array.get(index).get(i));
	            permute(array,index+1,output, results);
	            output.remove(output.size() - 1); 
	        }
	    }
	}
	
	public void printResult(ArrayList<ArrayList<Option>> result){
		System.out.println("--------------");
		for(ArrayList<Option> list : result){
			for(Option op : list){
				if(op == null)
					System.out.print("null - ");
				else
					System.out.print("("+op.getAttrtype() +" = "+  op.getOptionvalue()+") - ");
			}
			System.out.println("");
		}
		System.out.println("--------------");
	}

    public static void main(String[] args) {
    	ArrayList<Option> subA = new ArrayList<Option>();
    	Option op1 = new Option();
    	op1.setOptionvalue("att1.1");
    	subA.add(op1);
    	Option op2 = new Option();
    	op2.setOptionvalue("att1.2");
    	subA.add(op2);
    	Option op3 = new Option();
    	op3.setOptionvalue("att1.3");
    	subA.add(op3);
    	Option op4 = new Option();
    	op4.setOptionvalue("null");
    	subA.add(op4);
    	Option[] sA = subA.toArray(new Option[subA.size()]);
    	
    	ArrayList<Option> subB = new ArrayList<Option>();
    	Option op5 = new Option();
    	op5.setOptionvalue("att2.1");
    	subB.add(op5);
    	Option[] sB = subB.toArray(new Option[subB.size()]);
    	
    	ArrayList<Option> subC = new ArrayList<Option>();
    	Option op6 = new Option();
    	op6.setOptionvalue("att3.1");
    	subC.add(op6);
    	Option op7 = new Option();
    	op7.setOptionvalue("att3.2");
    	subC.add(op7);
    	Option[] sC = subC.toArray(new Option[subC.size()]);
    	
    	Option[][] teste2 = {sA, sB, sC};
    	System.out.println(teste2.length);
    	
    	
    	String[] subarrayA = {"att1.1","att1.2","att1.3", "null"};
    	String[] subarrayB = {"att2.1"};
    	String[] subarrayC = {"att3.1","att3.2"};
    	String[][] inputArray = {subarrayA, subarrayB, subarrayC};
    	
    	ArrayList<ArrayList<Option>> teste = new ArrayList<ArrayList<Option>>();
    	teste.add(subA);
    	teste.add(subB);
    	teste.add(subC);
    	System.out.println(teste.size());
    	
    	Combinations test = new Combinations(null); 
    	//test.permute(teste, 0, new ArrayList<Option>(), teste);
    	test.printResult(test.getServiceCombinations());
    }

}

