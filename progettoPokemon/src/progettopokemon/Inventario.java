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
        this.n_acqua = 1;
        this.n_bacche = 1;
        this.n_revitalizzanti = 1;
        this.n_pozioni = 1;
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

    public boolean usaPozione() {
        if (n_pozioni > 0) {
            n_pozioni--;
            return true;
        }
        return false;
    }

    public boolean usaRevitalizzante() {
        if (n_revitalizzanti > 0) {
            n_revitalizzanti--;
            return true;
        }
        return false;
    }

    public int getN_acqua() {
        return n_acqua;
    }

    public int getN_bacche() {
        return n_bacche;
    }

    public int getN_pozioni() {
        return n_pozioni;
    }

    public int getN_revitalizzanti() {
        return n_revitalizzanti;
    }

    public void setN_acqua(int n_acqua) {
        this.n_acqua = n_acqua;
    }

    public void setN_bacche(int n_bacche) {
        this.n_bacche = n_bacche;
    }

    public void setN_pozioni(int n_pozioni) {
        this.n_pozioni = n_pozioni;
    }

    public void setN_revitalizzanti(int n_revitalizzanti) {
        this.n_revitalizzanti = n_revitalizzanti;
    }
}
