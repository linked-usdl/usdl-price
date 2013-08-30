/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: QualitativeFeatureStrategy.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/

package generator.strategies;

import java.util.ArrayList;

import data.servicedata.Enumerator.*;
import data.servicedata.QualitativeFeature;

import uk.co.jemos.podam.api.AttributeStrategy;
import uk.co.jemos.podam.api.RandomDataProviderStrategy;
import uk.co.jemos.podam.exceptions.PodamMockeryException;

public class QualitativeFeatureStrategy implements AttributeStrategy<ArrayList<QualitativeFeature>> {
	
    public ArrayList<QualitativeFeature> getValue() throws PodamMockeryException {
    	ArrayList<QualitativeFeature> features = new ArrayList<QualitativeFeature>();
    	
    	for (QUAL_FEATURE feature : QUAL_FEATURE.values()) {
    		int numberFeatures = RandomDataProviderStrategy.getInstance().getIntegerInRange(1, 3, null);
    		for(int i = 0; i<numberFeatures; i++){
    			QualitativeFeature qf = new QualitativeFeature();
    			qf.setType(feature);
    			qf.setName(qf.getType() +"_"+ i); 
    			qf.setDescription(RandomDataProviderStrategy.getInstance().getStringOfLength(30, null));  
    			features.add(qf);
    		}
    		
    	}
    	
    	
    	return features;
    }
    
}
