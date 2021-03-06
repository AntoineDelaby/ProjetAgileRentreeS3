package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

	static Coordinate spawnT1 ;
	static Coordinate spawnT2 ;
	
	//pour la taille, prendre un nombre divisible par 3
	static final int TAILLE_MAP = 9 ;
	static final int RNG_MONSTER = 2;
	
	public static void main(String[] args) throws IOException {
		menu();
	}
	
	public static void menu() throws IOException {
		clear();
		
		System.out.println("     ~~ Donjon Baston ~~\n\n\nVeuillez choisir une option du menu : \n 1 - Start \n 2 - Regles \n 3 - Credits \n 4 - Quiter ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String answer ; 
		
		answer = scan.next();
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
			
			case "4":
				System.exit(0);
				break;

			}

	
	}
	
	public static void regles() throws IOException {
		clear();
		BufferedReader lecteur = null;
		String regles;
		try {
			lecteur=new BufferedReader(new FileReader("src/main/ReglesDuJeuDonjonBaston.txt"));
		}catch (FileNotFoundException e) {
			System.out.println("Erreur d'ouverture ...");
		}while ((regles=lecteur.readLine())!=null) {
			System.out.println(regles);
			
		}
		lecteur.close();
		System.out.println("\n\n\n Appuyez sur M pour retourner au Menu !");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String answer = scan.next();
		if (answer.equalsIgnoreCase("m")) {
			menu();
		}else{
			regles();
		}
	}
	
	public static void credits() throws IOException {
		clear();
		System.out.println("Credits : \n Antoine DELABY \n Charles DESBIENS \n Ayoub LAHOUAICHRI \n Corentin LEBLEU \n Maxime SOUDANT \n\n\n Appuyez sur M pour retourner au Menu !");
		@SuppressWarnings("resource")
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
	
	public static void partie() throws IOException {
		Random rand = new Random();
		
		Team team1 = new Team();
		Team team2 = new Team();
		creationDesTeam(team1);
		System.out.println("\n\n\n");
		creationDesTeam(team2);
		
		Plateau map = new Plateau(TAILLE_MAP,TAILLE_MAP);
		Plateau.setTeam(team1, 0, rand.nextInt(TAILLE_MAP));
		Plateau.setTeam(team2, TAILLE_MAP-1, rand.nextInt(TAILLE_MAP));
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
	public static void deroulement(Plateau map, Team team1, Team team2) throws IOException {
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
	
	private static void messageDeFin(int vainqueur) throws IOException {
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
		@SuppressWarnings("resource")
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
			team.getCoordinate().update(Plateau.askMove(team));
			break;
			
		case "2":
			for(int i = 0; i < 3; i++) {
				if (team.getCharacterList().get(i).isPassif()) {
					System.out.println((i+1) + "-pouvoir passsif") ;
				}else {
					System.out.println((i+1) + "-pouvoir " + team.getCharacterList().get(i).getName());
				}
			}
			System.out.println("4-retour");
			answer=scan.next();

			if(Integer.parseInt(answer)==4) {
				play(map, team);
				return ;
			}
			
			while (Integer.parseInt(answer)<1||Integer.parseInt(answer)>3 || team.getCharacterList().get(Integer.parseInt(answer)-1).isPassif()) {
				System.out.println("Choix non disponible.");
				answer = scan.next();
			}
			team.getCharacterList().get(Integer.parseInt(answer)-1).action();
			break;
		}
		if(Plateau.aCombatre != null) {
			System.out.println("Vous rencontrez un ennemie avec "+Plateau.aCombatre.getAttackDamage()+" de degats et "+Plateau.aCombatre.getHealthPoint()+" hp.");
			if (Plateau.aCombatre instanceof Boss) {
				System.out.println("Attention c'est le Boss !!!");
			}
			try {
				TimeUnit.SECONDS.sleep(2) ;
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			while(Plateau.aCombatre.getHealthPoint()>0 && team.getHealthPoint()>0) {
				Plateau.aCombatre.setHealthPoint(Plateau.aCombatre.getHealthPoint()-team.getAttackDamage());
				System.out.println("Vous infligez "+team.getAttackDamage()+ " de degats a?? l'ennemie...");
				try {
					TimeUnit.SECONDS.sleep(2) ;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (Plateau.aCombatre.getHealthPoint()>0) {
					team.setHealthPoint(team.getHealthPoint()-Plateau.aCombatre.getAttackDamage());
					System.out.println("L'ennemie vous inflige "+team.getAttackDamage()+ " de degats...");
				}else {
					System.out.println("Bravo, l'ennemie a ete vaincu !");
					
				}
				try {
					TimeUnit.SECONDS.sleep(2) ;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(Plateau.aCombatre instanceof Boss && team.getHealthPoint() > 0) {
				team.setTresorRecupere(true);
				System.out.println("Vous avez recupere le tresor !\nRevenez vite a?? votre camp de base !");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if (team.getHealthPoint()<=0) {
				System.out.println("Aie, l'ennemie vous a tue !");
				return ;
			}
			
			if(Plateau.aCombatre.getObjet() != null) {
				System.out.println("\nVous trouvez des morceaux d'equipement sur le monstre...");
				System.out.print("Felicitation, ces objets augmente votre ");
				if (Plateau.aCombatre.getObjet().isArme()) System.out.print("attaque ");
				else System.out.print("defense ");
				System.out.println("de "+Plateau.aCombatre.getObjet().getBoost()+" !");
				
				team.setItem(Plateau.aCombatre.getObjet());
				try {
					TimeUnit.SECONDS.sleep(5) ;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			Plateau.aCombatre = null ;
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
		Plateau.setTeam(new Boss(), (TAILLE_MAP/3) +rand.nextInt(TAILLE_MAP/3), (TAILLE_MAP/3) +rand.nextInt(TAILLE_MAP/3));
		
		for (int i = 0; i<TAILLE_MAP; i++) {
			for (int j=0;j<TAILLE_MAP;j++) {
				if (map.getCase(i, j)==null) {
					if (rand.nextInt(RNG_MONSTER)==0) {
						Plateau.setTeam(new Monster(), i, j);
					}
				}
			}
		}
	}
	
	public static void creationDesTeam(Team team) {
		@SuppressWarnings("resource")
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