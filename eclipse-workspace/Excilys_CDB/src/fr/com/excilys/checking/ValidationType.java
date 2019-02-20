package fr.com.excilys.checking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidationType {
	

	public ValidationType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean checkIsString (String str) {
		boolean response = false;
		return response;
	}
	
	public void ConvertDate (String str) {
		//boolean response = false;
		
		SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-mm-dd");
	    sdfrmt.setLenient(false);
	    /* Create Date object
	     * parse the string into date 
             */
	  //  String str = "2020-03-02";
	    
	    if (sdfrmt.equals(str)) {
		    try
		    {
		        Date javaDate = sdfrmt.parse(str); 
		       // System.out.println(str +" is valid Date format");
		       // return javaDate;	    }
		    /* Date format is invalid */
		    } catch (ParseException e)
		    {
		    	
		       System.out.println(str +" is Invalid Date format");   
		     
		    }
	    }
	    
	    
		//return response;
	}
	
	
	
	public boolean checkIsLong (String str) {
		boolean response = false;
		return response;
	}
}
