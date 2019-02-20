package fr.com.excilys.ui;

import java.text.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Scanner;

import fr.com.excilys.exceptions.NameIsEmpty;
import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;

public class VueMenu  {
	
	public static void showChoice() {
		System.out.println(
				"Computer DataBase Welecome: \n"
				+ " 1 : Show all companies \n"
				+ " 2 : Show all computers \n"
				+ " 3 : Show specific computers \n"
				+ " 4 : Add new computer to base \n"
				+ " 5 : UpDate a computer \n"
				+ " 6 : Delete a computer \n"
				+ " 7 : Quit the CDB \n");
	}
	public static String Choice() {
		Scanner scnz = new Scanner(System.in);
		 String value = scnz.nextLine();
		 System.out.println(value);
		 return value;
	}
	public static void showAllCompanies(List<Company> lCompany) {
		
		for(Company compa :lCompany )
		System.out.println(" Companny name : "+ compa.getName());
		
	}
	
	public static void showAllComputers(List<Computer> lComputer) {
		for(Computer compu : lComputer ) {
			System.out.println("Computer name: " + compu.getName() +" introduced: " + compu.getIntroduced() + " discontinued:" +compu.getDiscontinued());
		}
	}
	
	public static long getId() {
		System.out.println("Enter the id : \n");
		Scanner scnId = new Scanner(System.in);	
		return scnId.nextLong();
    }
	public static void showComputersDetails(Computer comp ) {
		
		System.out.println("Computer name: " + comp.getName() +" introduced: " + comp.getIntroduced() + " discontinued:" +comp.getDiscontinued());
		
	}
	
	public static Computer addComputer() {
		LocalDate introduced =null;
		LocalDate  discontinued =null ;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("Please enter the details of your new computer: \n");
		
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter ID company : \n");
		long idCompany = Long.parseLong(scn.nextLine());
		
		String name;
		do{
			System.out.println("enter name: ");
			name = scn.nextLine();
		}while(name.equals(""));
		
		int  i=0, j=0;
		while(i != 1) {
			System.out.println("Enter Introduced date in the following format [yyyy-mm-dd] : \n");
			String date = scn.nextLine();
			if (date.equalsIgnoreCase("")) {
				introduced = null; 
				i++;
			}
			else {
			try
		    {
				introduced = LocalDate.parse(date, dtf); 
				i++;
		    }catch (Exception e){
		    	
		       System.out.println(date +" is Invalid Date format");   
			}
		}}
	
		while(j != 1) {
			System.out.println("Enter Discontuned date in the following format [yyyy-mm-dd] : \n");
			String date = scn.nextLine();
			
			try
		    {			
				discontinued = LocalDate.parse(date, dtf);
				if(discontinued.isAfter(introduced)||introduced.equals(null)) {
					j++;
				} else System.out.println(" Ambiguous date: introduced date is after discontuned date. \n");
				
		    }catch (Exception e){
		    	
		       System.out.println(date +" is Invalid Date format\n");   
			}	
		}
		
		Computer computer = new Computer(name,introduced,discontinued,idCompany);
	   return computer;
	}
	
		
	public static Computer upDateComputer(){
		LocalDate introduced =null;
		LocalDate  discontinued =null ;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
	
		System.out.println("Please enter the details of your new computer: \n");
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter ID computer : \n");
		long idComputer = Long.parseLong(scn.nextLine());
		
		String name;
		do{
			System.out.println("enter name: ");
			name = scn.nextLine();
		}while(name.equals(""));
		
			
		int  i=0, j=0;
		
		while(i != 1) {
			System.out.println("Enter Introduced date in the following format [yyyy-mm-dd] : \n");
			String date = scn.nextLine();
			
			try
		    {
				introduced = LocalDate.parse(date, dtf); 
				i++;
		    }catch (Exception e){
		    	
		       System.out.println(date +" is Invalid Date format");   
			}
		}
	
		while(j != 1) {
			System.out.println("Enter Discontuned date in the following format [yyyy-mm-dd] : \n");
			String date = scn.nextLine();
			
			try
		    {			
				discontinued = LocalDate.parse(date, dtf);
				if(discontinued.isAfter(introduced)) {
					j++;
				} else System.out.println(" Ambiguous date: introduced date is after discontuned date. \n");
				
		    }catch (Exception e){
		    	
		       System.out.println(date +" is Invalid Date format\n");   
			}	
		}
		
		Computer computer = new Computer(idComputer,name,introduced,discontinued);
	
	   return computer;
	}
	
}