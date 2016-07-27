package com.doctorDetails;
import org.json.JSONArray;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoctorDashboardTest {
	GetDoctorDashboardInfo docInfo = new GetDoctorDashboardInfo();
	JSONArray json = new JSONArray();
	@Test(dataProvider ="validInput")
	public void retrieveDoctorInfoUsingValidInput(String name,String speciality,String area,String review,String gender,String insurance,String ExpectedResult)
	{
		json=docInfo.getDoctorDetails(name,speciality,area,review,gender,insurance);
		String obtainedResult=null;
		for(int i=0;i<json.length();i++)
		{
		obtainedResult=	json.get(i).toString();
		}
		Assert.assertTrue(obtainedResult.equals(ExpectedResult));
	}
	
	@Test(dataProvider ="invalidInput")
	public void retrieveDoctorInfoUsingInvalidInput(String name,String speciality,String area,String review,String gender,String insurance,String ExpectedResult)
	{
	json=docInfo.getDoctorDetails(name,speciality,area,review,gender,insurance);
	String obtainedResult=null;
	obtainedResult=	json.toString();
	Assert.assertTrue(obtainedResult.equals(ExpectedResult));
	}
	
	@Test(dataProvider ="doctorName")
	public void retrieveDoctorInfoUsingName(String doctorName,String ExpectedResult)
	{
		json=docInfo.getDoctorDetails(doctorName, null, null, null,null,null);
		String obtainedResult=null;
		for(int i=0;i<json.length();i++)
		{
		obtainedResult=	json.get(i).toString();
		}
		Assert.assertTrue(obtainedResult.equals(ExpectedResult));
	}
	
	@DataProvider(name = "doctorName")
	   public static Object[][] doctorName() {
	      return new Object[][] {{"Prabhu Maniraj","{\"Area\":\"Fremont\",\"Speciality\":\"ENT Doctor\",\"Insurance\":\"Atenna\",\"Gender\":\"Male\",\"Name\":\"Prabhu Maniraj\",\"Ratings\":3}"}};
	   }

	@DataProvider(name = "validInput")
	   public static Object[][] validInput() {
	      return new Object[][] {{"Prabhu","Ears", "Fremont", "3","Male","Atenna","{\"Area\":\"Fremont\",\"Speciality\":\"ENT Doctor\",\"Insurance\":\"Atenna\",\"Gender\":\"Female\",\"Name\":\"Prabhu Maniraj\",\"Ratings\":3}"}};
	   }
	@DataProvider(name = "invalidInput")
	   public static Object[][] invalidInput() {
	      return new Object[][] {{"xxxxc",null,null,null,null,null,"[]"}};
	   }
}
