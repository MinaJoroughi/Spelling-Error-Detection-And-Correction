
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
public class TxtReader extends Reader{





	public TxtReader(String path) {
		super(path);
		try {
			this.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void read() throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		String temp = textReader.readLine();
		while(temp != null){
			super.lines.add(temp);
			temp = textReader.readLine();
		}
			textReader.close( );
	}

	public void write(){

	}

}
