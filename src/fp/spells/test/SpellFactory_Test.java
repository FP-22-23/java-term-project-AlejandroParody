package fp.spells.test;

import java.time.LocalDate;
import java.util.HashSet;

import fp.auxi.Ctime;
import fp.auxi.School;
import fp.dnd_spells.Spell;
import fp.dnd_spells.SpellContainer;
import fp.dnd_spells.SpellFactory;

public class SpellFactory_Test {

	public static void main(String[] args) {
		testParseSpell();
		testReader();
	}

	//SECOND DELIVERY
	
	private static void testParseSpell() {
		System.out.println(SpellFactory.ParseSpell("\"Lightning bolt\",l, School.EVOCATION, Ctime.ACTION, -20.0, \"Instantaneous\", b, \"\", false, LocalDate.now(), 2023, \"a\""));

	}

	private static SpellContainer testReader() {
		SpellContainer a = SpellFactory.readFilefromPath("data/dnd-spells.csv");
		return a;
	}
}