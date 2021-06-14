package springhibernate.assignment.dto;

import org.springframework.stereotype.Component;
import springhibernate.assignment.entities.Game;

@Component
public class DtoConvertor
{
    public Game dtoToEntity(GameDto dto)
    {
        var game=new Game();
        game.setId(dto.getId());
        game.setDescription(dto.getDescription());
        game.setName(dto.getName());
        game.setPrice(dto.getPrice());
        return game;

    }

    public GameDto entityToDto(Game game)
    {
        var dto=new GameDto();
        dto.setId(game.getId());
        dto.setDescription(game.getDescription());
        dto.setName(game.getName());
        dto.setPrice(game.getPrice());
        return dto;
    }
}
