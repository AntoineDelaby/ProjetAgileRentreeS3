import main.Direction;
import main.Plateau;
import main.Team;

public class TestDeplacements {
	
	public static void main(String[] args) {
		Plateau plateau = new Plateau(10, 10);
		Team team = new Team();
		plateau.setTeam(team, 1, 1);
		System.out.println(plateau);
		System.out.println(plateau.move(team, Direction.NORTH));
		System.out.println(plateau.move(team, Direction.WEST));
		System.out.println(plateau.move(team, Direction.WEST));
		
		System.out.println(plateau);
	}
	
}
