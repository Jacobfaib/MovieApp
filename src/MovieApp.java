public class MovieApp{
	public static void main(String[] args){
		int n = 0; //variable which decides the state in which the app is
		LinkedList movieList = new LinkedList(null, null); //header
		
		
		while (n <= 9){
		System.out.println("Welcome to the Movie Rating App! Select an option below:");
		System.out.println("1) Add a movie");
		System.out.println("2) Remove a movie");
		System.out.println("3) Display movies alphabetically");
		System.out.println("4) Display movies >= a certain rating");
		System.out.println("5) Display movies in a specified genre");
		System.out.println("6) List all movies with a specified actor/actress");
		System.out.println("7) List all movies the user has yet to see");
		System.out.println("8) Display a movies description");
		System.out.println("9) Quit");
		System.out.println("Select an option above by inputing 1-9 into the console:");
		n = TextIO.getlnInt();
		
		
		
		if (n == 1){
			System.out.println("Please input the information in this order:");
			System.out.println("Title, Rating (1-5), Description, Genre, Have Seen(true/false), Actors (a comma seperated list)");
			String title = TextIO.getln();
			int rating = TextIO.getlnInt();
			String descr = TextIO.getln();
			String genre = TextIO.getln();
			Boolean haveSeen = TextIO.getlnBoolean();
			String names = TextIO.getln();
			String[] actors = simpleList(names);
			
			movie newMovie = new movie(title,rating,descr,genre,haveSeen,actors);
			movieList.append(newMovie);
			TextIO.putln("Size of movie list: " + movieList.getSize());
			
		}
		
		if (n ==2){
			String input = TextIO.getln();
			movieList.remove(input);
			TextIO.putln("Size of movie list: " + movieList.getSize());
		}
		
		if (n == 3){
			TextIO.putln(movieList.toString());
		}
		
		if (n == 4){
			int input = TextIO.getlnInt();
			TextIO.putln(movieList.rating(input));
		}
		
		if (n == 5){
			String input = TextIO.getln();
			TextIO.putln(movieList.genres(input));
		}
		
		if (n == 6){
			String input = TextIO.getln();
			TextIO.putln(movieList.actors(input));
		}
		
		if (n == 7){
			TextIO.putln(movieList.seeMe());
		}
		if (n == 8){
			String input = TextIO.getln();
			TextIO.putln(movieList.dispDescription(input));
		}
		if (n == 9){
			TextIO.putln("Are you sure you want to quit? All progress will be lost. y/n");
			boolean input = TextIO.getBoolean();
			if (input){
				TextIO.putln("Quitting now");
				n = 10;
				TextIO.putln("Quit successful");
			}else{
			TextIO.putln("Cancelling...");
			n = 0;
			TextIO.putln("Cancel successful");
			}
		}
		}
	}
	//middle-man function between input and larger linkedlist structure to parse the actors names into a variable sized array
	public static String[] simpleList(String names){
		return names.split(",");
	}
}