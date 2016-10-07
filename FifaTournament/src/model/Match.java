package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.owlike.genson.annotation.JsonDateFormat;

import data_access.PlayerDA;
import data_access.TeamDA;

@Entity
@Table(name = "fifa.Match")
public class Match {
	public Match() {
	}

	public Match(int homePlayer, int awayPlayer, int homeTeam, int awayTeam, int homescore, int awayscore, boolean overtime, boolean penalty, Date timestamp) {
		this.homePlayer = PlayerDA.getPlayer(homePlayer);
		this.awayPlayer = PlayerDA.getPlayer(awayPlayer);
		this.homeTeam = TeamDA.getTeam(homeTeam);
		this.awayTeam = TeamDA.getTeam(awayTeam);
		this.timestamp = timestamp;
		this.homescore = homescore;
		this.awayscore = awayscore;
		this.overtime = overtime;
		this.penalty = penalty;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "idMatch")
	private int id;
	@ManyToOne
	@JoinColumn(name = "homePlayer")
	private Player homePlayer;
	@ManyToOne
	@JoinColumn(name = "awayPlayer")
	private Player awayPlayer;
	@ManyToOne
	@JoinColumn(name = "homeTeam")
	private Team homeTeam;
	@ManyToOne
	@JoinColumn(name = "awayTeam")
	private Team awayTeam;
	@Column(name = "timestamp")
	private Date timestamp;
	@Column(name = "homescore")
	private int homescore;
	@Column(name = "awayscore")
	private int awayscore;
	@Column(name = "overtime")
	private boolean overtime;
	@Column(name = "penalty")
	private boolean penalty;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Player getHomePlayer() {
		return homePlayer;
	}

	public void setHomePlayer(int homePlayer) {
		this.homePlayer = PlayerDA.getPlayer(homePlayer);
	}

	public Player getAwayPlayer() {
		return awayPlayer;
	}

	public void setAwayPlayer(int awayPlayer) {
		this.awayPlayer = PlayerDA.getPlayer(awayPlayer);
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(int homeTeam) {
		this.homeTeam = TeamDA.getTeam(homeTeam);
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(int awayTeam) {
		this.awayTeam = TeamDA.getTeam(awayTeam);
	}

	@JsonDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Date getTimestamp() {
		return timestamp;
	}

	@JsonDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getHomescore() {
		return homescore;
	}

	public void setHomescore(int homescore) {
		this.homescore = homescore;
	}

	public int getAwayscore() {
		return awayscore;
	}

	public void setAwayscore(int awayscore) {
		this.awayscore = awayscore;
	}

	public boolean isOvertime() {
		return overtime;
	}

	public void setOvertime(boolean overtime) {
		this.overtime = overtime;
	}

	public boolean isPenalty() {
		return penalty;
	}

	public void setPenalty(boolean penalty) {
		this.penalty = penalty;
	}
}
