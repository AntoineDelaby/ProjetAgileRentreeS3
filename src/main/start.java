package main;

import main.Plateau;

public class start {

	public static void main(String[] args) {
		scenario();

	}
	
	public static void scenario() {
		Plateau plateau = new Plateau(15,15);
		Monster monstre = new Monster();
		System.out.println(plateau.toString());
		System.out.println("\n\n"+monstre);
		
	}

}
