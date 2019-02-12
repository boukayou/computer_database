package com.excilys.projet.cdb;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driv = new Driver();
		driv.getElements();
		for(Company com :driv.getList()) {
			System.out.println(com);
		}
	}

}