package fp.dnd_spells;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpellContainer {

	private Set<Spell> SpellContainer;
	
	public SpellContainer() {
		setSpells(new HashSet<>());
	}

	public SpellContainer(Stream<Spell> sp) {
		SpellContainer = sp.collect(Collectors.toSet());
	}

	public Set<Spell> getSpells() {
		return SpellContainer;
	}

	public void setSpells(Set<Spell> spells) {
		SpellContainer = spells;
	}
	
	public Integer getNumItems(Set<Spell> sc) {
		return sc.size();
	}

	public void addItem(Spell s) {
		SpellContainer.add(s);
	}
	
	public void addColl(Set<Spell> c) {
		SpellContainer.addAll(c);
	}
	
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

	public SpellContainer(Set<Spell> spellContainer) {
		super();
		SpellContainer = spellContainer;
	}

	

}
