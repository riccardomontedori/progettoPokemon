/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettopokemon;

/**
 *
 * @author montedori.riccardo
 */
public class Chimchar extends Pokemon {
    private boolean scudoFiammeggiante = false;

    public Chimchar() {
        super();
        this.nome = "Chimchar";
    }

    @Override
    public void abilitaPassiva() {
       
    }

    @Override
    public int usaAbilita() {
        this.scudoFiammeggiante = true;
        return 1;
    }
    
    public boolean isScudoAttivo() {
        return scudoFiammeggiante;
    }

    @Override
    public void eseguiEvoluzione() {
        if (this.stadio == 0) {
            this.nome = "Monferno";
            this.stadio = 1;
        } else if (this.stadio == 1) {
            this.nome = "Infernape";
            this.stadio = 2;
        }

        int nuovaVita = getVita() + 10;
        if (nuovaVita > getVitaMax()) {
            nuovaVita = getVitaMax();
        }
        setVita(nuovaVita);
    }
}

