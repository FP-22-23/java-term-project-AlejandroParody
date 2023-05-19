package fp.spells.test;

import fp.dnd_spells.SpellContainer;
import fp.dnd_spells.SpellFactory;

public class SpellFactory_Test {

	public static void main(String[] args) {
		
		// Test for the second delivery.
		
		testParseSpell();
		SpellContainer a = SpellFactory.readFilefromPath("data/dnd-spells.csv");
		System.out.println(a);
	
		// Test for the third delivery.
		
		SpellContainer b = SpellFactory.readFileStream("data/dnd-spells.csv");
		System.out.println(b);
	}

	//SECOND DELIVERY
	
	private static void testParseSpell() {
		System.out.println(SpellFactory.ParseSpell("Acid Splash;Artificer, Sorcerer, Wizard;Conjuration;Action;18.29;Instantaneous;;1;1;27/05/14"));

	}

}