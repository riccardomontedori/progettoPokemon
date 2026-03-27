/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettopokemon;

/**
 *
 * @author montedori.riccardo
 */
public class Froakie extends Pokemon {

    public Froakie() {
        super();
        this.nome = "Froakie";
    }

    @Override
    public void abilitaPassiva() {
        setSete(getSete() - 5);
        setFame(getFame() - 5);
    }

    @Override
    public int usaAbilita() {
        int totalePrecedente = getSete() + getFame();
        setSete(0);
        setFame(0);
        return totalePrecedente;
    }

    @Override
    public void eseguiEvoluzione() {
        if (this.stadio == 0) {
            this.nome = "Frogadier";
            this.stadio = 1;
        } else if (this.stadio == 1) {
            this.nome = "Greninja";
            this.stadio = 2;
        }

    
        int nuovaVita = getVita() + 10;
        if (nuovaVita > getVitaMax()) {
            nuovaVita = getVitaMax();
        }
        setVita(nuovaVita);
    }
}
