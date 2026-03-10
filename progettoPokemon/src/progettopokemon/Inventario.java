/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettopokemon;

/**
 *
 * @author montedori.riccardo
 */
public class Inventario {
    
    private int n_pozioni;
    private int n_revitalizzanti;
    private int n_bacche;
    private int n_acqua;
    
    public Inventario() {     
        this.n_acqua = 0;
        this.n_bacche = 0;
        this.n_revitalizzanti = 0;
        this.n_pozioni = 0;
    }
    
    public boolean usaAcqua() {
        if (n_acqua > 0) {
            n_acqua--;
            return true;
        }
        return false;
    }

    public boolean usaBacca() {
        if (n_bacche > 0) {
            n_bacche--;
            return true;
        }
        return false;
    }
    
    public boolean usaPozione(){
        if(n_pozioni > 0){
            n_pozioni--;
            return true;
        }
        return false;
    }
}
