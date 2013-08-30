/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: QuantitativeFeatureStrategy.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/

package generator.strategies;

import java.util.ArrayList;

import data.servicedata.Enumerator.*;
import data.servicedata.Enumerator;
import data.servicedata.QuantitativeFeature;

import uk.co.jemos.podam.api.AttributeStrategy;
import uk.co.jemos.podam.api.RandomDataProviderStrategy;
import uk.co.jemos.podam.exceptions.PodamMockeryException;

public class QuantitativeFeatureStrategy implements AttributeStrategy<ArrayList<QuantitativeFeature>> {
	
    public ArrayList<QuantitativeFeature> getValue() throws PodamMockeryException {
    	ArrayList<QuantitativeFeature> features = new ArrayList<QuantitativeFeature>();
    	
    	for (QUANT_FEATURE feature : QUANT_FEATURE.values()) {
    		//int numberFeatures = RandomDataProviderStrategy.getInstance().getIntegerInRange(1, 4, null);
    		//for(int i = 0; i<numberFeatures; i++){
    			QuantitativeFeature qf = new QuantitativeFeature();
    			qf.setType(feature);
    			qf.setName(qf.getType().toString());
    			qf = this.generateTypeValues(qf); 
    			qf.setDescription(RandomDataProviderStrategy.getInstance().getStringOfLength(30, null)); 
    			
    			features.add(qf);
    		//}
    		
    	}
    	
    	
    	return features;
    }
    
