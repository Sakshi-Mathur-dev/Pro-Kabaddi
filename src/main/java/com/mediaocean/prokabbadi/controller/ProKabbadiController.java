package com.mediaocean.prokabbadi.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediaocean.prokabbadi.entity.Match;
import com.mediaocean.prokabbadi.entity.Team;
import com.mediaocean.prokabbadi.service.IProkabbadiService;


@RestController
@RequestMapping("/prokabaddi")
public class ProKabbadiController {

	@Autowired
	private IProkabbadiService proKabaddiService;
	
	//schedule for the PRO-Kabaddi event
	
	@GetMapping("/matches")
	
	public ResponseEntity<List<Match>> getMatchesScheduled(@PathVariable Optional<String> startDate) {
		
		
		List<Match> matches = proKabaddiService.getMatchesScheduled();
		
		return new ResponseEntity<List<Match>>(matches, new HttpHeaders(), HttpStatus.OK);
		
	}
	
}
