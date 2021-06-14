package springhibernate.assignment.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class GameDto
{
    private int id;

    @Size(min = 3,message = "name should have minimum 3 characters")
    private String name;
    private String description;

    @Min(value = 0,message = "price should be a positive value")
    private int price;
}
