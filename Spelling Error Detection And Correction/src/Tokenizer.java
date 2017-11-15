import java.util.ArrayList;


public class Tokenizer {
	
	
	public Tokenizer() {
	}
	
	public ArrayList<String[]> tokenize(ArrayList<String> lines){
		ArrayList<String[]> tokens = new ArrayList<String[]>();
		for(int i=0; i<lines.size(); i++){
			String [] ss= lines.get(i).split(" |\t");
			tokens.add(ss);
		}
		return tokens;
		
	}
}
