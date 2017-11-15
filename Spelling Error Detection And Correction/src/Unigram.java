import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class Unigram {

	Test data;

	public Unigram() {
		this.data =  new Test(); ;
	}
	public static void main(String[] args) throws IOException{
		Unigram mina = new Unigram();
		mina.countUnigram();
	}

	public void countUnigram(){
		ArrayList<String[]> GOD = data.tokenizer.tokenize(data.rKey.getLines());
		int cnt=0;
		for(int i=0; i < data.allUncorrectwords.size(); i++){
			ArrayList<String> enumratedwords = data.dicMatch.wordList(data.allUncorrectwords.get(i));
			if(enumratedwords.size() == 0){
				data.allcorrectwords.add("NOT_FOUND_IN_DICTIONARY");	
				if( GOD.get(i)[0].equalsIgnoreCase("NOT_FOUND_IN_DICTIONARY") )
					cnt++;
				System.out.println("Iteration = "+i +" NOT_FOUND_IN_DICTIONARY" +" "+ cnt*100/(double)(i+1)+"%");
				continue;
			}
			double [] uniGramferq = new double[enumratedwords.size()];
			double [] uniGramprobab = new double[enumratedwords.size()];
			int countAllwords = 0 ; 
			for(int j=0 ; j<enumratedwords.size(); j++){
				uniGramferq[j] = (data.dicWords.calcUniGramFreq(enumratedwords.get(j)) + 1)/(data.N+data.V);
				String [] tt = enumratedwords.get(j).split(" ");
				if(data.missFreq.containsKey(tt[1])){ 
					int count = data.missFreq.get(tt[1]);
					countAllwords += count; 
					uniGramprobab[j] = count;}
				else{
					int count = 0;
					uniGramprobab[j] = count;
				}
			}
			double Max = Double.NEGATIVE_INFINITY;
			int wordPosition = 0;
			for(int j=0; j<uniGramprobab.length; j++){
				uniGramprobab[j] = uniGramprobab[j]/countAllwords;
				uniGramprobab[j] = Math.log10(uniGramprobab[j]) + uniGramferq[j];
				if(uniGramprobab[j] > Max)
				{
					Max = uniGramprobab[j];
					wordPosition = j;
				}
			}
			data.allcorrectwords.add(enumratedwords.get(wordPosition).split(" ")[0]);
			if( GOD.get(i)[0].equalsIgnoreCase(enumratedwords.get(wordPosition).split(" ")[0]) )
				cnt++;
			System.out.println("Iteration = "+i +" " +enumratedwords.get(wordPosition).split(" ")[0] +" "+ cnt*100/(double)(i+1)+"%");
		}
	}
}
