package fp.spells.test;

import java.time.LocalDate;
import java.util.ArrayList;

import fp.auxi.Ctime;
import fp.auxi.School;
import fp.auxi.Spelltype;
import fp.dnd_spells.Spell;

public class Spell_test {

	public static void main(String[] args) {
		
		// First constructor of the basic type.
		Spelltype b = new Spelltype("1","0");
		Spell a = new Spell("Fireball",School.EVOCATION,b);
		System.out.println(a.toString());
		

		// Second constructor of the basic type.
		ArrayList<String> l = new ArrayList<String>();
		l.add("Wizard");
		Spell s = new Spell("Lightning bolt",l, School.EVOCATION, Ctime.ACTION, 20.0, "Instantaneous", "", false, b, LocalDate.now(), 2023);
		System.out.println(s.toString());
	
		testEquality();
		
		testNatOrder();
		
		testConstrains1();
		
		testConstrains2();
		
		testConstrains3();
		
		
	}	
		
	private static void testEquality() {
		//Criterion of equality test.
		Spelltype b = new Spelltype("1","0");
		Spell a = new Spell("Fireball",School.EVOCATION,b);
		ArrayList<String> l = new ArrayList<String>();
		l.add("Wizard");
		Spell s = new Spell("Lightning bolt",l, School.EVOCATION, Ctime.ACTION, 20.0, "Instantaneous", "", false, b, LocalDate.now(), 2023);
		Spell s2 = s;
		System.out.println(a.equals(s));
		System.out.print(s.equals(s2));
	}
	
	private static void testNatOrder() {
		//Natural Order test.
		Spelltype b = new Spelltype("1","0");
		Spell a = new Spell("Fireball",School.EVOCATION,b);
		ArrayList<String> l = new ArrayList<String>();
		l.add("Wizard");
		Spell s = new Spell("Lightning bolt",l, School.EVOCATION, Ctime.ACTION, 20.0, "Instantaneous", "", false, b, LocalDate.now(), 2023);
		Spell s2 = s;
		System.out.println(a.compareTo(s));
		System.out.println(s2.compareTo(s));
	}
	
	private static void testConstrains1() {
		//Constrains.		
		Spelltype b = new Spelltype("1","0");
		ArrayList<String> l = new ArrayList<String>();
		l.add("Wizard");
		Spell q = new Spell("",School.EVOCATION,b);
		System.out.print(q);	
	}
	
	private static void testConstrains2() {
		//Constrains.		
		Spelltype b = new Spelltype("1","0");
		ArrayList<String> l = new ArrayList<String>();
		l.add("Wizard");
		Spell w = new Spell("Lightning bolt",l, School.EVOCATION, Ctime.ACTION, 20.0, "Instantaneous", "", false, b, LocalDate.now(), 2023);
		System.out.print(w);	
	}
	
	private static void testConstrains3() {
		//Constrains.		
		Spelltype b = new Spelltype("1","0");
		ArrayList<String> l = new ArrayList<String>();
		l.add("Wizard");
		Spell e = new Spell("Lightning bolt",l, School.EVOCATION, Ctime.ACTION, 20.0, "Instantaneous", "", false, b, LocalDate.now(), 2023);
		System.out.print(e);		
	}
}
