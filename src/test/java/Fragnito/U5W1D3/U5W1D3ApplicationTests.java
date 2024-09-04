package Fragnito.U5W1D3;

import Fragnito.U5W1D3.entities.*;
import Fragnito.U5W1D3.enums.StatoTavolo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U5W1D3ApplicationTests {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	void checkPizzaPrices(){
		Pizza pizzaMargherita = (Pizza) context.getBean("pizza_margherita");
		Pizza salamiPizza = (Pizza) context.getBean("salami_pizza");
		Pizza hawaiianPizza = (Pizza) context.getBean("hawaiian_pizza");
		assertEquals(4.99, pizzaMargherita.getPrezzo());
		assertEquals(5.99, salamiPizza.getPrezzo());
		assertEquals(6.49, hawaiianPizza.getPrezzo());
	}

	private static Stream<Arguments> orderGen(){
		return Stream.of(
				Arguments.of(new Ordine(new Tavolo(1, 2, StatoTavolo.LIBERO), 1, List.of(new Pizza("1", 100, 10, new ArrayList<>()), new Bevanda("4", 20, 5, 0.50)), 2, 2.00), 19.00),
				Arguments.of(new Ordine(new Tavolo(1, 2, StatoTavolo.LIBERO), 1, List.of(new Pizza("2", 100, 20, new ArrayList<>()), new Topping("test", 500, 0.50)), 2, 2.00), 24.50),
				Arguments.of(new Ordine(new Tavolo(1, 2, StatoTavolo.LIBERO), 1, List.of(new Pizza("3", 100, 50, new ArrayList<>()), new Bevanda("test", 20, 10, 0.80), new Topping("test", 300, 5)), 4, 2.00), 73.00)
		);
	}

	@ParameterizedTest
	@MethodSource("orderGen")
	void checkOrderTotal(Ordine ordine, double totalExpected){
		assertEquals(totalExpected, ordine.getTotaleOrdine());
	}
}
