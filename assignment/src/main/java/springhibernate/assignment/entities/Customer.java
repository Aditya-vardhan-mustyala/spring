package springhibernate.assignment.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Getter @Setter @RequiredArgsConstructor @ToString
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private int enabled;

    @ManyToMany(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="user_game",
            joinColumns=@JoinColumn(name="username"),
            inverseJoinColumns =@JoinColumn(name="id"))
    private List<Game> games;


    public void add(Game game)
    {
        if(games==null)
            games=new ArrayList<>();
        games.add(game);
    }

    public void remove(Game game)
    {
        games.remove(game);
    }




}
