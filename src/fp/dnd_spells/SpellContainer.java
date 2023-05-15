package fp.dnd_spells;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpellContainer {

	private Set<Spell> SpellContainer;
	
	// A constructor which creates a container without items in the collection.
	public SpellContainer() {
		setSpells(new HashSet<>());
	}

	// Constructor from a collection of objects.
	public SpellContainer(Set<Spell> s) {
		SpellContainer = s;
	}
	
	// Constructor from a Stream.
	public SpellContainer(Stream<Spell> sp) {
		SpellContainer = sp.collect(Collectors.toSet());
	}

	public Set<Spell> getSpells() {
		return SpellContainer;
	}

	public void setSpells(Set<Spell> spells) {
		SpellContainer = spells;
	}
	
	
	// Operation to get the number of items.
	public Integer getNumItems() {
		return SpellContainer.size();
	}

	// Operation to add an item.
	public void addItem(Spell s) {
		SpellContainer.add(s);
	}
	
	// Operation to add a collection of items.
	public void addColl(Set<Spell> c) {
		SpellContainer.addAll(c);
	}
	
	// Operation to delete an item.
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
	
	//Checks if a spell with the name introduced exists and returns a boolean.
	public Boolean SpellCheck(String n) {
		Boolean a = false;
		for(Spell s: SpellContainer) {
			if(s.name.toLowerCase().equals(n.toLowerCase())) {
				a = true;
			}
		}
		return a;
	}
	
	// as above but with Streams
	public Boolean SpellCheckST(String s) {
		return SpellContainer.stream()
				.anyMatch(sc -> sc.getName().toLowerCase().equals(s.toLowerCase()));
		
	}

	//Counts the number of spells that can be casted by the class introduced.
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
	
	// as above but with Streams
	public Integer NumSpellsST(String c) {
		return (int) SpellContainer.stream()
				.filter(sc -> sc.Classes.contains(c))
				.count();
	}
	
	//Checks all the spells and returns a set with the ones that can be used by the class introduced (c).
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
	
	// as above but with Streams
	public Set<Spell> ClassSpellsST(String c) {
		return SpellContainer.stream()
				.filter(sc -> sc.Classes.contains(c))
				.collect(Collectors.toCollection(HashSet::new));
	}
	
	
	//It creates a set of classes, add it as keys for the map and then add the spell to each class that can use it.

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
	
	// as above but with Streams
	public Map<String, Set<Spell>> SpellsbyClassST() {
		return null;
				//SpellContainer.stream()
	}
	
	
	//It creates a set of classes, add it as keys for the map and then spell by spell checks if it's contained and then sum 1 if true.
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

	// Method for max/min with filtering
	public Spell SpellMaxRangebyClass(String c) {
		return SpellContainer.stream()
				.filter(sc -> sc.Classes.contains(c))
				.max(Comparator.comparing(Spell::getRange))
				.orElse(null);
	}
	
	// Method with filtering and sorting
	public Set<Spell> SpellsbyClassSortedbyRange(String c) {
		return SpellContainer.stream()
				.filter(sc -> sc.Classes.contains(c))
				.sorted(Comparator.comparing(Spell::getRange))
				.collect(Collectors.toSet());
	}
	
	//
}