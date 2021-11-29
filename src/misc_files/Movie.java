package misc_files;

class Movie {
	
	
	
	//Instance variables
	String title;
	//String genre;
	int year=2020;//default value
	int rating; //0-5
	
	//constructor 
	Movie(String t, int year, int rating) {
		title = t;
		this.year = year;
		
		if (rating > 5 || rating < 0) rating = 1;
		this.rating = rating; //Use "this" if variable name is the same
	}
}
