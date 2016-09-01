
public class HashTable<K, V> {

	private final static int SIZE = 128;

	private HashEntry<K, V>[] hashTable;

	HashTable() {
		this.hashTable = new HashEntry[SIZE];
		for (int i = 0; i < SIZE; i++) {
			this.hashTable[i] = null;
		}
	}

	public void add(K key, V value) {
		int hashCode = key.hashCode();
		int index = hashCode % SIZE;
		while(hashTable[index] != null && hashTable[index].getKey() != key) {
			index = (index + 1) % SIZE;
		}
		hashTable[index] = new HashEntry(key, value);
	}

	public V get(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % SIZE;
		while(hashTable[index] != null && hashTable[index].getKey() != key) {
			index = (index + 1) % SIZE;
		}
		if (hashTable[index] == null) {
			return null;
		}
		else
			return hashTable[index].getValue();
	}

	public void remove(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % SIZE;
		while(hashTable[index] != null && hashTable[index].getKey() != key) {
			index = (index + 1) % SIZE;
		}
		if (hashTable[index] == null) {
			return;
		}
		else
			hashTable[index] = null;
			return;
	}

	public static void main(String[] args) {
		HashTable<String, Integer> table = new HashTable<String, Integer>();
		table.add("one", 1);
		table.add("two", 2);
		table.add("three", 3);
		System.out.println(table.get("two"));
		table.remove("two");
		System.out.println(table.get("one"));
		System.out.println(table.get("three"));

	}


}

class HashEntry<K, V> {

	private K key;
	private V value;

	public HashEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

}