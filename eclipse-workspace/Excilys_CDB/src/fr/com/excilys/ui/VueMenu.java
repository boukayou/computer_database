package fr.com.excilys.ui;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import fr.com.excilys.modele.Company;
import fr.com.excilys.modele.Computer;

public class VueMenu {
	
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
		System.out.println("Enter the id : /n");
		Scanner scnId = new Scanner(System.in);	
		return scnId.nextLong();
    }
	public static void showComputersDetails(Computer comp ) {
		
		System.out.println("Computer name: " + comp.getName() +" introduced: " + comp.getIntroduced() + " discontinued:" +comp.getDiscontinued());
		
	}
	
	public static Computer addComputer() throws ParseException {

		System.out.println("Please enter the details of your new computer: /n");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter ID company : \n");
		long idCompany = Long.parseLong(scn.nextLine());
		
		System.out.println("enter name: ");
		String name = new String(scn.nextLine());
		//computer.setName(name);
		
		System.out.println("Enter Introduced date in the following format [yyyy-mm-dd] : /n");
		Date introduced = sdf.parse(scn.nextLine());

		System.out.println("Enter Discontuned date in the following format [yyyy-mm-dd] : /n");
		Date discontinued = sdf.parse(scn.nextLine());

		Computer computer = new Computer(name,introduced,discontinued,idCompany);
	   return computer;
	}
	
		
	public static Computer upDateComputer() throws ParseException {
	
			System.out.println("Please enter the details of your new computer: /n");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Scanner scn = new Scanner(System.in);
			
			System.out.println("Enter ID computer : \n");
			long idComputer = Long.parseLong(scn.nextLine());
			
			System.out.println("enter name: ");
			String name = new String(scn.nextLine());
			
			System.out.println("Enter Introduced date in the following format [yyyy-mm-dd] : /n");
			Date introduced = sdf.parse(scn.nextLine());
			
			System.out.println("Enter Discontuned date in the following format [yyyy-mm-dd] : /n");
			Date discontinued = sdf.parse(scn.nextLine());
			
			Computer computer = new Computer(idComputer,name,introduced,discontinued);

		   return computer;
	}
	
	/*public static Computer userFillOut() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Please enter the details of your new computer: /n");
		Scanner scn = new Scanner(System.in);
		System.out.println("enter name: ");
		String name = new String(scn.nextLine());
		//computer.setName(name);
		
		System.out.println("Enter Introduced date in the following format [yyyy-mm-dd] : /n");
		Date introduced = sdf.parse(scn.nextLine());
		//computer.setIntroduced(introduced);
		//System.out.println(new java.sql.Timestamp(timeIntro.getTime()) );
		
		System.out.println("Enter Discontuned date in the following format [yyyy-mm-dd] : /n");
		Date discontinued = sdf.parse(scn.nextLine());
		//computer.setDiscontinued(discontinued);
		
		Computer computer = new Computer(0,name,introduced,discontinued,0);
		return computer;
	}
	*/

}
