package programming.set11.brownies;





	public class BrownieMap< K, V> {
		
		private int buckets;
		
		LinkedElement<BrownieEntry> [] bucketArray ;

		/**
		 * The capacity sets the length of the bucket array.
		 * 
		 * @param numberOfBuckets
		 *            bucket array length
		 * @throws IllegalArgumentException
		 *             if the number of buckets is smaller than one.
		 */
		public BrownieMap(int numberOfBuckets) {
			// Implement the constructor!
			if(numberOfBuckets<1) {
				throw new IllegalArgumentException("that are not enough buckets for our tasty Brownies");
			}
			buckets = numberOfBuckets;
			bucketArray = new LinkedElement[10];
			
		}

		/**
		 * Put an item into the map.
		 * 
		 * @param key
		 *            the key of the item.
		 * @param value
		 *            the value of the item.
		 * @throws IllegalArgumentException
		 *             if the key or the value is {@code null}.
		 */
		public void put(K key, V value) {
			int bucket = Math.abs(key.hashCode()) % buckets;
			
			
			
		}

		/**
		 * Returns the value of a given key.
		 * 
		 * @param key
		 *            the key of the item.
		 * @return the value belonging to that key or {@code null} if no value is mapped
		 *         to that key.
		 * @throws IllegalArgumentException
		 *             if the key is {@code null}.
		 */
		public V get(K key) {
			// Implement me!
			return null;
		}

		/**
		 * Removes one key and its value from the map. If the key does not exist in the
		 * map, nothing happens.
		 * 
		 * @param key
		 *            the key.
		 * @throws IllegalArgumentException
		 *             if the key is {@code null}.
		 */
		public void remove(K key) {
			// Implement me!
		}

		/**
		 * Clears the entire map.
		 */
		public void clear() {
			// Implement me!
		}

	}

	class BrownieEntry<V, K> {

		private K entryKey; /* The key component for this HashEntry */
		private V entryValue; /* The value component for this HashEntry */
		private BrownieEntry<V, K> entryLink; /* The next entry in the chain */

		/* Creates a new HashEntry for the specified key/value pair */
		public BrownieEntry(K key, V value) {
			entryKey = key;
			entryValue = value;
		}

		/* Returns the key component of a HashEntry */
		public K getKey() {
			return entryKey;
		}

		/* Returns the value component of a HashEntry */
		public V getValue() {
			return entryValue;
		}

		/* Sets the value component of a HashEntry to a new value */
		public void setValue(V value) {
			entryValue = value;
		}

		/* Returns the next link in the entry chain */
		public BrownieEntry<V, K> getLink() {
			return entryLink;
		}

		/* Sets the link to the next entry in the chain */
		public void setLink(BrownieEntry<V, K> nextEntry) {
			entryLink = nextEntry;
		}

	}
}
