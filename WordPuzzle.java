import student.*;
import java.util.ArrayList;
import java.util.Random;
// -------------------------------------------------------------------------
/**
 *  This program creates a WordPuzzle class which will manipulate string and arraylists of integers.
 * The purpose of this project is to learn how to create classes  and manipulate strings in Java.
 * In this project , I created WordPuzzle class , which methods can change message into 
 * puzzle and puzzle into message. First I create object using WordClass and then I access its 
 * method which can return puzzle (ArrayList of nested pairs of number) or message. The inputs in this object 
 * can be a message and a puzzle or one of each of them.
 * 
 *  @Adam Lech adaml8
 *  @2012.05.01
 */
public class WordPuzzle
{
    //~ Instance/static variables .............................................
	 // Instantiating variables which are the inputs of the class
      private String message;  
      private ArrayList<ArrayList<ArrayList<Integer>>> puzzle; 

    //~ Constructor ...........................................................
       
     // Gives a set of instructions to initialize object 
       
    // ----------------------------------------------------------
    /**
     * Creates a new WordPuzzle object.
     */
	//Empty Constructor
    public WordPuzzle() 
    {
        //we don't need to do anything for an empty constructor.
    }
    //This constructor initialize object if  input is message consisting of string characters
	// It uses setFromMessage() method to initialize object 
    public WordPuzzle(String message) 
                                      
    {
       
        
        this.setFromMessage(message);
        
    }
    //This constructor initialize object if  input is puzzle  consisting of ArrayList
	// It uses setFromPuzzle() method to initialize object 
    public WordPuzzle(ArrayList<ArrayList<ArrayList<Integer>>> puzzle) 
                                                                       
    {
       
         
         this.setFromPuzzle(puzzle); 
        
    }
    // This constructor initialize object if input is a messsage and puzzle
    public WordPuzzle(String message, ArrayList<ArrayList<ArrayList<Integer>>> puzzle) 
    {   
        this.message = message; 
        this.puzzle = puzzle ; 
        
    }
     // This constructor initialize object if input is a puzzle and message
    public WordPuzzle(ArrayList<ArrayList<ArrayList<Integer>>> puzzle, String message) 
    {  
        this.puzzle = puzzle; 
        this.message = message; 
        
        
    }  
    //getter method  for message 
    public String getMessage() 
    {
        return this.message; 
    }
    //sets the message
    public void setMessage(String message) 
    {
          this.setFromMessage(message); 
    }
    //getter method for puzzle
    public ArrayList<ArrayList<ArrayList<Integer>>> getPuzzle() 
    {
       return this.puzzle; 
    }
    //sets the puzzle 
    public void setPuzzle(ArrayList<ArrayList<ArrayList<Integer>>> puzzle) 
    {
        this.setFromPuzzle(puzzle) ; 
    }
   //sets the message and puzzle if the input is a message
    public void setFromMessage(String message) 
    {
        this.message = message; 
        puzzle = this.puzzleFromMessage(message); //uses puzzleFromMessage() method to set the puzzle
        
    }
     //sets the message and puzzle if the input is a puzzle 
    public void setFromPuzzle(ArrayList<ArrayList<ArrayList<Integer>>> puzzle)
    { 
        this.puzzle = puzzle; 
        message = this.messageFromPuzzle(puzzle); //uses messageFromPuzzle() to set message
        
        
    }
    //This method obtains ASCII code for  a given string character 
    public static int ord(char chr) 
    {
        return (int)chr;  
    }
    //defines a method which will transform a puzzle consisting of an ArrayList
	// of integers into a message 
    public String messageFromPuzzle(ArrayList<ArrayList<ArrayList<Integer>>> puzzle) 
                                                                                     
