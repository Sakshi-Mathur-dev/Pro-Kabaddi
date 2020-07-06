package com.mediaocean.prokabbadi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mediaocean.prokabbadi.entity.Team;
import com.mediaocean.prokabbadi.entity.Teams;

@Repository
public class TeamDao {
	
	private static Teams teams = new Teams();
	
	/*DAO class uses a static list to store data. 
	Here we need to implement actual database interaction.
	*/
	
static {
	teams.getTeamList().add(new Team(1,"Rajasthan-Royals", "Rajasthan"));
	teams.getTeamList().add(new Team(2,"Punjab-King", "Punjab"));
	teams.getTeamList().add(new Team(3,"J&K-Warriors", "J&K"));
	teams.getTeamList().add(new Team(4,"Gujarat-Gang", "Gujarat"));
	teams.getTeamList().add(new Team(5,"Delhi-Devils", "Delhi"));
	teams.getTeamList().add(new Team(6,"Mumbai-Marvel", "Jaipur"));
	/*teams.getTeamList().add(new Team(7,"Bangalore-Bands", "Bangalore"));
	teams.getTeamList().add(new Team(8,"Himachal-Hunk", "Himachal"));
	teams.getTeamList().add(new Team(9,"Patna-Pirates", "A"));
	teams.getTeamList().add(new Team(10,"B-B", "B"));
	teams.getTeamList().add(new Team(11,"C-C", "C"));
	teams.getTeamList().add(new Team(12,"D-D", "D"));
	teams.getTeamList().add(new Team(13,"E-E", "E"));*/
	
}

public List<Team> getAllTeams(){
	return teams.getTeamList();
}



public void addTeam(Team team) {
    teams.getTeamList().add(team);
}
}
