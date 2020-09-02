package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

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
	public void test_wellAdded() {
		assertTrue(t1.getCharacterList().contains(a1));
		assertTrue(t1.getCharacterList().contains(m1));
		assertTrue(t2.getCharacterList().contains(a2));
		assertTrue(t2.getCharacterList().contains(v2));
	}
	
	@Test
	public void test_rightHPs() {
		assertEquals(39,t1.getHealthPoint());
		assertEquals(33,t2.getHealthPoint());
	}
	
	@Test
	public void test_rightADs() {
		assertEquals(21,t1.getAttackDamage());
		assertEquals(19,t2.getAttackDamage());
	}
}
