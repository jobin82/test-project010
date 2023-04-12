package com.searchcar.selenium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadValidateFile implements aboutVehicle {
	private static ReadValidateFile file = null;

	private ReadValidateFile() {

	}

	public static ReadValidateFile getInstance() {
		synchronized (ReadValidateFile.class) {
			if (file == null) {
				file = new ReadValidateFile();
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

		list = outputtxtFile(filePath);
		return list;
	}

	private List<vehicleDetails> outputtxtFile(String filePath) {
		System.out.println("Start point of readFile() method ");
		String outputtxtFile = filePath;
		int lineNumber = 0;
		BufferedReader br = null;
		String line = "";
		String fileSplitBy = ",";
		List<vehicleDetails> lst = new ArrayList<vehicleDetails>();
		try {
			System.out.println("Read File " + filePath);
			vehicleDetails datalst = null;
			br = new BufferedReader(new FileReader(outputtxtFile));
			while ((line = br.readLine()) != null) {
				if(lineNumber == 0) {
                    lineNumber++;
                    continue;
                }
                lineNumber++;
				// use comma for separator
				String[] vehicleDatals = line.split(fileSplitBy);
				if (vehicleDatals.length < 3) {
					//System.out.println("Empty row ->" + line);
					continue;
				}
				datalst = new vehicleDetails();

				datalst.setVehicleReg(vehicleDatals[0].trim());
				datalst.setVehicleMake(vehicleDatals[1].trim());
				datalst.setVehicleModel(vehicleDatals[2].trim());
				listB.add(datalst);

			}
			System.out.println("Total count of vehicles found -->" + listB.size());

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
		System.out.println("Exit from ReadValidateFile() method ");
		return listB;
	}

}
