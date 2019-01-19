package com.test.json.jackson.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//craete object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read JSON file and map/convert to JAVA POJO
			Student st = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println("First Name ::::"+st.getFirstName());
			System.out.println("Last Name :::"+st.getLastName());
			Address address = st.getAddress();
			
			System.out.println("City ::::"+address.getCity());
			int i=0;
			for(String lang : st.getLanguages()) {
				
				i++;
				System.out.println("Lang "+i+lang);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
