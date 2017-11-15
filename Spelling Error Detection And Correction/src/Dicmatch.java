import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Dicmatch {
	Dictionary dic;
	//ArrayList<String> dicMatch = new ArrayList<String>();
	Enumrate enumrate = new Enumrate();
	public Dicmatch(Dictionary dictionary) {
		this.dic = dictionary;
		
	}

	public ArrayList<String> wordList(String ss){
		ArrayList<String> dicMatch = new ArrayList<String>();
		
		for(int i=0;i<4;i++){
			ArrayList<String> words = new ArrayList<String>();
			//System.out.println(words.size());
			switch(i){
				case 0:
					words = enumrate.delete(ss);
					break;
				case 1:
					words = enumrate.insert(ss);
					break;
				case 2:
					words = enumrate.substute(ss);
					break;
				case 3:
					words = enumrate.transpose(ss);
					break;
			}
			
			for(String w: words){
				String [] tt = w.split(" ");
				if (dic.isInDict(tt[0]) )	
					dicMatch.add(w);
			}
			
		}
		return dicMatch;
	}


	

	



}
