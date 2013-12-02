package dictionary;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		String in = "/home/tom/java/crossroads/cwdb.txt";
		String out = "/home/tom/java/crossroads/cwdb_out.txt";
		InteliCwDB db = new InteliCwDB(in);
		//Crossword cw = new Crossword(10, 10, db);
		Board a = new Board(10,10);
		a.width = 10;
		a.height = 10;
		BoardCell bc = new BoardCell();
		bc.setContent("a");
		bc.enableHorizStart();
		try{
			a.setCell(0, 0, bc);
			a.setCell(4, 0, bc);
			LinkedList<BoardCell> list = a.getStartCells();
			System.out.println( list.get(0).getContent() );
			String p = a.createPattern(0, 0, 5, 0);
			System.out.println(p);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*try{
			System.out.println( db.getRandom(6).getWord() );
			System.out.println( db.get("cukier").getClue() );
		}catch(Exception e){
			e.printStackTrace();
		}*/
		try{
			db.saveDB(out);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
