package model;

import com.owlike.genson.annotation.JsonIgnore;

//Model to send to the client
public class PlayerStats extends Player {
	@JsonIgnore
	public static final int WIN = 3;
	@JsonIgnore
	public static final int TIE = 1;
	@JsonIgnore
	public static final int DEFEAT = 0;

	public PlayerStats(Player player) {
		super(player.getName());
		this.id = player.getId();
	}

	// Properties specific for Stats
	private int wins = 0;
	private int defeats = 0;
	private int ties = 0;
	private int gamesPlayed = 0;
	private int points = 0;

	public int getWins() {
		return wins;
	}

	public int getDefeats() {
		return defeats;
	}

	public int getTies() {
		return ties;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public int getPoints() {
		return points;
	}

	public void addWin() {
		this.wins += 1;
		this.gamesPlayed += 1;
		this.points += WIN;
	}

	public void addTie() {
		this.ties += 1;
		this.gamesPlayed += 1;
		this.points += TIE;
	}

	public void addDefeat() {
		this.defeats += 1;
		this.gamesPlayed += 1;
		this.points += DEFEAT;
	}
}
