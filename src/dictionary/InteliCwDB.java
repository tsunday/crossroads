package dictionary;
import java.util.*;

public class InteliCwDB extends CwDB{
	public InteliCwDB(String filename){
		super(filename);
	}
	public LinkedList<Entry> findAll(String pattern)throws Exception{
		LinkedList<Entry> found = new LinkedList<Entry>();
		for(int i = 0; i < this.getSize(); i++){
			if( dict.get(i).getWord().matches(pattern) )
				found.add(dict.get(i));
		}
		if(!found.isEmpty())
			return found;
		throw new Exception("Brak rekordów o podanej charakterystyce.");
	}
	public Entry getRandom(){
		return dict.get( (int)(Math.random()*this.getSize()) );
	}
	public Entry getRandom(int length)throws Exception{
		try{
			return this.getRandom("^\\w{"+length+"}$");
		}catch(Exception e){
			throw e;
		}
	}
	public Entry getRandom(String pattern)throws Exception{
		try{
			LinkedList<Entry> found = this.findAll(pattern);
			return found.get( (int)(Math.random()*found.size()) );
		}catch(Exception e){
			throw e;
		}
	}
	@Override
	public void add(String word, String clue){
		if( dict.isEmpty() )
			dict.add( new Entry(word, clue) );
		else{
			for(int i = 0; i < dict.size(); i++){
				if( word.compareTo( dict.get(i).getWord() ) <= 0){
					dict.add(i, new Entry(word, clue) );
					break;
				}
				if( i == (dict.size()-1) )
					dict.add(new Entry(word, clue));
			}
		}
	}
}
