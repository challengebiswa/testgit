import java.util.HashMap;

public class HashmapDemo {
   public static void main(String args[]) {
   // create hash map
   HashMap newmap = new HashMap();
      
   // populate hash map
   newmap.put("dsuza", "tutorials");
   newmap.put("testauthor1", "point");
   newmap.put(3, "is best"); 
   Person p=new Person();
   p.setName("testauthor1");
   // check existence of key 2
   System.out.println("Check if key 2 exists: " + newmap.containsKey(p.getName()));
   }    
}

