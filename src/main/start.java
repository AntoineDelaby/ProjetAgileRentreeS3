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
	
		MonsterMap(map);
		affichage(map,team1,team2) ;
		
		
	}
	

	
	private static void affichage(Plateau p, Team t1, Team t2) {
		String tabulation = "\t" ;
		
		System.out.println(p.toString());
		System.out.print("Equipe1- "+"pv:"+t1.getHealthPoint()+ " attaque:"+t1.getAttackDamage()+tabulation) ;
		System.out.print("Equipe2- "+"pv:"+t2.getHealthPoint()+ " attaque:"+t2.getAttackDamage()) ;
		for (int i = 0; i < 3; i++) {
			System.out.println();
			System.out.print(tabulation +t1.getCharacterList().get(i).getName());
			System.out.print("                      "+tabulation);
			System.out.print(t2.getCharacterList().get(i).getName());
		}
	}

	public static void MonsterMap(Plateau map) {
		Random rand = new Random();
		map.setTeam(new Boss(), 6+rand.nextInt(3), 6+rand.nextInt(3));
		
		for (int i = 0; i<15; i++) {
			for (int j=0;j<15;j++) {
				if (map.getCase(i, j)==null) {
					if (rand.nextInt(5)==3) {
						map.setTeam(new Monster(), i, j);
					}
				}
			}
		}
	}
	
	public static void creationDesTeam(Team team) {
		Scanner scan=new Scanner(System.in);
		for (int i=0; i<3; i++) {
			System.out.println("Joueur "+team.toString()+", veuillez choisir votre classe "+(i+1)+" parmis : \n 1-Archer \n 2-Mage \n 3-Voleur");
			String answer=scan.next();
			while (Integer.parseInt(answer)<1||Integer.parseInt(answer)>3) {
				System.out.println("Choix non disponible, choisis parmis : \n 1-Archer \n 2-Mage \n 3-Voleur");
				answer = scan.next();
			}
			switch (answer) {
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
