package main;

public class Ranger extends Character{

	public static final int HP = 7;
	public static final int DMG = 7;
	private static final boolean PASSIF = true;
	
	public Ranger() {
		super(Ranger.HP, Ranger.DMG );
		super.name = "RANGER";
	}
	
	public boolean isPassif() {
		return Ranger.PASSIF;
	}
	
	@Override
	public void action() {
		
	}
}
