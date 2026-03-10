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
        if(vita <= 0 || sete >= 50 || fame >= 50){
            this.vivo = false;
        }
        return !this.vivo;
    }
    
    public int Bevi(Inventario i){
        if (i.usaAcqua()) {
            this.sete = sete - 10;          
        }
        return sete;
    }
    
    public int Mangia(Inventario i){
        if (i.usaBacca()) {
            this.fame = fame - 10;          
        }
        return fame;
    }
    
    public int Cura(Inventario i){
        if(i.usaPozione()){
            this.vita = vita + 20;
        }
        return vita;
    }
    
    public int Rinascita(Inventario i){
        if(i.usaRevitalizzante() && PokemonMorto()){
            this.vita = vitaMax / 2;
        }
        return vita;
    }
}
