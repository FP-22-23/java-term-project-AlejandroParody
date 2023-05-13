package fp.dnd_spells;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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

	
	//Constructor 1, receives a name, a school and the spell type.
	public Spell(String n, School s, Spelltype t) {
		name = n;
		Classes = new ArrayList<String>();
		school = s;
		cast_time = Ctime.OTHER;
		range = 0.0;
		duration = "";
		type = t;
		mat_cost = "";
		material = false;
		date = LocalDate.now();
		year = date.getYear();
		description = "";
		
	}
	
	
	//Constructor 2, receives a value for each.
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

	//Data constrains, a non-negative value, a date before today, and it needs a name.
	public Spell() {
		Checkers.check("The range can't be negative", range >= 0);
		Checkers.check("The spell needs a name", name != "" && name != null);
		Checkers.check("The date of creation needs to be either today or before", date.compareTo(LocalDate.now()) == 0 || date.compareTo(LocalDate.now()) == -1);
	}

	
	//Getters and Setters
	
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

	//CompareTo
	
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
	
	//Constructor 3, only receives a string.
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


	@Override
	public int hashCode() {
		return Objects.hash(Classes, cast_time, date, description, duration, mat_cost, material, name, range, school,
				type, year);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spell other = (Spell) obj;
		return Objects.equals(Classes, other.Classes) && cast_time == other.cast_time
				&& Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& Objects.equals(duration, other.duration) && Objects.equals(mat_cost, other.mat_cost)
				&& Objects.equals(material, other.material) && Objects.equals(name, other.name)
				&& Objects.equals(range, other.range) && school == other.school && Objects.equals(type, other.type)
				&& Objects.equals(year, other.year);
	}


	@Override
	public String toString() {
		return "Spell [name=" + name + ", Classes=" + Classes + ", school=" + school + ", cast_time=" + cast_time
				+ ", range=" + range + ", duration=" + duration + ", type=" + type + ", mat_cost=" + mat_cost
				+ ", material=" + material + ", date=" + date + ", year=" + year + ", description=" + description + "]";
	}

	
	
}
