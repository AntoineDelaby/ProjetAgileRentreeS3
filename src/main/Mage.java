package main;

public class Mage extends Character{
	
	public static final int HP = 11;
	public static final int DMG = 8;
	public static final boolean PASSIF = false;
	
	public static final int HEAL = 10;
	
	public Mage() {
		super(Mage.HP, Mage.DMG );
		super.name = "MAGE";
	}

	public boolean isPassif() {
		return Mage.PASSIF;
	}
	

	public void action() {
		super.team.heal(Mage.HEAL);
	}
}
