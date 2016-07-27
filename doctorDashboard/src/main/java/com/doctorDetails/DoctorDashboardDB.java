package com.doctorDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.doctorDetails.Utils.DBConnection;


public class DoctorDashboardDB {
	
	JSONArray json = new JSONArray();
	public JSONArray getDoctorDetails(String name,String speciality,String area,int review,String gender,String insurance)
	{
			String query= "SELECT * FROM doctordetails.doctorinformation where 1=1 ";	
	       
			if(name!=null)
			{
				query = query+"and name REGEXP  "+"\'"+name+"\'";
			}
			else if(speciality!=null)
			{
				query = query+"and speciality REGEXP  "+"\'"+speciality+"\'";
			}
			else if(area!=null)
			{
				query = query+"and area REGEXP  "+"\'"+area+"\'";
			}
			else if(gender!=null)
			{
				query = query+"and gender = "+"\'"+gender+"\'";
			}
			else if(insurance!=null)
			{
				query = query+"and insurance REGEXP  "+"\'"+insurance+"\'";
				
			}
			else if(review!=-1)
			{
				query = query+"and review ="+review;
			}
try {
			PreparedStatement stmt = DBConnection.getPreparedStatement(query);
			int i=0;
			ResultSet rs = stmt.executeQuery();
			if(rs!=null)
			{
				while (rs.next()) {
					
					JSONObject json1 = new JSONObject();
					json1.put("Name", rs.getString("Name"));
					json1.put("Speciality", rs.getString("Speciality"));
					json1.put("Area", rs.getString("Area"));
					json1.put("Ratings", rs.getInt("Review"));
					json1.put("Gender", rs.getString("Gender"));
					json1.put("Insurance", rs.getString("Insurance"));
					json.put(i,json1);
					i++;
					
					}
			}
}
catch (ClassNotFoundException e) {
	e.printStackTrace();
} catch (SQLException e) {
	e.printStackTrace();
}
catch (Exception e){
	e.printStackTrace();	
}
return json;
	}	
}
