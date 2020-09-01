package main;

import java.util.Random;
import java.util.Scanner;

import main.Plateau;

public class start {

	public static void main(String[] args) {
		//scenarioTest();
		partie();

	}
	
	public static void scenarioTest() {
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
	
	
	public static void partie() {
		Random rand = new Random();
		
		Team team1 = new Team();
		Team team2 = new Team();
		creationDesTeam(team1);
		System.out.println("\n\n\n");
		creationDesTeam(team2);
		
		Plateau map = new Plateau(15,15);
		map.setTeam(team1, 0, rand.nextInt(15));
		map.setTeam(team2, 14, rand.nextInt(15));
		
	
		map.setTeam(new Boss(), 6+rand.nextInt(3), 6+rand.nextInt(3));
		
		
		System.out.println(map.toString());
		
	}
	
	public static void creationDesTeam(Team team) {
		Scanner scan=new Scanner(System.in);
		for (int i=0; i<3; i++) {
			System.out.println("Joueur "+team.toString()+", veuillez choisir votre classe "+(i+1)+" parmis : \n 1-Archer \n 2-Mage \n 3-Voleur");
			switch (scan.next()) {
			case "1":
				team.addCharacter(new Archer());
				break;
				
			case "2":
				team.addCharacter(new Mage());
				break;
				
			case "3":
				team.addCharacter(new Voleur());
				break;

			default:
				break;
			}
		}
			
	}
	
	

}
