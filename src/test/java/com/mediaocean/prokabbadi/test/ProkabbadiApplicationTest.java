package com.mediaocean.prokabbadi.test;

import java.io.IOException;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.mediaocean.prokabbadi.entity.Match;
import com.mediaocean.prokabbadi.service.impl.ProKabbadiServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProkabbadiApplicationTest {

	@Mock
	private ProKabbadiServiceImpl proKabbadiServiceImpl;
	
	@Mock
	private List<Match> matchlist;
	
	 @BeforeEach
     public void beforeEachTest() throws IOException {
         MockitoAnnotations.initMocks(this); 
     }
	
	@Test
	public void generateScheduleMatches() {
		
		matchlist = proKabbadiServiceImpl.getMatchesScheduled();
		org.junit.Assert.assertNotEquals(matchlist, null);
		
		
	}
}
