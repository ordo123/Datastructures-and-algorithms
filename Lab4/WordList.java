import java.util.HashSet;
import java.io.*;

// Klassen WordList innehåller en ordlista och en datastruktur som håller
// reda på använda ord.

class WordList {
	static private HashSet<String> list; // ordlista
	static private HashSet<String> used; // databas med anv�nda ord

	static int wordLength;
	static int size; // antal ord i ordlistan

	// Read l�ser in en ordlista fr�n str�mmen input. Alla ord ska ha
	// wordLength bokst�ver.
	static public void read(int wordLength_, BufferedReader input) throws IOException {
		wordLength = wordLength_;
		size = 0;
		list = new HashSet<String>();
		while (true) {
			String s = input.readLine();
			if (s.equals("#")) {
				break;
			}
			if (s.length() != wordLength) {
				System.out.println("Rad " + size + " i filen inneh�ller inte " + wordLength + " tecken.");
			}
			list.add(s);
			size++;
		}
		used = new HashSet<String>(size);
	}

	// WordAt returnerar ordet med angivet index i ordlistan.
	static public String wordAt(int index) {
		if (index >= 0 && index < size) {
			return (String) list.toArray()[index];
		}
		return null;
	}

	// Contains sl�r upp w i ordlistan och returnerar ordet om det finns med.
	// Annars returneras null.
	static public String contains(String w) {

		if (list.contains(w)) {
			return w;
		}
		return null;
	}

	// MarkAsUsedIfUnused kollar om w �r anv�nt tidigare och returneras i s�
	// fall false. Annars markeras w som anv�nt och true returneras.
	static public boolean markAsUsedIfUnused(String w) {
		if (used.contains(w)) {
			return false;
		}
		used.add(w);
		return true;
	}

	// EraseUsed gör så att inga ord anses använda längre.
	static public void eraseUsed() {
		used.clear();
	}

}
