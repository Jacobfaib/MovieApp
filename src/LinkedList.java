
public class LinkedList {
	
	private LinkedList next;
	private movie film;
	private int size = 0;
	
	public LinkedList(movie film, LinkedList next){
		this.film = film;
		this.next = null;
	}
	
	public void append(movie film){
		
		if (this.film == null){ //if there is nothing there
			this.film = film;
			size++;
			return;
		}
		
		if (next == null){ //if it is at the end of the list
			this.next = new LinkedList(film,null);
			size++;
			return;
		}
		
		if (film.getTitle().compareTo(next.film.getTitle()) < 0){ //inserter
			LinkedList temp = new LinkedList(film,null);
			temp.next = this.next;
			this.next = temp;
			size++;
			return;
		}
		
		next.append(film);
	}
	
	public String toString(){
		if (film == null){
			return "Your movie list is empty";
		}
		if (next == null) return this.film.getTitle();
		String restOfString = next.toString(); 
		return film.getTitle() + ", " + restOfString;
		
	}
	
	public void remove(String toRemove){
		if (film == null){
			TextIO.putln("Your movie list is empty/movie not found");
			size--;
			if (size < 0) size = 0;
			return;
		}
		if(this.film.getTitle().compareToIgnoreCase(toRemove) ==0){//need to remove first one
			if(this.next == null){
				this.film = null;
			}else{
				this.film = next.film;
				this.next = next.next;
			}
			size--;
			if (size < 0) size = 0;
			return;
		}
		
		String skip = this.next.film.getTitle();
		if(skip.compareToIgnoreCase(toRemove)==0){//match
			if(this.next.next == null){
				this.next = null;
			}else{
				this.next = this.next.next;
			}
			size--;
			if (size < 0) size = 0;
			return;
		}
		next.remove(toRemove);
	}
	public String rating(int stars){
		if (this.film == null){ //if there is nothing there
			return "Your movie list is empty";
		}
		
		if (next == null){ //if it is at the end of the list
			if(film.getRating() >= stars)
				return film.getTitle();
			else return "";
		}
		
		if (film.getRating() >= stars){ //match found
			return this.film.getTitle() + ", " + next.rating(stars);
			
		}else{ //no matches found this cycle
			return next.rating(stars);
		}
	}
	public String genres(String genre){
		if (this.film == null){ //if there is nothing there
			return "Your movie list is empty";
		}
		
		if (next == null){ //if it is at the end of the list
			if(film.getGenre().equals(genre))
				return film.getTitle();
			else return "";
		}
		
		if (film.getGenre().equals(genre)){ //match found
			return this.film.getTitle() + ", " + next.genres(genre);
			
		}else{ //no matches found this cycle
			return next.genres(genre);
		}
	}
	public String actors(String actor){
		if (this.film == null){ //if there is nothing there
			return "Your movie list is empty";
		}
		
		if (next == null){ //if it is at the end of the list
			if(film.contains(actor))
				return film.getTitle();
			else return "";
		}
		
		if (film.contains(actor)){ //match found
			return this.film.getTitle() + ", " + next.actors(actor);
			
		}else{ //no matches found this cycle
			return next.actors(actor);
		}
	}
	public String seeMe(){
		if (this.film == null){ //if there is nothing there
			return "Your movie list is empty";
		}
		
		if (next == null){ //if it is at the end of the list
			if(film.getSeen() == false)
				return film.getTitle();
			else return "";
		}
		
		if (film.getSeen() == false){ //match found
			return this.film.getTitle() + ", " + next.seeMe();
			
		}else{ //no matches found this cycle
			return next.seeMe();
		}
		
	}
	public String dispDescription(String movie){
		if (this.film == null){ //if there is nothing there
			return "Your movie list is empty";
		}
		if (next == null){ //if it is at the end of the list
			if(film.getTitle().equals(movie))
				return film.getDescr();
			else return "";
		}
		if (film.getTitle().equals(movie)){ //match found
			return this.film.getDescr();
			
		}else{ //no matches found this cycle
			return next.dispDescription(movie);
		}
	}
	public int getSize(){
		return this.size;
	}
}
	
	


