package com.robvdr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APITest {
	public static void main(String[] args) throws IOException {
		APITest.MyGETRequest();
	}

	public static void MyGETRequest() throws IOException {
	    URL urlForGetRequest = new URL("https://api.nal.usda.gov/fdc/v1/food/789216?api_key=unmk3pqCBjYhdjHlDYjOTCi4MmGT7VxPK7Bu8ij4&nutrients=208");
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    int responseCode = conection.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } in .close();
	        // print result
	        System.out.println("JSON String Result " + response.toString());
	        //GetAndPost.POSTRequest(response.toString());
	    } else {
	        System.out.println("GET NOT WORKED");
	    }
	}
}
