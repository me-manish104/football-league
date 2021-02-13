package com.personal.footballleague;

import com.personal.footballleague.controller.LeadershipBoardController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FootballLeagueApplicationTests {
	@Autowired
	private LeadershipBoardController controller;

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

	@Test
	void testApiCall() {
		assertEquals(controller.getLeaderShipInformation(Optional.empty(),Optional.empty(),Optional.empty()).getStatusCode(), HttpStatus.OK);
	}

	@Test
	void testApiCallWithCountry() {
		assertEquals(controller.getLeaderShipInformation(Optional.of("England"),Optional.empty(),Optional.empty()).getStatusCode(),HttpStatus.OK);
	}
	@Test
	void testApiCallWithLeague() {
		assertEquals(controller.getLeaderShipInformation(Optional.empty(),Optional.of("Premier League"),Optional.empty()).getStatusCode(),HttpStatus.OK);
	}

	@Test
	void testApiCallWithTeam() {
		assertEquals(controller.getLeaderShipInformation(Optional.empty(),Optional.empty(),Optional.of("Leicester")).getStatusCode(),HttpStatus.OK);
	}

	@Test
	void testApiCallWithAll() {
		assertEquals(controller.getLeaderShipInformation(Optional.of("England"),Optional.of("Premier League"),Optional.of("Leicester")).getStatusCode(),HttpStatus.OK);
	}

}
