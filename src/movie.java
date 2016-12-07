
public class movie {
	
	private final String title;
	private final int rating;
	private final String descr;
	private final String genre;
	private final Boolean haveSeen;
	private String[] actors;
	
	//constructor

	public movie(String title, int rating, String descr, String genre, Boolean haveSeen, String[] actors){
		this.title = title;
		this.rating = rating;
		this.descr = descr;
		this.genre = genre;
		this.haveSeen = haveSeen;
		this.actors = actors;
	}
	
	//getter functions
	
	public String getTitle(){
		return this.title;
	}
	public int getRating(){
		return this.rating;
	}
	public String getGenre(){
		return this.genre;
	}
	public String[] getActors(){
		return actors;
	}
	public Boolean contains(String actor){
		Boolean contained = false;
		for (int i = 0;i < this.actors.length;i++){
			if (this.actors[i].equals(actor)){
				contained = true;
			}
		}
		return contained;
	}
	public Boolean getSeen(){
		return this.haveSeen;
	}
	public String getDescr(){
		return this.descr;
	}
}
