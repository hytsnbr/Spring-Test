package com.hytsnbr.dao;

import java.util.List;

public interface ZipCodeApi {
    
    String getAddress(int zipcode);
    
    String getAddress(String zipcode);
    
    List<String> getAddresses(int[] zipcodes);
    
    List<String> getAddresses(List<String> zipcodes);
}
