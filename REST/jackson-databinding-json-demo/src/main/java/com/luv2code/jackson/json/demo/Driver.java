package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			// create object mapper 
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and convert/map it to JAVA POJO data/simple-lite.json
			Student theStudent =
					mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print out first name and last name
			System.out.println(theStudent.getFirstName() + " " + theStudent.getLastName());
			
			String cityName = theStudent.getAddress().getCity();
			
			System.out.println("the city: " + cityName);
			
			String [] languages = theStudent.getLanguages();
			System.out.print("languages: "); 
			for	(int i =0; i <languages.length; i++) {
				System.out.print(languages[i] + " ");
			}
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}

		
	}

}
