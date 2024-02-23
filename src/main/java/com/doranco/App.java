package com.doranco;

import com.doranco.action.ApplicationCLI;

public class App
{
	 public static void main(String[] args) {
		 ApplicationCLI applicationCLI = new ApplicationCLI(System.in);
		 applicationCLI.start();
	 }
}
