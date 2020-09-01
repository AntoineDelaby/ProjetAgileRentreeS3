package main;

public class Archer extends Character{
	
	public static final int HP = 2;
	public static final int DMG = 2;
	
	public static final int PORTEE = 5;
	
	public Archer() {
		super(Archer.HP, Archer.DMG );
		super.name = "ARCHER";
	}

	@Override
	//FAIRE DES DEGATS SUR PLUSIEURS CASES DEVANT
	public void action() {
		//TODO super.team.makeDamage ou je sais pas quoi
	}
	
}
