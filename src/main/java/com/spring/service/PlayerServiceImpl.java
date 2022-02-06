package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import com.spring.dao.PlayerDAO;
import com.spring.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {


	private PlayerDAO playerDAO;

	@Autowired
	public PlayerServiceImpl(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}

	@Override
	public List<Player> AllPlayers() {
		System.out.println("PlayerServiceImpl");
		return playerDAO.getAllPlayers();
	}

	@Override
	public void savePlayer(Player player) {
		playerDAO.addPlayer(player);
	}

	@Override
	public Player getPlayer(int id) {
		return playerDAO.getPlayer(id);
	}

	@Override
	public int deletePlayer(int id) {
		return playerDAO.deletePlayer(id);
	}


}
