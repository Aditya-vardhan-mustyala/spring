package springhibernate.assignment.service;

import springhibernate.assignment.entities.Game;

import java.util.List;

public interface GameService
{
    public List<Game> findALL();
    public Game findById(int id);
    public void save(Game game);
    public void deleteById(int id);


}
