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
        turni++;
        p.subisciTurno();
        if (p instanceof Chimchar && ((Chimchar) p).getTurniImmune() > 0) {
            return;
        }
        Evento evento = ge.GeneraEventoCasuale(p);
        ge.ApplicaEvento(evento, p, i);
    }

    public void usaTattica() {
        if (p instanceof Chimchar) {
            p.usaAbilita();
        } else if (p instanceof Rowlet) {
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
}
