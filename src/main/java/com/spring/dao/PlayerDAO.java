package com.spring.dao;

import com.spring.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerDAO extends JpaRepository<Player,Integer> {
//	public List<Player> getAllPlayers();
//	public void addPlayer(Player player);
//	public Player getPlayer(int id);
//	public int deletePlayer(int id);
}
