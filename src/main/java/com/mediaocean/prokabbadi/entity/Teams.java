package com.mediaocean.prokabbadi.entity;

import java.util.ArrayList;
import java.util.List;

public class Teams {
	
	private List<Team> teamList;

	public List<Team> getTeamList(){
		if(teamList==null) {
			teamList = new ArrayList<Team>();
		}
		return teamList;
	}
	
	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}
}
