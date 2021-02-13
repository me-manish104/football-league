package com.personal.footballleague.mappings;

import com.personal.footballleague.dto.LeagueStandingDto;
import com.personal.footballleague.model.LeagueStanding;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public  interface LeagueStandpingMapper {
    LeagueStanding toLeagueStanding(LeagueStandingDto leagueStandingDto);
}
