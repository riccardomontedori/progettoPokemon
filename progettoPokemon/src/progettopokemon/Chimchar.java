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
    private int turniImmune = 0;

    public Chimchar() {
        super(100);
    }

    @Override
    public void abilitaPassiva() {
        if (turniImmune > 0) {
            setFame(getFame() - 5);
            setSete(getSete() - 5);
            turniImmune--;
        }
    }

    @Override
    public int usaAbilita() {
        turniImmune = 2;
        return turniImmune;
    }

    public int getTurniImmune() {
        return turniImmune;
    }
}

