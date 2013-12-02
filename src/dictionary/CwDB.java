package dictionary;
import java.util.*;
import java.io.*;

public class CwDB{
	protected LinkedList<Entry> dict;
	
	public CwDB(String filename){
		dict = new LinkedList<Entry>();
		try{
			createDB(filename);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void add(String word, String clue){
		dict.add(new Entry(word, clue));
	}
	public Entry get(String word)throws Exception{
		int i = this.indexOf(word);
		if( i >= 0)
			return dict.get(i);
		throw new Exception("Nie ma s³owa "+word+" w s³owniku.");
	}
	public void remove(String word){
		int i;
		if( (i = this.indexOf(word)) >= 0)
			dict.remove(i);
	}
	public void saveDB(String filename) throws IOException{
		File fw = new File(filename);
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(fw), "UTF-8") );
		for(int i = 0; i < this.getSize(); i++){
			bw.write(dict.get(i).getWord()+"\n");
			bw.write(dict.get(i).getClue()+"\n");
		}
		bw.close();
	}
	public int getSize(){
		return dict.size();
	}
	protected void createDB(String filename) throws IOException{
		File fr = new File(filename);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(fr), "UTF8"));
		
		int counter = 0;
		String line = null;
		while( (line = br.readLine()) != null )
			counter++;
		if( (counter % 2) != 0)
			counter--;
		br.close();
		
		fr = new File(filename);//mozliwe ze niekonieczne
		br=new BufferedReader(new InputStreamReader(
				new FileInputStream(fr), "UTF8"));
		for(int i = 0; i < counter; i+=2){
			String word = br.readLine();
			String clue = br.readLine();
			this.add(word, clue);
		}
		br.close();;
	}
	protected int indexOf(String word){
		for(int i = 0; i < this.getSize(); i++){
			if(dict.get(i).getWord().equals(word)){
				return i;
			}
		}
		return -1;
	}
}
