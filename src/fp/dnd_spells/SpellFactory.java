package fp.dnd_spells;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import fp.auxi.Ctime;
import fp.auxi.School;
import fp.auxi.Spelltype;
import fp.utils.Checkers;

public class SpellFactory {

	public Spell SpellF (String s) {
		String [] a = s.split(";");
		Checkers.check("Invalid string format", a.length == 11);
		String name1 = a[0].trim();
		ArrayList<String> Classes1 = new ArrayList<String>(Arrays.asList(a[1].split(",")));
		School school1 = School.valueOf(a[2]);
		Ctime cast_time1 = Ctime.valueOf(a[3]);
		Double range1 = Double.valueOf(a[4]);
		String duration1 = a[5].trim();
		Spelltype type1 = parseBool(a[6],a[7]);
		String mat_cost1 = a[8].trim();
		Boolean material1 = mat_cost1 != null;
		LocalDate date1 = LocalDate.parse(a[9], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer year1 = date1.getYear();
		String description1 = a[10].trim();
		
		Spell z = new Spell(name1, Classes1, school1, cast_time1, range1, duration1, type1, mat_cost1, material1, date1, year1, description1);
		return z;
	}

	public Spelltype parseBool(String a, String b) {
		Spelltype c = new Spelltype(a, b);
		return c;
	}


}
