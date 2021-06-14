package springhibernate.assignment.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="games")
@Getter @Setter @RequiredArgsConstructor
public class Game
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;


     @Column(name="price")
    private int price;

    @ManyToMany(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="user_game",
                joinColumns=@JoinColumn(name="id"),
                inverseJoinColumns =@JoinColumn(name="username"))
    private List<Customer> customers;

    public void add(Customer customer)
    {
        if(customers ==null)
            customers =new ArrayList<>();
        customers.add(customer);

    }
}
