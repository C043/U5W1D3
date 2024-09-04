package Fragnito.U5W1D3.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Menu {
    private List<Pizza> pizzaList;
    private List<Topping> toppingList;
    private List<Bevanda> bevandaList;

    public Menu(List<Pizza> pizzaList, List<Topping> toppingList, List<Bevanda> bevandaList) {
        this.pizzaList = pizzaList;
        this.toppingList = toppingList;
        this.bevandaList = bevandaList;
    }

    public void printMenu(){
        System.out.println("------------------Pizzas-----------------");
        pizzaList.forEach(pizza -> System.out.println(pizza.getNome() + " KCAL: " + pizza.getKcal() + " Price: " + pizza.getPrezzo()));
        System.out.println("------------------Toppings---------------");
        toppingList.forEach(topping -> System.out.println(topping.getNome() + " KCAL: " + topping.getKcal() + " Price: " + topping.getPrezzo()));
        System.out.println("------------------Drinks-----------------");
        bevandaList.forEach(bevanda -> System.out.println(bevanda.getNome() + " " + bevanda.getLitri() + "l KCAL: " + bevanda.getKcal() + " Price: " + bevanda.getPrezzo()));
    }
}
