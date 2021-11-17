// name: Yasmin Torres         date:1/29/2018

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Hangman 
{
	public static void main(String [] args) throws IOException
   {
   //Initialize arraylist and then transfer .txt file into the arraylist
	ArrayList <String> heroes = new ArrayList<String>();
   Scanner s = new Scanner(new File("hangman.txt"));
	Scanner s2 = new Scanner(System.in);
   //Create while loop to add the words from the text file into the arraylist  
	while (s.hasNext())
   heroes.add(s.next());
   s.close();
   //Now you gotta make a stack of chars to store the letters of the word from the arraylst
    Stack <Character> letters = new Stack <Character>();
	 String display = "";
	 
	 String word = heroes.get((int)(Math.random()*heroes.size()));
	 for(int i = 0; i < word.length(); i++)
		 letters.add(word.charAt(i));
	int points = 0;
	int correct = word.length()-1;
	int incorrect = 1;
	display += letters.pop();
	
	for(int i = 0; i <word.length()-1; i++)
		{
		System.out.print("Your word is: ");
		for(int j = 0; j < letters.size(); j++)
		 {
		 System.out.print("_ ");
		 }
		System.out.println(display);
		System.out.println("What letter is your guess?");	 
	   char guess = s2.nextLine().charAt(0);	
		char c = letters.pop();
		if(guess == c)
	     {
	   	points+=correct;
	   	System.out.println("Correct! You get " + points + " points!");
		  }
		else
			{
			points-=incorrect;
			System.out.println("Incorrect :c You lose " + points + " points");
			}
			display = c + display;
			incorrect++;
			correct--;
		
	   }
		System.out.println("The word is " + word);
      System.out.println(points);
	} 
}
	 	 