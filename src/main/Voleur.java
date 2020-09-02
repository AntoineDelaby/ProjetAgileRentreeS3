package main;

public class Voleur extends Character{
	
	public static final int HP = 4;
	public static final int DMG = 5;
	public static final boolean PASSIF = false;
	
	public Voleur() {
		super(Voleur.HP, Voleur.DMG );
		super.name = "VOLEUR";
	}

	public boolean isPassif() {
		return Mage.PASSIF;
	}

	public void action() {
		Direction dir = Plateau.askMove(super.team);
		Plateau.move(super.team, dir);
	}
}
