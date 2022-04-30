package com.basketball.producter.resolver;

import java.util.List;

import com.basketball.producter.entity.Player;
import com.basketball.producter.repopsitory.PlayerRepository;
import com.basketball.producter.repopsitory.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;


@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PositionRepository positionRepository;



    // list of all players
    public List<Player> allPlayers() {
        List<Player> players = playerRepository.findAll();
        if (players.size() > 0) {
            return players;
        }
        return null;
    }



}