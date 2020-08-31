package main;

public class Plateau {
	private int length;
	private int width;
	private String[] []plateau;
	
	public Plateau (int length, int width) {
		this.length=length;
		this.width=width;
		this.plateau=new String[this.length][this.width];
		
		for (int i=0; i<this.length; i++) {
			for (int j=0; j<this.width; j++) {
				plateau[i][j]=" ";
			}
		}
	}

	@Override
	public String toString() {
		String plateau="";
		for (int i=0;i<this.length;i++) {
			plateau+="--";
		}
		plateau+="\n";
		for (int i=0; i<this.length; i++) {
			plateau+="|";
			for (int j=0; j<this.width; j++) {
				plateau+=this.plateau[i][j]+"|";
			}
			plateau+="\n";
		}
		for (int i=0;i<this.length;i++) {
			plateau+="--";
		}
		return plateau;
	}
	
	
}
