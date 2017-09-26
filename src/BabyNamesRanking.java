import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BabyNamesRanking {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName, year, gender, targetName;
		
		System.out.println("Enter a year: ");
		Scanner f = new Scanner(System.in);
		year = f.nextLine();
		
		fileName = "";

		switch (year){
			case "2001": 
				fileName = "Babynamesranking2001.txt";
				break;
			case "2002":
				fileName = "Babynamesranking2002.txt";
				break;
			case "2003":
				fileName = "Babynamesranking2003.txt";
				break;
			case "2004":
				fileName = "Babynamesranking2004.txt";
				break;
			case "2005":
				fileName = "Babynamesranking2005.txt";
				break;
			case "2006":
				fileName = "Babynamesranking2006.txt";
				break;
			case "2007":
				fileName = "Babynamesranking2007.txt";
				break;
			case "2008":
				fileName = "Babynamesranking2008.txt";
				break;
			case "2009":
				fileName = "Babynamesranking2009.txt";
				break;
			case "2010":
				fileName = "Babynamesranking2010.txt";
				break;
				default:
					System.out.println("invalid year...");
					break;
		}
		
		File textFile = new File(fileName); //creates object for opening file
		
		Scanner input = new Scanner(textFile); //creates scanner for parsing file
		
		System.out.println("Enter a gender (M/F or m/f): ");
		gender = f.nextLine();
		
		System.out.println("Enter a name: ");
		targetName = f.nextLine();
		
		
		ArrayList<String> currLine = new ArrayList<>(); //holds current line read
		while (input.hasNext()) //while there are still lines to be read...
		{
			String str = input.nextLine(); //place the current line into String
			Scanner nextL = new Scanner(str); //create a NEW scanner, which parses the string
			
			//if end of file is reached, name is not in list
			if(input.hasNextLine() == false)
			{
				System.out.println("The name " + targetName + " is not ranked in "
				+ "the year " + year);
			}
			
			//read current line into list, each index containing subset(word) up to whitespace
			while (nextL.hasNext()) //while there are still characters in scanned line
			{
				String token = nextL.next(); //break words into tokens to be stored as indices
				currLine.add(token);
			}
			nextL.close();
			
			//each index corresponds to a subset of characters at the current line
			//male names are @ index [1] simply compare with targetName...
			if(gender.equals("M") || gender.equals("m"))
			{
				
				if(currLine.get(1).equals(targetName))
				{
					System.out.println(currLine.get(1) + " is ranked #" + currLine.get(0)
					+ " in year " + year);
					break;
				}
				else
				{
					currLine.clear();//clear the current line to retrieve next line if available
					continue;

				}

			}
			
			//female names are @ index [3]
			else if(gender.equals("F") || gender.equals("f"))
			{
				if(currLine.get(3).equals(targetName))
				{
					System.out.println(currLine.get(3) + " is ranked #" + currLine.get(0)
					+ " in year " + year);
					break;
				}
				
				else
				{
					currLine.clear();//clear the current line to retrieve next line if available
					continue;

				}
			}
			else
			{
				
				System.out.println("The name " + targetName + " is not ranked"
				+ " in year " + year);
				break;
			}
	
		}
				
		input.close();
		f.close();

	}

}