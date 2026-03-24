/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettopokemon;

/**
 *
 * @author montedori.riccardo
 */
import java.util.Random;
import java.util.ArrayList;

public class GestoreEvento {

    private ArrayList<Evento> eventi;
    private Random r;
    private String ultimoOggettoTrovato = "";

    public GestoreEvento() {
        this.r = new Random();
        this.eventi = new ArrayList<>();
        for (Evento e : Evento.values()) {
            eventi.add(e);
        }
    }

    public String getUltimoOggettoTrovato() {
        return ultimoOggettoTrovato;
    }

    public Evento GeneraEventoCasuale(Pokemon p) {
        int probabilita = r.nextInt(100);

        if (p instanceof Rowlet) {
            if (probabilita < 60) {
                return Evento.TROVA_OGGETTO;
            } else if (probabilita < 80) {
                return Evento.TEAM_ROCKET;
            } else {
                return Evento.POKEMON_SELVATICO;
            }
        } else {
            if (probabilita < 40) {
                return Evento.TROVA_OGGETTO;
            } else if (probabilita < 70) {
                return Evento.TEAM_ROCKET;
            } else {
                return Evento.POKEMON_SELVATICO;
            }
        }
    }

    public void ApplicaEvento(Evento e, Pokemon p, Inventario i) {
    Random randomOggetto = new Random();
    switch (e) {
        case TROVA_OGGETTO:
            int scelta = randomOggetto.nextInt(4);
            if (scelta == 0) {
                i.setN_acqua(i.getN_acqua() + 1);
                ultimoOggettoTrovato = "acqua";
            } else if (scelta == 1) {
                i.setN_bacche(i.getN_bacche() + 1);
                ultimoOggettoTrovato = "bacca";
            } else if (scelta == 2) {
                i.setN_pozioni(i.getN_pozioni() + 1);
                ultimoOggettoTrovato = "pozione";
            } else {
                i.setN_revitalizzanti(i.getN_revitalizzanti() + 1);
                ultimoOggettoTrovato = "revitalizzante";
            }
            break;

        case TEAM_ROCKET:
            ultimoOggettoTrovato = "team_rocket";
            if (p instanceof Chimchar) {
                int danno = ((Chimchar) p).isScudoAttivo() ? 5 : 10;
                p.setVita(p.getVita() - danno);
            } else {
                p.setVita(p.getVita() - 15);
            }
            break;

        case POKEMON_SELVATICO:
            ultimoOggettoTrovato = "selvatico";
            if (p instanceof Chimchar) {
                int danno = ((Chimchar) p).isScudoAttivo() ? 2 : 5;
                p.setVita(p.getVita() - danno);
            } else {
                p.setVita(p.getVita() - 10);
            }
            break;
    }
    p.PokemonMorto();
}
}
