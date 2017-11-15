
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Test {
	public Reader rDev;
	public Reader rCorp;
	public Reader rCount;
	public Reader rKey;
	public Tokenizer tokenizer;
	public Enumrate en;
	public Dictionary dicWords; 
	public wordProcess wordP ;
	public ArrayList<String> allUncorrectwords; 
	public ArrayList<String> allUncorrectBeforewords;
	public HashMap<String,Integer> missFreq ;
	public Dicmatch dicMatch;
	
	public int N ;
	public int V ;
	public int hame2Taeia;
	public ArrayList<String> allcorrectwords;
	
	
	public Test(){
		rDev = new DatReader("dev.dat");
		rCorp = new DatReader("corpus.dat");
		rCount = new TxtReader("count_1edit.txt");
		rKey = new TxtReader("dev.keys.txt");
		
		tokenizer = new Tokenizer();
		en = new Enumrate();
		dicWords = new Dictionary(tokenizer.tokenize(rCorp.getLines()));
		wordP = new wordProcess(tokenizer.tokenize(rDev.getLines()));
		allUncorrectwords = wordP.getUncorrectWords();
		allUncorrectBeforewords =  wordP.getBeforeUncorrectWords();
		missFreq = rCount.getCount(tokenizer.tokenize(rCount.getLines()));
		dicMatch = new Dicmatch(dicWords);
		N = dicWords.getDicsize();
		V = dicWords.getDictypes();
		hame2Taeia = dicWords.getnGramExtentAllDic();
		allcorrectwords = new ArrayList<String>();
	}
	
	public static void main2(String[] args) throws IOException{
		final long startTime = System.currentTimeMillis();
		/** Initialize
		 * 
		 */
		Enumrate en = new Enumrate();
		Tokenizer tokenizer = new Tokenizer();
	    Reader rDev = new DatReader("dev.dat");
	    Reader rCorp = new DatReader("corpus.dat");
	    Reader rCount = new DatReader("count_1edit.txt");
	     
		Dictionary dict_AdamKhuba  = new Dictionary(tokenizer.tokenize(rCorp.getLines()));
		wordProcess wp_adamBada = new wordProcess(tokenizer.tokenize(rDev.getLines()));
		Dicmatch dicMatch = new Dicmatch(dict_AdamKhuba);
		HashMap<String,Integer> missFreq = rCount.getCount(tokenizer.tokenize(rCount.getLines()));
		
				
		ArrayList<String> unCorrectWords = wp_adamBada.getUncorrectWords();
		for(int i=0;i<5;i++){
			ArrayList<String> res1 = dicMatch.wordList(unCorrectWords.get(i));
			ArrayList<ArrayList<String>> res2 = wp_adamBada.getAllNGramWord(2, i, res1);
			ArrayList<Integer> res3 = dict_AdamKhuba.getNgram(res2);
		}
	

		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
	}
	public void preProcess(Reader rDev,Reader rCorp){
		
	}
}