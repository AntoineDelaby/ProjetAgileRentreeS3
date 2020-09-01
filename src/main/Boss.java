package main;

public class Boss extends Monster{

	private boolean Tresor = true;
	
	private static final int COEFFHP = 3;
	private static final int COEFFATTACK = 2;
	
	public Boss() {
		super();
		this.setHealthPoint(this.getHealthPoint() * COEFFHP);
		this.setAttackDamage(this.getAttackDamage() * COEFFATTACK);
	}
	
	public String toString() {
		return "B";
	}
}
