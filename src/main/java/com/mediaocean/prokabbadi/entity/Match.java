package com.mediaocean.prokabbadi.entity;

import java.util.Date;

public class Match implements Comparable<Match>{

	private final Team homeTeam;
	private final Team awayTeam;
	private String location;
	private Date date;

	public Match(Team homeTeam, Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	@Override
	public String toString() {
		return "Match [homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", location=" + location + ", date=" + date
				+ "]";
	}

	@Override
	public int compareTo(Match match) {
		// TODO Auto-generated method stub
		return this.getDate().compareTo(match.getDate());
	}

	
	
	
}