    private QuantitativeFeature generateTypeValues(QuantitativeFeature feature){
    	
    	float res = 0;
    	Enumerator.UNIT_OF_MEASUREMENT unit = null;
    	
    	switch(feature.getType()){
    	case AVAILABILITY:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_AVAILABILITY.getValue(), MAX_QUANT_FEATURE.MAX_AVAILABILITY.getValue(), null);
			break;
		case CACHESIZE:
			unit = Enumerator.UNIT_OF_MEASUREMENT.GB;
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_CACHESIZE.getValue(), MAX_QUANT_FEATURE.MAX_CACHESIZE.getValue(), null);
			break;
		case CPUSPEED:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_CPUSPEED.getValue(), MAX_QUANT_FEATURE.MAX_CPUSPEED.getValue(), null);
			break;
		case DATAINEXTERNAL:
			unit = Enumerator.UNIT_OF_MEASUREMENT.GB;
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_DATAINEXTERNAL.getValue(), MAX_QUANT_FEATURE.MAX_DATAINEXTERNAL.getValue(), null);
			break;
		case DATAININTERNAL:
			unit = Enumerator.UNIT_OF_MEASUREMENT.GB;
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_DATAININTERNAL.getValue(), MAX_QUANT_FEATURE.MAX_DATAININTERNAL.getValue(), null);
			break;
		case DATAOUTEXTERNAL:
			unit = Enumerator.UNIT_OF_MEASUREMENT.GB;
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_DATAOUTEXTERNAL.getValue(), MAX_QUANT_FEATURE.MAX_DATAOUTEXTERNAL.getValue(), null);
			break;
		case DATAOUTINTERNAL:
			unit = Enumerator.UNIT_OF_MEASUREMENT.GB;
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_DATAOUTINTERNAL.getValue(), MAX_QUANT_FEATURE.MAX_DATAOUTINTERNAL.getValue(), null);
			break;
		case DATAPROCESSED:
			unit = Enumerator.UNIT_OF_MEASUREMENT.GB;
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_DATAPROCESSED.getValue(), MAX_QUANT_FEATURE.MAX_DATAPROCESSED.getValue(), null);
			break;
		case DISKSIZE:
			unit = Enumerator.UNIT_OF_MEASUREMENT.GB;
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_DISKSIZE.getValue(), MAX_QUANT_FEATURE.MAX_DISKSIZE.getValue(), null);
			break;
		case FILESIZE:
			unit = Enumerator.UNIT_OF_MEASUREMENT.GB;
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_FILESIZE.getValue(), MAX_QUANT_FEATURE.MAX_FILESIZE.getValue(), null);
			break;
		case MEMORYSIZE:
			unit = Enumerator.UNIT_OF_MEASUREMENT.GB;
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_MEMORYSIZE.getValue(), MAX_QUANT_FEATURE.MAX_MEMORYSIZE.getValue(), null);
			break;
		case NETWORKDELAY:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_NETWORKDELAY.getValue(), MAX_QUANT_FEATURE.MAX_NETWORKDELAY.getValue(), null);
			break;
		case NETWORKINTERNALBANDWIDTH:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_NETWORKINTERNALBANDWIDTH.getValue(), MAX_QUANT_FEATURE.MAX_NETWORKINTERNALBANDWIDTH.getValue(), null);
			break;
		case NETWORKLATENCY:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_NETWORKLATENCY.getValue(), MAX_QUANT_FEATURE.MAX_NETWORKLATENCY.getValue(), null);
			break;
		case NETWORKPUBLICBANDWIDTH:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_NETWORKPUBLICBANDWIDTH.getValue(), MAX_QUANT_FEATURE.MAX_NETWORKPUBLICBANDWIDTH.getValue(), null);
			break;
		case STORAGECAPACITY:
			unit = Enumerator.UNIT_OF_MEASUREMENT.GB;
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_STORAGECAPACITY.getValue(), MAX_QUANT_FEATURE.MAX_STORAGECAPACITY.getValue(), null);
			break;
		case TRAFFIC:
			unit = Enumerator.UNIT_OF_MEASUREMENT.GB;
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_TRAFFIC.getValue(), MAX_QUANT_FEATURE.MAX_TRAFFIC.getValue(), null);
			break;
		case TRANSFERRATE:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_TRANSFERRATE.getValue(), MAX_QUANT_FEATURE.MAX_TRANSFERRATE.getValue(), null);
			break;
		case APICALLS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_APICALLS.getValue(), MAX_QUANT_FEATURE.MAX_APICALLS.getValue(), null);
			break;
		case APPLICATIONS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_APPLICATIONS.getValue(), MAX_QUANT_FEATURE.MAX_APPLICATIONS.getValue(), null);
			break;
		case COPYREQUESTS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_COPYREQUESTS.getValue(), MAX_QUANT_FEATURE.MAX_COPYREQUESTS.getValue(), null);
			break;
		case CPUCORES:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_CPUCORES.getValue(), MAX_QUANT_FEATURE.MAX_CPUCORES.getValue(), null);
			break;
		case CPUFLOP:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_CPUFLOP.getValue(), MAX_QUANT_FEATURE.MAX_CPUFLOP.getValue(), null);
			break;
		case DELETEREQUESTS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_DELETEREQUESTS.getValue(), MAX_QUANT_FEATURE.MAX_DELETEREQUESTS.getValue(), null);
			break;
		case GETREQUESTS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_GETREQUESTS.getValue(), MAX_QUANT_FEATURE.MAX_GETREQUESTS.getValue(), null);
			break;
		case HTTPREQUEST:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_HTTPREQUEST.getValue(), MAX_QUANT_FEATURE.MAX_HTTPREQUEST.getValue(), null);
			break;
		case HTTPSREQUEST:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_HTTPSREQUEST.getValue(), MAX_QUANT_FEATURE.MAX_HTTPSREQUEST.getValue(), null);
			break;
		case IOOPERATIONS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_IOOPERATIONS.getValue(), MAX_QUANT_FEATURE.MAX_IOOPERATIONS.getValue(), null);
			break;
		case LISTREQUESTS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_LISTREQUESTS.getValue(), MAX_QUANT_FEATURE.MAX_LISTREQUESTS.getValue(), null);
			break;
		case POSTREQUESTS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_POSTREQUESTS.getValue(), MAX_QUANT_FEATURE.MAX_POSTREQUESTS.getValue(), null);
			break;
		case PUTREQUESTS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_PUTREQUESTS.getValue(), MAX_QUANT_FEATURE.MAX_PUTREQUESTS.getValue(), null);
			break;
		case QUERIES:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_QUERIES.getValue(), MAX_QUANT_FEATURE.MAX_QUERIES.getValue(), null);
			break;
		case READSREQUESTS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_READSREQUESTS.getValue(), MAX_QUANT_FEATURE.MAX_READSREQUESTS.getValue(), null);
			break;
		case RECORDS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_RECORDS.getValue(), MAX_QUANT_FEATURE.MAX_RECORDS.getValue(), null);
			break;
		case TRANSACTIONS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_TRANSACTIONS.getValue(), MAX_QUANT_FEATURE.MAX_TRANSACTIONS.getValue(), null);
			break;
		case USERS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_USERS.getValue(), MAX_QUANT_FEATURE.MAX_USERS.getValue(), null);
			break;
		case WEBSITES:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_WEBSITES.getValue(), MAX_QUANT_FEATURE.MAX_WEBSITES.getValue(), null);
			break;
		case WRITESREQUESTS:
			res = RandomDataProviderStrategy.getInstance().getFloatInRange(MIN_QUANT_FEATURE.MIN_WRITESREQUESTS.getValue(), MAX_QUANT_FEATURE.MAX_WRITESREQUESTS.getValue(), null);
			break;
    	}
		
    	feature.setUnitOfMeasurement(unit);
    	feature.setValueFloat(res);
    	
    	return feature;
    }
    
}
