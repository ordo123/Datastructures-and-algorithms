public class SymbolTable {
	private static final int INIT_CAPACITY = 7;

	/* Number of key-value pairs in the symbol table */
	private int N;
	/* Size of linear probing table */
	private int M;
	/* The keys */
	private String[] keys;
	/* The values */
	private Character[] vals;

	/**
	 * Create an empty hash table - use 7 as default size
	 */
	public SymbolTable() {
		this(INIT_CAPACITY);
	}

	/**
	 * Create linear probing hash table of given capacity
	 */
	public SymbolTable(int capacity) {
		N = 0;
		M = capacity;
		keys = new String[M];
		vals = new Character[M];
	}

	/**
	 * Return the number of key-value pairs in the symbol table
	 */
	public int size() {
		return N;
	}

	/**
	 * Is the symbol table empty?
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Does a key-value pair with the given key exist in the symbol table?
	 */
	public boolean contains(String key) {
		return get(key) != null;
	}

	/**
	 * Hash function for keys - returns value between 0 and M-1
	 */
	public int hash(String key) {
		int i;
		int v = 0;

		for (i = 0; i < key.length(); i++) {
			v += key.charAt(i);
		}
		return v % M;
	}

	/**
	 * Insert the key-value pair into the symbol table
	 */
	public void put(String key, Character val) {

		if (val == null) {
			delete(key);
		} else {

			for (int i = hash(key); i < M; i++) {

				if (keys[i] == null) {
					keys[i] = key;
					vals[i] = val;
					N++;
					break;
				}

				if (keys[i] != null) {
					if (keys[i].equals(key)) {
						vals[i] = val;
						break;
					}
				}

				if (val == null) {
					keys[i] = null;
				}

				if (i + 1 == M) {
					i = -1;
				} else if (i + 1 == hash(key)) {
					break;
				}

			}
		}

	}

	/**
	 * Return the value associated with the given key, null if no such value
	 */
	public Character get(String key) {

		for (int i = hash(key); i < M; i++) {

			if (keys[i] == null) {

				break;

			}

			else if (keys[i].equals(key)) {

				return vals[i];

			}

			if (i + 1 == M) {

				i = -1;

			} else if (i + 1 == hash(key)) {

				break;

			}

		}

		return null;

	}

	/**
	 * Delete the key (and associated value) from the symbol table
	 */
	public void delete(String key) {
		String tmpKey = " ";
		Character tmpVal = 'x';

		for (int i = hash(key); i < M; i++) {

			if (keys[i] != null && keys[i].equals(key)) {
				vals[i] = null;
				keys[i] = null;
				N--;

				for (int p = i + 1; p <= M; p++) {

					if (p == M) {
						p = 0;
					}

					if (keys[p] == null) {
						break;
					}

					if (keys[p] != null) {
						tmpKey = keys[p];
						tmpVal = vals[p];
						keys[p] = null;
						vals[p] = null;
						put(tmpKey, tmpVal);
						N--;

					}

					if (p + 1 == M) {
						p = -1;
					} else if (p + 1 == i) {
						break;
					}

				}
				break;
			}

			if (i + 1 == M) {
				i = -1;

			} else if (i + 1 == hash(key)) {
				break;
			}

		}

	}

	/**
	 * Print the contents of the symbol table
	 */
	public void dump() {
		String str = "";

		for (int i = 0; i < M; i++) {
			str = str + i + ". " + vals[i];
			if (keys[i] != null) {
				str = str + " " + keys[i] + " (";
				str = str + hash(keys[i]) + ")";
			} else {
				str = str + " -";
			}
			System.out.println(str);
			str = "";
		}
	}
}
