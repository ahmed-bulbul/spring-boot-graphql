package com.basketball.producter.resolver;


import com.basketball.producter.entity.Player;
import com.basketball.producter.entity.Position;
import com.basketball.producter.repopsitory.PlayerRepository;
import com.basketball.producter.repopsitory.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;


@Component
public class MutationResolver implements GraphQLMutationResolver {


    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PositionRepository positionRepository;


    // add player
    public Player addPlayer(String name, String surname, Integer position_id) {

        Position position = positionRepository.findById(position_id).orElseGet(null);

        Player player = new Player();
        player.setName(name);
        player.setSurname(surname);
        player.setPosition(position);
        return playerRepository.saveAndFlush(player);

    }

    //add position
    public Position addPosition(String pointGuard,String shootingGuard, String smallForward, String powerForward, String center){
        Position position = new Position();
        position.setPointGuard(pointGuard);
        position.setShootingGuard(shootingGuard);
        position.setSmallForward(smallForward);
        position.setPowerForward(powerForward);
        position.setCenter(center);
        return positionRepository.saveAndFlush(position);
    }


    public Boolean deletePlayer(Integer id) {
        try {
            Player player = playerRepository.findById(id).orElseGet(null);
            if (player != null) {
                playerRepository.delete(player);
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }


}