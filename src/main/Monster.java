package main;

import java.util.Random;

public class Monster extends Entity {

	private String name;
	
	private static Random rand = new Random();
	
	private static final int HPMIN=17;
	private static final int HPMAX=25;
	private static final int ADMIN=5; 
	private static final int ADMAX=8;
	private boolean hide = true;
	
	
	
	public Monster() {
		super(HPMIN+rand.nextInt(HPMAX-HPMIN),ADMIN+rand.nextInt(ADMAX-ADMIN));	
		super.setHide(true);
		this.name = "M";
		if (rand.nextInt(3)==0) {
			super.setObjet(new Item()) ;
			name = "I";			
		}
	}
	
	

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return name;
	}



	public boolean isHide() {
		return hide;
	}



	public void setHide(boolean hide) {
		this.hide = hide;
	}




	
	
	
}
