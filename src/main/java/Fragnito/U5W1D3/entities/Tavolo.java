package Fragnito.U5W1D3.entities;

import Fragnito.U5W1D3.enums.StatoTavolo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Tavolo {
    private int numeroTavolo;
    private int massimoCoperti;
    private StatoTavolo statoTavolo;
}
