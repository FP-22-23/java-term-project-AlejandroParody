package dnd_spells;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import utils.Checkers;

public record Spell (
String name, ArrayList<Clas> Classes, School school, Ctime cast_time, Double range, String duration, Boolean verbal, Boolean somatic, Boolean material, String mat_cost, LocalDate date, Integer year, String description) implements Comparable<Spell> {

	public Spell {
		Checkers.check("The range can't be negative", range >= 0);
		Checkers.check("The spell needs a name", name != null);
		Checkers.check("The date of creation needs to be either today or before", date.compareTo(LocalDate.now()) == 0 || date.compareTo(LocalDate.now()) == -1);
	}
	public int compareTo(Spell o) {
		int a;
		a = name().compareTo(o.name());
		if (a == 0) {
			a = school().compareTo(o.school());
		}
		return a;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Classes, cast_time, date, description, duration, mat_cost, name, range, school, somatic,
				verbal);
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
				&& Objects.equals(name, other.name) && Objects.equals(range, other.range) && school == other.school
				&& Objects.equals(somatic, other.somatic) && Objects.equals(verbal, other.verbal);
	}

	public String name() {
		return name;
	}

	public ArrayList<Clas> Classes() {
		return Classes;
	}

	public School school() {
		return school;
	}

	public Ctime cast_time() {
		return cast_time;
	}

	public Double range() {
		return range;
	}

	public String duration() {
		return duration;
	}

	public Boolean verbal() {
		return verbal;
	}

	public Boolean somatic() {
		return somatic;
	}

	public String mat_cost() {
		return mat_cost;
	}

	public LocalDate date() {
		return date;
	}

	public String description() {
		return description;
	}

	//derived boolean material from mat_cost
	public Boolean material() {
		return mat_cost != null;
	}
	
	//get the integer year as a derived
	public Integer year() {
		return date.getYear();
	}
	
}
