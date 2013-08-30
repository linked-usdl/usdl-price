/* Copyright (C) 2013 Jorge Araújo. All rights reserved.
* 
* This program and the accompanying materials are made available under
* the terms of the Common Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/cpl-v10.html
* 
* Id: Item.java, Project: CloudGen, 13 Apr 2013 Author: Jorge Araújo
*/

package scrappers.findthebest;

import com.thoughtworks.xstream.annotations.*;


@XStreamAlias("item")
public class Item {

	private String category;
	private String provider_url;
	private String name;
	private String license;
	private String monitoring;
	
	private String availability;
	private String load_balancing;
	private String autoscaling;
	private String logo;
	private ControlInterface control_Interface;
	private Languages languages;
	private Support_features support_features;
	private Free_security_features free_security_features;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProvider_url() {
		return provider_url;
	}
	public void setProvider_url(String provider_url) {
		this.provider_url = provider_url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getMonitoring() {
		return monitoring;
	}
	public void setMonitoring(String monitoring) {
		this.monitoring = monitoring;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getLoad_balancing() {
		return load_balancing;
	}
	public void setLoad_balancing(String load_balancing) {
		this.load_balancing = load_balancing;
	}
	public String getAutoscaling() {
		return autoscaling;
	}
	public void setAutoscaling(String autoscaling) {
		this.autoscaling = autoscaling;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public ControlInterface getControl_Interface() {
		return control_Interface;
	}
	public void setControl_Interface(ControlInterface control_Interface) {
		this.control_Interface = control_Interface;
	}
	public Languages getLanguages() {
		return languages;
	}
	public void setLanguages(Languages languages) {
		this.languages = languages;
	}
	public Support_features getSupport_features() {
		return support_features;
	}
	public void setSupport_features(Support_features support_features) {
		this.support_features = support_features;
	}
	public Free_security_features getFree_security_features() {
		return free_security_features;
	}
	public void setFree_security_features(
			Free_security_features free_security_features) {
		this.free_security_features = free_security_features;
	}
	@Override
	public String toString() {
		return "Item [category=" + category + ", provider_url=" + provider_url
				+ ", name=" + name + ", license=" + license + ", monitoring="
				+ monitoring + ", availability=" + availability
				+ ", load_balancing=" + load_balancing + ", autoscaling="
				+ autoscaling + ", logo=" + logo + ", control_Interface="
				+ control_Interface + ", languages=" + languages
				+ ", support_features=" + support_features
				+ ", free_security_features=" + free_security_features + "]";
	}
	
	

}
