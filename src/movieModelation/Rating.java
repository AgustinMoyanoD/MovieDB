package movieModelation;

public class Rating {
	//VARIABLES
	/*
	 * All the double variables are cap from 0 to 100, in case of overflow, null will be assign.
	 */
	private boolean watchP,watchA;//If the film is watchable for the owners of this db.
	private Double direction;
	private Double script;
	private Double performance;
	private Double sfx;
	private Double sound;
	private Double finalRating;//Average from all the previous fields.
	//CONSTRUCTOR
	public Rating() {
		
	}
	public Rating(boolean watchP, boolean watchA, double direction, double script, double performance, double sfx, double sound) 
	{
		this.watchP = watchP;
		this.watchA = watchA;
		if (this.verifyRange(direction))
			this.direction = direction;
		else
			this.direction = null;
		if (this.verifyRange(script))
			this.script = script;
		else
			this.script = null;
		if (this.verifyRange(performance))
			this.performance = performance;
		else
			this.performance = null;
		if (this.verifyRange(sfx))
			this.sfx = sfx;
		else
			this.sfx = null;
		if (this.verifyRange(sound))
			this.sound = sound;
		else
			this.sound = null;
		if (sfx != -1) // In case of SFX doesn't need a rating -1 will be assigned.
			this.finalRating = (this.direction + this.script + this.performance + this.sound) / 4; 
		else
			this.finalRating = (this.direction + this.script + this.performance + this.sound + this.sfx) / 5;
	}
	//Others functionalities (Privates).
	private boolean verifyRange(double num) {
		if (num < -1 || num > 100)
			return false;
		else
			return true;
	}
	
	
	// GETTERS AND SETTERS
	public boolean isWatchP() {
		return watchP;
	}
	public void setWatchP(boolean watchP) {
		this.watchP = watchP;
	}
	public boolean isWatchA() {
		return watchA;
	}
	public void setWatchA(boolean watchA) {
		this.watchA = watchA;
	}
	public double getDirection() {
		return direction;
	}
	public void setDirection(double direction) {
		this.direction = direction;
	}
	public double getScript() {
		return script;
	}
	public void setScript(double script) {
		this.script = script;
	}
	public double getPerformance() {
		return performance;
	}
	public void setPerformance(double performance) {
		this.performance = performance;
	}
	public double getSfx() {
		return sfx;
	}
	public void setSfx(double sfx) {
		this.sfx = sfx;
	}
	public double getSound() {
		return sound;
	}
	public void setSound(double sound) {
		this.sound = sound;
	}
	public double getFinalRating() {
		return finalRating;
	}
	public void setFinalRating(double finalRating) {
		this.finalRating = finalRating;
	}

	
}
