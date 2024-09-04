package Fragnito.U5W1D3;

import Fragnito.U5W1D3.entities.*;
import Fragnito.U5W1D3.enums.StatoTavolo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Bean(name = "tomato")
    public Topping tomato(){
        return new Topping("Tomato", 50, 1);
    }
    @Bean(name = "cheese")
    public Topping cheese(){
        return new Topping("Cheese", 50, 0.69);
    }
    @Bean(name = "ham")
    public Topping ham(){
        return new Topping("Ham", 120, 0.99);
    }
    @Bean(name = "pineapple")
    public Topping pineapple(){
        return new Topping("Pineapple", 24, 0.79);
    }
    @Bean(name = "salami")
    public Topping salami(){
        return new Topping("Salami", 86, 0.99);
    }
    @Bean(name = "pizza_margherita")
    public Pizza pizzaMargherita(){
        List<Topping> margheritaToppings = new ArrayList<>();
        margheritaToppings.add(tomato());
        margheritaToppings.add(cheese());
        return new Pizza("Pizza Margherita (tomato, cheese)", 1104, 4.99, margheritaToppings);
    }
    @Bean(name = "hawaiian_pizza")
    public Pizza hawaiianPizza(){
        List<Topping> hawaiianPizzaToppings = new ArrayList<>();
        hawaiianPizzaToppings.add(tomato());
        hawaiianPizzaToppings.add(cheese());
        hawaiianPizzaToppings.add(ham());
        hawaiianPizzaToppings.add(pineapple());
        return new Pizza("Hawaiian Pizza (tomato, cheese, ham, pineapple)", 1024, 6.49, hawaiianPizzaToppings);
    }
    @Bean(name = "salami_pizza")
    public Pizza salamiPizza(){
        List<Topping> salamiPizzaToppings = new ArrayList<>();
        salamiPizzaToppings.add(tomato());
        salamiPizzaToppings.add(cheese());
        salamiPizzaToppings.add(salami());
        return new Pizza("Salami Pizza (tomato, cheese, salami)", 1160, 5.99, salamiPizzaToppings);
    }
    @Bean(name = "acqua")
    public Bevanda acqua(){
        return new Bevanda("Water", 0, 1.29, 0.5);
    }
    @Bean(name = "birra")
    public Bevanda birra(){
        return new Bevanda("Beer", 355, 5, 0.55);
    }
    @Bean(name = "vino")
    public Bevanda vino(){
        return new Bevanda("Wine", 607, 7.49, 0.75);
    }
    @Bean
    public Menu menu(){
        List<Pizza> pizzaList = new ArrayList<>();
        List<Topping> toppingList = new ArrayList<>();
        List<Bevanda> bevandaList = new ArrayList<>();

        pizzaList.add(pizzaMargherita());
        pizzaList.add(hawaiianPizza());
        pizzaList.add(salamiPizza());

        toppingList.add(tomato());
        toppingList.add(cheese());
        toppingList.add(ham());
        toppingList.add(pineapple());
        toppingList.add(salami());

        bevandaList.add(acqua());
        bevandaList.add(birra());
        bevandaList.add(vino());

        return new Menu(pizzaList, toppingList, bevandaList);
    }
    @Bean(name = "tavolo1")
    public Tavolo tavolo1(){
        return new Tavolo(1, 4, StatoTavolo.LIBERO);
    }
    @Bean
    public Tavolo tavolo2(){
        return new Tavolo(2, 2, StatoTavolo.LIBERO);
    }
    @Bean(name = "tavolo3")
    public Tavolo tavolo3(){
        return new Tavolo(3, 6, StatoTavolo.OCCUPATO);
    }
    @Bean(name = "coperto")
    public double coperto(@Value("${ordine.coperto}") String coperto){
        return Double.parseDouble(coperto);
    }
}

