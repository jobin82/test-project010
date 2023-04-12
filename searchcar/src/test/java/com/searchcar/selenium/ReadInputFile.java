package com.searchcar.selenium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReadInputFile implements aboutVehicle {
	private static ReadInputFile file = null;
	
	private ReadInputFile() {

	}

	public static ReadInputFile getInstance() {
		synchronized (ReadInputFile.class) {
			if (file == null) {
				file = new ReadInputFile();
			}

		}
		return file;
	}

	public List<vehicleDetails> getVehicleDetails(String filePath) {
		List<vehicleDetails> list = null;
		if (filePath == null || "".equals(filePath.trim())) {
			System.out.println("Incorrect filePath ->" + filePath);
			return null;

		} 		

		list = inputtxtFile(filePath);
		return list;
	}

	private List<vehicleDetails> inputtxtFile(String filePath) {
		System.out.println("Start point of ReadInputFile() method ");
		String inputtxtFile = filePath;
		BufferedReader br = null;
		String line = "";
		String regStr ="";
		List<vehicleDetails> listA = new ArrayList<vehicleDetails>();
		try {
			System.out.println("Read File " + filePath);
			vehicleDetails datalst = null;
			br = new BufferedReader(new FileReader(inputtxtFile));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				Pattern p = Pattern.compile("[A-Z0-9]{4} [A-Z0-9]{3}|[A-Z0-9]{4}[A-Z0-9]{3}");
				List<String> list = new ArrayList<String>();
				Matcher m = p.matcher(line);
			    //System.out.println(m);
			    while (m.find()) {
       			        list.add(m.group());
			    } 
			      
			    
				if (list.size() > 0) {
					//System.out.println(list.size());
					for (int i = 0; i < list.size();i++) 
				      { 		      
				          System.out.println(list.get(i).trim());
				 
				          datalst = new vehicleDetails();
				          datalst.setVehicleReg(list.get(i).trim());
				          listA.add(datalst);
				      }
						continue;
				}
				
			}
			System.out.println("Total count of vehicles found -->" + listA.size());
			//System.exit(0);

		} catch (FileNotFoundException e) {
			System.out.printf(e.getMessage(), e);
		} catch (IOException e) {
			System.out.printf(e.getMessage(), e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.printf(e.getMessage(), e);

				}
			}

		}
		System.out.println("Exit from this ReadInputFile() method ");
		return listA;
	}

}
