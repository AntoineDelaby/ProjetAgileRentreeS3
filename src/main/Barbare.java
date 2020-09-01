package main;

public class Barbare extends Character{

	public static final int HP = 20;
	public static final int DMG = 20;
	private static final boolean PASSIF = true;
	
	public Barbare() {
		super(Barbare.HP, Barbare.DMG );
		super.name = "BARBARE";
	}
	
	public boolean isPassif() {
		return Barbare.PASSIF;
	}
	
	@Override
	public void action() {
		
	}
}
