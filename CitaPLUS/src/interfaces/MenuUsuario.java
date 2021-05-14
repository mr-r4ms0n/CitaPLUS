/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import rojeru_san.complementos.RSEffectFade;

/**
 *
 * @author David Vergara
 */
public class MenuUsuario extends javax.swing.JFrame
{

    public static JFrame vtn;
    public static int idUsuario;

    /**
     * Creates new form MenuPrincipal
     *
     * @param usuario
     * @param nombre
     * @param foto
     */
    public MenuUsuario(String usuario, String nombre, byte[] foto, int idUsuario)
    {
        initComponents();
        this.idUsuario = idUsuario;
        setIconImage(Toolkit.getDefaultToolkit().getImage("citasplus.png"));
        vtn = this;
        RSEffectFade.setFadeWindowIn(this, 30, 0.1f);
        setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        setShape(forma);
        //Establecemos los campos segun esto corresponda de lo que se encontro registrado en la BD
        jLNombre.setText(nombre);
        jLUsuario.setText(usuario);
        try
        {
            BufferedImage img1;
            img1 = ImageIO.read(new ByteArrayInputStream(foto));
            ImageIcon icon1 = new ImageIcon(img1.getScaledInstance(imagenDePerfil.getWidth(), imagenDePerfil.getHeight(), Image.SCALE_DEFAULT));
            imagenDePerfil.setImagen(icon1);
        } catch (IOException ex)
        {
            System.err.println("Error al insertar la foto desde la base de datos en el panel de edicion de informacion");
        }
    }

    private MenuUsuario()
    {

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
        imagenDePerfil = new RSMaterialComponent.RSPanelBorderImage();
        jLNombre = new javax.swing.JLabel();
        btnInicio = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCitas = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnPacientes = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnServicios = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAcercaDe = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLUsuario = new javax.swing.JLabel();
        pnlTopBar = new RSMaterialComponent.RSPanelMaterial();
        jLabel1 = new javax.swing.JLabel();
        rSLabelIcon1 = new RSMaterialComponent.RSLabelIcon();
        btnCerrar = new RSMaterialComponent.RSButtonIconOne();
        rSPanelMaterial1 = new RSMaterialComponent.RSPanelMaterial();
        pnlSlider = new newscomponents.RSPanelEffect();
        pnlInicio = new paneles.Inicio();
        pnlCitas = new paneles.Citas();
        pnlPacientes = new paneles.Pacientes();
        pnlServicios = new paneles.Servicios();
        pnlAcercaDe = new paneles.AcercaDe();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(219, 231, 228));
        pnlMenu.setIntensity(5);
        pnlMenu.setRound(20);
        pnlMenu.setShadowLeft(false);
        pnlMenu.setShadowRight(false);

        imagenDePerfil.setBackground(new java.awt.Color(255, 255, 255));
        imagenDePerfil.setImagen(new javax.swing.ImageIcon(getClass().getResource("/imagenes/doctor.png"))); // NOI18N
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

        jLNombre.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLNombre.setText("NombreN");

