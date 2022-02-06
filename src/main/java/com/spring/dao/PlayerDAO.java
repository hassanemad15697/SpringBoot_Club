package com.spring.dao;

import com.spring.model.Player;

import java.util.List;

public interface PlayerDAO {
	public List<Player> getAllPlayers();
	public void addPlayer(Player player);
	public Player getPlayer(int id);
	public int deletePlayer(int id);
}
