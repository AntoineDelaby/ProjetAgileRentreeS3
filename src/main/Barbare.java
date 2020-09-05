package main;

public class Barbare extends Character{

	public static final int HP = 14;
	public static final int DMG = 5;
	private static final boolean PASSIF = true;
	
	public Barbare() {
		super(Barbare.HP, Barbare.DMG );
		super.name = "BARBARE";
	}
	
	public boolean isPassif() {
		return Barbare.PASSIF;
	}
	

	public void action() {
		
	}
} 
