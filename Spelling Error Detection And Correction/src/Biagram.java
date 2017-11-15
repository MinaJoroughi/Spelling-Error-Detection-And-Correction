import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Biagram {
	Test data = new Test();

	public static void main(String[] args) throws IOException{
		Biagram mina = new Biagram();
		mina.countBiagram();
	}

	public void countBiagram(){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("all.dat"));

			ArrayList<String[]> GOD = data.tokenizer.tokenize(data.rKey.getLines());
			

			for(double D=0.05 ; D <= 1 ; D+=0.05){
				out.write("D changed to : "+ D + "\n");
				System.out.println("D is "+D);
				int cnt=0;
				for(int i=0; i< data.allUncorrectwords.size(); i++){

					ArrayList<String> enumratedwords = data.dicMatch.wordList(data.allUncorrectwords.get(i));
					if(enumratedwords.size() ==0){
						data.allcorrectwords.add("NOT_FOUND_IN_DICTIONARY");	
						if( GOD.get(i)[0].equalsIgnoreCase("NOT_FOUND_IN_DICTIONARY") )
							cnt++;
						System.out.println("Iteration = "+i +" 0 NOT_FOUND_IN_DICTIONARY" +" "+ cnt*100/(double)(i+1)+"%");
						out.write("NOT_FOUND_IN_DICTIONARY \n");
						continue;
					}
					double [] biaGramferq = new double[enumratedwords.size()];
					double [] biaGramprobab = new double[enumratedwords.size()];
					int countAllwords = 0 ;

					double pw_1 = data.dicWords.getnGramExtent(data.allUncorrectBeforewords.get(i)) / (double)data.hame2Taeia ;
					double landa1_1 = D / data.dicWords.calcUniGramFreq(data.allUncorrectBeforewords.get(i));
					double landa_1 = landa1_1 * data.dicWords.getnGramExtent(data.allUncorrectBeforewords.get(i));
					double knes_1 = landa_1 * pw_1;

					for(int j=0 ; j<enumratedwords.size(); j++){
						ArrayList<ArrayList<String>> Biagaramwords = data.wordP.getNGramWord(2, i, enumratedwords.get(j).split(" ")[0]);
						ArrayList<Integer> numberofBiagramwords = data.dicWords.getNgram(Biagaramwords);
						int numPrevWord = data.dicWords.calcUniGramFreq(Biagaramwords.get(0).get(0));
						int numberofEnumeratedword = data.dicWords.calcUniGramFreq(Biagaramwords.get(0).get(1));
						if(numberofBiagramwords.size()==1) numberofBiagramwords.add(0);
						/*int a=2;
				if(i==5)
					a=2;*/

						double Pa_1 = Math.max(numberofBiagramwords.get(0) - D,0) / (double) numPrevWord ;
						Pa_1 += knes_1;


						double pw_2 = data.dicWords.getnGramExtent(enumratedwords.get(j).split(" ")[0]) / (double)data.hame2Taeia ;
						double landa1_2 = D / data.dicWords.calcUniGramFreq(enumratedwords.get(j).split(" ")[0]);
						double landa_2 = landa1_2 * data.dicWords.getnGramExtent(enumratedwords.get(j).split(" ")[0]);

						double knes_2 = landa_2 * pw_2;
						double Pa_2 = Math.max(numberofBiagramwords.get(1) - D,0) / (double) numberofEnumeratedword ;
						Pa_2 += knes_2;

						biaGramferq[j] = Math.log10(Pa_1) +  Math.log10(Pa_2);
					
						String [] tt = enumratedwords.get(j).split(" ");
						if(data.missFreq.containsKey(tt[1])){ 
							int count = data.missFreq.get(tt[1]);
							countAllwords += count; 
							biaGramprobab[j] = count;
						}
						else{
							int count = 0;
							biaGramprobab[j] = count;
						}
					}
					double Max = Double.NEGATIVE_INFINITY;

					int wordPosition = 0;
					for(int j=0; j<biaGramprobab.length; j++){
						biaGramprobab[j] = biaGramprobab[j]/countAllwords;
						biaGramprobab[j] = Math.log10(biaGramprobab[j])+ biaGramferq[j];
						if(biaGramprobab[j]> Max){
							Max = biaGramprobab[j];
							wordPosition = j;
						}
					}
					data.allcorrectwords.add(enumratedwords.get(wordPosition).split(" ")[0]);	

					if( GOD.get(i)[0].equalsIgnoreCase(data.allcorrectwords.get(i)) ){
						cnt++;
						System.out.println("Iteration = "+i +"  1 " +enumratedwords.get(wordPosition).split(" ")[0] +" "+ cnt*100/(double)(i+1)+"%");
					}else
						System.out.println("Iteration = "+i +"  0 " +enumratedwords.get(wordPosition).split(" ")[0] +" "+ cnt*100/(double)(i+1)+"%");


					out.write(enumratedwords.get(wordPosition).split(" ")[0] +" "+ cnt*100/(double)(i+1)+"% " +"\n");
				}
			}
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*System.out.println(data.allcorrectwords.size());
		System.out.println(GOD.size());

		for(int i=0;i<GOD.size();i++){

		}
		System.out.println(cnt);
		System.out.println(cnt/(double)GOD.size());*/
	}

	/*private double kinSearchSmoothing(int numberofBiagramwords0,int numPrevWord ,int numberofBiagramwords1,int numberofEnumeratedword) {
		double D = 0.75;
		double pw = /data.
		double res = Math.log10(((numberofBiagramwords0)-D)/(double)(numPrevWord + ))+
				Math.log10((numberofBiagramwords1-D)/(double)(numberofEnumeratedword + data.V));
		return res;
	}*/

	private double normalSmoothing(int numberofBiagramwords0,int numPrevWord ,int numberofBiagramwords1,int numberofEnumeratedword) {
		// TODO Auto-generated method stub
		double res = Math.log10(((numberofBiagramwords0)+1)/(double)(numPrevWord + data.V))+
				Math.log10((numberofBiagramwords1+1)/(double)(numberofEnumeratedword + data.V));
		return res;

	}

}


