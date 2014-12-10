
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.Spring;


public class dna {
	
	//public static List<String> dnaList;
	public static Vector<genome> dnalist;
	dna(){
		dnalist = new Vector<genome>();
	}
	public void readdata()
	{
		try (BufferedReader br = new BufferedReader(new FileReader("file.txt")))
		{	
			StringBuilder sb = new StringBuilder();
			String line;
			String name = null;
			String seq;
			line = br.readLine();
			name = line;
			line = br.readLine();
			
			do {
				if(line.charAt(0)=='>'){
					seq = sb.toString();
					genome tmpgen = new genome(name.substring(1),seq);
					dnalist.add(tmpgen);
					sb.setLength(0);
					name = line;
				}
				else{
					sb.append(line);
					//line = br.readLine();
				}
				line = br.readLine();
			} while (line != null);
			seq = sb.toString();
			genome tmpgen = new genome(name.substring(1),seq);
			dnalist.add(tmpgen);
			sb.setLength(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void printdna(){
		int len = dnalist.size();
		for(int i = 0; i<len ; i++){
			System.out.println(dnalist.get(i).name);
		}
	}
    public void find(){
    	for(int i = 0 ; i < dnalist.size(); i++){
    		for(int j = 0 ; j <dnalist.size(); j++){
    			if(dnalist.get(i).name != dnalist.get(j).name){
    				String s1 = dnalist.get(i).seq.substring(dnalist.get(i).seq.length()-3);
    				String s2 = dnalist.get(j).seq.substring(0,3);
    				if( s1.equals(s2) ){
    					String tmp = dnalist.get(i).name +" "+ dnalist.get(j).name;
    					System.out.println(tmp);
    				}
    				
    			}
    		}
    	}
    }
	public void findLongest(){
		
	}
    public static void main(String[] args) {
    	dna test = new dna();
    	test.readdata();
    	//System.out.println(test.dnalist.size());
    	test.find();
    	//test.printdna();
    	//genome a = new genome("a","b");
    }

}
