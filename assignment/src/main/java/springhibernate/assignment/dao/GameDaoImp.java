package springhibernate.assignment.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springhibernate.assignment.entities.Game;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

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

    @Override
    public List<Game> findAll(int page, int size)
    {
        Session sess=entityManager.unwrap(Session.class);
        Query query=sess.createQuery("from Game");
        query.setFirstResult(page);
        query.setMaxResults(size);
        return query.getResultList();

    }

    @Override
    public List<Game> findBySort(String sort, String order, int start, int size)
    {
        Session sess=entityManager.unwrap(Session.class);
        Query query=sess.createQuery("from Game order by "+sort+" "+order);
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.getResultList();
    }
}
