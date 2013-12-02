package dictionary;
import java.util.*;

public class Board {
	int width;
	int height;
    public BoardCell[][] board;
    
    public Board(int width, int height){
    	this.width = width;
    	this.height = height;
    	board = new BoardCell[width][height];
    	for(int i = 0; i < width; i++){
    		for(int j = 0; j < height; j++)
    			board[i][j] = new BoardCell();
    	}
    }
    public int getWidth(){
    	return width;
    }
    public int getHeight(){
    	return height;
    }
    public BoardCell getCell(int x, int y)throws Exception{
    	if(this.isInRangeX(x) && this.isInRangeY(y))
    			return board[x][y];
    	throw new Exception("Index out of range.");
    }
    public void setCell(int x, int y, BoardCell c)throws Exception{
    	if(this.isInRangeX(x) && this.isInRangeY(y))
    		board[x][y] = c;
    	else
    		throw new Exception("Index out of range.");
    }
    public LinkedList<BoardCell> getStartCells(){
    	LinkedList<BoardCell> starters = new LinkedList<BoardCell>();
    	for(int i = 0; i < this.getWidth(); i++){
    		for(int j = 0; j < this.getHeight(); j++){
    			if(board[i][j].vert.getStart() == 1)
    				starters.add(board[i][j]);
    			if(board[i][j].horiz.getStart() == 1)
    				starters.add(board[i][j]);
    		}
    	}
    	return starters;
    }
    protected String createPattern(int fromx, int fromy, int tox, int toy)throws Exception{
    	String pattern = null;
    	String c = null;
    	String empty = "(\\w)";
    	if( this.isInRangeX(fromx) && this.isInRangeY(fromy) && this.isInRangeX(tox) && this.isInRangeY(toy) ){
    		if(fromx < tox && fromy == toy){
    			for(int i = 0; i < tox; i++){
    				try{
    					if( (c = this.getCell(i, fromy).getContent()) != null){
    						pattern = (pattern!=null) ? pattern+"("+c+")" : "("+c+")";
    					}
    					else
    						pattern = (pattern!=null) ? pattern+empty : empty;
    				}catch(Exception e){
    					throw e;
    				}
    			}
    		}
    		else if(fromy < toy && fromx == tox){
    			for(int i = 0; i < toy; i++){
    				try{
    					if( (c = this.getCell(fromx, i).getContent()) != null){
    						pattern = (pattern!=null) ? pattern+"("+c+")" : "("+c+")";
    					}
    					else
    						pattern = (pattern!=null) ? pattern+empty : empty;
    				}catch(Exception e){
    					throw e;
    				}
    			}
    		}
    		else{
    			throw new Exception("Wrong range.");
    		}
    		return pattern;
    	}
    	else
    		throw new Exception("Index out of range.");
    }
    protected boolean isInRangeX(int x){
    	if(x >= 0 && x < this.getWidth())
    		return true;
    	return false;
    }
    protected boolean isInRangeY(int y){
    	if(y >= 0 && y < this.getHeight())
    		return true;
    	return false;
    }
}
