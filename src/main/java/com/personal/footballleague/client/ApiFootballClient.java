package com.personal.footballleague.client;

import com.personal.footballleague.dto.LeagueStandingDto;
import com.personal.footballleague.model.LeagueStanding;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class ApiFootballClient {
    @Autowired
    RestTemplate restTemplate;

    public List<LeagueStandingDto> getLeaguesStanding() {
        URI targetURI = UriComponentsBuilder.fromUriString("https://apiv2.apifootball.com/?action=get_standings&league_id=148&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978")
                .build()
                .encode()
                .toUri();
        log.info("Sending request to Football API");
        LeagueStandingDto[] leagueStandings = restTemplate.getForObject(targetURI,LeagueStandingDto[].class);
       return leagueStandings!=null?Arrays.asList(leagueStandings):Collections.emptyList();
    }
}
