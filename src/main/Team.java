package main;

import java.util.ArrayList;

public class Team extends Entity{
	
	private Coordinate coo;
	
	private String token;
	private static int nombreEquipe= 0 ;
	private ArrayList<Character> characterList;
	
	public Team() {
		super(0, 0) ;
		this.characterList = new ArrayList<Character>();
		nombreEquipe++ ;
		this.token = ""+ nombreEquipe ;
		this.coo = new Coordinate(0, 0);
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
		return token;
	}
	

	public void setToken(String token) {
		this.token = token;
	}
	
	public void setCoordinate(Coordinate coo) {
		this.coo = coo;
	}
	public Coordinate getCoordinate() {
		return this.coo;
	}
	
	
}
