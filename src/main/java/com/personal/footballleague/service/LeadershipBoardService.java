package com.personal.footballleague.service;

import com.personal.footballleague.client.ApiFootballClient;
import com.personal.footballleague.dto.LeagueStandingDto;
import com.personal.footballleague.mappings.LeagueStandpingMapper;
import com.personal.footballleague.model.LeagueStanding;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeadershipBoardService {
    @Autowired
    private ApiFootballClient apiFootballClient;
    @Autowired
    private LeagueStandpingMapper mapper;

    public List<LeagueStanding> getLeagueStandingByCountryAndLeagueAndTeam(Optional<String> countryName, Optional<String> leaugeName, Optional<String> teamName) {
        List<LeagueStandingDto> leagueStandings = apiFootballClient.getLeaguesStanding();
        return leagueStandings.stream()
                .filter(l->!countryName.isPresent() || countryName.get().equalsIgnoreCase(l.getCountryName()))
                .filter(l->!leaugeName.isPresent() || leaugeName.get().equalsIgnoreCase(l.getLeagueName()))
                .filter(l->!teamName.isPresent() || teamName.get().equalsIgnoreCase(l.getTeamName())).map(mapper::toLeagueStanding)
                .collect(Collectors.toList());
    }
}
