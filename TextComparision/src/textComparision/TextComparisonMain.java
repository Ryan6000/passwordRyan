package textComparision;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextComparisonMain {

	 
	    public static void main(String[] args) {
			//set paths for the 2 docs
	    	String path = "/Users/Ryan/Desktop/newFile.txt";
			String path2 = "/Users/Ryan/Desktop/newFile 2.txt";
			
			//import the docs and clean them of punctuation and trim leading and trailing spaces
			String scrubbedString1 = importText(path);
			scrubbedString1 = scrubbedString1.trim();
		//	System.out.println(scrubbedString1);
			String scrubbedString2 = importText(path2);
			scrubbedString2 = scrubbedString2.trim();
		//	System.out.println(scrubbedString2);
			
					
			//create combo string
			String comboString = scrubbedString1+ " " + scrubbedString2;


			//convert the strings to arrays
			String[] strArray1 = null; 
			String[] strArray2 = null;
			String[] comboArray = null;
			strArray1 = scrubbedString1.split(" "); 
			strArray2 = scrubbedString2.split(" "); 
			comboArray = comboString.split(" "); 
			
			System.out.println(strArray1.length);
			printArray(strArray1);
			System.out.println("^ that should be string 1");
			
			System.out.println(strArray2.length);
			printArray(strArray2);
			System.out.println("^that should be string 2");
			
			System.out.println(comboArray.length);
			printArray(comboArray);
			System.out.println("^that should be combo string");
			
			
			
			System.out.println("compare string 1 and combo:");
			System.out.println(compareStrings(comboArray, strArray1));
			System.out.println("compare string 2 and combo:");
			System.out.println(compareStrings(comboArray, strArray2));
			
			
			

			//while loop
			//iterate through strings
			//compare and count

	    }

	

	public static String importText(String path) {
		String content = "";
        
		try {

            // default StandardCharsets.UTF_8
            content = Files.readString(Paths.get(path));

           // Remove Punctuation
	        content = removePunctuations(content);

        } catch (IOException e) {
            e.printStackTrace();
        }

		return content;

		}
	
    public static String removePunctuations(String source) {
        //source.replaceAll("and", "");
    	return source.replaceAll("\\p{Punct}| an | for | a | to | the | in| and ", " ");
    	
    }
    
    public static int compareStrings(String[] comboString, String[] comparisionString) {
    	int similarities = 0;
		for(int j = 0; j<comboString.length; j++)
    	for(int i = 0; i< comparisionString.length; i++) {
			if (comparisionString[i] == comboString[j]) {
				similarities++;
			}
			
		}
    	return similarities;
    }
	
    public static void printArray(String [] printArray) {
    	for(int i = 0; i < printArray.length; i++) {
    		System.out.print(printArray[i] + " ");
    	}
    }
    
	//import text          X
	//strip punctuation    X
	//create string 1      X
	//create string 2      X
    //remove common words  X
	//create combostring
	//compare combostring with string 1
    //use str2.equalsIgnoreCase(str1);
	//create doc1minusdoc2
	//compare combostring with string 2
	//create doc2minusdoc1
	//create docIntersect

}
