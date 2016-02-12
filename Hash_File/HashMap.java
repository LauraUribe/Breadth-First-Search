package alg_hwk6;

public class HashMap 
{
    private final static int SIZE = 36;

    HashEntry[] table;

    HashMap() 
    {
          table = new HashEntry[SIZE];
          for (int i = 0; i < SIZE; i++)
                table[i] = null;
    }

    public void get(int key) 
    {
          int hash = (key % SIZE);
          while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % SIZE;
          if (table[hash] == null)
                System.out.println("NO RECORD FOUND");
          else
                System.out.println("KEY VALUE " + table[hash].getKey() + " IS " + table[hash].getValue());
    }
    
    public void put(int key, int value) 
    {
          int hash = (key % SIZE);
          while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % SIZE;
          table[hash] = new HashEntry(key, value);
    }
    
}
