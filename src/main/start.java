package main;

import main.Plateau;

public class start {

	public static void main(String[] args) {
		scenario();

	}
	
	public static void scenario() {
		Plateau map = new Plateau(15,15);
		Team t = new Team() ;
		map.setTeam(t, 0, 0);
		System.out.println(map.toString());

		//Monster monstre = new Monster();
		//System.out.println("\n\n"+monstre);
		
		/*
		Team t = new Team() ;
		System.out.println(t);
		t.addCharacter(new Voleur());
		t.addCharacter(new Mage());
		t.addCharacter(new Archer());
		System.out.println(t);
	*/
	}

}
