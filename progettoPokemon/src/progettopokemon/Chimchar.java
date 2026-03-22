/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettopokemon;

/**
 *
 * @author montedori.riccardo
 */
public class Chimchar extends Pokemon{
    private boolean scudoFiammeggiante = false;

    public Chimchar() {
        
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
}

