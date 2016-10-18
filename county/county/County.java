package county;

import java.util.ArrayList;

public class County {
	private int numArmies;
	private int teamOwned;
	private String state;
	protected ArrayList<County> borders=new ArrayList<County>();
	protected static StCharles stCharles=new StCharles();
	protected static Bond bond=new Bond();
	protected static Calhoun calhoun=new Calhoun();
	protected static Clinton clinton=new Clinton();
	protected static Franklin franklin=new Franklin();
	protected static Jefferson jefferson=new Jefferson();
	protected static Lincoln lincoln=new Lincoln();
	protected static Madison madison=new Madison();
	protected static Monroe monroe=new Monroe();
	protected static StCharles stCharels=new StCharles();
	protected static StClair stClair=new StClair();
	protected static StLouis stLouis=new StLouis();
	protected static Warren warren=new Warren();
	protected static Washington washington=new Washington();
	public County(String state) {
		this.numArmies = 0;
		this.teamOwned = 0;
		this.state = state;
	}
	public int getNumArmies() {
		return numArmies;
	}
	public void setNumArmies(int numArmies) {
		this.numArmies = numArmies;
	}
	public int getTeamOwned() {
		return teamOwned;
	}
	public void setTeamOwned(int teamOwned) {
		this.teamOwned = teamOwned;
	}
	public String getState() {
		return state;
	}
}
