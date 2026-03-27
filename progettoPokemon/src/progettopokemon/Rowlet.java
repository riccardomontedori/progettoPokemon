/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettopokemon;

/**
 *
 * @author montedori.riccardo
 */
public class Rowlet extends Pokemon {

    public Rowlet() {
        super();
        this.nome = "Rowlet";
    }

    @Override
    public void abilitaPassiva() {
        
    }

    @Override
    public int usaAbilita() {
        setVita(getVita() + 15);
        if (getVita() > getVitaMax()) {
            setVita(getVitaMax());
        }
        return getVita();
    }

    @Override
    public void eseguiEvoluzione() {
        if (this.stadio == 0) {
            this.nome = "Dartrix";
            this.stadio = 1;
        } else if (this.stadio == 1) {
            this.nome = "Decidueye";
            this.stadio = 2;
        }
        int nuovaVita = getVita() + 10;
        if (nuovaVita > getVitaMax()) {
            nuovaVita = getVitaMax();
        }
        setVita(nuovaVita);
    }
}