     {
        
            
            String message = "";  //creates an empty string to store a message
           

		   //loops over every ArrayList of an ArrayList which represents individual word in the message
            for(Integer i = 0 ; i <puzzle.size(); ++i) { 
               
                 ArrayList<ArrayList<Integer>> wordPuzzle = puzzle.get(i); //Creates an ArrayList which consists of ArrayList of pair numbers 
                                                                           // representing a word 
                 String word = "";  // creates an empty string to store a word
                 
                 
                 
                 //Starts nested loop which will go over every pair of Integers in an ArrayList representing a character 
                 for(Integer p = 0; p < wordPuzzle.size(); ++p) {
                        
                        ArrayList<Integer>  pair = wordPuzzle.get(p);  //Creates an ArrayList which consists of pair of integers sum of which represents a string character
                                                                       
                        int letterNumber = pair.get(0) + pair.get(1); //Adds pairs of integers which make up a string character
                        
                        char letter = (char) letterNumber; //Changes a letterNumber into  a string character
                        word= word + letter; //Adds string character into a word of message
                        
                }
           
                
                message =   message + " "  + word ; //adds word into a message
               
            }   
              String finalMessage = message.trim(); //As the result of looping there are some redundant space characters in the message 
                                                    // I used .trim() method to remove them. I also created a new string to store the final message
        return  finalMessage;  //returns message
        
        
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> puzzleFromMessage(String message) //creates a method which will transform string into an an ArrayList     of pairs of integers representing this message
                                                                                   
     {
        
        /*# Do any work to initialize your class here. *///this create a random number generator, if you do 
        //r.nextInt(someNumber)
        //then it will give you an integers from 0-someNumber
        Random r = new Random();

        
        String[] words = message.split(" "); // this will be an array of Strings with each element being one of the
                                             // words from your message
       
         
        
       ArrayList<ArrayList<ArrayList<Integer>>> puzzle  =  new  ArrayList<ArrayList<ArrayList<Integer>>>(); //create a new ArrayList<ArrayList<ArrayList<Integer>>> to hold your final result
                                                                                                            
      
        
       
        
        //loops over all the words in words 
          for (Integer i =0;i <  words.length; ++i) {  
              
              String word = words[i]; //Creates a new string word which will store an individual  word from the words array
              ArrayList<ArrayList<Integer>> wordPairs = new ArrayList<ArrayList<Integer>>();  //creates an ArrayList<ArrayList<Integer>> wordPairs to hold the pairs  that belong to the current word in the message
                                                                                             
              //starts nested loop 
              for(Integer l = 0; l <word.length(); ++l) { 
                 
                 ArrayList<Integer> letterNumber = new  ArrayList<Integer>(); //Creates an ArrayList of integers which will store a pair of integers 
                                                                             // representing each character in the message
                 
                 Integer number = (int)word.charAt(l);  //obtains ASCII code number for each of the string characters in the message
                 Integer firstNumber = r.nextInt(number); //obtains a first number of a pair which is a random number 
                 Integer secondNumber = number -firstNumber; //obtains a second number of a pair which is a difference between number and first number
                 letterNumber.add(firstNumber) ; //adds first number to the pair of integers representing each string character in the message
                 letterNumber.add(secondNumber) ; //adds second number to the pair of integers representing each string character in the message 
                 wordPairs.add(letterNumber); //adds a pair of integers(letterNumber) to the wordPairs ArrayList which represents an individual word in the message
                 
                 
               }
               puzzle.add(wordPairs); // adds an ArrayList representing an individual word in the message to the final puzzle 
              
               
          
    }
      
      
      return puzzle; // returns puzzle 

    

}

    public static char chr(int chrVal) //This methods changes ASCII code number into a string character 
    {
        char r = (char) chrVal;
        return r;
    }
    
    public String toString() //toString() method which didn't work in my case because instructor had an older version of java than I had (1.7.0_03) 
    {
        String prettyPrint = "";
        String topLine;
        String bottomLine;
        String underLine;
        for (ArrayList<ArrayList<Integer>> wordArray : this.puzzle)
        {
            topLine = "";
            bottomLine = "";
            underLine = "";
            for (ArrayList<Integer> pair : wordArray)
            {
                topLine += padLeft(pair.get(0).toString(), 4) + "  ";
                bottomLine += "+" + padLeft(pair.get(1).toString(), 3) + "  ";
                underLine += "----  ";
            }
            prettyPrint += topLine + "\n" + bottomLine + "\n" + underLine + "\n\n\n";
        }
        return prettyPrint;
    }
    
    public static String padLeft(String s, int n) 
    {
        return String.format("%1$#" + n + "s", s);   
    }

 
    public static void main(String[] args) //main method which tests all the methods in this class; 
	
	
	// { System.out.println(WordPuzzle.getClass()): 
	
	
	
	
	
	
	
    {
        ArrayList<ArrayList<ArrayList<Integer>>> puzzle = new ArrayList<ArrayList<ArrayList<Integer>>>();
        ArrayList<ArrayList<Integer>>word = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>pair = new ArrayList<Integer>();
        pair.add(61);
        pair.add(11);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(93);
        pair.add(4);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(73);
        pair.add(39);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(78);
        pair.add(34);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(17);
        pair.add(104);
        word.add(pair);
        puzzle.add(word);
        word = new ArrayList<ArrayList<Integer>>();
        pair = new ArrayList<Integer>();
        pair.add(23);
        pair.add(43);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(11);
        pair.add(93);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(65);
        pair.add(52);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(20);
        pair.add(96);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(66);
        pair.add(31);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(86);
        pair.add(24);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(40);
        pair.add(61);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(102);
        pair.add(13);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(50);
        pair.add(51);
        word.add(pair);
        puzzle.add(word);
        word = new ArrayList<ArrayList<Integer>>();
        pair = new ArrayList<Integer>();
        pair.add(73);
        pair.add(43);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(28);
        pair.add(73);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(8);
        pair.add(89);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(31);
        pair.add(68);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(77);
        pair.add(27);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(24);
        pair.add(77);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(42);
        pair.add(72);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(15);
        pair.add(24);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(64);
        pair.add(51);
        word.add(pair);
        puzzle.add(word);
        word = new ArrayList<ArrayList<Integer>>();
        pair = new ArrayList<Integer>();
        pair.add(25);
        pair.add(75);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(7);
        pair.add(90);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(10);
        pair.add(111);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(17);
        pair.add(16);
        word.add(pair);
        puzzle.add(word);
        WordPuzzle wp = new WordPuzzle();
        
        WordPuzzle wp2 = new WordPuzzle(puzzle);
        System.out.println(wp2); 
        System.out.println(wp.messageFromPuzzle(puzzle));

    }
} 
