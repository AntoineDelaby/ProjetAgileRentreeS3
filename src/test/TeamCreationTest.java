package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.Archer;
import main.Barbare;
import main.Mage;
import main.Team;
import main.Voleur;

public class TeamCreationTest {
	public Archer a1 = new Archer();
	public Mage m1 = new Mage();
	public Barbare b1 = new Barbare();
	public Archer a2 = new Archer();
	public Voleur v2 = new Voleur();
	public Mage m2 = new Mage();
	public Team t1 = new Team();
	public Team t2 = new Team();
	
	@Before
	public void beforeATest() {
		t1.addCharacter(a1);
		t1.addCharacter(m1);
		t1.addCharacter(b1);
		t2.addCharacter(a2);
		t2.addCharacter(v2);
		t2.addCharacter(m2);
	}
	
	@Test
	public void test_teamCreation() {
		assertEquals(24,t1.getHealthPoint());
		assertEquals(21,t1.getAttackDamage());
		assertEquals(18,t2.getHealthPoint());
		assertEquals(19,t2.getAttackDamage());
	}
}
