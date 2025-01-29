package com.spring.playersstatistics.controller;

import com.spring.playersstatistics.config.PlayersStatisticsConfiguration;
import com.spring.playersstatistics.model.PlayersStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players-management")
public class PlayersStatisticsController {

    @Autowired
    private PlayersStatisticsConfiguration playersStatisticsConfiguration;

    @GetMapping("/statistics")
    public PlayersStatistics getPlayersStatistics() {
        return new PlayersStatistics(playersStatisticsConfiguration.getNumberTeams(),
                playersStatisticsConfiguration.getNumberPlayers(),
                playersStatisticsConfiguration.getCountry());
    }
}
