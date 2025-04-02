package src.movieModelation;

public class Movie {
	//VARIABLES
	private int dbID; //Database identificator.
	private String name;
	private String nameESP;
	private int duration; // minutes format.
	private int year; // Release.
	private Rating rating;
	//CONSTRUCTOR
	public Movie() {
		this.rating = new Rating();
	}
	
	public Movie(String name, String nameESP, int duration, int year,boolean watchP, boolean watchA, double direction, double script, double performance, double sfx, double sound) {
		this.name = name;
		this.nameESP = nameESP;
		this.duration = duration;
		this.year = year;
		this.rating = new Rating(watchP,watchA,direction,script, performance,sfx,sound);
	}
	/*
	 * This constructor contains ID value from the db in case of need.
	 */
	public Movie(int dbID,String name, String nameESP, int duration, int year,boolean watchP, boolean watchA, double direction, double script, double performance, double sfx, double sound) {
		this.dbID = dbID;
		this.name = name;
		this.nameESP = nameESP;
		this.duration = duration;
		this.year = year;
		this.rating = new Rating(watchP,watchA,direction,script, performance,sfx,sound);
	}
	//GETTERS AND SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameESP() {
		return nameESP;
	}
	public void setNameESP(String nameESP) {
		this.nameESP = nameESP;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Rating getRating() {
		return this.rating;
	}
	
	public int getDbID() {
		return dbID;
	}
	public void setDbID(int dbID) {
		this.dbID = dbID;
	}
	public void setRating(boolean watchP, boolean watchA, double direction, double script, double performance, double sfx, double sound) {
		this.rating.setWatchP(watchP);
		this.rating.setWatchA(watchA);
		this.rating.setDirection(direction);
		this.rating.setScript(script);
		this.rating.setPerformance(performance);
		this.rating.setSfx(sfx);
		this.rating.setSound(sound);
	}
	
}
