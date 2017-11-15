
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
public abstract class Reader{
	
	protected String path; 
	protected ArrayList<String> lines = new ArrayList<String>();
	
	
	public Reader(String path){
		this.path = path;
	}
	
	
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public ArrayList<String> getLines() {
		return lines;
	}


	public void setLines(ArrayList<String> lines) {
		this.lines = lines;
	}


	public abstract void read()throws IOException;
	public abstract void write();


	public HashMap<String, Integer> getCount(ArrayList<String[]> in) {
		// TODO Auto-generated method stub
		HashMap<String ,Integer> out = new HashMap<String ,Integer> ();
		for(String [] ss:in){
			if(ss.length==2)
				out.put(ss[0], Integer.valueOf(ss[1]));
		}
		return out;
	}


	
}
