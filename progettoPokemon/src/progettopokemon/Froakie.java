/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettopokemon;

/**
 *
 * @author montedori.riccardo
 */
public class Froakie extends Pokemon{
    
    public Froakie() {
        super(35);
    }

    @Override
    public void abilitaPassiva() {
        setSete(getSete() - 5);
    }
    
    @Override
    public int usaAbilita() {
    int totalePrecedente = getSete() + getFame();
    setSete(0);
    setFame(0);
    return totalePrecedente; 
}
}
