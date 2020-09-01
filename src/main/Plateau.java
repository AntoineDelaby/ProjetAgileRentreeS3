package main;

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
				if(this.plateau[i][j]==null) {
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

	
	public void setTeam(Team t, int x, int y) {
		this.plateau[x][y] = t ;
	}
	
	
	
}
