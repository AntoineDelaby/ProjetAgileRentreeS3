package main;

import java.util.Random;

public class Item {
	private boolean arme ;
	private int boost ;
	
	public Item() {
		Random rand = new Random() ;
		this.arme = rand.nextBoolean();
		if (arme) {
			this.setBoost(rand.nextInt(5)+1) ;
		}
	}

	public int getBoost() {
		return boost;
	}
	public void setBoost(int boost) {
		this.boost = boost;
	}
	public boolean isArme() {
		return arme;
	}


	
	
	
}
