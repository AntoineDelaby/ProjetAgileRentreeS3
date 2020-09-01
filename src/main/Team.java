package main;

import java.util.ArrayList;

public class Team extends Entity{

	
	private ArrayList<Character> characterList;
	public Team() {
		super(0, 0) ;
		this.characterList = new ArrayList<Character>();
	}
	
	public void addCharacter(Character charac) {
		this.characterList.add(charac);
		charac.setTeam(this);
		super.setHealthPoint(super.getHealthPoint() + charac.getHealthPoint());
		super.setAttackDamage(super.getAttackDamage() + charac.getDamgage()) ;
	}
	
	//Faire subir des degats a la team ou heal la team 
	public void heal(int amount) {
		super.setHealthPoint(super.getHealthPoint()+ amount);
	}
	public void damage(int amount) {
		super.setHealthPoint(super.getHealthPoint() - amount);
		if (super.getHealthPoint()<0) super.setHealthPoint(0); 
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		for (Character charac : this.characterList) {
			str.append(charac.getName()+",");
		}
		str.append("]" + "HP:" + super.getHealthPoint() + " DMG: " + super.getAttackDamage());
		return str.toString();
	}
	
	
}
