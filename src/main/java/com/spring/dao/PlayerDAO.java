package com.spring.dao;

import com.spring.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDAO extends JpaRepository<Player,Integer> {
    /*
    http://localhost:8080/players
     */
}
