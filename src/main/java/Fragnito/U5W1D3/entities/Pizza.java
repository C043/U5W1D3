package Fragnito.U5W1D3.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pizza extends Cibo{
    private List<Topping> toppingList;

    public Pizza(String nome, int kcal, double prezzo, List<Topping> toppingList) {
        super(nome, kcal, prezzo);
        this.toppingList = toppingList;
    }

    public void addTopping(Topping topping){
        this.toppingList.add(topping);
    }

    @Override
    public String toString() {
        return "Pizza: " +
                getNome() + " " +
                "Kcal: " + getKcal() + " " +
                "Prezzo " + getPrezzo() + "$";
    }
}

