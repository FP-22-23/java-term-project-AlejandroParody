package fp.spells.test;

import fp.auxi.School;
import fp.auxi.Spelltype;
import fp.dnd_spells.Spell;

public class Spells_test {

	public static void main(String[] args) {

		Spelltype b = new Spelltype("1","0");
		Spell a = new Spell("Fireball",School.EVOCATION,b);
		System.out.println(a.toString());	

		System.out.println();
	}

}
