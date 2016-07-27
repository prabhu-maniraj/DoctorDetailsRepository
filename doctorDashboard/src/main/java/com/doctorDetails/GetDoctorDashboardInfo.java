package com.doctorDetails;

import org.json.JSONArray;

public class GetDoctorDashboardInfo {

	DoctorDashboardPOJO pojo = new DoctorDashboardPOJO();
	DoctorDashboardDB db = new DoctorDashboardDB();
	JSONArray json = new JSONArray();
	
	public JSONArray getDoctorDetails(String name,String speciality,String area,String review,String gender,String insurance)
	{
		pojo.setName(name);
		pojo.setSpeciality(speciality);
		pojo.setArea(area);
		pojo.setReview(review);
		pojo.setGender(gender);
		pojo.setInsurance(insurance);
		json=db.getDoctorDetails(pojo.getName(),pojo.getSpeciality(),pojo.getArea(),pojo.getReview(),pojo.getGender(),pojo.getInsurance());	
		return json;
		
	}
public static void main(String[] args){	
	
		GetDoctorDashboardInfo docInfo = new GetDoctorDashboardInfo();
		JSONArray json = new JSONArray();
		json=docInfo.getDoctorDetails("Prabhu", "Ear", "Fremont", "3","Male","Atenna");
		if(json.length()==0)
		{
			System.out.println("Zero Result Found");
		}
		else
		{
		for(int i=0;i<json.length();i++)
		{
			System.out.println(json.get(i).toString());
		}
		}

	}

}
