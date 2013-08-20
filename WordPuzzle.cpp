#include <iostream> 
using std::cout; 
using std::cin; 
using std::endl; 

#include <vector> 
using std:: vector;

#include "WordPuzzle.h" //includes definition of class

#include <stdLib.h> 
#include <time.h> 
#include <sstream> 
using std::ostringstream; 
 
 WordPuzzle:: WordPuzzle() { 
    //Empty constructor
  }
  
 WordPuzzle:: WordPuzzle(string message) { 
 
   WordPuzzle::message = message; 
   puzzle = puzzleFromMessage(message); 
 }
WordPuzzle:: WordPuzzle(vector<vector<vector<int>>> puzzle) { 
     
	WordPuzzle::puzzle = puzzle; 
    message =  messageFromPuzzle(puzzle); 
} 
WordPuzzle:: WordPuzzle(vector<vector<vector<int>>> puzzle , string message) { 
    WordPuzzle::message = message; 
    WordPuzzle::puzzle = puzzle; 
} 

WordPuzzle:: WordPuzzle(string message , vector<vector<vector<int>>> puzzle) { 
     WordPuzzle::message = message; 
	 WordPuzzle::puzzle = puzzle; 
} 


  
string WordPuzzle::getMessage() { 

  return message; 
} 

vector<vector<vector<int>>> WordPuzzle:: getPuzzle() { 
  
  return puzzle; 
} 
string WordPuzzle::messageFromPuzzle(vector<vector<vector<int>>> puzzle) { 
       string message = ""; 
	   for (int i=0 ; i < puzzle.size(); i++) {  
	      
	      vector<vector<int>> wordPuzzle = puzzle.at(i); 
    	  string word = ""; 
	       
		  for(int j=0; j < wordPuzzle.size(); j++) { 
		     vector<int> pair = wordPuzzle.at(j); 
			 int letterNumber = pair.at(0) + pair.at(1); 
			 char letter = (char)letterNumber; 
			 
			 word.append(1,letter); 
			
		  }
		  message = message + " " + word; 
	   } 
	   string finalMessage =  trim(message); 
	   return finalMessage; 
} 
vector<vector<vector<int>>> WordPuzzle::puzzleFromMessage(string message) {
      srand(time(NULL)); 
	  vector<string> words = split(message, ' '); 
	  
	  vector<vector<vector<int>>> puzzle(0); 
	  for(int i=0; i <words.size(); i++) { 
	     
		 string word = words.at(i); 
		 vector<vector<int>> wordPairs(0); 
		 
		 for(int j=0; j<word.size(); j++) { 
		  
		  vector<int> letterPair(2); 
		  int number = (int) word.at(i); 
		  
		  int firstNumber = rand()%number; 
		  int secondNumber = number -firstNumber; 
		  
		  letterPair.insert(letterPair.begin() , firstNumber); 
		  letterPair.insert(letterPair.begin() + 1, secondNumber); 
		  wordPairs.insert(wordPairs.begin() + j , letterPair); 
		  
		 
		 } 
		 
		 puzzle.insert(puzzle.begin() +i , wordPairs); 
		 
	  }
	  
	  return puzzle; 
}
void WordPuzzle::setFromMessage(string message) { 
   
   WordPuzzle::message = message; 
   puzzle = puzzleFromMessage(message); 

} 

void WordPuzzle::setFromPuzzle(vector<vector<vector<int>>> puzzle) { 

    WordPuzzle::puzzle = puzzle; 
	message = messageFromPuzzle(puzzle); 
   
} 

void WordPuzzle::setMessage(string message) { 
   
     WordPuzzle::message = message; 
	 
} 
void WordPuzzle::setPuzzle(vector<vector<vector<int>>> puzzle) { 
     WordPuzzle::puzzle = puzzle; 
} 

string WordPuzzle::asString() { 
     
	 string prettyPrint = ""; 
	 string topLine; 
	 string bottomLine;
	 string underLine;
	 
	 for each ( vector<vector<int>> wordArray in puzzle  ) { 
	 
	      topLine = ""; 
		  bottomLine = ""; 
		  underLine = ""; 
		  
		  for each(vector<int> pair in wordArray) { 
		      string firstN = integerToString<int>(pair.at(0)); 
			  string secondN = integerToString<int>(pair.at(1)); 
		      topLine += padLeft(firstN , 4) + "  " ; 
			  bottomLine += "+" + padLeft(secondN , 3) + "  "; 
			  underLine += "----  "; 
		    } 
		prettyPrint += topLine  +"\n" + bottomLine + "\n" + underLine + "\n\n\n"; 
	    
	 } 
	 return prettyPrint; 
} 

string WordPuzzle::padLeft(string s , int n) { 
    
     
	 string ret = s; 
     if(s.size() < n) { 
		 
         ret.insert(0 ,n - s.size(), ' '); 
		
	  } 
	 else  { 
	   ret = s; 
     }
     return ret; 
	
	
 } 
//private methods
vector<string> WordPuzzle::split(string s, char c) { 
   int counter = 0; 
   string p = s; 
   int pos = p.find_first_of(c); 
   vector<string> retVector(0); 
   while(pos != -1) { 
   cout<< "pos is: " <<pos<< endl; 
        p = s.substr(0, pos); 
		
		s = s.substr(pos +1  , string::npos); 
		cout<< "s is: " << s << endl; 
		pos = s.find_first_of(c); 
		
		retVector.insert(retVector.begin() + ++counter, p); 
		if(pos == -1) {
		  retVector.insert(retVector.begin() + counter, s); 
		} 
     } 
   
   return retVector; 
}  

string WordPuzzle::trim(string s) { 
    if (s.size() == 0) { 
	   return s; 
	} 
    while(s.at(s.size() -1) == ' ') { 
        s.erase(s.end() -1); 
     } 
	 while(s.at(0) == ' ') { 
        s.erase(s.begin()); 
     } 
     return s; 
} 

template <class T> 
string WordPuzzle::integerToString(T n) { 
     ostringstream ss; 
	 ss << n; 
	 return ss.str(); 
} 

 