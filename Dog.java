class Dog {

 String name;
 public static void main (String [] args) {
  Dog dog1 = new Dog ();
  dog1.name = "Bart";
  dog1.bark ();
  Dog [] myDogs = new Dog [3];
  myDogs [0] = new Dog ();
  myDogs [1] = new Dog ();
  myDogs [2] = dog1;
  
  myDogs [0].name = "Fred";
  myDogs [1].name = "Marge";
  
  System.out.println ("last dog's name is  ");
  System.out.println (myDogs[2].name);
// now lop through the array
// and tell the dogs to bark
 
  int x = 0;

  while (x < myDogs.length) {
  myDogs[x].bark ();
  x = x+1;
  }
}

public void bark () {
  System.out.println (name + "  says Woof Woof");
}
public void eat () { };
public void chaseCat () { };
}    
  
