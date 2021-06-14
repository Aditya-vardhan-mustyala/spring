package springhibernate.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springhibernate.assignment.dto.GameDto;
import springhibernate.assignment.dto.DtoConvertor;
import springhibernate.assignment.entities.Game;
import springhibernate.assignment.entities.Customer;
import springhibernate.assignment.service.serviceInterfaces.GameService;
import springhibernate.assignment.service.serviceInterfaces.CustomerService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class GameController
{
    @Autowired
    private GameService gameService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DtoConvertor gameDto;

    private Customer customer;


    private void getCustomer()
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var username="none";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        }

        customer = customerService.findById(username);
    }

    @RequestMapping("/")
    public String home()
    {
        return "index";
    }

    @RequestMapping("/customLogin")
    public String login()
    {
        return "fancy-login";
    }

    @RequestMapping("/products")
    public String getall(Model model)
    {
        return "redirect:/products?page=0&sort&order";

    }

//    @RequestMapping(value="/products",params = {"page"})
//    public String getPagination(@RequestParam("page") int page,Model model)
//    {
//        int size=5;
//        int start=page*size;
//        List<Game> games=gameService.findALL(start,size);
//
//        model.addAttribute("allgames",games);
//        model.addAttribute("size",games.size());
//        model.addAttribute("page",page);
//        return "list-products";
//    }

    @RequestMapping(value="/products",params = {"page","sort","order"})
    public String getallsort(@RequestParam("page") int page,@RequestParam("sort") String sort,@RequestParam("order") String order, Model model)
    {
        int size=5;
        int start=page*size;
        List<Game> games;

        if(sort.equals("")) {
            games=gameService.findALL(start,size);
        }
        else{

            games = gameService.findBySort(sort, order,start,size);
        }

        model.addAttribute("allgames",games);
        model.addAttribute("size",games.size());
        model.addAttribute("page",page);
        model.addAttribute("sort",sort);
        model.addAttribute("order",order);
        return "list-products";

    }


    @RequestMapping("/accessDenied")
    public String accessDenied() {
        return "redirect:/";
    }

    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {


        var gam = new Game();


        model.addAttribute("game", gameDto.entityToDto(gam));

        return "form";
    }

    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("gameId") int id, Model model)
    {

       var game=gameService.findById(id);
       model.addAttribute("game",gameDto.entityToDto((game)));
       return "form";
    }

    @PostMapping("/saveGame")
    public String save(@Valid @ModelAttribute("game") GameDto dto, BindingResult result) {


        var game=gameDto.dtoToEntity(dto);
        // save the customer using our service
        if(result.hasErrors())
            return "form";

        gameService.save(game);
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("gameId") int id) {

        // save the customer using our service
        gameService.deleteById(id);

        return "redirect:/products";
    }
    @GetMapping("/addtocart")
    public String addtocart(@RequestParam("gameId") int id, Model model)
    {
        var game=gameService.findById(id);
        getCustomer();

        List<Game> allgames=customer.getGames();

        var flag=1;
        for(Game thegame : allgames)
           if(thegame.getId()==game.getId())
           {
               flag=0;
               break;
           }


        if(flag==1) {
            customer.add(game);
            customerService.save(customer);
        }
        return "redirect:/cart";

    }

    @GetMapping("/deletefromcart")
    public String delettocart(@RequestParam("gameId") int id, Model model)
    {
        var game=gameService.findById(id);
        getCustomer();


        customer.remove(game);

        customerService.save(customer);

        return "redirect:/cart";

    }
    @RequestMapping("/cart")
    public String showcart(Model model)
    {
        getCustomer();

        model.addAttribute("games", customer.getGames());
        return "cart";
    }



}
