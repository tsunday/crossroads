package crossword;


import dictionary.InteliCwDB;

//import java.util.*;
public class Test {

	public static void main(String[] args) {
		String in = "c:\\Users\\Tomek\\Programowanie\\java\\crossroads\\cwdb.txt";
		String out = "c:\\Users\\Tomek\\Programowanie\\java\\crossroads\\cwdb_out.txt";
		InteliCwDB db = new InteliCwDB(in);
		
		try{
			db.saveDB(out);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
