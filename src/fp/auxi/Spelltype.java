package fp.auxi;

import java.util.Objects;

public class Spelltype implements Comparable<Spelltype>{

	Boolean verbal;
	Boolean somatic; 	
	String text;
	
	//derived property, uses three values from the string of text of the csv.
	
	public Spelltype(Boolean v, Boolean s, String t) {
		verbal = v;
		somatic = s;
		text = t;
	}
	
	public Boolean getVerbal() {
		return verbal;
	}
	
	public void setVerbal(Boolean verbal) {
		this.verbal = verbal;
	}

	public Boolean getSomatic() {
		return somatic;
	}

	public void setSomatic(Boolean somatic) {
		this.somatic = somatic;
	}

	public static String getText (Boolean verbal, Boolean somatic) {
		String a = new String();
		if(verbal == true) {
			a += "The Spell requires to speak";
			if(somatic == true) {
				a += " and to do some gestures.";				
			}
			else {
				a += " but no gestures.";
			}
		}
		else {
			a += "The spell requires no speaking";
			if(somatic == true) {
				a += " but to do some gestures.";				
			}
			else {
				a += " and no gestures.";
			}
			
		}
		return a; 
	}

	@Override
	public int compareTo(Spelltype o) {
		int res = this.verbal.compareTo(o.verbal);
		if (res == 0) {
			res = this.somatic.compareTo(o.somatic);
		}
		return res;
	}

	@Override
	public int hashCode() {
		return Objects.hash(somatic, verbal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spelltype other = (Spelltype) obj;
		return Objects.equals(somatic, other.somatic) && Objects.equals(verbal, other.verbal);
	}

	@Override
	public String toString() {
		return "Spelltype [verbal=" + verbal + ", somatic=" + somatic + "]";
	}

	public Spelltype(String a, String b) {
		Boolean v = Boolean.valueOf(a);
		Boolean s = Boolean.valueOf(b);
		
		verbal = v;
		somatic = s;
		text = getText(verbal, somatic);
	}

}
