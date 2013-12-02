package dictionary;

public class CwEntry extends Entry{
    private int x;
    private int y;
    private Direction d;
    
    public CwEntry(String word, String clue){
    	super(word, clue);
    }
    public int getX(){
    	return x;
    }
    public int getY(){
    	return y;
    }
    public int getDir(){
    	return d.getNum();
    }

}

enum Direction{
	HORIZ(0), VERT(1);
	
	private int num;
	Direction(int num){
		this.num = num;
	}
	public int getNum(){
		return num;
	}
}
