package org.japo.java.forms;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class RegularExpresioneitor extends javax.swing.JFrame {

    // Ruta de recursos
    private final String RES_PKG = "/img";

    // Recurso SI
    private final String IMG_SI = "mini_si.jpg";
    private final String RES_SI = RES_PKG + "/" + IMG_SI;

    // Recurso NO
    private final String IMG_NO = "mini_no.jpg";
    private final String RES_NO = RES_PKG + "/" + IMG_NO;

    // Recurso Tal Vez
    private final String IMG_TV = "mini_tv.jpg";
    private final String RES_TV = RES_PKG + "/" + IMG_TV;

    // Referencias a los iconos
    Icon iconoSi;
    Icon iconoNo;
    Icon iconoTv;

    public RegularExpresioneitor() {
        iniciarAnterior();
        initComponents();
        iniciarPosterior();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTextoPrueba = new javax.swing.JPanel();
        txfTextoPrueba = new javax.swing.JTextField();
        scrExpReg = new javax.swing.JScrollPane();
        txaExpReg = new javax.swing.JTextArea();
        pnlResultados = new javax.swing.JPanel();
        lblResultado = new javax.swing.JLabel();
        btnComprobar = new javax.swing.JButton();
        mnbPpal = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuEditar = new javax.swing.JMenu();
        mnuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comprobador de expresiones regulares");
        setResizable(false);

        pnlTextoPrueba.setBorder(javax.swing.BorderFactory.createTitledBorder("Texto de prueba"));

        txfTextoPrueba.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txfTextoPrueba.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txfTextoPruebaFocusGained(evt);
            }
        });
        txfTextoPrueba.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfTextoPruebaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlTextoPruebaLayout = new javax.swing.GroupLayout(pnlTextoPrueba);
        pnlTextoPrueba.setLayout(pnlTextoPruebaLayout);
        pnlTextoPruebaLayout.setHorizontalGroup(
            pnlTextoPruebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTextoPruebaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfTextoPrueba)
                .addContainerGap())
        );
        pnlTextoPruebaLayout.setVerticalGroup(
            pnlTextoPruebaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTextoPruebaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfTextoPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrExpReg.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Expresión regular"), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        txaExpReg.setColumns(20);
        txaExpReg.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txaExpReg.setLineWrap(true);
        txaExpReg.setRows(3);
        txaExpReg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txaExpReg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txaExpRegFocusGained(evt);
            }
        });
        scrExpReg.setViewportView(txaExpReg);

        pnlResultados.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        lblResultado.setBackground(java.awt.Color.white);
        lblResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultado.setIcon(iconoTv);
        lblResultado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblResultado.setOpaque(true);

        btnComprobar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnComprobar.setText("Comprobar");
        btnComprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlResultadosLayout = new javax.swing.GroupLayout(pnlResultados);
        pnlResultados.setLayout(pnlResultadosLayout);
        pnlResultadosLayout.setHorizontalGroup(
            pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnComprobar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlResultadosLayout.setVerticalGroup(
            pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnComprobar)
                .addContainerGap())
        );

        mnuArchivo.setText("Archivo");
        mnuArchivo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mnbPpal.add(mnuArchivo);

        mnuEditar.setText("Edición");
        mnuEditar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mnbPpal.add(mnuEditar);

        mnuAyuda.setText("Ayuda");
        mnuAyuda.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mnbPpal.add(mnuAyuda);

        setJMenuBar(mnbPpal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTextoPrueba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrExpReg, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTextoPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrExpReg)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(858, 332));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobarActionPerformed
        comprobarExpReg();
    }//GEN-LAST:event_btnComprobarActionPerformed

    private void txaExpRegFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaExpRegFocusGained
        lblResultado.setIcon(iconoTv);
    }//GEN-LAST:event_txaExpRegFocusGained

    private void txfTextoPruebaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfTextoPruebaFocusGained
        lblResultado.setIcon(iconoTv);
    }//GEN-LAST:event_txfTextoPruebaFocusGained

    private void txfTextoPruebaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTextoPruebaKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            comprobarExpReg();
        }
    }//GEN-LAST:event_txfTextoPruebaKeyPressed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegularExpresioneitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegularExpresioneitor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprobar;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JMenuBar mnbPpal;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenu mnuEditar;
    private javax.swing.JPanel pnlResultados;
    private javax.swing.JPanel pnlTextoPrueba;
    private javax.swing.JScrollPane scrExpReg;
    private javax.swing.JTextArea txaExpReg;
    private javax.swing.JTextField txfTextoPrueba;
    // End of variables declaration//GEN-END:variables

    private void iniciarAnterior() {
        crearIconos();
    }

    private void iniciarPosterior() {
    }

    private void crearIconos() {
        iconoSi = new ImageIcon(getClass().getResource(RES_SI));
        iconoNo = new ImageIcon(getClass().getResource(RES_NO));
        iconoTv = new ImageIcon(getClass().getResource(RES_TV));
    }

    private void comprobarExpReg() {
        try {
            // Obtiene el texto de prueba
            String textoPrueba = txfTextoPrueba.getText();

            // Obtiene la expresión regular
            String expReg = txaExpReg.getText();

            // Patrón de la expresión regular
            Pattern patron = Pattern.compile(expReg);

            // Aplica el patrón al texto de prueba
            Matcher detector = patron.matcher(textoPrueba);

            if (detector.matches()) {
                lblResultado.setIcon(iconoSi);
            } else {
                lblResultado.setIcon(iconoNo);
            }
        } catch (PatternSyntaxException pse) {
            txaExpReg.requestFocus();
            JOptionPane.showMessageDialog(this, "Expresión regular errónea");
        }
    }
}
