package com.hytsnbr.zipcode.dao;

import java.util.List;

public interface ZipcodeApi {
	
	String getAddress(int zipcode);
	
	String getAddress(String zipcode);
	
	List<String> getAddresses(int[] zipcodes);
	
	List<String> getAddresses(List<String> zipcodes);
}
