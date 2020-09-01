package main;

import java.util.Scanner;

import main.Direction;
import main.Team;

public class Plateau {
	private int length;
	private int width;
	private Entity[][]plateau;
	
	public Plateau (int length, int width) {
		this.length=length;
		this.width=width;
		this.plateau=new Entity[this.length][this.width];
	}

	@Override
	public String toString() {
		String tmp="";
		for (int i=0; i<this.length; i++) {
			tmp+="-";
			for (int z=0;z<this.length;z++) {
				tmp+="---";
			}
			tmp+="\n";
			tmp+="|";
			for (int j=0; j<this.width; j++) {
				if(this.plateau[i][j]==null||this.plateau[i][j].isHide()) {
					tmp+="  ";
				}else{
					tmp+=this.plateau[i][j].toString() + " ";
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

	
	public void setTeam(Entity t, int x, int y) {
		this.plateau[x][y] = t ;
		t.setCoordinate(new Coordinate(x, y));
	}
	public void setTeam(Entity t, Coordinate coo) {
		this.setTeam(t, coo.getX(), coo.getY());
	}
	
	public boolean move(Team team, Direction dir) {
		Coordinate tmp = team.getCoordinate();
		
		Coordinate update = tmp.update(dir);
		if ( (update.getX()<0) || (update.getY()<0) || 
				(update.getX()>=this.length) || (update.getY()>=this.width)) {
			return false;
		}
		this.plateau[tmp.getX()][tmp.getY()] = null;
		this.setTeam(team, update);
		return true;
	}
	
	public Entity getCase(int x, int y) {
		return this.plateau[x][y];
	}
	
	public void askMove(Team team) {
		Scanner scan = new Scanner(System.in);
		Direction dir = null;
		do {
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
		}while ((dir==null) || (!this.move(team, dir)));
	}
	
}
