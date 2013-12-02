package dictionary;

public abstract class Strategy {
	public abstract CwEntry findEntry(Crossword cw);
	public abstract void updateBoard(Board b, CwEntry e); 
}
