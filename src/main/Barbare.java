package main;

public class Barbare extends Character{

	public static final int HP = 10;
	public static final int DMG = 7;
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
