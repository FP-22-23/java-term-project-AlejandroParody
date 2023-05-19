package fp.dnd_spells;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.auxi.School;

public class SpellContainer {

	private Set<Spell> SpellContainer;
	
	/**
	 * A constructor which creates a container without items in the collection.
	 */
	public SpellContainer() {
		setSpells(new HashSet<>());
	}

	/**
	 *  Constructor from a collection of objects.
	 * @param s, set of spells from which we create the container.
	 */
	public SpellContainer(Set<Spell> s) {
		SpellContainer = s;
	}
	
	/**
	 *  Constructor from a Stream.
	 * @param sp, the stream from which we create the container.
	 */
	public SpellContainer(Stream<Spell> sp) {
		SpellContainer = sp.collect(Collectors.toSet());
	}

	public Set<Spell> getSpells() {
		return SpellContainer;
	}

	public void setSpells(Set<Spell> spells) {
		SpellContainer = spells;
	}
	
	
	/**
	 *  Operation to get the number of items.
	 * @return number of elements in the container.
	 */
	public Integer getNumItems() {
		return SpellContainer.size();
	}

	/**
	 *  Operation to add an item.
	 */
	public void addItem(Spell s) {
		SpellContainer.add(s);
	}
	
	/**
	 *  Operation to add a collection of items.
	 * @param c, the collection of items we want to add.
	 */
	public void addColl(Set<Spell> c) {
		SpellContainer.addAll(c);
	}
	
