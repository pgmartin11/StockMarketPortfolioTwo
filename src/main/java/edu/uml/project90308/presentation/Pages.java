// Presentation tier
package edu.uml.project90308.presentation;

import edu.uml.project90308.businesslogic.*;
import edu.uml.project90308.persistence.*;

public class Pages {
	
	public Pages() {
		return;
	}

	public void displayWelcomePage() {
		System.out.println("Welcome to the application");
	}

	public void displayLoginSuccess() {
		System.out.println("You have been logged in");
	}

	public void displayLoginError() {
		System.out.println("Could not log in with username and password provided");
	}

	public void displayLogout() {
		System.out.println("You have been logged out");
	}

}