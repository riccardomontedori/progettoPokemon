/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package progettopokemon;

import java.awt.Image;
import java.util.Set;
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
    
    private void aggiornaGrafica() {
    Pokemon p = g.getPokemon();

    jLabel5.setText("" + p.getVita());
    jLabel6.setText("" + p.getSete());
    jLabel3.setText("" + p.getFame());

    boolean vivo = !p.PokemonMorto();

    btnMangia.setEnabled(vivo);
    btnBevi.setEnabled(vivo);
    btnCura.setEnabled(vivo);
    btnEsplora.setEnabled(vivo);
    btnAbilità.setEnabled(vivo); 
    btnInventario.setEnabled(true); 
    if (!vivo && g.getInventario().getN_revitalizzanti() > 0) {
        btnRinasci.setEnabled(true);
        jLabel5.setText("ESAUSTO");
    } else {
        btnRinasci.setEnabled(false);
    }

    if (vivo && p.getTurniInCampo() >= 3 && p.getStadio() < 2) {
        btnEvolvi.setEnabled(true);
        btnEvolvi.setText("EVOLVI!");
    } else {
        btnEvolvi.setEnabled(false);
        if (p.getStadio() >= 2) {
            btnEvolvi.setText("Stadio Finale");
        } else {
            btnEvolvi.setText("Evo tra: " + (3 - p.getTurniInCampo()) + " t");
        }
    }
    String nomeFile = "immagine_" + p.getNome().toLowerCase() + ".png";
    imgCorrente = new ImageIcon(nomeFile).getImage();
    ridimensionaImmagine();
}

    private void ridimensionaSfondo() {
        if (imgSfondo != null && jLabel8.getWidth() > 0 && jLabel8.getHeight() > 0) {
            Image scalata = imgSfondo.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_SMOOTH);
            jLabel8.setIcon(new ImageIcon(scalata));
        }
    }

    private void ridimensionaImmagine() {
        if (imgCorrente != null && jLabel7.getWidth() > 0 && jLabel7.getHeight() > 0) {

            int w = jLabel7.getWidth();
            int h = jLabel7.getHeight();

            if (w > 250) {
                w = 250;
            }
            if (h > 250) {
                h = 250;
            }

            if (w < 100) {
                w = 100;
            }
            if (h < 100) {
                h = 100;
            }

            double imgW = imgCorrente.getWidth(null);
            double imgH = imgCorrente.getHeight(null);

            if (imgW > 0 && imgH > 0) {
                double ratioX = (double) w / imgW;
                double ratioY = (double) h / imgH;

                double ratio = Math.min(ratioX, ratioY);

                int finalW = (int) (imgW * ratio);
                int finalH = (int) (imgH * ratio);

                if (finalW > 0 && finalH > 0) {
                    Image scalata = imgCorrente.getScaledInstance(finalW, finalH, Image.SCALE_SMOOTH);
                    jLabel7.setIcon(new ImageIcon(scalata));
                }
            }
        }
    }

    private void impostaImmagineEvento(String percorso) {
        if (percorso == null) {
            jLabel9.setIcon(null);
            return;
        }
        try {
            ImageIcon icon = new ImageIcon(percorso);
            int lblW = jLabel9.getWidth();
            int lblH = jLabel9.getHeight();

            if (lblW <= 0) {
                lblW = 250;
            }
            if (lblH <= 0) {
                lblH = 250;
            }

            double ratio = Math.min((double) lblW / icon.getIconWidth(), (double) lblH / icon.getIconHeight());
            int finalW = (int) (icon.getIconWidth() * ratio);
            int finalH = (int) (icon.getIconHeight() * ratio);

            Image img = icon.getImage().getScaledInstance(finalW, finalH, Image.SCALE_SMOOTH);
            jLabel9.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            jLabel9.setIcon(null);
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
    btnEvolvi = new javax.swing.JButton("Evolvi Pokémon");
    btnEvolvi.setEnabled(false);
    
    btnSalvaCsv = new javax.swing.JButton("Salva (CSV)");
    btnCaricaCsv = new javax.swing.JButton("Carica (CSV)");
    btnSalvaBinario = new javax.swing.JButton("Salva (BIN)");
    btnCaricaBinario = new javax.swing.JButton("Carica (BIN)");

    jLabel1 = new javax.swing.JLabel("Fame attuale:");
    jLabel2 = new javax.swing.JLabel("Sete attuale:");
    jLabel3 = new javax.swing.JLabel("0");
    jLabel4 = new javax.swing.JLabel("Vita attuale:");
    jLabel5 = new javax.swing.JLabel("" + g.getPokemon().getVita());
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
    jScrollPane1.setPreferredSize(new java.awt.Dimension(10, 10));
    jScrollPane1.setMinimumSize(new java.awt.Dimension(10, 10));

    jLabel9 = new javax.swing.JLabel();
    jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel9.setPreferredSize(new java.awt.Dimension(10, 10));
    jLabel9.setMinimumSize(new java.awt.Dimension(10, 10));

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
    pnlStats.setPreferredSize(new java.awt.Dimension(10, 10));
    pnlStats.add(jLabel4); pnlStats.add(jLabel5);
    pnlStats.add(jLabel2); pnlStats.add(jLabel6);
    pnlStats.add(jLabel1); pnlStats.add(jLabel3);

    c.gridx = 0; c.gridy = 0;
    c.weightx = 0.3; c.weighty = 0.2;
    contentPanel.add(pnlStats, c);

    c.gridx = 0; c.gridy = 1;
    c.weighty = 0.8;
    contentPanel.add(jLabel7, c);

    javax.swing.JPanel pnlBottoni = new javax.swing.JPanel(new java.awt.GridBagLayout());
    pnlBottoni.setOpaque(false);
    pnlBottoni.setPreferredSize(new java.awt.Dimension(10, 10));
    java.awt.GridBagConstraints cb = new java.awt.GridBagConstraints();
    cb.fill = java.awt.GridBagConstraints.HORIZONTAL;
    cb.insets = new java.awt.Insets(5, 5, 5, 5);
    cb.weightx = 1.0;

    cb.gridx = 0; cb.gridy = 0; pnlBottoni.add(btnCura, cb);
    cb.gridx = 1; cb.gridy = 0; pnlBottoni.add(btnMangia, cb);
    cb.gridx = 0; cb.gridy = 1; pnlBottoni.add(btnBevi, cb);
    cb.gridx = 1; cb.gridy = 1; pnlBottoni.add(btnRinasci, cb);
    
    cb.gridx = 0; cb.gridy = 2; cb.gridwidth = 2;
    pnlBottoni.add(btnAbilità, cb);
    cb.gridy = 3; pnlBottoni.add(btnEsplora, cb);
    cb.gridy = 4; pnlBottoni.add(btnInventario, cb);
    cb.gridy = 5; pnlBottoni.add(btnEvolvi, cb);

    cb.gridwidth = 1;
    cb.gridy = 6; cb.gridx = 0; pnlBottoni.add(btnSalvaCsv, cb);
    cb.gridx = 1; pnlBottoni.add(btnCaricaCsv, cb);
    
    cb.gridy = 7; cb.gridx = 0; pnlBottoni.add(btnSalvaBinario, cb);
    cb.gridx = 1; pnlBottoni.add(btnCaricaBinario, cb);

    c.gridx = 1; c.gridy = 0;
    c.gridheight = 2; c.weightx = 0.3; c.weighty = 1.0;
    contentPanel.add(pnlBottoni, c);

    c.gridx = 2; c.gridy = 0;
    c.gridheight = 1; c.weightx = 0.4; c.weighty = 0.5;
    contentPanel.add(jScrollPane1, c);

    c.gridx = 2; c.gridy = 1;
    c.weighty = 0.5;
    contentPanel.add(jLabel9, c);

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
    btnEvolvi.addActionListener(this::btnEvolviActionPerformed);
    btnSalvaCsv.addActionListener(this::btnSalvaCsvActionPerformed);
    btnCaricaCsv.addActionListener(this::btnCaricaCsvActionPerformed);
    btnSalvaBinario.addActionListener(this::btnSalvaBinarioActionPerformed);
    btnCaricaBinario.addActionListener(this::btnCaricaBinarioActionPerformed);

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
        jLabel9 = new javax.swing.JLabel();
        btnEvolvi = new javax.swing.JButton();
        btnCaricaCsv = new javax.swing.JButton();
        btnSalvaCsv = new javax.swing.JButton();
        btnSalvaBinario = new javax.swing.JButton();
        btnCaricaBinario = new javax.swing.JButton();

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
        jScrollPane1.setBounds(460, 10, 234, 370);

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

        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(60, 250, 60, 16);

        btnEvolvi.setText("Evolvi pokemon");
        btnEvolvi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvolviActionPerformed(evt);
            }
        });
        getContentPane().add(btnEvolvi);
        btnEvolvi.setBounds(140, 340, 130, 23);

        btnCaricaCsv.setText("Carica (CSV)");
        btnCaricaCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaricaCsvActionPerformed(evt);
            }
        });
        getContentPane().add(btnCaricaCsv);
        btnCaricaCsv.setBounds(160, 120, 95, 23);

        btnSalvaCsv.setText("Salva (CSV)");
        btnSalvaCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaCsvActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvaCsv);
        btnSalvaCsv.setBounds(260, 120, 120, 23);

        btnSalvaBinario.setText("Salva (BIN)");
        btnSalvaBinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaBinarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvaBinario);
        btnSalvaBinario.setBounds(40, 100, 110, 23);

        btnCaricaBinario.setText("Carica (BIN)");
        btnCaricaBinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaricaBinarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnCaricaBinario);
        btnCaricaBinario.setBounds(40, 130, 100, 23);

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

            g.getPokemon().setFame(0);
            g.getPokemon().setSete(0);
            g.getPokemon().setVita(g.getPokemon().getVitaMax() / 2);

            jLabel3.setText("" + g.getPokemon().getFame());
            jLabel6.setText("" + g.getPokemon().getSete());
            jLabel5.setText("" + g.getPokemon().getVita());

            txtLog.append("> Il tuo Pokémon è rinato! \n");
            aggiornaGrafica();
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
            impostaImmagineEvento(null);
            String oggetto = g.getGestoreEvento().getUltimoOggettoTrovato();
        
        if (oggetto.equals("acqua")) {
            msg = "Hai trovato una rinfrescante Acqua Fresca!";
            impostaImmagineEvento("immagine_acqua.png");
        } else if (oggetto.equals("bacca")) {
            msg = "Hai trovato una Bacca matura!";
            impostaImmagineEvento("immagine_bacca.png");
        } else if (oggetto.equals("pozione")) {
            msg = "Hai trovato una Pozione curativa!";
            impostaImmagineEvento("immagine_pozione.png");
        } else if (oggetto.equals("revitalizzante")) {
            msg = "Incredibile! Hai trovato una Pepita!";
            impostaImmagineEvento("immagine_revitalizzante.png");
        }
        } else if (e == Evento.TEAM_ROCKET) {
            impostaImmagineEvento(null);
            msg = "Il Team Rocket ti ha attaccato!";
            impostaImmagineEvento("immagine_team_rocket.png");
        } else {
            impostaImmagineEvento(null);

            int scelta = (int) (Math.random() * 3) + 1;

            if (scelta == 1) {
                g.getInventario().setN_bacche(g.getInventario().getN_bacche() - 1);
                msg = "Un Bidoof selvatico ti taglia la strada! Ti ruba una bacca e per farlo di reca del danno";
                impostaImmagineEvento("immagine_pokemon_selvatico2.png");
            } else if (scelta == 2) {
                msg = "Dalla foresta sbuca un mightyena, ha i suoi cuccioli li accanto e per difenderli è pronto ad attaccare, lo scontro fa aumentare la tua sete e fame oltre a i danni";
                impostaImmagineEvento("immagine_pokemon_selvatico.png");
                g.getPokemon().setFame(g.getPokemon().getFame() + 5);
                g.getPokemon().setSete(g.getPokemon().getSete() + 5);
            } else {
                msg = "Il cielo trema, compare Palkia, re dello spazio! Non penso gradisca, vedendo che è in scontro con Giratina per il bene dello spazio e del tempo gli lasci il tuo inventario";
                g.getInventario().setN_bacche(0);
                g.getInventario().setN_acqua(0);
                g.getInventario().setN_pozioni(0);
                g.getInventario().setN_revitalizzanti(0);
                impostaImmagineEvento("immagine_pokemon_selvatico3.png");
            }
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
            btnEvolvi.setEnabled(false);

            jLabel5.setText("POKEMON ESAUSTO");
            txtLog.append("> ATTENZIONE: " + g.getPokemon().getNome() + " è esausto!\n");

            if (g.getInventario().getN_revitalizzanti() > 0) {
                btnRinasci.setEnabled(true);
                txtLog.append("> Usa una Pepita per continuare.\n");
            } else {
                txtLog.append("> Non hai Pepite! Game Over.\n");
            }
        }
        aggiornaGrafica();
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
            txtLog.append("> Rowlet ha usato Sintesi! Vita ripristinata.\n");
        } else if (g.getPokemon() instanceof Froakie) {
            g.getPokemon().usaAbilita();
            jLabel6.setText("" + g.getPokemon().getSete());
            jLabel3.setText("" + g.getPokemon().getFame());
            txtLog.append("> Froakie ha usato Idratazione! Fame e Sete ridotte.\n");
        } else if (g.getPokemon() instanceof Chimchar) {
            g.getPokemon().usaAbilita();
            txtLog.append("> Chimchar ha usato Schudo Fiammeggiante! Subirà meno danni d'ora in poi.\n");
        }

        btnAbilità.setEnabled(false);
    }//GEN-LAST:event_btnAbilitàActionPerformed

    private void btnEvolviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvolviActionPerformed
        // TODO add your handling code here:
        String nomeVecchio = g.getPokemon().getNome();
    g.eseguiEvoluzione();
    String nomeNuovo = g.getPokemon().getNome();
    
    txtLog.append("> " + nomeVecchio + " si sta evolvendo...\n");
    txtLog.append("> Incredibile! Si è evoluto in " + nomeNuovo + "!\n");
    
    aggiornaGrafica();
    }//GEN-LAST:event_btnEvolviActionPerformed

    private void btnCaricaCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaricaCsvActionPerformed
        // TODO add your handling code here:
        try {
            Gestore caricato = FileManager.caricaCSV();
            if (caricato != null) {
                this.g = caricato;
                aggiornaGrafica(); 
                jLabel9.setIcon(null);
                txtLog.setText("");
                txtLog.append("> Partita caricata con successo!\n");
            } else {
                txtLog.append("> Nessun salvataggio trovato o file corrotto.\n");
            }
        } catch (Exception e) {
            txtLog.append("> Errore nel caricamento: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_btnCaricaCsvActionPerformed

    private void btnSalvaCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaCsvActionPerformed
        // TODO add your handling code here:
        try {
            FileManager.salvaCSV(g); // Chiama il metodo statico del tuo FileManager
            txtLog.append("> Partita salvata correttamente in CSV.\n");
        } catch (Exception e) {
            txtLog.append("> Errore durante il salvataggio CSV: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_btnSalvaCsvActionPerformed

    private void btnSalvaBinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaBinarioActionPerformed
        // TODO add your handling code here:
        try {
        FileManager.salvaBinario(g);
        txtLog.append("> Partita salvata correttamente in formato BINARIO.\n");
    } catch (Exception e) {
        txtLog.append("> Errore durante il salvataggio BIN: " + e.getMessage() + "\n");
    }
    }//GEN-LAST:event_btnSalvaBinarioActionPerformed

    private void btnCaricaBinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaricaBinarioActionPerformed
        // TODO add your handling code here:
        try {
        Gestore caricato = FileManager.caricaBinario();
        if (caricato != null) {
            this.g = caricato;
            aggiornaGrafica();
            jLabel9.setIcon(null); // Pulisce l'immagine dell'ultimo evento
            txtLog.setText("");
            txtLog.append("> Partita caricata con successo dal file BINARIO!\n");
        } else {
            txtLog.append("> Nessun salvataggio binario trovato.\n");
        }
    } catch (Exception e) {
        txtLog.append("> Errore nel caricamento BIN: " + e.getMessage() + "\n");
    }
    }//GEN-LAST:event_btnCaricaBinarioActionPerformed

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
    private javax.swing.JButton btnCaricaBinario;
    private javax.swing.JButton btnCaricaCsv;
    private javax.swing.JButton btnCura;
    private javax.swing.JButton btnEsplora;
    private javax.swing.JButton btnEvolvi;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnMangia;
    private javax.swing.JButton btnRinasci;
    private javax.swing.JButton btnSalvaBinario;
    private javax.swing.JButton btnSalvaCsv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables
}
