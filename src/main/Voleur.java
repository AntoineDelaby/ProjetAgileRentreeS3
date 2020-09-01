package main;

public class Voleur extends Character{
	
	public static final int HP = 5;
	public static final int DMG = 5;
	
	public Voleur() {
		super(Voleur.HP, Voleur.DMG );
		super.name = "VOLEUR";
	}

	@Override
	//AVANCER DE PLUSIEURS CASES
	public void action() {
		Direction dir = Plateau.askMove(super.team);
		Plateau.move(super.team, dir);
	}
}
