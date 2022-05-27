/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios_Registros;

import interfaces.*;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import metodosBD.MetodosBD;
import rojeru_san.complementos.RSEffectFade;
import seguridad.Encoder;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import seguridad.EncoderA;

/**
 *
 * @author Kevin
 */
public class RegAdm extends javax.swing.JDialog
{

    int tipoSesion = 1;

    /**
     * Creates new form InicioSesion
     */
    public RegAdm()
    {
        initComponents();
        setModal(true);
        //setIconImage(new ImageIcon(getClass().getResource("../imagenes/citasplus.png")).getImage());
        setIconImage(Toolkit.getDefaultToolkit().getImage("citasplus.png"));
        setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        setShape(forma);
        RSEffectFade.setFadeWindowIn(this, 30, 0.1f);
        iniciarLabels();
    }

    public void iniciarLabels()
    {
        jLErrorUsuario.setText(null);
        jLErrorContra.setText(null);
        jLCorrrecto.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        rSPanelMaterialImage1 = new RSMaterialComponent.RSPanelMaterialImage();
        rSPanelMaterial1 = new RSMaterialComponent.RSPanelMaterial();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTFUsuario = new RSMaterialComponent.RSTextFieldMaterialIcon();
        JTFContraseña = new RSMaterialComponent.RSPasswordMaterialIcon();
        jLErrorUsuario = new javax.swing.JLabel();
        jLErrorContra = new javax.swing.JLabel();
        btnreg = new newscomponents.RSButtonIcon_new();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLCorrrecto = new javax.swing.JLabel();
        rSButtonIcon_new3 = new newscomponents.RSButtonIcon_new();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelMaterialImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        rSPanelMaterialImage1.setShadowBottom(false);
        rSPanelMaterialImage1.setShadowLeft(false);
        rSPanelMaterialImage1.setShadowRight(false);
        rSPanelMaterialImage1.setShadowTop(false);

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setIntensity(10);
        rSPanelMaterial1.setRound(20);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido a Cita PLUS");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Como es la primera vez que usas el sistema, necesitas definir un administrador");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/autorized.png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        JTFUsuario.setForeground(new java.awt.Color(0, 0, 0));
        JTFUsuario.setColorIcon(new java.awt.Color(0, 0, 0));
        JTFUsuario.setColorMaterial(new java.awt.Color(0, 0, 0));
        JTFUsuario.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        JTFUsuario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PEOPLE);
        JTFUsuario.setPhColor(new java.awt.Color(0, 0, 0));
        JTFUsuario.setPlaceholder("Ingrese Usuario");
        JTFUsuario.setSelectionColor(new java.awt.Color(0, 0, 0));
        JTFUsuario.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                JTFUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                JTFUsuarioKeyReleased(evt);
            }
        });

        JTFContraseña.setForeground(new java.awt.Color(0, 0, 0));
        JTFContraseña.setColorIcon(new java.awt.Color(0, 0, 0));
        JTFContraseña.setColorMaterial(new java.awt.Color(0, 0, 0));
        JTFContraseña.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        JTFContraseña.setPhColor(new java.awt.Color(0, 0, 0));
        JTFContraseña.setPlaceholder("Ingrese contraseña");
        JTFContraseña.setSelectionColor(new java.awt.Color(0, 0, 0));
        JTFContraseña.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                JTFContraseñaActionPerformed(evt);
            }
        });
        JTFContraseña.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                JTFContraseñaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                JTFContraseñaKeyReleased(evt);
            }
        });

        jLErrorUsuario.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLErrorUsuario.setForeground(new java.awt.Color(255, 51, 51));
        jLErrorUsuario.setText("Este campo se requiere.");

        jLErrorContra.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLErrorContra.setForeground(new java.awt.Color(255, 51, 51));
        jLErrorContra.setText("Este campo se requiere.");

        btnreg.setBackground(new java.awt.Color(72, 202, 228));
        btnreg.setText("Activar");
        btnreg.setBackgroundHover(new java.awt.Color(171, 229, 240));
        btnreg.setEnabled(false);
        btnreg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnreg.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ARROW_FORWARD);
        btnreg.setRound(10);
        btnreg.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnregActionPerformed(evt);
            }
        });

        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        jLabel7.setText("2022 - Tecnologinc");

        jLCorrrecto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        jLCorrrecto.setText("Ing");

        rSButtonIcon_new3.setBackground(new java.awt.Color(255, 51, 51));
        rSButtonIcon_new3.setText("Salir");
        rSButtonIcon_new3.setBackgroundHover(new java.awt.Color(255, 153, 153));
        rSButtonIcon_new3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSButtonIcon_new3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXIT_TO_APP);
        rSButtonIcon_new3.setRound(10);
        rSButtonIcon_new3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rSButtonIcon_new3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelMaterial1Layout = new javax.swing.GroupLayout(rSPanelMaterial1);
        rSPanelMaterial1.setLayout(rSPanelMaterial1Layout);
        rSPanelMaterial1Layout.setHorizontalGroup(
            rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                .addGroup(rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                        .addGroup(rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rSPanelMaterial1Layout.createSequentialGroup()
                                            .addComponent(btnreg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(rSButtonIcon_new3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jLCorrrecto, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelMaterial1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelMaterial1Layout.createSequentialGroup()
                        .addGroup(rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLErrorContra, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLErrorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTFContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelMaterial1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(137, 137, 137))))
        );
        rSPanelMaterial1Layout.setVerticalGroup(
            rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(JTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLErrorUsuario)
                .addGap(26, 26, 26)
                .addComponent(JTFContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLErrorContra)
                .addGap(43, 43, 43)
                .addGroup(rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonIcon_new3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCorrrecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout rSPanelMaterialImage1Layout = new javax.swing.GroupLayout(rSPanelMaterialImage1);
        rSPanelMaterialImage1.setLayout(rSPanelMaterialImage1Layout);
        rSPanelMaterialImage1Layout.setHorizontalGroup(
            rSPanelMaterialImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterialImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rSPanelMaterialImage1Layout.setVerticalGroup(
            rSPanelMaterialImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterialImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelMaterial1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterialImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelMaterialImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnregActionPerformed
    {//GEN-HEADEREND:event_btnregActionPerformed

        boolean creado = EncoderA.creaAdm(JTFUsuario.getText().trim(), JTFContraseña.getText().trim());
        if (creado)
        {
            dispose();
            System.out.println("Admin insertado y guardado");
        }
       

    }//GEN-LAST:event_btnregActionPerformed

    private void JTFContraseñaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_JTFContraseñaActionPerformed
    {//GEN-HEADEREND:event_JTFContraseñaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_JTFContraseñaActionPerformed

    private void JTFContraseñaKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JTFContraseñaKeyPressed
    {//GEN-HEADEREND:event_JTFContraseñaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            btnreg.requestFocus();
            btnreg.doClick();
        }

    }//GEN-LAST:event_JTFContraseñaKeyPressed

    private void JTFUsuarioKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JTFUsuarioKeyPressed
    {//GEN-HEADEREND:event_JTFUsuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            JTFContraseña.requestFocus();
        }

    }//GEN-LAST:event_JTFUsuarioKeyPressed

    private void rSButtonIcon_new3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rSButtonIcon_new3ActionPerformed
    {//GEN-HEADEREND:event_rSButtonIcon_new3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_rSButtonIcon_new3ActionPerformed

    private void JTFUsuarioKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JTFUsuarioKeyReleased
    {//GEN-HEADEREND:event_JTFUsuarioKeyReleased
        if (!JTFUsuario.getText().isEmpty() && !JTFContraseña.getText().isEmpty())
        {
            btnreg.setEnabled(true);
        } else
        {
            btnreg.setEnabled(false);
        }
    }//GEN-LAST:event_JTFUsuarioKeyReleased

    private void JTFContraseñaKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_JTFContraseñaKeyReleased
    {//GEN-HEADEREND:event_JTFContraseñaKeyReleased
        if (!JTFUsuario.getText().isEmpty() && !JTFContraseña.getText().isEmpty())
        {
            btnreg.setEnabled(true);
        } else
        {
            btnreg.setEnabled(false);
        }
    }//GEN-LAST:event_JTFContraseñaKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new RegAdm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSPasswordMaterialIcon JTFContraseña;
    private RSMaterialComponent.RSTextFieldMaterialIcon JTFUsuario;
    private newscomponents.RSButtonIcon_new btnreg;
    private javax.swing.JLabel jLCorrrecto;
    private javax.swing.JLabel jLErrorContra;
    private javax.swing.JLabel jLErrorUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private newscomponents.RSButtonIcon_new rSButtonIcon_new3;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    private RSMaterialComponent.RSPanelMaterialImage rSPanelMaterialImage1;
    // End of variables declaration//GEN-END:variables
}
