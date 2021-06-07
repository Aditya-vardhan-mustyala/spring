package springhibernate.assignment.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springhibernate.assignment.entities.Game;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class GameDaoImp implements GameDao
{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Game> findAll()
    {
        Session sess=entityManager.unwrap(Session.class);
        return sess.createQuery("from Game order by  price").getResultList();
    }

    @Override
    public Game findById(int id)
    {
        Session sess=entityManager.unwrap(Session.class);
        return sess.get(Game.class,id);
    }

    @Override
    public void save(Game game)
    {
        Session sess=entityManager.unwrap(Session.class);
        sess.saveOrUpdate(game);
    }

    @Override
    public void deleteById(int id)
    {
        Session sess=entityManager.unwrap(Session.class);
        sess.createQuery("delete from Game where id="+id).executeUpdate();

    }
}
