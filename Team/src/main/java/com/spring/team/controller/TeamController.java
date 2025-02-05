package com.spring.team.controller;

import com.spring.team.config.Proxy;
import com.spring.team.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("team-players")
public class TeamController {

    @Autowired
    private Proxy proxy;

    @GetMapping("/team/{from}/player/{to}")
    public Team teamWithPlayer(@PathVariable String from, @PathVariable String to) {
        Map<String, String> urlAttribute = new HashMap<>();
        urlAttribute.put("from", from);
        urlAttribute.put("to", to);
        ResponseEntity<Team> teamResponseEntity = new RestTemplate().getForEntity(
                "http://localhost:8888/football-players/buy/{from}/player/{to}",
                Team.class,
                urlAttribute);
        Team teamResponse = teamResponseEntity.getBody();
//        Team team = new Team(teamResponse.getId(), teamResponse.getFrom(), teamResponse.getTo(), teamResponse.getMoneyTeam(), "NONE", "7");
        Team team = new Team(teamResponse.getId(), teamResponse.getFrom(), teamResponse.getTo(), teamResponse.getMoneyTeam(), "NONE", "7");
        team.setPort(teamResponse.getPort());
        return team;
    }

//    @GetMapping("/teamProxy/{from}/player/{to}")
//    public Team teamWithPlayerProxy(@PathVariable String from, @PathVariable String to) {
//        Team teamResponse = proxy.getFootballPlayer(from, to);
////        Team team = new Team(teamResponse.getId(), teamResponse.getFrom(), teamResponse.getTo(), teamResponse.getMoneyTeam(), "Hallo", "7");
////        Team team = new Team(teamResponse.getId(), teamResponse.getFrom(), teamResponse.getTo(), teamResponse.getMoneyTeam(), "Hallo", "7", teamResponse.getPort());
//        teamResponse.setNote("Ya");
//        teamResponse.setNumberTeam("30");
//        return teamResponse;
//    }

    @GetMapping("/teamProxy/{from}/player/{to}")
    public Team teamWithPlayerNew(@PathVariable String from,@PathVariable String to){
        Team teamResponse = proxy.getFootballPlayer(from,to);
        teamResponse.setNote("No");
        teamResponse.setNumberTeam("20");
        //Team team = new Team(teamResponse.getId(),teamResponse.getFrom(),teamResponse.getTo(),teamResponse.getMoneyTeam(),"NONE","50");
        return teamResponse;
    }
}
