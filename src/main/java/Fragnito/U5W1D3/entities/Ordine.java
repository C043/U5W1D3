package Fragnito.U5W1D3.entities;

import Fragnito.U5W1D3.enums.StatoOrdine;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@ToString
public class Ordine {
    private Tavolo tavolo;
    private int numeroOrdine;
    private StatoOrdine statoOrdine;
    private List<Cibo> listaCibo;
    private int numeroCoperti;
    private int oraAcquisizione;
    private double totaleOrdine;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Ordine(Tavolo tavolo, int numeroOrdine, List<Cibo> listaCibo, int numeroCoperti, double coperto) {
        this.tavolo = tavolo;
        this.numeroOrdine = numeroOrdine;
        this.statoOrdine = StatoOrdine.IN_CORSO;
        this.listaCibo = listaCibo;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        this.totaleOrdine = calcoloTotaleOrdine(coperto);
    }

    public double calcoloTotaleOrdine(double coperto){
        return this.listaCibo
                .stream()
                .map(Cibo::getPrezzo)
                .reduce(0.00, Double::sum) + this.numeroCoperti * coperto;
    }

    public void printOrder(){
        System.out.println("--------------Ordine n. " + getNumeroOrdine() + "--------------");
        System.out.println("Tavolo: " + this.tavolo.getNumeroTavolo());
        System.out.println("Orario: " + getOraAcquisizione());
        listaCibo.forEach(System.out::println);
        System.out.println("Numero coperti: " + getNumeroCoperti());
        System.out.println("Totale ordine: " + df.format(getTotaleOrdine()) + "$");
    }
}
