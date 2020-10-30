public class Entry {
      // This is my basic understanding of the chaining concept. 
      // I didn't attempt to make it more confusing than it had to be. 
      // The members of the class are here to contain input primarily 
      // for the get and put methods in the other class. 
      String key;
      int value;
      Entry next;
      // Constructors for getters and pointers
      // to nodes. 
      public Entry(String key, int value) {
            this.key = key;
            this.value = value;
            next = null;
      }

      public Entry() {
            next = null;
      }
      public String getKey() {
            return key;
      }

      public int getValue() {
            return value;
      }
} //Again, GeekstoGeeks gave me a decent understanding. This code was pulled from 
// snippets and changed to fit with the lab. 