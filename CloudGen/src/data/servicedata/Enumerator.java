/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: test.java, Project: CloudAid, 13 Apr 2013 Author: Jorge Araújo
*/
package data.servicedata;

import java.util.HashMap;
import java.util.Map;

public class Enumerator {
	
	public enum UNIT_OF_MEASUREMENT{
		TB("E35"),
		GB("E34"),
		MB("4L"), 
		HOUR("HUR"), 
		MONTH("MON"), 
		GHZ("A86"),
		MBIT_SEC("E20");
		
		private String value;
		
		private static final Map<String, UNIT_OF_MEASUREMENT> lookup = new HashMap<String, UNIT_OF_MEASUREMENT>();
        static {
            for (UNIT_OF_MEASUREMENT f : UNIT_OF_MEASUREMENT.values())
                lookup.put(f.getValue(), f);
        }
        
        public static UNIT_OF_MEASUREMENT get(String name) {
            return lookup.get(name);
        }
        
		UNIT_OF_MEASUREMENT(String value){
			this.value = value;
		}
		
		public String getValue(){
			return this.value;
		}
	}
	
	public enum MIN_QUANT_FEATURE{
		MIN_AVAILABILITY(98.0f),
		MIN_CACHESIZE(0.25f),
		MIN_CPUSPEED(0.7f),
		MIN_DATAINEXTERNAL(0.0f),
		MIN_DATAININTERNAL(0.0f),
		MIN_DATAOUTEXTERNAL(0.0f),
		MIN_DATAOUTINTERNAL(0.0f),
		MIN_DATAPROCESSED(0.0f),
		MIN_DISKSIZE(1.0f),
		MIN_FILESIZE(0.5f),
		MIN_MEMORYSIZE(0.25f),
		MIN_NETWORKDELAY(0.0f),
		MIN_NETWORKINTERNALBANDWIDTH(0.0f),
		MIN_NETWORKLATENCY(0.0f),
		MIN_NETWORKPUBLICBANDWIDTH(0.0f),
		MIN_STORAGECAPACITY(0.0f),
		MIN_TRAFFIC(0.0f),
		MIN_TRANSFERRATE(0.0f),
		MIN_APICALLS(100.0f),
		MIN_APPLICATIONS(1.0f),
		MIN_COPYREQUESTS(1000.0f),
		MIN_CPUCORES(1.0f),
		MIN_CPUFLOP(1.0f),
		MIN_DELETEREQUESTS(1000.0f),
		MIN_GETREQUESTS(1000.0f),
		MIN_HTTPREQUEST(1000.0f),
		MIN_HTTPSREQUEST(1000.0f),
		MIN_IOOPERATIONS(1000.0f),
		MIN_LISTREQUESTS(1000.0f),
		MIN_POSTREQUESTS(1000.0f),
		MIN_PUTREQUESTS(1000.0f),
		MIN_QUERIES(100.0f),
		MIN_READSREQUESTS(1000.0f),
		MIN_RECORDS(10000.0f),
		MIN_TRANSACTIONS(1000.0f),
		MIN_USERS(1.0f),
		MIN_WEBSITES(1.0f),
		MIN_WRITESREQUESTS(1000.0f);
		
		private float value;
		
		MIN_QUANT_FEATURE(float value){
			this.value = value;
		}
		
		public float getValue(){
			return this.value;
		}
	}
	
	public enum MAX_QUANT_FEATURE{
		
		MAX_AVAILABILITY(100.0f),
		MAX_CACHESIZE(256.0f),
		MAX_CPUSPEED(4.0f),
		MAX_DATAINEXTERNAL(1047586.0f),
		MAX_DATAININTERNAL(1047586.0f),
		MAX_DATAOUTEXTERNAL(1047586.0f),
		MAX_DATAOUTINTERNAL(1047586.0f),
		MAX_DATAPROCESSED(10475860.0f),
		MAX_DISKSIZE(4096.0f),
		MAX_FILESIZE(50.0f),
		MAX_MEMORYSIZE(256.0f),
		MAX_NETWORKDELAY(2000.0f),
		MAX_NETWORKINTERNALBANDWIDTH(1024.0f),
		MAX_NETWORKLATENCY(2000.0f),
		MAX_NETWORKPUBLICBANDWIDTH(1024.0f),
		MAX_STORAGECAPACITY(10475860.0f),
		MAX_TRAFFIC(10475860.0f),
		MAX_TRANSFERRATE(0.75f),
		MAX_APICALLS(10000.0f),
		MAX_APPLICATIONS(50.0f),
		MAX_COPYREQUESTS(100000.0f),
		MAX_CPUCORES(16.0f),
		MAX_CPUFLOP(10.0f),
		MAX_DELETEREQUESTS(100000.0f),
		MAX_GETREQUESTS(100000.0f),
		MAX_HTTPREQUEST(10000000.0f),
		MAX_HTTPSREQUEST(10000000.0f),
		MAX_IOOPERATIONS(10000.0f),
		MAX_LISTREQUESTS(100000.0f),
		MAX_POSTREQUESTS(100000.0f),
		MAX_PUTREQUESTS(100000.0f),
		MAX_QUERIES(10000.0f),
		MAX_READSREQUESTS(1000000.0f),
		MAX_RECORDS(10000000.0f),
		MAX_TRANSACTIONS(1000000.0f),
		MAX_USERS(1.0f),
		MAX_WEBSITES(100.0f),
		MAX_WRITESREQUESTS(1000000.0f);
		
		private float value;
		
		MAX_QUANT_FEATURE(float value){
			this.value = value;
		}
		
		public float getValue(){
			return this.value;
		}
	}
	
