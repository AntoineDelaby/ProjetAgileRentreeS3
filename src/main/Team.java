package main;

import java.util.ArrayList;

public class Team {

	private int healthPoint;
	private int damage;
	private ArrayList<Character> characterList;
	
	public Team() {
		this.characterList = new ArrayList<Character>();
	}
	
	public void addCharacter(Character charac) {
		this.characterList.add(charac);
		charac.setTeam(this);
		this.healthPoint += charac.getHealthPoint();
		this.damage += charac.getDamgage();
	}
	
	//Faire subir des degats a la team ou heal la team 
	public void heal(int amount) {
		this.healthPoint = this.healthPoint + amount;
	}
	public void damage(int amount) {
		this.healthPoint = this.healthPoint - amount;
		if (this.healthPoint<0) this.healthPoint = 0; 
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		for (Character charac : this.characterList) {
			str.append(charac.getName()+",");
		}
		str.append("]" + "HP:" + this.healthPoint + " DMG: " + this.damage);
		return str.toString();
	}
}
