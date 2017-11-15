import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Dictionary {
	ArrayList<String[]> dic = new ArrayList<String[]>();
	
	public Dictionary(ArrayList<String[]> _dic) {
		//this.dic = _dic;
		for(String [] tt:_dic){
			String  sub[] = new String [tt.length-2]; 
			for(int i=1;i<tt.length-1;i++){
				sub[i-1] =tt[i];
			}
			dic.add(sub);
		}
	
	}
	public int calcUniGramFreq(String target){
		int res=0;
		for(String [] src : dic){
			for(String ss: src)
				if(ss.equalsIgnoreCase(target))
					res++;
		}
		return res;
	}
	public int getDicsize() {
		return dic.size();
	}
	public int getDictypes(){
		Set<String> types = new HashSet<String>();
		for(int i=0; i<dic.size(); i++){
			for(int j=0; j<dic.get(i).length; j++){
				if(types.contains(dic.get(i)[j])) continue;
				types.add(dic.get(i)[j]);
			}		
		}
		return types.size();
	}
	
	public boolean isInDict(String target){
		
		for(String [] src : dic){
			for(String ss: src)
				if(ss.equalsIgnoreCase(target))
					return true;
		}
		return false;
	}
	public int getnGramFreq(ArrayList<String> target){
		/*if(n != target.size()){
			System.err.println("Error in Dictionary->nGram, size array is not match with n for ngram");
			return -1;
		}*/
		int n= target.size();
		int res=0;
		for(String [] line : dic){
			for(int i=0;i <= line.length-n;i++){
				boolean sw=true;
				for(int j=0;j<n;j++)
					if(line[i+j].equals(target.get(j)) == false){
						sw=false;
						break;
					}
				if(sw) res++;
			}
		}
		return res;
	}
	
	public int getnGramExtent(String target){
		Set<String> word= new HashSet<String>();
		for(String [] line : dic){
			for(int i=0;i < line.length-1;i++){
				if(line[i].equals(target)){
					if(!word.contains(line[i+1])){
						word.add(line[i+1]);
					}
				}	
			}
		}
		return word.size();
	}
	
	public int getnGramExtentAllDic(){
		Set<String> word= new HashSet<String>();
		for(String[] line : dic){
			for(int i= 0; i<line.length-1; i++){
				if(! word.contains(line[i] + " " + line[i+1])){
					word.add(line[i] + " "+ line[i+1]);
				}
			}
		}
		return word.size();
	}
	
	
	public ArrayList<Integer> getNgram(ArrayList<ArrayList<String>> res2) {
		ArrayList<Integer>  res = new ArrayList<Integer>();
		// TODO Auto-generated method stub
		for(ArrayList<String> ss : res2){
			res.add( this.getnGramFreq(ss));
			
		}
		return res;
	}
}
