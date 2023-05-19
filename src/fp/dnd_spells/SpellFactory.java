package fp.dnd_spells;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.auxi.Ctime;
import fp.auxi.School;
import fp.auxi.Spelltype;
import fp.utils.Checkers;

public class SpellFactory {

	/**
	 * 
	 * @param line, a string formated as the lines of the CSV.
	 * @return returns the spell created from taking the data from the line.
	 */
	public static Spell ParseSpell(String line) {
			String [] a = line.split(";");
			Checkers.check("Invalid string format", a.length == 10);
			String name1 = a[0].trim();
			ArrayList<String> Classes1 = new ArrayList<String>(Arrays.asList(a[1].replaceAll("\\s","").toUpperCase().split(",")));
			School school1 = School.valueOf(a[2].toUpperCase());
			Ctime cast_time1 = Spell.cast_time(a[3].trim());
			Double range1 = Double.parseDouble(a[4]);
			String duration1 = a[5].trim();
			String mat_cost1 = a[6].trim();
			Boolean material1 = mat_cost1 != null;
			Spelltype type1 = Spell.parseBool(a[7],a[8]);
			LocalDate date1 = LocalDate.parse(a[9].trim(), DateTimeFormatter.ofPattern("dd/MM/yy"));
			Integer year1 = date1.getYear();


		return new Spell(name1,Classes1,school1,cast_time1,range1,duration1,mat_cost1,material1,type1,date1,year1);
	}
	
	/**
	 * 
	 * @param file, contains the name and path of the CSV file.
	 * @return a set of spells.
	 */
	public static SpellContainer readFilefromPath(String file) {
		SpellContainer s = null;
		try {
			Stream<Spell> sp =
					Files.lines(Paths.get(file))
					.skip(1)
					.map(SpellFactory::ParseSpell);
			s = new SpellContainer(sp.collect(Collectors.toSet()));
		}catch (IOException e) {
		System.out.println("Error in file " + file);
		e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * 
	 * @param file, contains the name and path of the CSV file.
	 * @return an object of the type SpellContainer that contains all the spells from the CSV file.
	 */
	public static SpellContainer readFileStream(String file) {
		SpellContainer s = null;
		try {
		Stream<Spell> sp = Files.lines(Paths.get(file))
					.skip(1)
					.map(SpellFactory::ParseSpell);
		s = new SpellContainer(sp);
		;
		}catch (IOException e) {
		System.out.println("Error in file " + file);
		e.printStackTrace();
		}
		return s;
	}
	
	
}
