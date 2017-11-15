import java.util.ArrayList;
import java.lang.StringBuilder;

public class Enumrate {

	
	public ArrayList<String> delete (String word){
		ArrayList<String> createdWords = new ArrayList<String>();
		//StringBuilder w = new StringBuilder(word2);
		for(int i=0; i<word.length(); i++){
			
			String newWord = word.substring(0, i)+word.substring(i+1, word.length());
			if(i == 0){
				createdWords.add(newWord + " >"+word.substring(0, i+1)+  "|" + ">"+word.substring(0, i));
			}
			else  {
				createdWords.add(newWord + " "+word.substring(i-1, i+1)+  "|" +word.substring(i-1, i));
			}
			
		}
		return createdWords;
		
	}

	public ArrayList<String> insert(String word){
		ArrayList<String> createdWords = new ArrayList<String>();
		//StringBuilder word = new StringBuilder(word2);
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l',
				'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for(char c : alphabet){
			for(int i=0; i<word.length()+1; i++){
				String newWord = word.substring(0, i)+ c +word.substring(i, word.length());
				//String newWord = word.insert(i, c).toString();
				if(i==0){
					createdWords.add(newWord + " >"+  "|" + ">"+c);
				}
				else {
					createdWords.add(newWord + " "+word.substring(i-1, i)+  "|" +word.substring(i-1, i)+c);
				}
				//word.deleteCharAt(i);
			}	
		}
		
		return createdWords;
	}

	public ArrayList<String> substute(String word){
		ArrayList<String> createdWords = new ArrayList<String>();
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l',
				'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for(char c : alphabet){
			for(int i=0; i<word.length(); i++){
				String newWord = word.substring(0, i)+ c +word.substring(i+1, word.length());
				if(i==0){
					createdWords.add(newWord + " >"+word.substring(i, i+1)+  "|" + ">"+c);
				}
				else{
					createdWords.add(newWord + " "+word.substring(i, i+1)+  "|"+c);
				}
			}
		}
		return createdWords;
	}

	public ArrayList<String> transpose(String word){
		ArrayList<String> createdWords = new ArrayList<String>();
		for(int i=0; i<word.length()-1; i++){
			String newWord = word.substring(0, i)+ word.charAt(i+1) + word.charAt(i) +word.substring(i+2, word.length()); 
			createdWords.add(newWord + " "+word.substring(i, i+2)+  "|" +word.charAt(i+1) + word.charAt(i) );
		}
		return createdWords;
	}


}