	/**
	 *  Operation to delete an item.
	 * @param s, the item we want to delete from the container.
	 */
	public void delItem(Spell s) {
		SpellContainer.remove(s);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(SpellContainer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpellContainer other = (SpellContainer) obj;
		return Objects.equals(SpellContainer, other.SpellContainer);
	}

	@Override
	public String toString() {
		return "SpellContainer [SpellContainer=" + SpellContainer + "]";
	}
	
	/**
	 * Checks if a spell with the name introduced exists and returns a boolean.
	 * @param n, name of the spell whose existence in the container we want to check. 
	 * @return Boolean, depending if the spell was found or not.
	 */
	public Boolean SpellCheck(String n) {
		Boolean a = false;
		for(Spell s: SpellContainer) {
			if(s.name.toLowerCase().equals(n.toLowerCase())) {
				a = true;
			}
		}
		return a;
	}
	
	/**
	 * Checks if a spell with the name introduced exists and returns a boolean using strams.
	 * @param s, name of the spell whose existence in the container we want to check. 
	 * @return Boolean, depending if the spell was found or not.
	 */
	public Boolean SpellCheckST(String s) {
		return SpellContainer.stream()
				.anyMatch(sc -> sc.getName().toLowerCase().equals(s.toLowerCase()));
		
	}

	/**
	 * Counts the number of spells that can be casted by the class introduced.
	 * @param c, class we introduce to check it's number of spells.
	 * @return the number of spells that can be cast by that class.
	 */
	public Integer NumSpells(String c) {
		Integer a = 0;
		for(Spell s: SpellContainer) {
			if(s.Classes.contains(c)) {
				a = a+1; 
			} else {
			}
		}
		return a;
	}
	
	/**
	 *  Counts the number of spells that can be casted by the class introduced, but using streams.
	 * @param c, class we introduce to check it's number of spells.
	 * @return the number of spells that can be cast by that class.
	 */
	public Integer NumSpellsST(String c) {
		return (int) SpellContainer.stream()
				.filter(sc -> sc.Classes.contains(c))
				.count();
	}
	
	/**
	 * Checks all the spells and returns a set with the ones that can be used by the class introduced (c).
	 * @param c, class we introduce to check it's spells.
	 * @return the set of spells that can be cast by that class.
	 */
	public Set<Spell> ClassSpells(String c) {
		Set<Spell> a = new HashSet<Spell>();
		for(Spell s: SpellContainer) {
			if(s.Classes.contains(c)) {
				a.add(s);
			} else {
				a.remove(s);
			}
		}
		return a;
	}
	
	/**
	 * Checks all the spells and returns a set with the ones that can be used by the class introduced (c), but using streams.
	 * @param c, class we introduce to check it's spells.
	 * @return the set of spells that can be cast by that class.
	 */
	public Set<Spell> ClassSpellsST(String c) {
		return SpellContainer.stream()
				.filter(sc -> sc.Classes.contains(c))
				.collect(Collectors.toCollection(HashSet::new));
	}
	
	
	/**
	 * It creates a set of classes, add it as keys for the map and then add the spell to each class that can use it.
	 * @return a map with the different classes as keys and the set of usable spells as values.
	 */
	public Map<String, Set<Spell>> SpellsbyClass() {
		Map<String, Set<Spell>> m = new HashMap<String, Set<Spell>>();
		Set<String> keys = new HashSet<String>();
		
		for(Spell s: SpellContainer) {
			keys.addAll(s.Classes);
		}
		for(String k: keys) {
			m.put(k, new HashSet<Spell>());
			for(Spell z: SpellContainer) {
				if(z.Classes.contains(k)) {
					m.get(k).add(z);
				}
			}
		}
	return m;
	}
	
	/**
	 * Uses the different release datesas keys for the map and then add the spell to the date it was released.
	 * @return a map with the dates as keys and the set of spells as values.
	 */
	public Map<LocalDate, Set<Spell>> SpellbyDatesST() {
		return SpellContainer.stream()
				.collect(Collectors.groupingBy(s -> s.date, Collectors.toSet()));
	}
	
	
	/**
	 * It creates a set of classes, add it as keys for the map and then spell by spell checks if it's contained and then sum 1 if true.
	 * @return a map where the keys are the different classes and the values are the sum of usable spells.
	 */
	public Map<String, Integer> ClassNumSpells() {
		Map<String, Integer> m = new HashMap<String, Integer>();
		Set<String> keys = new HashSet<String>();
		
		for(Spell s: SpellContainer) {
			keys.addAll(s.Classes);
		}
		for(Spell s: SpellContainer) {
			for(String k: keys) {
				if(s.Classes.contains(k)) {
					m.merge(k, 1, Integer::sum);
				}
			}
		}
		return m;
	}

	/**
	 *  Method for max/min with filtering
	 * @param c, the class for which we want to check it's spell with the max range.
	 * @return the spell with the most range for the class introduced
	 */
	public Spell SpellMaxRangebyClass(String c) {
		return SpellContainer.stream()
				.filter(sc -> sc.Classes.contains(c))
				.max(Comparator.comparing(Spell::getRange))
				.get();
	}
	
	/**
	 *  Method with filtering and sorting
	 * @param c, class for which we want to filter the spells.
	 * @return a set of spells usable for the class, ordered by apllying the natural order to the ranges.
	 */
	public Set<Spell> SpellsbyClassSortedbyRange(String c) {
		return SpellContainer.stream()
				.filter(sc -> sc.Classes.contains(c))
				.sorted(Comparator.comparing(Spell::getRange))
				.collect(Collectors.toSet());
	}
	
	/**
	 *  Method with Collectors.mapping	
	 * @return map with the release dates as keys and the names of the spells released in that date.
	 */
	public Map<LocalDate, Set<String>> NSpellsbyDate() {
		return SpellContainer.stream()
				.collect(Collectors.groupingBy(s->s.getDate(), Collectors.mapping(s -> s.name, Collectors.toSet())));
	}
	
	/**
	 * the keys are an attribute or a function over an attribute, and the values are maximum/minimum of the elements that have that value
	 * @return it returns a Map he keys are the different schools of magic, and as values each has the corresponding spell to that class that has the maximum range.
	 */
	public Map<School, Spell> SpellMaxRangeBySchool() {
		return SpellContainer.stream()
				.collect(Collectors.toMap(Spell::getSchool, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Spell::getRange))));
	} 
	
	/**
	 * SortedMap, keys are an attribute or a function over an attribute, and the values are lists with the n best or worst elements that share the value of that attribute (or function over the attribute).
	 * @param n, number of elements (best)
	 * @return a SortedMap where the keys are the different schools of magic and the values are the n spells that have the most range from each school.
	 */
	public Map<School, Object> SpellsMostRangeBySchool(Integer n) {
		return SpellContainer.stream()
				.collect(Collectors.groupingBy(Spell::getSchool, TreeMap::new, 
						Collectors.collectingAndThen(Collectors.mapping(Spell::getName, 
								Collectors.toList()), list -> list.stream()
								.sorted(Comparator.naturalOrder())
								.limit(n).collect(Collectors.toList()))));	
	}
	
	/**
	 *  A method that calculates a Map and returns the key with the associated value (largest or smallest) of the entire Map.
	 * @param s, string that decides whether to obtain the largest or the smallest.
	 * @return the key with largest of the smallest number of spells that can be casted by each.
	 */
	public String ClassQuantitySpells(String s) {
		Map<String, Set<Spell>> a = SpellsbyClass();
		if (s.toLowerCase() == "largest") {
			return Collections.max(a.entrySet(), Comparator.comparing(c -> c.getValue().stream().count())).getKey();
		} if (s.toLowerCase() == "smallest")  {
			return Collections.min(a.entrySet(), Comparator.comparing(c -> c.getValue().stream().count())).getKey();
		} else {
			return "Invalid String; Select between largest or smallest nº of spells";
		}
	}
	
}