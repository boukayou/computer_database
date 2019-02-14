package fr.com.excilys.ui;

import java.sql.Timestamp;
import java.util.List;
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
	
	public static void showAllCompanies(List<Company> lCompany) {
		
		for(Company compa :lCompany )
		System.out.println(" Companny name : "+ compa.getName());
		
	}
	
	public static void showAllComputers(List<Computer> lComputer) {
		for(Computer compu : lComputer ) {
			System.out.println("Computer name: " + compu.getName() +" introduced: " + compu.getIntroduced() + " discontinued:" +compu.getDiscontinued());
		}
	}
	
	public static void showComputersDetails(Computer computer) {
		
			System.out.println("Computer name: " + computer.getName() +" introduced: " + computer.getIntroduced() + " discontinued:" +computer.getDiscontinued());
	}
	
	public static Computer addComputerUser() {
		
		System.out.println("Please enter the details of your new computer: /n");
	
		Scanner scnId = new Scanner(System.in);
		System.out.println("enter name: ");
		String name = new String(scnId.nextLine());
		System.out.println("Enter Introduced date in the following format [yyyy-mm-dd] : /n");
		String timeIntro = new String (scnId.nextLine());
		System.out.println("Enter Discontuned date in the following format [yyyy-mm-dd] : /n");
		String timeDisc = new String (scnId.nextLine());
		System.out.println(timeDisc);
		//computerToAdd.setDiscontinued(Timestamp.valueOf(scnId.nextLine()));
		System.out.println("Enter ID company : \n");
		long idCompany = Long.parseLong(scnId.nextLine());
		//computerToAdd.setCompany_id(Long.valueOf(scnId.nextLine()));
		Computer computerToAdd = new Computer(name,Timestamp.valueOf(timeIntro),Timestamp.valueOf(timeDisc),idCompany) ;
		return computerToAdd;
	}

}
