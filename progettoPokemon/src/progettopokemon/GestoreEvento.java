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
        switch (e) {
            case TROVA_OGGETTO:
                i.setN_bacche(i.getN_bacche() + 1);
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
