package misc_files;

import java.util.ArrayList;

public class MoveProgram {

	static ArrayList<Movie> movieList = new ArrayList<Movie>();;

	public static void main(String[] args) {
		Movie m = new Movie("The Avengers", 2015,5); //"new" makes an object
		m.year = 2000;
		movieList.add(m);
		m = new Movie("Jurassic Park", 1997, 4);
		movieList.add(m);
		movieList.add(new Movie("Gone with the Wind", 1937, 3));

		System.out.println(m.title + " " + m.rating);

		printList();

		System.out.println(movieList.size());
	}

	static void printList() {
		for (int i = 0; i <movieList.size(); i++) {
			Movie movie = movieList.get(i);
			System.out.println(movie.title + "\t" +
					movie.year + " Stars: " + movie.rating);
		}
	}
	
	static void printList2() {
		for (Movie movie : movieList) {
			
			System.out.println(movie.title + "\t" + movie.year + "stars:" + movie.rating);
		}
	}
}
