package com.basketball.producter.repopsitory;


import com.basketball.producter.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
