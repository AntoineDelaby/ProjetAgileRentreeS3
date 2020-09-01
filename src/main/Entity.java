package main;

public class Entity {
	private int healthPoint;
	private int attackDamage;
	
	protected Coordinate coo;
	
	public Entity(int hp, int ad) {
		this.healthPoint = hp;
		this.attackDamage = ad;
	}
	
	public String toString() {
		return "HP="+this.healthPoint+" AD="+this.attackDamage;
	}
	public int getHealthPoint() {
		return healthPoint;
	}

	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}
	
	public void setCoordinate(Coordinate coo) {
		this.coo = coo;
	}
	public Coordinate getCoordinate() {
		return this.coo;
	}
	
}
