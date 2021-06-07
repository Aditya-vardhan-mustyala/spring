package springhibernate.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springhibernate.assignment.dao.GameDao;
import springhibernate.assignment.entities.Game;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImp implements GameService
{
    @Autowired
    private GameDao gameDao;

    @Override
    @Transactional
    public List<Game> findALL()
    {
        return gameDao.findAll();
    }

    @Override
    @Transactional
    public Game findById(int id)
    {
        return gameDao.findById(id);
        
    }

    @Override
    @Transactional
    public void save(Game game)
    {
        gameDao.save(game);
    }

    @Override
    @Transactional
    public void deleteById(int id)
    {
        gameDao.deleteById(id);
    }
}
