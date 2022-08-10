package passwordRyan;

import java.util.Scanner;

public class PasswordRyan {

	//First Method - Password Check
	public static void PasswordCheck(boolean lengthCheck, 
			boolean correctDigits, boolean alphaNumericCheck,
			boolean lowerCheck, boolean upperCheck) {
	
		//Initialize Violation String
		String invalidPassword = "";
		
		//Check for violations
		if (lengthCheck != true) {
			invalidPassword = invalidPassword.concat("A ");
			
		}
		if (correctDigits != true) {
			invalidPassword = invalidPassword + "B ";
			
		}
		if (alphaNumericCheck != true) {
			invalidPassword = invalidPassword + "C ";
			
		}
		if (lowerCheck != true) {
			invalidPassword = invalidPassword + "D ";

		}
		if (correctDigits != true) {
			invalidPassword = invalidPassword + "E ";
			
		}
		//check for a successful password
		if ((lengthCheck == true) && (alphaNumericCheck == true) && (correctDigits == true) && (lowerCheck == true) && (upperCheck == true)) {
			System.out.printf("Judgement: \t\tValid Password\n");
			System.out.printf("Retry (Y/N)\n");
		}
		else {
			System.out.printf("Judgement: \t\tViolation: " + invalidPassword + "\n");
			System.out.printf("Retry (Y/N)\n");
		}
		
	}
	
	//Method Rule A - Password Length
	public static boolean CheckLength(String passwordString, int requiredLength) {
	 	Boolean lengthCheck = false;
		if(passwordString.length() >= requiredLength){
			lengthCheck = true;		
		}
		return lengthCheck;
		
	}
	//Method Rule B - AlphaNumeric Check
	public static boolean CheckCharacters(String passwordString) {
	    Boolean alphaNumericCheck = true;
	    int anySymbols = 0;
		//Check that all characters are letters or numbers
		for(int i = 0; i < passwordString.length(); i++) {
			char anCheck = passwordString.charAt(i);
			if( (anCheck >= 'A' && anCheck <= 'Z') || (anCheck >= 'a' && anCheck <= 'z') 
					|| (anCheck >= '0' && anCheck <= '9')){
				//do nothing
			}
			else {
				anySymbols++;
			}
			
			if(anySymbols > 0) {
				alphaNumericCheck = false;
			}
		}
	    
		return alphaNumericCheck;
	}
	//Method Rule C - Number of Digits
	public static boolean CheckDigits(String passwordString, int requiredDigits) {
	    Boolean correctDigits = false;
		//Check for the correct number of digits
	    int digitCount = 0;
		for(int i = 0; i < passwordString.length(); i++) {
			char dCheck = passwordString.charAt(i);
			if(dCheck >= '0' && dCheck <= '9') {
				digitCount++;
				}
			}
		if (digitCount >= requiredDigits) {
			correctDigits = true;	
		}
		return correctDigits;
	}
	//Method Rule D - lower-case letter check
	public static boolean LowerCheck(String passwordString, int requiredLowers) {
		Boolean correctLowers = false;
		//Check for the minimum number of lower case letters
		int lowerCount = 0;
		for(int i=0; i < passwordString.length(); i++) {
			char lCheck = passwordString.charAt(i);
			if(lCheck >= 'a' && lCheck <= 'z') {
				lowerCount++;
			}
			if(lowerCount >= requiredLowers) {
				correctLowers = true;
			}
		}
		return correctLowers;
	}
	//Method Rule E - upper-case letter check
	public static boolean UpperCheck(String passwordString, int requiredUppers) {
		Boolean correctUppers = false;
		//Check for the minimum number of lower case letters
				int upperCount = 0;
				for(int i=0; i < passwordString.length(); i++) {
					char uCheck = passwordString.charAt(i);
					if(uCheck >= 'A' && uCheck <= 'Z') {
						upperCount++;
					}
					if(upperCount >= requiredUppers) {
						correctUppers = true;
					}
				}
		return correctUppers;
	}
	
	//Main Method, initialize values & retry loop
	public static void main(String[] args) {
		//Initialize required password length
		final int requiredLength = 8;	
		//Initialize required number of digits in password
		final int requiredDigits = 4;
		//Initialize required number of Lowers Case Letters in password
		final int requiredLowers = 3;	
		//Initialize required number of Upper Case Letters in password
		final int requiredUppers = 3;

		
		//Start that repeat loop
	    String retry = "Y";
	    boolean repeatAgain = true;
	    while (repeatAgain == true){

	    		if (retry.equalsIgnoreCase("N")){
	    			repeatAgain = false;
	    			System.out.println("Program Terminated");
	    			}
	    		else if(retry.equalsIgnoreCase("Y")) {
		
	    //Initialize password checks



	    			
		// Prompt user
		System.out.println("Enter a password. \nRule A It must be at least " + requiredLength + " characters long"
				+ "\nRule B it must include only letters and numbers \nRule C it must contain at least " + requiredDigits + " digits."
				+ "\nRule D it must contain at least " + requiredUppers + " upper case letters \nRule E it must contain at least " + requiredLowers + " lower case letters."
				+ "\n \nPassword: ");
		//create a scanner and collect input
		Scanner sc = new Scanner(System.in);
		String passwordString = sc.next();
		System.out.printf("\nEntered Password: \t" + passwordString + "\n");
		
		//check password length
		boolean lengthCheck = CheckLength(passwordString, requiredLength);
		//check the correct number of digits
		boolean correctDigits = CheckDigits(passwordString, requiredDigits);
		//check for any characters other than Letters or Numbers
		boolean alphaNumericCheck = CheckCharacters(passwordString);
		//check number of lower-case letters
		boolean lowerCheck = LowerCheck(passwordString, requiredLowers);
		//check number of upper-case letters
		boolean upperCheck = UpperCheck(passwordString, requiredUppers);
		
		PasswordCheck(lengthCheck, correctDigits, alphaNumericCheck, lowerCheck, upperCheck);

		
		retry = sc.next();
//A loop for retry
	    		}
	    }
	}
}