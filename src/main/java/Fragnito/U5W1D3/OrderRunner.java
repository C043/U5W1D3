package Fragnito.U5W1D3;

import Fragnito.U5W1D3.entities.Cibo;
import Fragnito.U5W1D3.entities.Menu;
import Fragnito.U5W1D3.entities.Ordine;
import Fragnito.U5W1D3.entities.Tavolo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Menu menu = context.getBean(Menu.class);
        menu.printMenu();

            List<Cibo> ciboList = new ArrayList<>();
            ciboList.add((Cibo) context.getBean("pizza_margherita"));
            ciboList.add((Cibo) context.getBean("salami_pizza"));
            ciboList.add((Cibo) context.getBean("cheese"));
            ciboList.add((Cibo) context.getBean("birra"));
            ciboList.add((Cibo) context.getBean("vino"));
            Ordine ordine = new Ordine((Tavolo) context.getBean("tavolo2"), 1, ciboList, 2, (double)context.getBean("coperto"));
            ordine.printOrder();

        context.close();
    }
}
