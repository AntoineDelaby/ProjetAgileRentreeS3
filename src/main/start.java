package main;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import main.Plateau;

public class start {

	static Coordinate spawnT1 ;
	static Coordinate spawnT2 ;
	
	public static void main(String[] args) {
		
		menu();

	}
	
	public static void menu() {
		clear();
		System.out.println("Veuillez choisir une option du menu : \n 1 - Start \n 2 - R�gles \n 3 - Cr�dits");
		Scanner scan = new Scanner(System.in);
		String answer = scan.next();
		switch (answer) {
		case "1":
			partie();
			break;
			
		case "2":
			regles();
			break;
			
		case "3":
			credits();
			break;

		default:
			break;
		}
	}
	
	public static void regles() {
		clear();
		System.out.println("     ~~ Donjon Baston ~~\r\n" + 
				"\r\n" + 
				"R�gles du jeu :\r\n" + 
				"\r\n" + 
				"  Deux joueurs s'affrontent dans le donjon. Chaque joueur a la possibilit� de choisir\r\n" + 
				"trois personnages de classe diff�rente (ou pas!) afin de constituer leur �quipe.\r\n" + 
				"Parcourez avec votre �quipe le donjon, d�couvrez les diff�rentes salles, combattez\r\n" + 
				"les monstres que vous rencontrez, trouvez la salle du boss (il para�t qu'elle se situerait plus ou moins\r\n" + 
				"au centre du donjon ...), terrassez-le, et r�cup�rer son tr�sor !\r\n" + 
				"\r\n" + 
				"Le premier joueur � atteindre son point de d�part avec le tr�sor du boss a gagn�.\r\n" + 
				"Mais attention ! Les combats seront r�des et les blessures nombreuses! Si une �quipe perd tous ses \r\n" + 
				"points de vie, l'�quipe adverse s'empare de la victoire sans m�me avoir atteint l'objectif initial.\r\n" + 
				"\r\n" + 
				" Aventuri�res, aventuriers, � vous de jouer !\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Voici les diff�rentes classes disponibles :\r\n" + 
				"\r\n" + 
				" BARBARE :\r\n" + 
				"    - PV : 15\r\n" + 
				"    - Attaque : 7\r\n" + 
				"    - Passif : lors d'un combat, le barbare prend plus de coup pour ses co�quipier et l'�quipe\r\n" + 
				"	       du joueur prend 10% de d�g�ts en moins lors de combats. R�duisez les d�g�ts subis jusqu'� 20%\r\n" + 
				"               si votre �quipe est compos�e de deux barbares.\r\n" + 
				"\r\n" + 
				" ARCHER :\r\n" + 
				"    - PV : 13\r\n" + 
				"    - Attaque : 6\r\n" + 
				"    - Actif : l'archer est un �claireur dans l'�me. Utilisez sa comp�tence pour r�v�ler les 4 salles du donjon\r\n" + 
				"              au nord, sud, est et ouest de la salle dans laquelle votre �quipe se trouve.\r\n" + 
				"\r\n" + 
				" MAGE :\r\n" + 
				"    - PV : 11\r\n" + 
				"    - Attaque : 8\r\n" + 
				"    - Actif : le mage a la capacit� de soigner son �quipe de ses lourdes blessures. Utilisez sa comp�tence\r\n" + 
				"              afin de soigner votre �quipe de 5 PV. Ce soin monte � 10PV si l'�quipe est compos�e de deux mages.\r\n" + 
				"\r\n" + 
				" RANGER :\r\n" + 
				"    - PV : 12\r\n" + 
				"    - Attaque : 6\r\n" + 
				"    - Passif : le ranger se sent pousser des ailes en combat d'�quipe ! Ses d�g�ts d'attaque augmente l�g�rement\r\n" + 
				"	       et procurent � l'�quipe un bonus de points d'attaque de 3. Obtenez un bonus maximum de 6\r\n" + 
				"               points d'attaque si votre �quipe est compos�e de deux rangers.\r\n" + 
				"\r\n" + 
				" VOLEUR :\r\n" + 
				"    - PV : 9\r\n" + 
				"    - Attaque : 5\r\n" + 
				"    - Actif : lorsque le voleur est choisi, il a la capacit� de faire avancer son �quipe d'une case de plus,\r\n" + 
				" 	      soit deux cases en un tour. Avec deux voleur dans votre �quipe, le bonus peut aller jusqu'� deux\r\n" + 
				"              cases en plus lors du d�placement de l'�quipe.\r\n" + 
				"\r\n" + 
				"Attention ! Lors du tour d'un joueur, celui-ci a le choix entre AVANCER, ou UTILISER UNE COMPETENCE,\\\r\n" + 
				"mais pas les deux. ");
		System.out.println("\n\n\n Appuyez sur M pour retourner au Menu !");
		Scanner scan = new Scanner(System.in);
		String answer = scan.next();
		if (answer.equalsIgnoreCase("m")) {
			menu();
		}else{
			regles();
		}
	}
	
