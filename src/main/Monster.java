package main;

import java.util.Random;

public class Monster extends Entity {

	private String name = "M";
	
	private static Random rand = new Random();
	private static int HpMin=10;
	private static int AdMin=8;
	
	
	public Monster() {
		super(HpMin+=rand.nextInt(11),AdMin+=rand.nextInt(8));	
	}
	

	@Override
	public String toString() {
		return ""+this.name+" : "+super.toString();
	}
	
	
	
}
