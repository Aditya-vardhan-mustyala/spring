package springhibernate.assignment.service.serviceInterfaces;

import springhibernate.assignment.entities.Game;

import java.util.List;

public interface GameService
{
    public List<Game> findALL();
    public Game findById(int id);
    public void save(Game game);
    public void deleteById(int id);


    List<Game> findALL(int page, int size);

    List<Game> findBySort(String sort, String order, int start, int size);
}
