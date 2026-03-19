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

    public Pokemon() {
        this.vitaMax = 35;
        this.vita = vitaMax;
        this.fame = 0;
        this.sete = 0;
        this.vivo = true;
    }

    public boolean PokemonMorto() {
        if (vita <= 0 || sete >= 50 || fame >= 50) {
            this.vivo = false;
        }
        return !this.vivo;
    }

    public int Bevi(Inventario i) {
        if (i.usaAcqua()) {
            this.sete = sete - 10;
        }
        if (this.sete < 0) {
            this.sete = 0;
        }
        return sete;
    }

    public int Mangia(Inventario i) {
        if (i.usaBacca()) {
            this.fame = fame - 10;
        }
        if (this.fame < 0) {
            this.fame = 0;
        }
        return fame;
    }

    public int Cura(Inventario i) {
        if (i.usaPozione()) {
            this.vita = vita + 20;
        }
        if (vita > vitaMax) {
            this.vita = vitaMax;
        }
        return vita;
    }

    public int Rinascita(Inventario i) {
        if (i.usaRevitalizzante() && PokemonMorto()) {
            this.vita = vitaMax / 2;
        }
        return vita;
    }

    public int getVita() {
        return vita;
    }

    public int getFame() {
        return fame;
    }

    public int getSete() {
        return sete;
    }

    public int getVitaMax() {
        return vitaMax;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public void setFame(int fame) {
        this.fame = fame;
    }

    public void setSete(int sete) {
        this.sete = sete;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    
    public abstract int usaAbilita();
    
    public abstract void abilitaPassiva();
    
    public void subisciTurno() {
        this.fame += 10;
        this.sete += 10;
        this.abilitaPassiva();
        this.PokemonMorto();
    }
}
