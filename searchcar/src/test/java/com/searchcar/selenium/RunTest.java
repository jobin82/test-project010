package com.searchcar.selenium;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class RunTest extends TestCase{
	public RunTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSearchVehicleDetails() {
		
		List<vehicleDetails> extractedList = new ArrayList<vehicleDetails>();
		List<vehicleDetails> expectedList = new ArrayList<vehicleDetails>();
		
		extractedList = ReadInputFile.getInstance().getVehicleDetails("C:\\Users\\jobin\\eclipse-workspace\\car_input_v2.txt");
	    expectedList = ReadValidateFile.getInstance().getVehicleDetails("C:\\Users\\jobin\\eclipse-workspace\\car_output_v2.txt");
		ConnectCarZooSite site = new ConnectCarZooSite();
		vehicleDetails inputlist =  null;
		vehicleDetails outputlist =  null;
		vehicleDetails validatelist = null;
				
		for ( int i = 0 ; i< extractedList.size() ; i++ ) {
			inputlist = extractedList.get(i);
			try {
				outputlist = site.connectSite( inputlist.getVehicleReg());
			} catch (MalformedURLException e) {}
			catch (Exception e) {
				System.out.println("Test Failed");
			}
			
			
			
			//assertEquals( outputlist != null , validatelist != null);
			if (outputlist == null) {
				System.out.println("Car Reg is null: Validation Failed");
				continue;
			}
			else 
			{	
			     for (int j=0 ; j < expectedList.size(); j++) {
					validatelist = expectedList.get(j);
					//System.out.println("Here: "+String.valueOf(validatelist.getVehicleReg()));
					if (outputlist.getVehicleReg().trim().equals(validatelist.getVehicleReg().trim()))
					{
						System.out.println("Car Reg is matched: Validation Passed");
						if (outputlist.getVehicleMake().trim().equals(validatelist.getVehicleMake().trim()))
						{
							System.out.println("Car Make is matched: Validation Passed");
						}
						if (outputlist.getVehicleModel().trim().equals(validatelist.getVehicleModel().trim()))
						{
							System.out.println("Car Model is matched: Validation Passed");	
						}
						
					}
					
				}
	   	  }	
	  }	
	}
}
