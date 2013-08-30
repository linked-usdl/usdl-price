/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: InputReader.java, Project: CloudGen, 17 Apr 2013 Author: Jorge Araújo
*/
package data.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author Jorge
 *
 */
public class InputReader {
	
	private final String inputDataDirectory = "./input/";

	public InputReader(){
		
	}
	
	public ArrayList<GenData> loadData(){
		
		ArrayList<GenData> genDataList = new ArrayList<GenData>();
		
		ArrayList<String> fileNames = new ArrayList<String>();
		
		fileNames = this.getFileNames();
		
		System.out.println("Found "+fileNames.size()+" generation files. Loading generation data...");
		for(String filename : fileNames){
			GenData temp = this.readXMLData(filename);
			if(temp != null)
				genDataList.add(temp);
		}
		
		System.out.println("Successfully loaded "+genDataList.size()+" generation files.");
		
		return genDataList;
	}
	
	private GenData readXMLData(String filename){
		
		File file = new File(filename);
		InputStream instream;
		try {
			instream = new FileInputStream(file);
			XStream s = new XStream(new DomDriver());
			s.processAnnotations(GenData.class);
			GenData root = (GenData) s.fromXML(instream);

			return root;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Unable to load file: " + filename);
			return null;
		}

	}
	
	private ArrayList<String> getFileNames(){
		final ArrayList<String> fileNames = new ArrayList<String>();
		
		try {
		    Path startPath = Paths.get(this.inputDataDirectory);
		    Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
		        @Override
		        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		            //System.out.println("Dir: " + dir.toString());
		            return FileVisitResult.CONTINUE;
		        }

		        @Override
		        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		            //System.out.println("File: " + file.toString());
		            if (file.getFileName().toString().endsWith(".xml")){
		            	fileNames.add(file.toString());
		            }		            
		            return FileVisitResult.CONTINUE;
		        }

		        @Override
		        public FileVisitResult visitFileFailed(Path file, IOException e) {
		            return FileVisitResult.CONTINUE;
		        }
		    });
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return fileNames;
	}
	
	private void printData(GenData service){
		System.out.println("Name: " + service.getServicename());
		System.out.println("Free: ");
		for(Attribute attr : service.getFreeattributes()){
			System.out.println("    - Type: ");
			for(String s : attr.getAttrtype()){
				System.out.println("       -  "+ s);
			}
			System.out.println("    - Optional: " + attr.getOptional());
			System.out.println("    - Values: ");
			for(Option val : attr.getOptions()){
				System.out.println("        - Type: ");
				for(String s : val.getAttrtype()){
					System.out.println("           -  "+ s);
				}
				System.out.println("        - Value: " + val.getOptionvalue());
				System.out.println("        - AVGPrice: " + val.getAvgprice());
				System.out.println("        - DiffPrice: " + val.getDiffprice());
				System.out.println("        - Min: " + val.getMin());
				System.out.println("        - Max: " + val.getMax());				
			}
		}
		System.out.println("Paid: ");
		for(Attribute attr : service.getFreeattributes()){
			System.out.println("    - Type: ");
			for(String s : attr.getAttrtype()){
				System.out.println("       -  "+ s);
			}
			System.out.println("    - Optional: " + attr.getOptional());
			System.out.println("    - Values: ");
			for(Option val : attr.getOptions()){
				System.out.println("        - Type: ");
				for(String s : val.getAttrtype()){
					System.out.println("           -  "+ s);
				}
				System.out.println("        - Value: " + val.getOptionvalue());
				System.out.println("        - AVGPrice: " + val.getAvgprice());
				System.out.println("        - DiffPrice: " + val.getDiffprice());
				System.out.println("        - Min: " + val.getMin());
				System.out.println("        - Max: " + val.getMax());				
			}
		}
	}

	public static void main(String[] args) {
		InputReader test = new InputReader();
		test.loadData();
	}
}
