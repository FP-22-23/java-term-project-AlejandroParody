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
	String mat_cost;  
	Boolean material;
	Spelltype type;  
	LocalDate date; 
	Integer year;  

	
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
		
	}
	
	
	//Constructor 2, receives a value for each.
	public Spell(String name1, ArrayList<String> classes1, School school1, Ctime cast_time1, Double range1, String duration1,String mat_cost1, Boolean material1, Spelltype type1, LocalDate date1, Integer year1) {
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
	}

	//Data constrains, a non-negative value, a date before today, and it needs a name.
	public Spell() {
		Checkers.check("The range can't be negative", range >= 0);
		Checkers.check("The spell needs a name", !name.equals("") || !name.equals(null));
		Checkers.check("The date of creation needs to be either today or before", date.isEqual(LocalDate.now()) || date.isBefore(LocalDate.now()));
	}

	public static Ctime cast_time(String a) {
		if(a.toUpperCase() == Ctime.ACTION.toString()) {
			return Ctime.ACTION;
		} if(a.toUpperCase() == Ctime.REACTION.toString()) {
			return Ctime.REACTION;
		} if(a.toUpperCase() == Ctime.BONUS.toString()) {
			return Ctime.BONUS;
		} else {
			return Ctime.OTHER;
		}
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
	
	public static Spelltype parseBool(String a, String b) {
		Spelltype c = new Spelltype(a, b);
		return c;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Classes, cast_time, date, duration, mat_cost, material, name, range, school,
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
				&& Objects.equals(duration, other.duration) && Objects.equals(mat_cost, other.mat_cost)
				&& Objects.equals(material, other.material) && Objects.equals(name, other.name)
				&& Objects.equals(range, other.range) && school == other.school && Objects.equals(type, other.type)
				&& Objects.equals(year, other.year);
	}


	@Override
	public String toString() {
		return "Spell [name=" + name + ", Classes=" + Classes + ", school=" + school + ", cast_time=" + cast_time
				+ ", range=" + range + ", duration=" + duration + ", mat_cost=" + mat_cost
				+ ", material=" + material + ", type=" + type + ", date=" + date + ", year=" + year + "]";
	}

	
	
}
