package springhibernate.assignment.dao;

import springhibernate.assignment.entities.Game;

import java.util.List;


public interface GameDao 
{

    List<Game> findAll();

    Game findById(int id);

    void save(Game game);

    void deleteById(int id);

    List<Game> findAll(int page, int size);

    List<Game> findBySort(String sort, String order, int start, int size);
}
