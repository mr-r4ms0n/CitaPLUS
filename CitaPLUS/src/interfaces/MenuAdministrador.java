/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.geom.RoundRectangle2D;
import javax.swing.UIManager;
import rojeru_san.complementos.RSEffectFade;

/**
 *
 * @author David Vergara
 */
public class MenuAdministrador extends javax.swing.JFrame
{
    public static Window vtn;
    /**
     * Creates new form MenuPrincipal
     *
     * @param usuario
     * @param nombre
     * @param foto
     */
    public MenuAdministrador()
    {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("citasplus.png"));
        vtn = this;
        RSEffectFade.setFadeWindowIn(this, 30, 0.1f);
        setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        setShape(forma);
        //Establecemos los campos segun esto corresponda de lo que se encontro registrado en la BD
    }
    
    public static void cerrar()
    {
        vtn.dispose();
        new InicioSesion().setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new RSMaterialComponent.RSPanelMaterial();
        jLNombre = new javax.swing.JLabel();
        btnAcercaDe = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnUsuarios = new RSMaterialComponent.RSButtonMaterialIconOne();
        imagenDePerfil = new RSMaterialComponent.RSPanelBorderImage();
        pnlTopBar = new RSMaterialComponent.RSPanelMaterial();
        jLabel1 = new javax.swing.JLabel();
        rSLabelIcon1 = new RSMaterialComponent.RSLabelIcon();
        btnCerrar = new RSMaterialComponent.RSButtonIconOne();
        rSPanelMaterial1 = new RSMaterialComponent.RSPanelMaterial();
        pnlSlider = new newscomponents.RSPanelEffect();
        pnlUsuarios = new paneles.Usuarios();
        pnlCredenciales = new paneles.Administrador();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1457, 592));
        setMinimumSize(new java.awt.Dimension(1457, 592));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1457, 592));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(219, 231, 228));
        pnlMenu.setIntensity(5);
        pnlMenu.setRound(20);
        pnlMenu.setShadowLeft(false);
        pnlMenu.setShadowRight(false);

        jLNombre.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLNombre.setText("Administrador");

        btnAcercaDe.setBackground(new java.awt.Color(255, 153, 153));
        btnAcercaDe.setText("Cambiar contraseña");
        btnAcercaDe.setBackgroundHover(new java.awt.Color(255, 102, 102));
        btnAcercaDe.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SECURITY);
        btnAcercaDe.setRound(20);
        btnAcercaDe.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAcercaDeActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(253, 241, 205));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel2.setText("Navegación");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(253, 241, 205));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        btnUsuarios.setBackground(new java.awt.Color(255, 153, 153));
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBackgroundHover(new java.awt.Color(255, 102, 102));
        btnUsuarios.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PEOPLE);
        btnUsuarios.setRound(20);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUsuariosActionPerformed(evt);
            }
        });

        imagenDePerfil.setBackground(new java.awt.Color(255, 255, 255));
        imagenDePerfil.setImagen(new javax.swing.ImageIcon(getClass().getResource("/imagenes/autorized.png"))); // NOI18N
        imagenDePerfil.setShapePanel(rojeru_san.efectos.ValoresEnum.PANEL_FORMA.CIRCLE);

        javax.swing.GroupLayout imagenDePerfilLayout = new javax.swing.GroupLayout(imagenDePerfil);
        imagenDePerfil.setLayout(imagenDePerfilLayout);
        imagenDePerfilLayout.setHorizontalGroup(
            imagenDePerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        imagenDePerfilLayout.setVerticalGroup(
            imagenDePerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagenDePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenDePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 126, 230, 450));

        pnlTopBar.setBackground(new java.awt.Color(255, 102, 102));
        pnlTopBar.setIntensity(10);
        pnlTopBar.setRound(20);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cita Plus Administrador");

        rSLabelIcon1.setBackground(new java.awt.Color(255, 255, 255));
        rSLabelIcon1.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LIBRARY_BOOKS);
        rSLabelIcon1.setSizeIcon(50.0F);

        btnCerrar.setBackground(new java.awt.Color(255, 102, 102));
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.setBackgroundHover(new java.awt.Color(255, 160, 160));
        btnCerrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.KEYBOARD_ARROW_RIGHT);
        btnCerrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTopBarLayout = new javax.swing.GroupLayout(pnlTopBar);
        pnlTopBar.setLayout(pnlTopBarLayout);
        pnlTopBarLayout.setHorizontalGroup(
            pnlTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 909, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlTopBarLayout.setVerticalGroup(
            pnlTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSLabelIcon1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTopBarLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.add(pnlTopBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, -1, 130));

        rSPanelMaterial1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterial1.setIntensity(5);
        rSPanelMaterial1.setRound(10);

        pnlSlider.setBackground(new java.awt.Color(255, 255, 255));

        pnlUsuarios.setName("pnlUsuarios"); // NOI18N
        pnlSlider.add(pnlUsuarios, "card2");

        pnlCredenciales.setName("pnlCredenciales"); // NOI18N
        pnlSlider.add(pnlCredenciales, "card3");

        javax.swing.GroupLayout rSPanelMaterial1Layout = new javax.swing.GroupLayout(rSPanelMaterial1);
        rSPanelMaterial1.setLayout(rSPanelMaterial1Layout);
        rSPanelMaterial1Layout.setHorizontalGroup(
            rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                .addContainerGap())
        );
        rSPanelMaterial1Layout.setVerticalGroup(
            rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(rSPanelMaterial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 1200, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1000));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCerrarActionPerformed
    {//GEN-HEADEREND:event_btnCerrarActionPerformed
        dispose();
        new InicioSesion().setVisible(true);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUsuariosActionPerformed
    {//GEN-HEADEREND:event_btnUsuariosActionPerformed
        if (!btnUsuarios.isSelected())
        {
            btnUsuarios.setSelected(true);
            btnAcercaDe.setSelected(false);
            pnlSlider.setPanelNormal(pnlUsuarios);
        }
        
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnAcercaDeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAcercaDeActionPerformed
    {//GEN-HEADEREND:event_btnAcercaDeActionPerformed
        if (!btnAcercaDe.isSelected())
        {
            btnAcercaDe.setSelected(true);
            btnUsuarios.setSelected(false);
            pnlSlider.setPanelNormal(pnlCredenciales);
        }
    }//GEN-LAST:event_btnAcercaDeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MenuAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAcercaDe;
    public static RSMaterialComponent.RSButtonIconOne btnCerrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnUsuarios;
    private RSMaterialComponent.RSPanelBorderImage imagenDePerfil;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private paneles.Administrador pnlCredenciales;
    private RSMaterialComponent.RSPanelMaterial pnlMenu;
    private newscomponents.RSPanelEffect pnlSlider;
    private RSMaterialComponent.RSPanelMaterial pnlTopBar;
    private paneles.Usuarios pnlUsuarios;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon1;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    // End of variables declaration//GEN-END:variables
}
