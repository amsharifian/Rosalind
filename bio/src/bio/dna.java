package bio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dna {
	
	public static List<String> dnaList;
	public dna(){
		dnaList = new ArrayList<String>();
	}
	public void readdata()
	{
		try (BufferedReader br = new BufferedReader(new FileReader("file")))
		{	
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			line = br.readLine();
			
			while(line != null){
				if(line.charAt(0) != '>'){
					sb.append(line);
					//sb.append(System.lineSeparator());
					line = br.readLine();
				}
				else{
					String fdna = sb.toString();
					dnaList.add(fdna);
					sb.setLength(0);
					line = br.readLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void printdna(){
		int len = dnaList.size();
		for(int i = 0; i<len ; i++){
			System.out.println(dnaList.get(i));
		}
	}
    public static void main(String[] args) {
    	dna test = new dna();
    	test.readdata();
    	test.printdna();
    	
    	System.out.println("Test!");
    }

}
