import java.util.ArrayList;


public class wordProcess {

	private ArrayList<String> uncorrectWords = new ArrayList<String>();
	private ArrayList<String> uncorrectBeforeWords = new ArrayList<String>();
	private ArrayList<String[]> data;
	
	public wordProcess(ArrayList<String[]> _data) {
		data = _data;
	}
	
	public ArrayList<String> getUncorrectWords(){
		this.uncorrectWords.clear();
		for(String[] ss : data){
			if(ss.length ==0)continue;
			int idx =  Integer.parseInt(ss[0]);
			idx = idx +1;
			uncorrectWords.add(ss[idx]);
		}
		return uncorrectWords;
	}
	public ArrayList<String> getBeforeUncorrectWords(){
		this.uncorrectBeforeWords.clear();
		for(String[] ss : data){
			if(ss.length ==0)continue;
			int idx =  Integer.parseInt(ss[0]);
			uncorrectBeforeWords.add(ss[idx]);
		}
		return uncorrectBeforeWords;
	}
	public ArrayList<ArrayList<String>> getAllNGramWord(int ngram, int idxLine, ArrayList<String> newWords){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int idx =  Integer.parseInt(data.get(idxLine)[0]) + 1;
		String[] myLine = data.get(idxLine);
		for(String src:newWords){	
			for(int i= idx -ngram + 1 ; i <= idx ; i++){
				if( i < 0 || i+ngram >= myLine.length ) continue;
				ArrayList<String> temp = new ArrayList<String>();
				for(int j=i;j<i+ngram;j++){
					if(j==idx)
						temp.add(src.split(" ")[0]);
					else
						temp.add(myLine[j]);
				}
				res.add(temp);
			}
		}
		return res;
	}
	public ArrayList<ArrayList<String>> getNGramWord(int ngram, int idxLine, String newWord){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		int idx =  Integer.parseInt(data.get(idxLine)[0]) + 1;
		String[] myLine = data.get(idxLine);
		
		for(int i= idx -ngram + 1 ; i <= idx ; i++){
			if( i < 0 || i+ngram >= myLine.length ) continue;
			ArrayList<String> temp = new ArrayList<String>();
			for(int j=i;j<i+ngram;j++){
				if(j==idx)
					temp.add(newWord);
				else
					temp.add(myLine[j]);
			}
			res.add(temp);
		}
		return res;
	}
	public void setUncorrectWords(ArrayList<String> uncorrectWords) {
		this.uncorrectWords = uncorrectWords;
	}
	
	
	
}
