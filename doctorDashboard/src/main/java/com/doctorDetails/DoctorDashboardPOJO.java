package com.doctorDetails;

public class DoctorDashboardPOJO {
	
	private String name = null;
	private String speciality = null;
	private String area = null;
	private String gender = null;
	private String insurance = null;
	private int review = -1;
	
	DoctorDashboardPOJO()
	{
		name=null;
		speciality=null;
		area=null;
		gender=null;
		insurance=null;
		review=-1;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!((name==null )||(name.equals(" "))))
				{
		this.name = name;
				}
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		if(!((speciality==null)||(speciality.equals(" "))))
		{
this.speciality = speciality;
		}
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		if(!((area==null)||(area.equals(" "))))
		{
this.area = area;
		}
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if(!((gender==null)||(gender.equals(" "))))
		{
			this.gender = gender;
		}
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		if(insurance!=null && !insurance.equals(" "))
		{
			
			this.insurance = insurance;
		}
	}
	public int getReview() {
		return review;
	}
	public void setReview(String review) {
		
		int temp =0;
		
		try
		{
		temp= Integer.parseInt(review);
		}
		catch(Exception e)
		{
			temp=0;
		}
		if((temp>0)&&(temp<6))
		{
			this.review = temp;
		}
	}
}
