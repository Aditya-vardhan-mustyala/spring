package springhibernate.assignment.service.serviceImplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springhibernate.assignment.dao.GameDao;
import springhibernate.assignment.entities.Game;
import springhibernate.assignment.service.serviceInterfaces.GameService;

import java.util.List;

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

    @Override
    public List<Game> findALL(int page, int size) {
        return gameDao.findAll(page,size);
    }

    @Override
    public List<Game> findBySort(String sort, String order, int start, int size) {
        return gameDao.findBySort(sort,order,start,size);
    }
}
