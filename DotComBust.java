import java.util.*;
import java.io.*;
class DotCom {
  private ArrayList<String> locationCells;
  private String name;
  public void setLocationCells (ArrayList<String> loc) {
    locationCells = loc;
  }
  public void setName(String n) {
    name = n;
  }
  public String checkYourSelf(String userInput) {
    String result = "miss";
    int index = locationCells.indexOf(userInput);
    if (index >= 0) {
      locationCells.remove(index);
       if (locationCells.isEmpty()) {
          result = "kill";
          System.out.println ("Ouch! You sunk " +name+  " :( " );
       } else {
            result = "hit";
       } // close if
    } //close if
    return result;
 } // close CheckYourself method

} // close DotCom class




///////////////DOTCOMEND**/////




class GameHelper {
  private static final String alphabet = "abcdefg";
  private int gridLength = 7;
  private int gridSize = 49;
  private int [] grid = new int [gridSize];
  private int comCount = 0;
  public String getUserInput (String prompt) {
    String inputLine = null;
    System.out.print(prompt + "  ");
    try {
      BufferedReader is = new BufferedReader(new InputStreamReader(System.in)); 
      inputLine = is.readLine();
      if (inputLine.length () == 0) return null;
     } catch (IOException e) {
       System.out.println ("IOException " + e);
     }
        return inputLine.toLowerCase();
     } // Close getUserInput method
public ArrayList<String> placeDotCom (int comSize) {
  ArrayList<String> alphaCells = new ArrayList<String> ();
  String [] alphacoords = new String [comSize];
  String temp = null;
  int [] coords = new int[comSize];
  int attempts = 0;
  boolean success = false;
  int location = 0;
  comCount++;
  int incr = 1;
  if ((comCount % 2) == 1) {
    incr = gridLength;
  }
  while (!success & attempts ++ < 200) { 
    location = (int) (Math.random() * gridSize);
    System.out.print (" try " +location);
    int x = 0;
     success = true;
     while (success && x < comSize) {
       if (grid[ location] == 0) {
          coords [x++] = location;
          location += incr;
          if (location >= gridSize) {
             success = false;
 	  }
       if (x>0 && (location % gridLength == 0)) {
         success = false;
       }
      } else {
          System.out.print (" used " +location);
	  success = false;
      }
    }
  }
  int x = 0;
  int row = 0;
  int column = 0;
  while (x < comSize) {
   grid [coords[x]] = 1;
   row = (int) (coords[x] / gridLength);
   column = coords[x] % gridLength;
   temp = String.valueOf(alphabet.charAt(column));
   alphaCells.add (temp.concat(Integer.toString(row)));
   x++;
   System.out.print ( "  coord  " +x+ " = " +alphaCells.get(x-1));
  }
  System.out.println("\n");
 return alphaCells;
}
}

////////////////GAMEHELPER END****///




public class DotComBust {
 private GameHelper helper = new GameHelper ();
 private ArrayList<DotCom> dotComsList = new ArrayList<DotCom> ();
 //Arraylist to hold DotCom Objects declared.
 private int numOfGuesses;
 //int variable for giving out player scores.
 private void SetUpGame() {
    // make some dotcoms and give them locations.
    DotCom one = new DotCom();
    one.setName ("Pets.com");
    DotCom two = new DotCom();
    two.setName ("eToys.com");
    DotCom three = new DotCom();
    three.setName ("Go2.com");
    dotComsList.add (one);
    dotComsList.add (two);
    dotComsList.add (three);
    System.out.println ("Your Goal is to sink three dotcoms.");
    System.out.println ("Pets.com, eToys.com, Go2.com");
    System.out.println ("Try to sink all of em in fewest number of Guesses");
    for (DotCom dotComToSet : dotComsList){
      //Repeat with each dotcoms in the list.
      ArrayList<String> newLocation = helper.placeDotCom(3);
      dotComToSet.setLocationCells(newLocation);
    } // close for loop
 } // close setUpGame() method
private void startPlaying() {
    while (!dotComsList.isEmpty()) {
      String userGuess = helper.getUserInput("Enter a Guess");
      checkUserGuess(userGuess);
    } //close while
    finishGame();
} //close start playing method
private void checkUserGuess (String userGuess) {
   numOfGuesses++;
   String result = "miss";
   for (DotCom dotComToTest : dotComsList) {
      result = dotComToTest.checkYourSelf(userGuess);
      if (result == "hit") {
         break;
      }
      if (result == "kill") {
         dotComsList.remove(dotComToTest);
         break;
      }
   } //close for

   System.out.println(result);
} // close CheckUserGuess method.
private void finishGame(){
  System.out.println ("All Dotcoms are dead! Your stock is now worthless.");
  if (numOfGuesses <= 18) {
     System.out.println("It took only " +numOfGuesses + " guesses." );
     System.out.println ("You got out before your options sank");
   } else {
     System.out.println ("Took you long enough." +numOfGuesses+ " guesses.");
     System.out.println ("Fish are dancing with your options");
   }
} // close finish Game method
public static void main (String [] args) {
  DotComBust game = new DotComBust ();
  game.SetUpGame ();
  game.startPlaying();
} // close main
}
