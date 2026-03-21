/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package progettopokemon;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author montedori.riccardo
 */
public class InterfacciaSvolgimentoGioco extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InterfacciaSvolgimentoGioco.class.getName());

    /**
     * Creates new form InterfacciaSvolgimentoGioco
     */
    private Gestore g;
    private Image imgFroakie = new ImageIcon("immagine_froakie.png").getImage();
    private Image imgRowlet = new ImageIcon("immagine_rowlet.png").getImage();
    private Image imgChimchar = new ImageIcon("immagine_chimchar.png").getImage();
    private Image imgSfondo = new ImageIcon("immagine_sfondo.jpg").getImage();
    private Image imgCorrente;

    public InterfacciaSvolgimentoGioco(Gestore g) {
        this.g = g;
        initComponentsCustom();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        btnRinasci.setEnabled(false);

        if (g.getPokemon() instanceof Rowlet) {
            imgCorrente = imgRowlet;
        } else if (g.getPokemon() instanceof Froakie) {
            imgCorrente = imgFroakie;
        } else {
            imgCorrente = imgChimchar;
        }

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                ridimensionaImmagine();
                ridimensionaSfondo();
            }
        });
    }

    private void ridimensionaSfondo() {
        if (imgSfondo != null && jLabel8.getWidth() > 0 && jLabel8.getHeight() > 0) {
            Image scalata = imgSfondo.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_SMOOTH);
            jLabel8.setIcon(new ImageIcon(scalata));
        }
    }

    private void ridimensionaImmagine() {
        if (imgCorrente != null && jLabel7.getWidth() > 0 && jLabel7.getHeight() > 0) {
            // Prendiamo la dimensione attuale della JLabel (calcolata dal GridBagLayout)
            int w = jLabel7.getWidth();
            int h = jLabel7.getHeight();

            // --- NUOVO LIMITE MASSIMO PIÙ PICCOLO (es. 250 pixel) ---
            // Impedisce all'immagine di superare questa grandezza anche su schermi giganti
            if (w > 250) {
                w = 250;
            }
            if (h > 250) {
                h = 250;
            }

            // --- DIMENSIONE MINIMA (Opzionale, es. 100 pixel) ---
            // Impedisce all'immagine di sparire se rimpicciolisci troppo la finestra
            if (w < 100) {
                w = 100;
            }
            if (h < 100) {
                h = 100;
            }

            // Calcolo per mantenere le PROPORZIONI (Aspect Ratio) originali
            double imgW = imgCorrente.getWidth(null);
            double imgH = imgCorrente.getHeight(null);

            if (imgW > 0 && imgH > 0) {
                double ratioX = (double) w / imgW;
                double ratioY = (double) h / imgH;

                // Scegliamo il rapporto più piccolo per far stare l'immagine nella cella
                double ratio = Math.min(ratioX, ratioY);

                // Calcoliamo le dimensioni finali
                int finalW = (int) (imgW * ratio);
                int finalH = (int) (imgH * ratio);

                // Evitiamo errori se il calcolo porta a zero
                if (finalW > 0 && finalH > 0) {
                    Image scalata = imgCorrente.getScaledInstance(finalW, finalH, Image.SCALE_SMOOTH);
                    jLabel7.setIcon(new ImageIcon(scalata));
                }
            }
        }
    }

    private void initComponentsCustom() {
        btnBevi = new javax.swing.JButton("Bevi");
        btnMangia = new javax.swing.JButton("Mangia");
        btnCura = new javax.swing.JButton("Cura");
        btnRinasci = new javax.swing.JButton("Rinasci");
        btnEsplora = new javax.swing.JButton("Esplora");
        btnInventario = new javax.swing.JButton("Apri Inventario");
        btnAbilità = new javax.swing.JButton("Usa abilità");

        jLabel1 = new javax.swing.JLabel("Fame attuale:");
        jLabel2 = new javax.swing.JLabel("Sete attuale:");
        jLabel3 = new javax.swing.JLabel("0");
        jLabel4 = new javax.swing.JLabel("Vita attuale:");
        jLabel5 = new javax.swing.JLabel("35");
        jLabel6 = new javax.swing.JLabel("0");

        jLabel7 = new javax.swing.JLabel();
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setPreferredSize(new java.awt.Dimension(200, 200));

        jLabel8 = new javax.swing.JLabel();
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtLog = new javax.swing.JTextArea();
        txtLog.setEditable(false);
        txtLog.setColumns(20);
        txtLog.setLineWrap(true);
        jScrollPane1 = new javax.swing.JScrollPane(txtLog);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.JLayeredPane layeredPane = new javax.swing.JLayeredPane();
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(layeredPane, java.awt.BorderLayout.CENTER);

        javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridBagLayout());
        contentPanel.setOpaque(false);

        java.awt.GridBagConstraints c = new java.awt.GridBagConstraints();
        c.insets = new java.awt.Insets(10, 10, 10, 10);
        c.fill = java.awt.GridBagConstraints.BOTH;

        javax.swing.JPanel pnlStats = new javax.swing.JPanel(new java.awt.GridLayout(3, 2, 5, 5));
        pnlStats.setOpaque(false);
        pnlStats.add(jLabel4);
        pnlStats.add(jLabel5);
        pnlStats.add(jLabel2);
        pnlStats.add(jLabel6);
        pnlStats.add(jLabel1);
        pnlStats.add(jLabel3);

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.3;
        c.weighty = 0.2;
        contentPanel.add(pnlStats, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.8;
        contentPanel.add(jLabel7, c);

        javax.swing.JPanel pnlBottoni = new javax.swing.JPanel(new java.awt.GridBagLayout());
        pnlBottoni.setOpaque(false);
        java.awt.GridBagConstraints cb = new java.awt.GridBagConstraints();
        cb.fill = java.awt.GridBagConstraints.HORIZONTAL;
        cb.insets = new java.awt.Insets(5, 5, 5, 5);
        cb.weightx = 1.0;

        cb.gridx = 0;
        cb.gridy = 0;
        pnlBottoni.add(btnCura, cb);
        cb.gridx = 1;
        pnlBottoni.add(btnMangia, cb);
        cb.gridx = 0;
        cb.gridy = 1;
        pnlBottoni.add(btnBevi, cb);
        cb.gridx = 1;
        pnlBottoni.add(btnRinasci, cb);
        cb.gridx = 0;
        cb.gridy = 2;
        cb.gridwidth = 2;
        pnlBottoni.add(btnAbilità, cb);
        cb.gridx = 0;
        cb.gridy = 3;
        pnlBottoni.add(btnEsplora, cb);
        cb.gridx = 0;
        cb.gridy = 4;
        pnlBottoni.add(btnInventario, cb);

        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 2;
        c.weightx = 0.3;
        c.weighty = 1.0;
        contentPanel.add(pnlBottoni, c);

        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 2;
        c.weightx = 0.4;
        contentPanel.add(jScrollPane1, c);

        layeredPane.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(contentPanel, javax.swing.JLayeredPane.PALETTE_LAYER);

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                jLabel8.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
                contentPanel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
                ridimensionaSfondo();
                ridimensionaImmagine();
            }
        });

        btnMangia.addActionListener(this::btnMangiaActionPerformed);
        btnBevi.addActionListener(this::btnBeviActionPerformed);
        btnCura.addActionListener(this::btnCuraActionPerformed);
        btnEsplora.addActionListener(this::btnEsploraActionPerformed);
        btnRinasci.addActionListener(this::btnRinasciActionPerformed);
        btnAbilità.addActionListener(this::btnAbilitàActionPerformed);
        btnInventario.addActionListener(this::btnInventarioActionPerformed);

        pack();
    }

    public void inserimentoPokemon() {
        Image imgSelezionata;

        if (g.getPokemon() instanceof Rowlet) {
            imgSelezionata = imgRowlet;
        } else if (g.getPokemon() instanceof Froakie) {
            imgSelezionata = imgFroakie;
        } else {
            imgSelezionata = imgChimchar;
        }

        if (imgSelezionata != null) {
            // Forza la Label ad essere grande quanto l'immagine che vuoi (es. 300x300)
            int larghezza = 300;
            int altezza = 300;

            jLabel7.setSize(larghezza, altezza);

            Image scalata = imgSelezionata.getScaledInstance(larghezza, altezza, Image.SCALE_SMOOTH);
            jLabel7.setIcon(new ImageIcon(scalata));
            jLabel7.setText("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBevi = new javax.swing.JButton();
        btnMangia = new javax.swing.JButton();
        btnCura = new javax.swing.JButton();
        btnRinasci = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEsplora = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnInventario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        btnAbilità = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnBevi.setText("Bevi");
        btnBevi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeviActionPerformed(evt);
            }
        });
        getContentPane().add(btnBevi);
        btnBevi.setBounds(109, 213, 72, 23);

        btnMangia.setText("Mangia");
        btnMangia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMangiaActionPerformed(evt);
            }
        });
        getContentPane().add(btnMangia);
        btnMangia.setBounds(199, 172, 72, 23);

        btnCura.setText("Cura");
        btnCura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuraActionPerformed(evt);
            }
        });
        getContentPane().add(btnCura);
        btnCura.setBounds(109, 172, 72, 23);

        btnRinasci.setText("Rinasci");
        btnRinasci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRinasciActionPerformed(evt);
            }
        });
        getContentPane().add(btnRinasci);
        btnRinasci.setBounds(199, 213, 72, 23);

        jLabel1.setText("Fame attuale:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 90, 80, 16);

        jLabel2.setText("Sete attuale:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 30, 80, 16);

        jLabel3.setText("0");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 90, 40, 16);

        jLabel4.setText("Vita attuale:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 70, 80, 16);

        btnEsplora.setText("Esplora");
        btnEsplora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsploraActionPerformed(evt);
            }
        });
        getContentPane().add(btnEsplora);
        btnEsplora.setBounds(109, 297, 72, 23);

        jLabel5.setText("35");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 70, 160, 16);

        jLabel6.setText("0");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(310, 30, 50, 16);

        btnInventario.setText("Apri Inventario");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnInventario);
        btnInventario.setBounds(260, 290, 130, 23);

        txtLog.setColumns(20);
        txtLog.setRows(5);
        jScrollPane1.setViewportView(txtLog);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(470, 10, 234, 370);

        btnAbilità.setText("Usa abilità");
        btnAbilità.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbilitàActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbilità);
        btnAbilità.setBounds(310, 230, 120, 23);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 130, 37, 16);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 270, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMangiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMangiaActionPerformed
        // TODO add your handling code here:
        g.eseguiMangia();
        jLabel3.setText("" + g.getPokemon().getFame());
    }//GEN-LAST:event_btnMangiaActionPerformed

    private void btnRinasciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRinasciActionPerformed
        // TODO add your handling code here:
        boolean successo = g.getPokemon().Rinascita(g.getInventario());

        if (successo) {
            // Aggiorna le scritte (Label) con i nuovi valori resettati
            jLabel3.setText("" + g.getPokemon().getFame());
            jLabel6.setText("" + g.getPokemon().getSete());
            jLabel5.setText("" + g.getPokemon().getVita());

            txtLog.append("> Il tuo Pokémon è rinato! \n");
            btnMangia.setEnabled(true);
            btnBevi.setEnabled(true);
            btnCura.setEnabled(true);
            btnEsplora.setEnabled(true);
            btnInventario.setEnabled(true);
            btnAbilità.setEnabled(true);

            btnRinasci.setEnabled(false);
        } else {
            txtLog.append("> Errore: Non hai Revitalizzanti o il Pokémon è già vivo!\n");
        }
    }//GEN-LAST:event_btnRinasciActionPerformed

    private void btnBeviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeviActionPerformed
        // TODO add your handling code here:
        g.eseguiBevi();
        jLabel6.setText("" + g.getPokemon().getSete());
    }//GEN-LAST:event_btnBeviActionPerformed

    private void btnCuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuraActionPerformed
        // TODO add your handling code here:
        g.eseguiCura();
        jLabel5.setText("" + g.getPokemon().getVita());
    }//GEN-LAST:event_btnCuraActionPerformed

    private void btnEsploraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsploraActionPerformed
        // TODO add your handling code here:
        g.getPokemon().subisciTurno();
        Evento e = g.getGestoreEvento().GeneraEventoCasuale(g.getPokemon());
        g.getGestoreEvento().ApplicaEvento(e, g.getPokemon(), g.getInventario());

        String msg = "";
        if (e == Evento.TROVA_OGGETTO) {
            msg = "Hai trovato un oggetto!";
        } else if (e == Evento.TEAM_ROCKET) {
            msg = "Il Team Rocket ti ha attaccato!";
        } else {
            msg = "Un Pokemon selvatico ti ha colpito!";
        }

        txtLog.append("> " + msg + "\n");
        txtLog.setCaretPosition(txtLog.getDocument().getLength());

        jLabel5.setText("" + g.getPokemon().getVita());
        jLabel6.setText("" + g.getPokemon().getSete());
        jLabel3.setText("" + g.getPokemon().getFame());

        if (g.getPokemon().PokemonMorto()) {
            btnMangia.setEnabled(false);
            btnBevi.setEnabled(false);
            btnCura.setEnabled(false);
            btnEsplora.setEnabled(false);
            btnAbilità.setEnabled(false);

            jLabel5.setText("POKEMON ESAUSTO");
            txtLog.append("> ATTENZIONE: " + g.getPokemon().getClass().getSimpleName() + " è esausto!\n");

            if (g.getInventario().getN_revitalizzanti() > 0) {
                btnRinasci.setEnabled(true);
                txtLog.append("> Usa un Revitalizzante per continuare.\n");
            } else {
                txtLog.append("> Non hai Revitalizzanti! Game Over.\n");
            }
        }
    }//GEN-LAST:event_btnEsploraActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        // TODO add your handling code here:
        InterfacciaInventario inv = new InterfacciaInventario(g);
        inv.setBounds(0, 0, 450, 350); // X, Y, Larghezza, Altezza
        inv.setLocationRelativeTo(null); // Centra a schermo
        inv.setResizable(false);
        inv.setVisible(true);
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnAbilitàActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbilitàActionPerformed
        // TODO add your handling code here:
        if (g.getPokemon() instanceof Rowlet) {
            g.getPokemon().usaAbilita();
            jLabel5.setText("" + g.getPokemon().getVita());
        } else if (g.getPokemon() instanceof Froakie) {
            g.getPokemon().usaAbilita();
            jLabel6.setText("" + g.getPokemon().getSete());
            jLabel3.setText("" + g.getPokemon().getFame());
        } else {

        }
        btnAbilità.setEnabled(false);
    }//GEN-LAST:event_btnAbilitàActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new InterfacciaSvolgimentoGioco(null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbilità;
    private javax.swing.JButton btnBevi;
    private javax.swing.JButton btnCura;
    private javax.swing.JButton btnEsplora;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnMangia;
    private javax.swing.JButton btnRinasci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables
}