	public static void credits() {
		clear();
		System.out.println("Cr�dits : \n Antoine DELABY \n Charles DESBIENS \n Ayoub LAHOUAICHRI \n Corentin LEBLEU \n Maxime SOUDANT \n\n\n Appuyez sur M pour retourner au Menu !");
		Scanner scan = new Scanner(System.in);
		String answer = scan.next();
		if (answer.equalsIgnoreCase("m")) {
			menu();
		}else{
			credits();
		}
	}
	
	public static void clear() {
		for (int i=0; i<50; i++) {
			System.out.println("\n");
		}
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
		clear();
		affichage(map, team1, team2);
		int vainqueur = 0 ;
		while(vainqueur == 0) {
			play(map, team1);
			vainqueur = verification(team1,team2) ;
			clear();
			affichage(map, team1, team2);
			if (vainqueur != 0)	break; 
			play(map, team2);
			clear();
			affichage(map, team1, team2);
			vainqueur = verification(team1,team2) ;
		}
		clear();
		affichage(map, team1, team2);
		messageDeFin(vainqueur) ;

	}
	
	private static void messageDeFin(int vainqueur) {
		switch (vainqueur) {
		case 1:
			clear();
			System.out.println("Le vainqueur est le joueur 1.\n Felicitation!!!");
			try {
				Thread.sleep(5000);
				credits();
			}catch (InterruptedException ie) {
				
			}
			break;
		case 2:
			clear();
			System.out.println("Le vainqueur est le joueur 2.\n Felicitation!!!");
			try {
				Thread.sleep(5000);
				credits();
			}catch (InterruptedException ie) {
				
			}
			break;
		}
		
	}


	public static void play(Plateau map, Team team) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\n\nTeam "+team.toString()+" Choisissez votre action :\n");
		System.out.println(" 1-Deplacement \n 2-Action ");
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
				if (team.getCharacterList().get(i).isPassif()) {
					System.out.println((i+1) + "-pouvoir passsif") ;
				}else {
					System.out.println((i+1) + "-pouvoir " + team.getCharacterList().get(i).getName());
				}
					
			}
			answer=scan.next();

			while (Integer.parseInt(answer)<1||Integer.parseInt(answer)>3 || team.getCharacterList().get(Integer.parseInt(answer)).isPassif()) {
				System.out.println("Choix non disponible.");
				answer = scan.next();
			}
			team.getCharacterList().get(Integer.parseInt(answer)-1).action();
			break;
		}
		if(Plateau.aCombatre != null) {
			System.out.println("Vous rencontrez un ennemie avec "+Plateau.aCombatre.getAttackDamage()+" de dégâts et "+Plateau.aCombatre.getHealthPoint()+" hp.");
			try {
				TimeUnit.SECONDS.sleep(2) ;
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			while(Plateau.aCombatre.getHealthPoint()>0 && team.getHealthPoint()>0) {
				Plateau.aCombatre.setHealthPoint(Plateau.aCombatre.getHealthPoint()-team.getAttackDamage());
				System.out.println("Vous infligez "+team.getAttackDamage()+ " de dégâts à l'ennemie...");
				try {
					TimeUnit.SECONDS.sleep(2) ;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (Plateau.aCombatre.getHealthPoint()>0) {
					team.setHealthPoint(team.getHealthPoint()-Plateau.aCombatre.getAttackDamage());
					System.out.println("L'ennemie vous inflige"+team.getAttackDamage()+ " de dégâts...");
				}else {
					System.out.println("Bravo, l'ennemie a été vaincu !");
					
				}
				try {
					TimeUnit.SECONDS.sleep(2) ;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(Plateau.aCombatre instanceof Boss && team.getHealthPoint() > 0) {
				team.setTresorRecupere(true);
				System.out.println("Vous avez récupéré le trésor !\nRevenez vite à votre camp de base !");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Plateau.aCombatre = null ;
			if (team.getHealthPoint()<=0) {
				System.out.println("Aïe, l'ennemie vous a tué !");
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
			clear();
			System.out.println("Joueur "+team.toString()+", veuillez choisir votre classe "+(i+1)+" parmis : \n 1-Archer \n 2-Mage \n 3-Voleur \n 4-Barbare \n 5-Ranger");
			String answer=scan.next();
			while (Integer.parseInt(answer)<1||Integer.parseInt(answer)>5) {
				System.out.println("Choix non disponible, choisis parmis : \n 1-Archer \n 2-Mage \n 3-Voleur \n 4-Barbare \n 5-Ranger");
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
			case "4":
				team.addCharacter(new Barbare());
				break;
			case "5":
				team.addCharacter(new Ranger());
				break;

			default:
				break;
			} 
		}
			
	}
	
	

}
