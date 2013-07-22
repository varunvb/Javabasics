class Hobbits {
 String name;
 public static void main (String [] args) {
  Hobbits [] h = new Hobbits [3];
  int z = -1;
System.out.println (h.length);
  
  while (z < h.length) {
   z= z + 1;
   h [z] = new Hobbits ();
   h [z].name = "bilbo";
   if (z == 1) {
    h[z].name = "frodo";
   }
   if (z == 2) {
     h[z].name = "sam";
   }
 
  System.out.println ( h[z].name + "  is a good hobbit name");
  }
 }
// the exception here is due to the length being 9 and the maximum iteration value being 2
}
 
