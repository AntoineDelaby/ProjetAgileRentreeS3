package main;

public abstract class Entity {
	private int healthPoint;
	private int attackDamage;
	
	public Entity(int hp, int ad) {
		this.healthPoint = hp;
		this.attackDamage = ad;
	}
	
	public abstract String toString();
}
