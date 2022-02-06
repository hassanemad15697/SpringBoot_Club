package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.model.Player;

import javax.persistence.EntityManager;


@Repository
public class PlayerDaoImpl implements PlayerDAO {

	private EntityManager entityManager ;
	@Autowired
	public PlayerDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Player> getAllPlayers() {
		Session session = entityManager.unwrap(Session.class);
		Query<Player> query= session.createQuery("from Player",Player.class);
		return query.getResultList();
	}

	@Override
	public void addPlayer(Player player) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(player);
		
	}

	@Override
	public Player getPlayer(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Player.class, id);
	}

	@Override
	public int deletePlayer(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query q = session.createQuery("delete from Player where id=?1");
		q.setInteger(1, id);

		return q.executeUpdate();
	}
	
}