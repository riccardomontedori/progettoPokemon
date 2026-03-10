/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettopokemon;

/**
 *
 * @author montedori.riccardo
 */
public abstract class Pokemon {
    
    private boolean vivo;
    private int sete;
    private int fame;
    private int vita;
    private int vitaMax;
    
    public Pokemon(int vitaMax){
        this.vitaMax = vitaMax;
        this.vita = vitaMax; 
        this.fame = 0;       
        this.sete = 0;       
        this.vivo = true;
    }
    
    public boolean PokemonMorto(){
        if(vita <= 0 && sete >= 50 && fame >= 50){
            vivo = false;
        }
        return vivo;
    }
    
}
