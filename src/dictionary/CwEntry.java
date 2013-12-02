package dictionary;

public class CwEntry extends Entry{
    private int x;
    private int y;
    private Direction d;
    
    public CwEntry(String word, String clue){
    	super(word, clue);
    }
    public void setX(int x){
    	this.x = x;
    }
    public int getX(){
    	return x;
    }
    public void setY(int y){
    	this.y = y;
    }
    public int getY(){
    	return y;
    }
    public void setDir(Direction d){
    	this.d = d;
    }
    public int getDir(){
    	return d.getNum();
    }
}
