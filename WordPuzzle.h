#include <string> 
using std::string; 

#include <vector> 
using std::vector;

class WordPuzzle { 

  public: 
     WordPuzzle(); 
	 WordPuzzle(string);
	 WordPuzzle(vector<vector<vector<int>>>); 
	 WordPuzzle(vector<vector<vector<int>>> , string); 
	 WordPuzzle(string, vector<vector<vector<int>>>); 
	 
	 string getMessage(); 
	 vector<vector<vector<int>>> getPuzzle(); 
	 string messageFromPuzzle(vector<vector<vector<int>>>); 
	 vector<vector<vector<int>>> puzzleFromMessage(string); 
	 void setFromMessage(string); 
	 void setFromPuzzle(vector<vector<vector<int>>>); 
	 void setMessage(string); 
	 void setPuzzle(vector<vector<vector<int>>>); 
	 string asString(); 
	 string padLeft(string ,int); 
	 
	 
	 

   private:
     vector<string> split(string,char); 
     string message; 
	
	 vector<vector<vector<int>>> puzzle; 
	 string trim(string); 
	 template<class T> 
	 string integerToString(T); 
	

};