package com.hytsnbr.demo.app.zipcode.repository;

import org.springframework.web.client.RestClientException;

public interface ZipCodeApi {

    String getAddress(int zipcode) throws RestClientException;

    String getAddress(String zipcode) throws RestClientException;

    // List<String> getAddresses(int[] zipcodes) throws RestClientException;

    // List<String> getAddresses(List<Integer> zipcodes) throws RestClientException;

    // List<String> getAddresses(List<String> zipcodes) throws RestClientException;
}
