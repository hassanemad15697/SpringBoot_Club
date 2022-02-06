package com.spring.service;

import com.spring.model.Player;

import java.util.List;

public interface PlayerService {

	public List<Player> AllPlayers();
	public void savePlayer(Player player);
	public Player getPlayer(int id);
	public void deletePlayer(int id);
}
