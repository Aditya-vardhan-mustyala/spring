package springhibernate.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springhibernate.assignment.entities.Game;

import java.util.List;
import java.util.Optional;


public interface GameDao 
{

    List<Game> findAll();

    Game findById(int id);

    void save(Game game);

    void deleteById(int id);
}
