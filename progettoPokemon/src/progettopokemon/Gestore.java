/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettopokemon;

/**
 *
 * @author montedori.riccardo
 */
public class Gestore {

    private Pokemon p;
    private Inventario i;
    private GestoreEvento ge;
    private int turni;

    public Gestore(Pokemon scelto) {
        this.p = scelto;
        this.i = new Inventario();
        this.ge = new GestoreEvento();
        this.turni = 0;
    }

    public void prossimoTurno() {
        if (p.isVivo()) {
            turni++;
            p.subisciTurno(); 
            Evento evento = ge.GeneraEventoCasuale(p);
            ge.ApplicaEvento(evento, p, i);
        }
    }

    public void eseguiEvoluzione() {
        
        if (p.getTurniInCampo() >= 3 && p.getStadio() < 2) {
            p.eseguiEvoluzione(); 
            p.resetTurniInCampo(); 
        }
    }

    public void usaTattica() {
        if (p instanceof Chimchar || p instanceof Rowlet) {
            p.usaAbilita();
        } else if (p instanceof Froakie) {
            p.setFame(0);
            p.setSete(0);
        }
    }

    public void eseguiMangia() {
        p.Mangia(i);
    }

    public void eseguiBevi() {
        p.Bevi(i);
    }

    public void eseguiCura() {
        p.Cura(i);
    }

    public Pokemon getPokemon() {
        return p;
    }

    public Inventario getInventario() {
        return i;
    }

    public int getTurni() {
        return turni;
    }
    
    public GestoreEvento getGestoreEvento() {
        return this.ge;
    }
}