package dictionary;

public class BoardCell {
	public Mode vert;
	public Mode horiz;
	String content;
	
	public BoardCell(){
		vert = new Mode();
		horiz = new Mode();
		content = null;
	}
	public void enableVertStart(){
		vert.setStart(1);
	}
	public void disableVertStart(){
		vert.setStart(0);
	}
	public void enableVertInner(){
		vert.setInner(1);
	}
	public void disableVertInner(){
		vert.setInner(0);
	}
	public void enableVertEnd(){
		vert.setEnd(1);
	}
	public void disableVertEnd(){
		vert.setEnd(0);
	}
	public void enableHorizStart(){
		horiz.setStart(1);
	}
	public void disableHorizStart(){
		horiz.setStart(0);
	}
	public void enableHorizInner(){
		horiz.setInner(1);
	}
	public void disableHorizInner(){
		horiz.setInner(0);
	}
	public void enableHorizEnd(){
		horiz.setEnd(1);
	}
	public void disableHorizEnd(){
		horiz.setEnd(0);
	}
	public String getContent() {
		return content;
	}
	protected void setContent(String content) {
		this.content = content;
	}
}

class Mode{
	int start, inner, end;
	
	public Mode(){
		start = 0;
		inner = 0;
		end = 0;
	}
	public int getStart() {
		return start;
	}
	protected void setStart(int start) {
		this.start = start;
	}
	public int getInner() {
		return inner;
	}
	public void setInner(int inner) {
		this.inner = inner;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}
