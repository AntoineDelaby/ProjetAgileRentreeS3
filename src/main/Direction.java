package main;

public enum Direction {
	
	NORTH(-1,0),EAST(0,1),SOUTH(1,0),WEST(0,-1);
	
	private int x;
	private int y;
	
	private Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
