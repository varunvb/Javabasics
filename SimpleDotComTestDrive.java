import java.io.*;
import java.util.ArrayList;
public class SimpleDotComTestDrive {
  public static void main (String []  args) {
    int numOfGuesses = 0;
    GameHelper helper = new GameHelper ();
    SimpleDotCom dot = new SimpleDotCom ();
    int randomNum = (int) (Math.random()*5);
    ArrayList<Integer> locations = new ArrayList<Integer> (); 
    locations.add (randomNum);
     locations.add (randomNum+1); 
     locations.add (randomNum+2);
    dot.setLocationCells (locations);
    boolean isAlive = true;
    while (isAlive == true) {
      String guess = helper.getUserInput ("enter a number");
      String result = dot.checkYourself (guess);
      numOfGuesses++;
      if (result.equals("kill")) {
         isAlive = false;
         System.out.println ("You took " +numOfGuesses + " guesses");
      } // if close
    } // while
  } // main
} // class

class SimpleDotCom {
 private ArrayList<Integer> locationCells;
 public void setLocationCells(ArrayList<Integer> loc) {
  locationCells = loc;
 }
 public String checkYourself (String userInput) {
 String result = "miss";
 int index = locationCells.indexOf(userInput);
 if (index >= 0) {
   locationCells.remove(index);
   if (locationCells.isEmpty()) {
   result = "kill";
} else {
    result = "hit";
 } // close if
}
return result;
} // close method
} // close class

class GameHelper {

public String getUserInput (String prompt) {
 String inputLine = null;
 System.out.print (prompt + " ");
 try {
 BufferedReader is = new BufferedReader (new InputStreamReader (System.in));
 inputLine = is.readLine();
 if (inputLine.length() == 0) return null;
 } catch (IOException e) {
   System.out.println("IOException: " + e);
 }
 return inputLine;
 }
}
 

