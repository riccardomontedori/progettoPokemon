/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettopokemon;

/**
 *
 * @author montedori.riccardo
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
public class FileManager{

    private static final String FILE_BINARIO = "partita.dat";
    private static final String FILE_CSV = "partita.csv";

   

    public static void salvaBinario(Gestore g) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_BINARIO))) {
            oos.writeObject(g);
            System.out.println("Salvataggio binario riuscito.");
        } catch (IOException e) {
            System.err.println("Errore salvataggio binario: " + e.getMessage());
        }
    }

    public static Gestore caricaBinario() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_BINARIO))) {
            return (Gestore) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Errore caricamento binario: " + e.getMessage());
            return null;
        }
    }

    public static void salvaCSV(Gestore g) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_CSV))) {
            Pokemon p = g.getPokemon();
            Inventario inv = g.getInventario();

            writer.println("Classe,Nome,Stadio,Vita,Fame,Sete,TurniEvo,Bacche,Acqua,Pozioni,Revitalizzanti");

            writer.print(p.getClass().getSimpleName() + ",");
            writer.print(p.getNome() + ",");
            writer.print(p.getStadio() + ",");
            writer.print(p.getVita() + ",");
            writer.print(p.getFame() + ",");
            writer.print(p.getSete() + ",");
            writer.print(p.getTurniInCampo() + ",");
            writer.print(inv.getN_bacche() + ",");
            writer.print(inv.getN_acqua() + ",");
            writer.print(inv.getN_pozioni() + ",");
            writer.println(inv.getN_revitalizzanti());

            System.out.println("Salvataggio CSV riuscito.");
        } catch (IOException e) {
            System.err.println("Errore salvataggio CSV: " + e.getMessage());
        }
    }

    public static Gestore caricaCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_CSV))) {
            reader.readLine();
            String linea = reader.readLine();
            if (linea == null) return null;

            String[] dati = linea.split(",");

            String tipo = dati[0];
            Pokemon p;
            if (tipo.equals("Rowlet")) p = new Rowlet();
            else if (tipo.equals("Froakie")) p = new Froakie();
            else p = new Chimchar();

            p.setNome(dati[1]);
            p.setStadio(Integer.parseInt(dati[2]));
            p.setVita(Integer.parseInt(dati[3]));
            p.setFame(Integer.parseInt(dati[4]));
            p.setSete(Integer.parseInt(dati[5]));
            p.setTurniInCampo(Integer.parseInt(dati[6]));

            Gestore g = new Gestore(p);
            Inventario inv = g.getInventario();
            inv.setN_bacche(Integer.parseInt(dati[7]));
            inv.setN_acqua(Integer.parseInt(dati[8]));
            inv.setN_pozioni(Integer.parseInt(dati[9]));
            inv.setN_revitalizzanti(Integer.parseInt(dati[10]));

            return g;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Errore caricamento CSV: " + e.getMessage());
            return null;
        }
    }
}
