package main;

import java.util.Random;
import java.util.Scanner;

import main.Plateau;

public class start {

	static Coordinate spawnT1 ;
	static Coordinate spawnT2 ;
	
	public static void main(String[] args) {
		
		partie();

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
		spawnT1 = team1.getCoordinate() ;
		spawnT2 = team2.getCoordinate() ;
		
		MonsterMap(map);
		
		deroulement(map, team1, team2);
		
	}
	
	private static int verification(Team team1, Team team2) {
		if(team1.getHealthPoint() <= 0) return 2;
		if(team2.getHealthPoint() <= 0) return 1;
		if(team1.getCoordinate().equals(spawnT1) && team1.isTresorRecupere()) return 1 ;
		if(team2.getCoordinate().equals(spawnT2) && team2.isTresorRecupere()) return 2 ;
		return 0;
	}
	public static void deroulement(Plateau map, Team team1, Team team2) {
		affichage(map, team1, team2);
		int vainqueur = 0 ;
		while(vainqueur == 0) {
			play(map, team1);
			vainqueur = verification(team1,team2) ;
			affichage(map, team1, team2);
			if (vainqueur != 0)	break; 
			play(map, team2);
			affichage(map, team1, team2);
			vainqueur = verification(team1,team2) ;
		}
		affichage(map, team1, team2);
		messageDeFin(vainqueur) ;

	}
	
	private static void messageDeFin(int vainqueur) {
		switch (vainqueur) {
		case 1:
			System.out.println("Le vainqueur est le joueur 1.\n Felicitation!!!");
			break;
		case 2:
			System.out.println("Le vainqueur est le joueur 2.\n Felicitation!!!");
			break;
		}
		
	}


	public static void play(Plateau map, Team team) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n Choisissez votre action :");
		System.out.println("1-Deplacement \n 2-Action ");
		String answer=scan.next();

		while (Integer.parseInt(answer)<1||Integer.parseInt(answer)>2) {
			System.out.println("Choix non disponible, choisis parmis : \n 1-Deplacement \n 2-Action ");
			answer = scan.next();
		}
		
		switch (answer) {
		case "1":
			team.getCoordinate().update(map.askMove(team));
			break;
			
		case "2":
			for(int i = 0; i < 3; i++) {
				System.out.println((i+1) + "-pouvoir " + team.getCharacterList().get(i));
			}
			answer=scan.next();

			while (Integer.parseInt(answer)<1||Integer.parseInt(answer)>3) {
				System.out.println("Choix non disponible.");
				answer = scan.next();
			}
			team.getCharacterList().get(Integer.parseInt(answer)-1).action();
			break;
		}
		if(Plateau.aCombatre != null) {
			while(Plateau.aCombatre.getHealthPoint()>=0 && team.getHealthPoint()>=0) {
				Plateau.aCombatre.setHealthPoint(Plateau.aCombatre.getHealthPoint()-team.getAttackDamage());
				if (Plateau.aCombatre.getHealthPoint()>=0) {
					team.setHealthPoint(team.getHealthPoint()-Plateau.aCombatre.getAttackDamage());
				}
			}
		}
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
