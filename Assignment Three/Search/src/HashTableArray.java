// Creation of hashtable
public class HashTableArray<T> {
    // Memmbers of the class with the entry handling
    // chains by placing the hash within. Size for 
    //obvious reasons. Init comparisons. 
    Entry[] arrayHash;
    int size;
    int moreComparions = 0;
    //Takes a size argument to set the size of 
    //the table. 
    public HashTableArray(int size) {
        this.size = size;
        arrayHash = new Entry[size];
        for (int i = 0; i < size; i++)
            arrayHash[i] = new Entry();
            moreComparions++;
            
    }
    // Using the hash function of the given java file. 
    // The below function iterations through the key's 
    // characters and generates a numerical value.
    int GetHash(String key) {
        key = key.toUpperCase();
        int length = key.length();
        int letterTotal = 0;
        // Individual characters placed into variables and 
        // casted into ints with the total letter value
        // being calculated.
        for (int i = 0; i < length; i++) {
            char thisLetter = key.charAt(i);
            int thisValue = (int) thisLetter;
            letterTotal = letterTotal + thisValue;
        }
        // Hash chode generated through the modulo of the 
        // size of the table. 
        int hashCode = (letterTotal * 1) % size;

        return hashCode;
    }
    // Put method that takes in a value and key. Uses 
    // the above GetHash method to create and index and 
    // passed into the arrayvalue. at the same time, the 
    // entry node is placed as a newitem with the next
    // being generated upon successful creation. 
    public void put(String key, int value) {
        int HashIndex = GetHash(key);
        Entry ArrayValue = arrayHash[HashIndex];
        Entry newItem = new Entry(key, value);
        newItem.next = ArrayValue.next;
        ArrayValue.next = newItem;
    }

    
    public int get(String key) {
        moreComparions++;
        int value = 0;
        int HashIndex = GetHash(key);
        Entry ArrayValue = arrayHash[HashIndex];
        while (ArrayValue != null) {
            if (ArrayValue.getKey() == key) {
                moreComparions++;
                value = ArrayValue.getValue();
                break;
            }
            ArrayValue = ArrayValue.next;
        }
        return value;
    }

    

}
