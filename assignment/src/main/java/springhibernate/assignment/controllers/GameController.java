package springhibernate.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springhibernate.assignment.entities.Game;
import springhibernate.assignment.entities.Customer;
import springhibernate.assignment.service.GameService;
import springhibernate.assignment.service.CustomerService;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class GameController
{
    @Autowired
    private GameService gameService;

    @Autowired
    private CustomerService customerService;

    private Customer customer;


    private void getCustomer()
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username="none";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        }
        System.out.println(username);
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
        List<Game> games=gameService.findALL();

        model.addAttribute("allgames",games);
        return "list-products";
    }
    @RequestMapping("/accessDenied")
    public String accessDenied() {
        return "redirect:/";
    }

    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // create model attribute to bind form data
        Game gam = new Game();

        model.addAttribute("game", gam);

        return "form";
    }

    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("gameId") int id, Model model)
    {

       Game game=gameService.findById(id);
       model.addAttribute("game",game);
       return "form";
    }

    @PostMapping("/saveGame")
    public String save(@ModelAttribute("game") Game game) {

        // save the customer using our service
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
        Game game=gameService.findById(id);
        getCustomer();

        List<Game> allgames=customer.getGames();
        System.out.println(allgames);
        for(Game thegame : allgames)
           if(thegame.getId()==game.getId())
               return "redirect:/cart";

        customer.add(game);
        customerService.save(customer);

        return "redirect:/cart";

    }

    @GetMapping("/deletefromcart")
    public String delettocart(@RequestParam("gameId") int id, Model model)
    {
        Game game=gameService.findById(id);
        getCustomer();


        customer.remove(game);
       // System.out.println(game+"b"+game.getCustomers());
        customerService.save(customer);
        //gameService.save(game);
        //System.out.println(game+"e"+game.getCustomers());
        return "redirect:/cart";

    }
    @RequestMapping("/cart")
    public String showcart(Model model)
    {
        getCustomer();
//        List<Game> allgames=gameService.findALL();
//
//        for(Game thegame : allgames)
//            System.out.println(thegame.getCustomers());
        model.addAttribute("games", customer.getGames());
        return "cart";
    }

//    @GetMapping("/cart")
//    public String cart(Model model)
//    {
//        return "showcart";
//    }


}
