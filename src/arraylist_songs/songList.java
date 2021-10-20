package arraylist_songs;

import java.util.ArrayList;
/*
 * Chris S
 * Sept 23, 2021
 * Mr Harwood
 * Song Book Program
 * Outputs songs with title, artist, release year and rating
 * If the song is rated a 0 it gets deleted
 */

public class songList {
	static ArrayList<Songs> songBook = new ArrayList<Songs>();
	
	public static void main (String[] args) {
		songBook.add(new Songs("Gangnam Style", "Psy", 2012, 0));
		songBook.add(new Songs("Africa", "Toto", 1982, 4));
		songBook.add(new Songs("Hey Ya", "OutKast", 2003, 3));
		songBook.add(new Songs("Should I Stay or Should I Go Now", "The Clash", 1982, 4));
		songBook.add(new Songs("Hey Ya", "OutKast", 2003, 5));
		
		printSongs();
	
		System.out.println("");
		
		removeSongs();
		
		printSongs();
	}
	
	static void printSongs() {
		for (Songs list : songBook) {
			System.out.printf("Song Title: %-36s | Artist: %-10s | Release Year: %4d | Rating: %1d", list.title, list.artist, list.releaseYear, list.score);
			System.out.println("");
		}
	}
	
	static void removeSongs() {
		for (int j = songBook.size()-1; j>=0; j--) {
			Songs list = songBook.get(j);
			if (list.score == 0) songBook.remove(j);
		}
	}
}
