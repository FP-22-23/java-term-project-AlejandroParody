package fp.spells.test;

import java.util.HashSet;
import java.util.Set;

import fp.dnd_spells.Spell;
import fp.dnd_spells.SpellContainer;
import fp.dnd_spells.SpellFactory;

public class SpellContainer_test {

	public static void main(String[] args) {
		
		SpellContainer c = SpellFactory.readFileStream("data/dnd-spells.csv");
		
		//SECOND DELIVERY
		
		//Empty spell container.
		SpellContainer a = new SpellContainer();
		System.out.println(a);
	
		//Container from Set.
		Set<Spell> s = new HashSet<Spell>();
		Spell s1 = SpellFactory.ParseSpell("Acid Splash;Artificer, Sorcerer, Wizard;Conjuration;Action;18.29;Instantaneous;;1;1;27/05/14");
		Spell s2 = SpellFactory.ParseSpell("Aid;Artificer, Bard, Cleric, Paladin, Ranger;Abjuration;Action;9.15;8 hours;a tiny strip of white cloth;1;1;27/05/14");
		s.add(s1);
		s.add(s2);
		
		SpellContainer b = new SpellContainer(s);
		System.out.println(b);
		
		//Criterion of equality
		System.out.println(b.equals(a));
		
		//Representation as a chain
		System.out.println(b.toString());
	
		// Operation to get the number of items
		System.out.println(b.getNumItems());
		
		// Operation to add an item
		Spell s3 = SpellFactory.ParseSpell("Bane;Bard, Cleric;Enchantment;Action;9.15;Concentration, up to 1 minute;a drop of blood;1;1;27/05/14");
		a.addItem(s3);
		System.out.println(a);
		System.out.println(a.getNumItems());
		
		// Operation to add a collection
		a.addColl(s);
		System.out.println(a);
		System.out.println(a.getNumItems());
		
		// Operation to remove an item
		a.delItem(s2);
		System.out.println(a);
		System.out.println(a.getNumItems());
	
		// Operation of type a (Exists)
		System.out.println(a.SpellCheck("Bane"));
		
		// Operation of type b (Counter)
		System.out.println(a.NumSpells("CLERIC"));
		
		// Operation of type c (Filter)
		a.addItem(s2);
		System.out.println(a.ClassSpells("BARD"));
		
		// Operation of type d
		System.out.println(a.SpellsbyClass());
		
		// Operation of type e
		System.out.println(a.ClassNumSpells());
	
		
		//THIRD DELIVERY
		
		// Operations with Stream implementation.
		
		// Operation of type a (Exists)
		System.out.println(a.SpellCheckST("Acid Splash"));
		
		// Operation of type b (Counter)
		System.out.println(a.NumSpellsST("ARTIFICER"));
		
		// Operation of type c (Filter)
		System.out.println(a.ClassSpellsST("ARTIFICER"));
		
		// Operation of maximum with filtering
		System.out.println(a.SpellMaxRangebyClass("CLERIC"));
		
		// Operation with filtering and sorting
		a.addItem(SpellFactory.ParseSpell("Darkness;Sorcerer, Warlock, Wizard;Evocation;Action;18.29;Concentration, up to 10 minutes;bat fur and a drop of pitch or piece of coal;1;0;27/05/14"));
		a.addItem(SpellFactory.ParseSpell("Create Undead;Cleric, Warlock, Wizard;Necromancy;1 Minute;3.05;Instantaneous;one clay pot filled with grave dirt, one clay pot filled with brackish water, and one 150 gp black onyx stone for each corpse;1;1;27/05/14"));
		System.out.println(a.SpellsbyClassSortedbyRange("WIZARD"));
	
		// Method of delivery 4 with Stream
		System.out.println(a.SpellbyDatesST());
		
		// Method with Collector.collectingAndThen
		System.out.println(c.NSpellsbyDate());
	
		// Method with attribute and max/min
		System.out.println(c.SpellMaxRangeBySchool());
		
		// Method with Sorted Map
		System.out.println(c.SpellsMostRangeBySchool(3));
		
		// Method that calculates a Map and returns the key with the associated value (largest) of the entire Map.
		System.out.println(c.ClassQuantitySpells("smallest"));
	}

}
