package main;

public class Archer extends Character{
	
	public static final int HP = 8;
	public static final int DMG = 6;
	public static final boolean PASSIF = false;
	
	public Archer() {
		super(Archer.HP, Archer.DMG );
		super.name = "ARCHER";
	}
	
	public boolean isPassif() {
		return Archer.PASSIF;
	}
	

	public void action() {
		boolean res = false;
		for (int i=0; i<Direction.values().length; i++) {
			Plateau.reveal(super.team.getCoordinate().update(Direction.values()[i]));
		}
	}
	
}
