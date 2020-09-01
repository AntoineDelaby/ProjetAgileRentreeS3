package main;

public class Archer extends Character{
	
	public static final int HP = 2;
	public static final int DMG = 2;
	public static final boolean PASSIF = false;
	
	public static final int PORTEE = 5;
	
	public Archer() {
		super(Archer.HP, Archer.DMG );
		super.name = "ARCHER";
	}
	
	public boolean isPassif() {
		return Archer.PASSIF;
	}
	
	@Override
	public void action() {
		
	}
	
}
