package fp.dnd_spells;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SpellFactory {

	public static Spell ParseSpell(String line) {
		return new Spell(line);
	}
	
	public static SpellContainer readFile(String file) {
		SpellContainer s = null;
		try {
			Stream<Spell> sp =
					Files.lines(Paths.get(file))
					.skip(1)
					.map(SpellFactory::ParseSpell);
			s = new SpellContainer(sp);
		}catch (IOException e) {
		System.out.println("Error in file " + file);
		e.printStackTrace();
		}
		return s;
	}
	
}
