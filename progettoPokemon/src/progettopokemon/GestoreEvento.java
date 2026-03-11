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

    public GestoreEvento() {
        this.r = new Random();
        this.eventi = new ArrayList<>();
        for (Evento e : Evento.values()) {
            eventi.add(e);
        }
    }

    public Evento GeneraEventoCasuale() {
        int indice = r.nextInt(eventi.size());
        return eventi.get(indice);
    }

    public void ApplicaEvento(Evento e, Pokemon p, Inventario i) {
        Random randomOggetto = new Random();
        switch (e) {
            case TROVA_OGGETTO:
                int scelta = randomOggetto.nextInt(4);

                if (scelta == 0) {
                    i.setN_acqua(i.getN_acqua() + 1);
                } else if (scelta == 1) {
                    i.setN_bacche(i.getN_bacche() + 1);
                } else if (scelta == 2) {
                    i.setN_pozioni(i.getN_pozioni() + 1);
                } else {
                    i.setN_revitalizzanti(i.getN_revitalizzanti() + 1);
                }
                break;
            case TEAM_ROCKET:
                p.setVita(p.getVita() - 15);
                break;

            case POKEMON_SELVATICO:
                p.setVita(p.getVita() - 5);
                break;
        }
        p.PokemonMorto();
    }
}