	public enum QUANT_FEATURE{
		AVAILABILITY("Availability"),
		CACHESIZE("CacheSize"),
		CPUSPEED("CPUSpeed"),
		DATAINEXTERNAL("DataINExternal"),
		DATAININTERNAL("DataINInternal"),
		DATAOUTEXTERNAL("DataOUTExternal"),
		DATAOUTINTERNAL("DataOUTInternal"),
		DATAPROCESSED("DataProcessed"),
		DISKSIZE("DiskSize"),
		FILESIZE("FileSize"),
		MEMORYSIZE("MemorySize"),
		NETWORKDELAY("NetworkDelay"),
		NETWORKINTERNALBANDWIDTH("NetworkInternalBandwidth"),
		NETWORKLATENCY("NetworkLatency"),
		NETWORKPUBLICBANDWIDTH("NetworkPublicBandwidth"),
		STORAGECAPACITY("StorageCapacity"),
		TRAFFIC("Traffic"),
		TRANSFERRATE("TransferRate"),
		APICALLS("APICalls"),
		APPLICATIONS("Applications"),
		COPYREQUESTS("COPYRequest"),
		CPUCORES("CPUCores"),
		CPUFLOP("CPUFlops"),
		DELETEREQUESTS("DELETERequest"),
		GETREQUESTS("GETRequest"),
		HTTPREQUEST("HTTPRequest"),
		HTTPSREQUEST("HTTPSRequest"),
		IOOPERATIONS("IOOperations"),
		LISTREQUESTS("LISTRequest"),
		POSTREQUESTS("POSTRequest"),
		PUTREQUESTS("PUTRequest"),
		QUERIES("Queries"),
		READSREQUESTS("Reads"),
		RECORDS("Records"),
		TRANSACTIONS("Transactions"),
		USERS("Users"),
		WEBSITES("Websites"),
		WRITESREQUESTS("Writes"),
		NUMBEROFIPS("NumberOfIPs"),
		MESSAGENUMBER("MessageNumber"),
		DEDICATEDIP("DedicatedIP");
		
		private String value;
		
		private static final Map<String, QUANT_FEATURE> lookup = new HashMap<String, QUANT_FEATURE>();
        static {
            for (QUANT_FEATURE f : QUANT_FEATURE.values())
                lookup.put(f.getValue(), f);
        }
        
        public static QUANT_FEATURE get(String name) {
            return lookup.get(name);
        }
        
		QUANT_FEATURE(String value){
			this.value = value;
		}
		
		public String getValue(){
			return this.value;
		}
	}
	
	public enum QUAL_FEATURE {
		//interface Types
		API("API"),
		 COMMAND_LINE("CommandLine"),
		 CONSOLE("Console"),
		 GUI("GUI"),
		 WEB("Web"),
		 OTHER_INTERFACE("Interface"),
		 
				CONSISTENCY("Consistency"),
				DURABILITY("Durability"),
				PERFORMANCE("Performance"),
				RELIABILITY("Reliability"),
				SCALABILITY("Scalability"),
				//security Types
				SECURITY("Security"),
				SSL("SSL"),
				ENCRYPTION("Encryption"),
				LOCATION("Location"),
				MONITORING("Monitoring"),
				PLATFORM("Platform"),
				REPLICATION("Replication"),
				COMPUTINGINTANCE("ComputingInstance"),
				CPUTYPE("CPUType"),
				GRAPHICALCARD("GraphicalCard"),
				LOADBALANCING("LoadBalancing"),
				MEMORYALLOCATION("MemoryAllocation"),
				STORAGETYPE("StorageType"),
				FAILOVER("FailOver"),
				
				//Support types
				DEVELOPERCENTER("DeveloperCenter"),
				FORUM("Forum"),
				LIVECHAT("LiveChat"),
				MANUAL("Manual"),
				SUPPORT_24_7("Support_24_7"),
				SUPPORTTEAM("SupportTeam"),
				VIDEOS("Videos"),
				OTHER_SUPPORT("SupportProperties"),

				
				//License types
				OPENSOURCE("OpenSource"),
				 PROPRIETARY("Proprietary"),

				
				//Architecture types
				BIT32("Arch32bit"),
				 BIT64("Arch64bit"),

				
				//OS Types
				EMBEDDED("Embedded"),
				 MOBILE("Mobile"),
				 WINDOWS("Windows"),
				 UNIX("Unix"),
				 REALTIME("RealTime"),

				
				//----->DATA PROPERTIES
				BACKUP_RECOVERY("Backup_Recovery"),
				REDUNDANCY("Redundancy"),

				//----->NETWORK PROPERTIES
				PUBLICIP("PublicIP"),
				 ELASTICIP("ElasticIP"),
				 IPV4("IPv4"),
				 IPV6("IPv6"),
				 PROTOCOL("NetworkProtocol"),

				//----->PLATFORM PROPERTIES
				LANGUAGE("Language"),

				//----->Messages
				MESSAGEPROTOCOL("MessageProtocol"),
				MESSAGETYPE("MessageType"),
				
				//Other Features
				FEATURE("Feature");
		
		private String value;
		
		private static final Map<String, QUAL_FEATURE> lookup = new HashMap<String, QUAL_FEATURE>();
        static {
            for (QUAL_FEATURE f : QUAL_FEATURE.values())
                lookup.put(f.getValue(), f);
        }
        
        public static QUAL_FEATURE get(String name) {
            return lookup.get(name);
        }
        
		QUAL_FEATURE(String value){
			this.value = value;
		}
		
		public String getValue(){
			return this.value;
		}
		
	}
}
