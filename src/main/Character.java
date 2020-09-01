package main;

public abstract class Character {
	
	protected Team team;
	public int healthPoint;
	public int damage;
	protected String name;
	
	public Character(int healthPoint, int damage) {
		this.healthPoint = healthPoint;
		this.damage = damage;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public abstract void action();
	public abstract boolean isPassif();

	//======
	
	public int getHealthPoint() {
		return this.healthPoint;
	}

	public int getDamgage() {
		return this.damage;
	}
	
	public String getName() {
		return this.name;
	}
	
}
