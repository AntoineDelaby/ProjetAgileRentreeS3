package main;

public class Entity {
	private int healthPoint;
	private int attackDamage;
	
	public Entity(int hp, int ad) {
		this.healthPoint = hp;
		this.attackDamage = ad;
	}
	
	public String toString() {
		return "HP="+this.healthPoint+" AD="+this.attackDamage;
	}
}
