/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: NameStrategy.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/

package generator.strategies;

import uk.co.jemos.podam.api.AttributeStrategy;
import uk.co.jemos.podam.exceptions.PodamMockeryException;

public class NameStrategy implements AttributeStrategy<String> {
	
	private static long serviceCount;
	
    public String getValue() throws PodamMockeryException {
            String service = "Service_";
            
            return service + serviceCount++;
    }
    
}
