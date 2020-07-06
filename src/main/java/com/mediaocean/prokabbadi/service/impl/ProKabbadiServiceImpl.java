package com.mediaocean.prokabbadi.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mediaocean.prokabbadi.dao.TeamDao;
import com.mediaocean.prokabbadi.entity.Match;
import com.mediaocean.prokabbadi.entity.Team;
import com.mediaocean.prokabbadi.service.IProkabbadiService;

@Component("ProKabbadiServiceImpl")
public class ProKabbadiServiceImpl implements IProkabbadiService{
	
	@Autowired
	private TeamDao teamDao;
	
	public List<Match> getMatchesScheduled() {
		List<Team> teamsList = teamDao.getAllTeams();
		
		//prepare list of matches between participating teams
		List<Match> matches = initializeMatches(teamsList);
		
		Date startDate = new Date();
		// Define current date
		DateTime currentDate = new DateTime(startDate.getTime());
		
	      
		
		// Loop till one of the match is not scheduled
		while (isMatchScheduleRemaining(matches)) {
			
			// Prepare already participated team id list
			List<Integer> participatedTeamIds = previousParticipatedTeams(matches, currentDate.minus(Period.days(1)).toDate());
			List<Integer> currentDayMatches =new ArrayList<Integer>();
			
			for (Match match : matches) {
				if (match.getDate()  == null &&
						!participatedTeamIds.contains(match.getHomeTeam().getId()) &&
						!participatedTeamIds.contains(match.getAwayTeam().getId())&& currentDayMatches.size()<=2) {
					match.setDate(currentDate.toDate());
					participatedTeamIds.add(match.getHomeTeam().getId());
					participatedTeamIds.add(match.getAwayTeam().getId());
					
					currentDayMatches.add(match.getHomeTeam().getId());
					currentDayMatches.add(match.getAwayTeam().getId());
					
				}
			}
			
			// Increment current date to ensure No team plays on consecutive days 
			currentDate = currentDate.plus(Period.days(1));
			
		}

		Collections.sort(matches);
		
		return matches;
		
		//return matches.generateScheduledMatches(teamsList, new Date());
		
	
	}
	
private List<Match> initializeMatches(List<Team> teams) {
		
		List<Match> matches = new ArrayList<Match>();

		// Initialize matches
		for (Team homeTeam : teams) {
			for (Team awayTeam : teams) {
				if (!homeTeam.getName().equalsIgnoreCase(awayTeam.getName())) {
					Match match = new Match(homeTeam, awayTeam);
					match.setLocation(homeTeam.getCity());
					
					matches.add(match);
				}
			}
		}

		// Return list of matches
		return matches;
	}
	
	private boolean isMatchScheduleRemaining(List<Match> matches) {
		for (Match match : matches) {
			if (match.getDate() == null) {
				return true;
			}
		}
		return false;
	}
	
	private List<Integer> previousParticipatedTeams(List<Match> matches, Date date) {
		List<Integer> teamIds = new ArrayList<Integer>();
		for (Match match : matches) {
			if (match.getDate() != null) {
				if (date.equals(match.getDate())) {
					teamIds.add(match.getHomeTeam().getId());
					teamIds.add(match.getAwayTeam().getId());
				}
			}
		}
		return teamIds;
	}

}
