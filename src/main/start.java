package main;

import main.Plateau;

public class start {

	public static void main(String[] args) {
		scenario();

	}
	
	public static void scenario() {
		Plateau plateau = new Plateau(15,15);
		System.out.println(plateau.toString());
	}

}
