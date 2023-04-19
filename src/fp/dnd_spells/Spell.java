package fp.dnd_spells;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import fp.auxi.Ctime;
import fp.auxi.School;
import fp.auxi.Spelltype;
import fp.utils.Checkers;

public class Spell {
	String name; 
	ArrayList<String> Classes; 
	School school; 
	Ctime cast_time; 
	Double range; 
	String duration; 
	Spelltype type; 
	String mat_cost;  
	Boolean material; 
	LocalDate date; 
	Integer year; 
	String description; 

	public Spell(String n, School s, Spelltype t) {
		name = n;
		Classes = new ArrayList<String>();
		school = s;
		cast_time = Ctime.OTHER;
		range = 0.0;
		duration = new String();
		type = t;
		mat_cost = new String();
		material = false;
		date = LocalDate.now();
		year = date.getYear();
		description = new String();
		
	}
	
	public Spell(String name1, ArrayList<String> classes1, School school1, Ctime cast_time1, Double range1, String duration1, Spelltype type1, String mat_cost1, Boolean material1, LocalDate date1, Integer year1, String description1) {
		name = name1;
		Classes = classes1;
		school = school1;
		cast_time = cast_time1;
		range = range1;
		duration = duration1;
		type = type1;
		mat_cost = mat_cost1;
		material = material1;
		date = date1;
		year = year1;
		description = description1;
	}

	public Spell() {
		Checkers.check("The range can't be negative", range >= 0);
		Checkers.check("The spell needs a name", name != null);
		Checkers.check("The date of creation needs to be either today or before", date.compareTo(LocalDate.now()) == 0 || date.compareTo(LocalDate.now()) == -1);
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getClasses() {
		return Classes;
	}

	public void setClasses(ArrayList<String> classes) {
		Classes = classes;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Ctime getCast_time() {
		return cast_time;
	}

	public void setCast_time(Ctime cast_time) {
		this.cast_time = cast_time;
	}

	public Double getRange() {
		return range;
	}

	public void setRange(Double range) {
		this.range = range;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Spelltype getType() {
		return type;
	}

	public void setType(Spelltype type) {
		this.type = type;
	}

	public String getMat_cost() {
		return mat_cost;
	}

	public void setMat_cost(String mat_cost) {
		this.mat_cost = mat_cost;
	}

	public void setMaterial(Boolean material) {
		this.material = material;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public int compareTo(Spell o) {
		int a = getName().compareTo(o.getName());
		if (a == 0) {
			a = getSchool().compareTo(o.getSchool());
		}
		return a;
	}
	
	//derived boolean material from mat_cost
	public Boolean getMaterial() {
		return mat_cost != null;
	}
	
	//get the integer year as a derived
	public Integer getYear() {
		return date.getYear();
	}
	
	public Spell(String s) {
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
		
		name = name1;
		Classes = Classes1;
		school = school1;
		cast_time = cast_time1;
		range = range1;
		duration = duration1;
		type = type1;
		mat_cost = mat_cost1;
		material = material1;
		date = date1;
		year = year1;
		description = description1;
	}

	public static Spelltype parseBool(String a, String b) {
		Spelltype c = new Spelltype(a, b);
		return c;
	}
}
