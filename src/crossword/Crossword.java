package crossword;
import java.util.*;

import dictionary.CwEntry;
import dictionary.InteliCwDB;
import board.Board;

public class Crossword {
	private LinkedList<CwEntry> entries;
	private Board b;
	private InteliCwDB cwdb;
	private final long ID = -1;
	
	public Crossword(int width, int height, InteliCwDB cwdb){
		b = new Board(width,height);
		this.cwdb = cwdb;
		
	}
	public Iterator<CwEntry> getROEntryIter(){
		return entries.iterator();
	}
	public Board getBoardCopy(){
		return b;
	}
	public InteliCwDB getCwDB(){
		return cwdb;
	}
	public void setCwDB(InteliCwDB cwdb){
		this.cwdb = cwdb;
	}
	public boolean contains(String word){
		 for(int i =0; i < entries.size(); i++){
			 if(entries.get(i).getWord() == word)
				 return true;
		 }
		 return false;
	}
	public final void addCwEntry(CwEntry cwe, Strategy s){
		entries.add(cwe);
		s.updateBoard(b,cwe);
	}
	public final void generate(Strategy s){
		CwEntry e = null;
		while((e = s.findEntry(this)) != null){
			addCwEntry(e,s);
		}
	}

}
