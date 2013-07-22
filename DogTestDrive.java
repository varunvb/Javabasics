class Dog {

int size;
String name;

void bark () {
 
 if (size > 60) {
 System.out.println (name + "says Woof Woof");
 }

if (size < 60) {
 System.out.println (name + "says Ruff Ruff");
 }

if (size < 14) {
 System.out.println (name + "says Yip Yip");
 }
}
}
public class DogTestDrive {

public  static void main (String [] args) {
   Dog one = new Dog ();
   one.name = "biggie";
   one.size = 70;
   Dog two = new Dog();
   two.name = "marge";
   two.size = 50;
   Dog three = new Dog ();
   three.name = "rocci";
   three.size = 10;

   one.bark();
  two.bark();
  three.bark();

}
} 
