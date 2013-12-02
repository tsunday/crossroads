package dictionary;

public enum Direction{
	HORIZ(0), VERT(1);
	
	private int num;
	Direction(int num){
		this.num = num;
	}
	public int getNum(){
		return num;
	}
}