        btnInicio.setBackground(new java.awt.Color(112, 190, 186));
        btnInicio.setText("Inicio");
        btnInicio.setBackgroundHover(new java.awt.Color(178, 218, 216));
        btnInicio.setRound(20);
        btnInicio.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnInicioActionPerformed(evt);
            }
        });

        btnCitas.setBackground(new java.awt.Color(68, 165, 160));
        btnCitas.setText("Citas registradas");
        btnCitas.setBackgroundHover(new java.awt.Color(178, 218, 216));
        btnCitas.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.RECEIPT);
        btnCitas.setRound(20);
        btnCitas.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCitasActionPerformed(evt);
            }
        });

        btnPacientes.setBackground(new java.awt.Color(68, 165, 160));
        btnPacientes.setText("Pacientes");
        btnPacientes.setBackgroundHover(new java.awt.Color(178, 218, 216));
        btnPacientes.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON);
        btnPacientes.setRound(20);
        btnPacientes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPacientesActionPerformed(evt);
            }
        });

        btnServicios.setBackground(new java.awt.Color(68, 165, 160));
        btnServicios.setText("Servicios");
        btnServicios.setBackgroundHover(new java.awt.Color(178, 218, 216));
        btnServicios.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.NEW_RELEASES);
        btnServicios.setRound(20);
        btnServicios.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnServiciosActionPerformed(evt);
            }
        });

        btnAcercaDe.setBackground(new java.awt.Color(68, 165, 160));
        btnAcercaDe.setText("Acerda De");
        btnAcercaDe.setBackgroundHover(new java.awt.Color(178, 218, 216));
        btnAcercaDe.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.INFO);
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

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel4.setText("Extras");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLUsuario.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLUsuario.setText("UsuarioN");

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMenuLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(imagenDePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jLUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnServicios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(btnPacientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCitas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(imagenDePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );

        jPanel1.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 126, 230, 870));

        pnlTopBar.setBackground(new java.awt.Color(144, 224, 239));
        pnlTopBar.setIntensity(10);
        pnlTopBar.setRound(20);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cita Plus Usuario");

        rSLabelIcon1.setBackground(new java.awt.Color(255, 255, 255));
        rSLabelIcon1.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LIBRARY_BOOKS);
        rSLabelIcon1.setSizeIcon(50.0F);

        btnCerrar.setBackground(new java.awt.Color(144, 224, 239));
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.setBackgroundHover(new java.awt.Color(159, 221, 234));
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1024, Short.MAX_VALUE)
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

        pnlInicio.setName("pnlInicio"); // NOI18N

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
        );

        pnlSlider.add(pnlInicio, "card5");

        pnlCitas.setName("pnlCitas"); // NOI18N
        pnlSlider.add(pnlCitas, "card2");

        pnlPacientes.setName("pnlPacientes"); // NOI18N
        pnlSlider.add(pnlPacientes, "card3");

        pnlServicios.setName("pnlServicios"); // NOI18N
        pnlSlider.add(pnlServicios, "card4");

        pnlAcercaDe.setName("pnlAcercaDe"); // NOI18N

        javax.swing.GroupLayout pnlAcercaDeLayout = new javax.swing.GroupLayout(pnlAcercaDe);
        pnlAcercaDe.setLayout(pnlAcercaDeLayout);
        pnlAcercaDeLayout.setHorizontalGroup(
            pnlAcercaDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        pnlAcercaDeLayout.setVerticalGroup(
            pnlAcercaDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
        );

        pnlSlider.add(pnlAcercaDe, "card6");

        javax.swing.GroupLayout rSPanelMaterial1Layout = new javax.swing.GroupLayout(rSPanelMaterial1);
        rSPanelMaterial1.setLayout(rSPanelMaterial1Layout);
        rSPanelMaterial1Layout.setHorizontalGroup(
            rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        rSPanelMaterial1Layout.setVerticalGroup(
            rSPanelMaterial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterial1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(rSPanelMaterial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 1200, 860));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1000));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCerrarActionPerformed
    {//GEN-HEADEREND:event_btnCerrarActionPerformed
        dispose();
        new InicioSesion().setVisible(true);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCitasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCitasActionPerformed
    {//GEN-HEADEREND:event_btnCitasActionPerformed
        if (!btnCitas.isSelected())
        {
            btnCitas.setSelected(true);
            btnInicio.setSelected(false);
            btnPacientes.setSelected(false);
            btnServicios.setSelected(false);
            btnAcercaDe.setSelected(false);

            pnlSlider.setPanelNormal(pnlCitas);
        }
    }//GEN-LAST:event_btnCitasActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnInicioActionPerformed
    {//GEN-HEADEREND:event_btnInicioActionPerformed
        if (!btnInicio.isSelected())
        {
            btnInicio.setSelected(true);
            btnCitas.setSelected(false);
            btnPacientes.setSelected(false);
            btnServicios.setSelected(false);
            btnAcercaDe.setSelected(false);

            pnlSlider.setPanelNormal(pnlInicio);
        }
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPacientesActionPerformed
    {//GEN-HEADEREND:event_btnPacientesActionPerformed
        if (!btnPacientes.isSelected())
        {
            btnPacientes.setSelected(true);
            btnCitas.setSelected(false);
            btnInicio.setSelected(false);
            btnServicios.setSelected(false);
            btnAcercaDe.setSelected(false);

            pnlSlider.setPanelNormal(pnlPacientes);
        }

    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnServiciosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnServiciosActionPerformed
    {//GEN-HEADEREND:event_btnServiciosActionPerformed
        if (!btnServicios.isSelected())
        {
            btnServicios.setSelected(true);
            btnCitas.setSelected(false);
            btnPacientes.setSelected(false);
            btnInicio.setSelected(false);
            btnAcercaDe.setSelected(false);

            pnlSlider.setPanelNormal(pnlServicios);
        }

    }//GEN-LAST:event_btnServiciosActionPerformed

    private void btnAcercaDeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAcercaDeActionPerformed
    {//GEN-HEADEREND:event_btnAcercaDeActionPerformed
        if (!btnAcercaDe.isSelected())
        {
            btnAcercaDe.setSelected(true);
            btnCitas.setSelected(false);
            btnPacientes.setSelected(false);
            btnServicios.setSelected(false);
            btnInicio.setSelected(false);

            pnlSlider.setPanelNormal(pnlAcercaDe);
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
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MenuUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAcercaDe;
    private RSMaterialComponent.RSButtonIconOne btnCerrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCitas;
    private RSMaterialComponent.RSButtonMaterialIconOne btnInicio;
    private RSMaterialComponent.RSButtonMaterialIconOne btnPacientes;
    private RSMaterialComponent.RSButtonMaterialIconOne btnServicios;
    private RSMaterialComponent.RSPanelBorderImage imagenDePerfil;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private paneles.AcercaDe pnlAcercaDe;
    private paneles.Citas pnlCitas;
    private paneles.Inicio pnlInicio;
    private RSMaterialComponent.RSPanelMaterial pnlMenu;
    public static paneles.Pacientes pnlPacientes;
    private paneles.Servicios pnlServicios;
    private newscomponents.RSPanelEffect pnlSlider;
    private RSMaterialComponent.RSPanelMaterial pnlTopBar;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon1;
    private RSMaterialComponent.RSPanelMaterial rSPanelMaterial1;
    // End of variables declaration//GEN-END:variables
}
