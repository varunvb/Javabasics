class Movie {
String title;
String genre;
int rating;

 void playIt() {
  System.out.println("playing the movie");
 }
}
public class MovieRun {
  public static void main (String [] args) {

 Movie one = new Movie ();
 one.title = "pulp fiction";
 one.genre = "comedy";
 one.rating = -3;

 Movie two = new Movie ();
 two.title = "Mr bean";
 two.genre = "comedy";
 two.rating = -4;
 one.playIt();

 }
}
