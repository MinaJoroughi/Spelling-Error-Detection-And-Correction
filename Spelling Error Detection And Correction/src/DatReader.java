
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
public class DatReader extends Reader{


	public DatReader(String path) {
		super(path);
		try {
			this.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void read()throws IOException{

		FileReader file = new FileReader(new File(path));
		BufferedReader br = new BufferedReader(file);
		String temp = br.readLine();
		while(temp != null){
			
			super.lines.add(temp);
			temp = br.readLine();
			}
			//
		//String [] ss= temp.split(" ");
		//System.out.print(ss[76]);
		br.close();

	}

	
	
	public void write(){

	}

}
