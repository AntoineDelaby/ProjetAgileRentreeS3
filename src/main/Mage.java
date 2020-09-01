package main;

public class Mage extends Character{
	
	public static final int HP = 10;
	public static final int DMG = 10;
	
	public static final int HEAL = 10;
	
	public Mage() {
		super(Mage.HP, Mage.DMG );
		super.name = "MAGE";
	}

	@Override
	//HEAL LA TEAM
	public void action() {
		super.team.heal(Mage.HEAL);
	}
}
