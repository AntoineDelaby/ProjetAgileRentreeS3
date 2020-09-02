package main;

import java.util.Scanner;

import main.Direction;
import main.Team;

public class Plateau {
	private static int length;
	private static int width;
	private static Entity[][]plateau;
	
	public static Entity aCombatre ;
	
	public Plateau (int length, int width) {

		this.length=length;
		this.width=width;
		this.plateau=new Entity[this.length][this.width];
		aCombatre = null ;

		Plateau.length=length;
		Plateau.width=width;
		plateau=new Entity[length][width];
//>>>>>>> branch 'master' of https://gitlab.univ-lille.fr/2020-S3-projet/groupe-5.git
	}

	@Override
	public String toString() {
		String tmp="";
		for (int i=0; i<length; i++) {
			tmp+="-";
			for (int z=0;z<length;z++) {
				tmp+="---";
			}
			tmp+="\n";
			tmp+="|";
			for (int j=0; j<this.width; j++) {
				if(plateau[i][j]==null||plateau[i][j].isHide()) {
					tmp+="  ";
				}else{
					tmp+=plateau[i][j].toString() + " ";
				}
				tmp+="|";
			}
			tmp+="\n";
		}
		for (int i=0;i<this.length;i++) {
			tmp+="---";
		}
		return tmp+"-";
	}

	
	public static void setTeam(Entity t, int x, int y) {
		plateau[x][y] = t ;
		t.setCoordinate(new Coordinate(x, y));
	}
	public static void setTeam(Entity t, Coordinate coo) {
		setTeam(t, coo.getX(), coo.getY());
	}
	
	public static boolean move(Team team, Direction dir) {
		aCombatre = null ;
		Coordinate tmp = team.getCoordinate();
		
		Coordinate update = tmp.update(dir);
		
		if ( (update.getX()<0) || (update.getY()<0) || 
				(update.getX()>=length) || (update.getY()>=width)) {
			return false;
		}
		
		aCombatre = plateau[update.getX()][update.getY()] ;
		
		plateau[tmp.getX()][tmp.getY()] = null;
		setTeam(team, update);
		return true;
	}
	
	public Entity getCase(int x, int y) {
		return plateau[x][y];
	}
	
	public static Direction askMove(Team team) {
		Scanner scan = new Scanner(System.in);
		Direction dir = null;
		do {
			System.out.println("Dans quelle direction voulez vous vous déplacer ?");
			System.out.println("N - S - E - O");
			String res = scan.nextLine();
			dir = null;
			switch (res) {
			case "N":
				dir = Direction.NORTH;
				break;
			case "S":
				dir = Direction.SOUTH;
				break;
			case "E":
				dir = Direction.EAST;
				break;
			case "O":
				dir = Direction.WEST;
				break;

			}
		}while ((dir==null) || (!move(team, dir)));
		
		return dir;
	}
	
}
