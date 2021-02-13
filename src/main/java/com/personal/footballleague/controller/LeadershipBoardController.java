package com.personal.footballleague.controller;

import com.personal.footballleague.model.LeagueStanding;
import com.personal.footballleague.service.LeadershipBoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        value = "/v1",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@Api(
        value = "Leadership board service",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
@Validated
@Slf4j
public class LeadershipBoardController {
    @Autowired
    private LeadershipBoardService leadershipBoardService;

    @GetMapping(value = "/leadershipboard")
    @ApiOperation(value = "Get Leadership information request", response = LeagueStanding[].class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Successfull"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<List<LeagueStanding>> getLeaderShipInformation(@RequestParam("countryname") Optional<String> countryName,
                                                                        @RequestParam("leagueName") Optional<String> leagueName,
                                                                        @RequestParam("teamName") Optional<String> teamName)  {
        return ResponseEntity.ok().body(leadershipBoardService.getLeagueStandingByCountryAndLeagueAndTeam(countryName,leagueName,teamName));
    }
}
