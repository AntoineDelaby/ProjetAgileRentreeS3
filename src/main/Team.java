package main;

import java.util.ArrayList;

public class Team extends Entity{
	
	private static final int MAX_HP = 30;
	
	private String token;
	private static int nombreEquipe= 0 ;
	private ArrayList<Character> characterList;
	private boolean tresorRecupere ;
	
	public Team() {
		super(0, 0) ;
		this.characterList = new ArrayList<Character>();
		nombreEquipe++ ;
		this.token = ""+ nombreEquipe ;
		this.coo = new Coordinate(0, 0);
		setTresorRecupere(false) ;
	}
	
	public void addCharacter(Character charac) {
		this.characterList.add(charac);
		charac.setTeam(this);
		super.setHealthPoint(super.getHealthPoint() + charac.getHealthPoint());
		super.setAttackDamage(super.getAttackDamage() + charac.getDamgage()) ;
	}
	
	//Faire subir des degats a la team ou heal la team 
	public void heal(int amount) {
		if ((super.getHealthPoint()+amount)<Team.MAX_HP) {
			super.setHealthPoint(super.getHealthPoint()+ amount);
		}else {
			super.setHealthPoint(Team.MAX_HP);
		}
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
	
	public ArrayList<Character> getCharacterList() {
		return characterList;
	}

	public boolean isTresorRecupere() {
		return tresorRecupere;
	}

	public void setTresorRecupere(boolean tresorRecupere) {
		this.tresorRecupere = tresorRecupere;
	}

	
	
}
