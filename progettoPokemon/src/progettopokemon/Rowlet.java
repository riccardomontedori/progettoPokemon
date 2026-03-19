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
}
