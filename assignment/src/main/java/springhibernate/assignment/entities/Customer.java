package springhibernate.assignment.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
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

    public Customer(){}

    public Customer(String userName, String password, int enabled) {
        this.username = userName;
        this.password = password;
        this.enabled = enabled;
    }

    public Customer(String userName, String password, int enabled, List<Game> games) {
        this.username = userName;
        this.password = password;
        this.enabled = enabled;
        this.games = games;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", games=" + games +
                '}';
    }


}
