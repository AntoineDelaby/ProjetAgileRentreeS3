package main;

import java.util.Random;

public class Monster extends Entity {

	private String name = "M";
	
	private static Random rand = new Random();
	
	private static final int HPMIN=10;
	private static final int HPMAX=20;
	
	private static final int ADMIN=8;
	private static final int ADMAX=15;
	
	
	
	public Monster() {
		super(HPMIN+rand.nextInt(HPMAX-HPMIN),ADMIN+rand.nextInt(ADMAX-ADMIN));	
	}
	

	@Override
	public String toString() {
		return ""+this.name+" : "+super.toString();
	}
	
	
	
}
