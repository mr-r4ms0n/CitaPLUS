/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios_Detalles;

import interfaces.MenuPrincipal;
import java.awt.Color;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import rojeru_san.complementos.RSUtilities;
import metodosAux.*;
import metodosBD.MetodosBD;
import paneles.Pacientes;
import static paneles.Pacientes.actualizarNumPacientes;
import static paneles.Pacientes.tabSelecc;
import static paneles.Pacientes.tablaContenidoPacientes2;
import paneles.TablaContenidoPacientes;
import static paneles.TablaContenidoPacientes.listarPacientes;
import rojeru_san.complementos.RSEffectFade;
import rojeru_san.efectos.ValoresEnum;

/**
 *
 * @author David Vergara
 */
public class InfoUsuarios extends javax.swing.JDialog
{

    RSObjectArray arregloDatos = new RSObjectArray();
    BufferedImage img1;

    /**
     * Creates new form FormPacientes
     */
    public InfoUsuarios(java.awt.Frame parent, boolean modal, RSObjectArray datos)
    {
        super(parent, modal);
        this.arregloDatos = datos;
        //RSUtilities.setFullScreenJFrame(this);
        initComponents();
        RSEffectFade.setFadeWindowIn(this, 30, 0.3f);
        RSUtilities.setCenterWindow(this);
        RSUtilities.setOpaqueWindow(this, false);
        RSUtilities.setOpacityComponent(this.pnlFondo, 150);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        setShape(forma);

        try
        {
            byte[] imagP = (byte[]) arregloDatos.getValue("foto");
            img1 = ImageIO.read(new ByteArrayInputStream(imagP));
            ImageIcon icon1 = new ImageIcon(img1.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
            lblFoto.setImagen(icon1);

            lblNombre.setText((!arregloDatos.getValue("apellidoMaterno").equals("No Proporcionado"))
                    ? (String) arregloDatos.getValue("nombre") + " " + (String) arregloDatos.getValue("apellidoPaterno") + " " + (String) arregloDatos.getValue("apellidoMaterno")
                    : (String) arregloDatos.getValue("nombre") + " " + (String) arregloDatos.getValue("apellidoPaterno"));

            lblSexo.setText((String) arregloDatos.getValue("sexo"));
            lblTelefono.setText((String) arregloDatos.getValue("telefono"));
            lblCorreo.setText((String) arregloDatos.getValue("correo"));
            lblEstatus.setText((String) arregloDatos.getValue("estatus"));

            lblEstatus.setForeground((arregloDatos.getValue("estatus").equals("Activo")) ? new Color(151, 194, 129) : new Color(216, 43, 43));
            rSLabelTextIcon6.setForeground((arregloDatos.getValue("estatus").equals("Activo")) ? new Color(151, 194, 129) : new Color(216, 43, 43));

            //Le ponemos el color al boton segun sea el caso del estatus
            btnEstatus.setBackground((arregloDatos.getValue("estatus").equals("Activo")) ? new Color(216, 43, 43) : new Color(151, 194, 129));
            btnEstatus.setBackgroundHover((arregloDatos.getValue("estatus").equals("Activo")) ? new Color(216, 43, 43) : new Color(151, 194, 129));
            //Le ponemos el texto al boton segun sea el caso del estatus
            btnEstatus.setText((arregloDatos.getValue("estatus").equals("Activo")) ? "Inhabilitar" : "Habilitar");

            btnEstatus.setIcons((arregloDatos.getValue("estatus").equals("Activo")) ? ValoresEnum.ICONS.RADIO_BUTTON_UNCHECKED : ValoresEnum.ICONS.RADIO_BUTTON_CHECKED);
        } catch (IOException ex)
        {
            System.out.println("Error, no se ha podido renderizar la imagen :" + ex);
        }
    }

    public InfoUsuarios(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        RSEffectFade.setFadeWindowIn(this, 30, 0.3f);
        RSUtilities.setCenterWindow(this);
        RSUtilities.setOpaqueWindow(this, false);
        RSUtilities.setOpacityComponent(this.pnlFondo, 150);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        setShape(forma);
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

        pnlFondo = new javax.swing.JPanel();
        rSPanelBorder1 = new RSMaterialComponent.RSPanelBorder();
        btnEstatus = new newscomponents.RSButtonIcon_new();
        lblFoto = new RSMaterialComponent.RSPanelMaterialImage();
        rSPanelBorderGradient1 = new RSMaterialComponent.RSPanelBorderGradient();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new RSMaterialComponent.RSButtonIconOne();
        lblNombre = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        rSPanelBorder2 = new RSMaterialComponent.RSPanelBorder();
        rSLabelTextIcon6 = new RSMaterialComponent.RSLabelTextIcon();
        lblEstatus = new javax.swing.JLabel();
        rSPanelBorder3 = new RSMaterialComponent.RSPanelBorder();
        rSLabelTextIcon8 = new RSMaterialComponent.RSLabelTextIcon();
        lblTelefono = new javax.swing.JLabel();
        rSPanelBorder4 = new RSMaterialComponent.RSPanelBorder();
        rSLabelTextIcon9 = new RSMaterialComponent.RSLabelTextIcon();
        lblCorreo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        pnlFondo.setBackground(new java.awt.Color(0, 0, 0));

        rSPanelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelBorder1.setBgBorder(new java.awt.Color(204, 182, 128));
        rSPanelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEstatus.setBackground(new java.awt.Color(216, 43, 43));
        btnEstatus.setText("Inhabilitar");
        btnEstatus.setBackgroundHover(new java.awt.Color(255, 51, 51));
        btnEstatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEstatus.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEstatus.setRound(20);
        btnEstatus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEstatusActionPerformed(evt);
            }
        });
        rSPanelBorder1.add(btnEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 580, 119, 41));

        lblFoto.setBackground(new java.awt.Color(255, 255, 255));
        lblFoto.setBgShade(new java.awt.Color(102, 102, 102));
        lblFoto.setImagen(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Hombre.png"))); // NOI18N
        lblFoto.setShapePanel(rojeru_san.efectos.ValoresEnum.PANEL_FORMA.CIRCLE);

        javax.swing.GroupLayout lblFotoLayout = new javax.swing.GroupLayout(lblFoto);
        lblFoto.setLayout(lblFotoLayout);
        lblFotoLayout.setHorizontalGroup(
            lblFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        lblFotoLayout.setVerticalGroup(
            lblFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );

        rSPanelBorder1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        rSPanelBorderGradient1.setBgShade(new java.awt.Color(204, 182, 128));
        rSPanelBorderGradient1.setColorPrimario(new java.awt.Color(144, 224, 239));
        rSPanelBorderGradient1.setColorSecundario(new java.awt.Color(204, 182, 128));
        rSPanelBorderGradient1.setGradiente(RSMaterialComponent.RSPanelBorderGradient.Gradiente.CIRCULAR);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("Información del Paciente");

        btnCerrar.setBackground(new java.awt.Color(216, 43, 43));
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.setBackgroundHover(new java.awt.Color(255, 51, 51));
        btnCerrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnCerrar.setRound(50);
        btnCerrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelBorderGradient1Layout = new javax.swing.GroupLayout(rSPanelBorderGradient1);
        rSPanelBorderGradient1.setLayout(rSPanelBorderGradient1Layout);
        rSPanelBorderGradient1Layout.setHorizontalGroup(
            rSPanelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelBorderGradient1Layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(158, 158, 158)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        rSPanelBorderGradient1Layout.setVerticalGroup(
            rSPanelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelBorderGradient1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(rSPanelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        rSPanelBorder1.add(rSPanelBorderGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 664, 180));

        lblNombre.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre");
        rSPanelBorder1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 279, 650, 40));

        lblSexo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblSexo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSexo.setText("Sexo");
        rSPanelBorder1.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 295, 40));

        rSPanelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelBorder2.setBgBorder(new java.awt.Color(204, 182, 128));
        rSPanelBorder2.setBorderTop(false);

        rSLabelTextIcon6.setForeground(new java.awt.Color(51, 51, 51));
        rSLabelTextIcon6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        rSLabelTextIcon6.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.RADIO_BUTTON_CHECKED);
        rSLabelTextIcon6.setSizeIcon(30.0F);

        lblEstatus.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblEstatus.setForeground(new java.awt.Color(153, 153, 153));
        lblEstatus.setText("Estatus");

        javax.swing.GroupLayout rSPanelBorder2Layout = new javax.swing.GroupLayout(rSPanelBorder2);
        rSPanelBorder2.setLayout(rSPanelBorder2Layout);
        rSPanelBorder2Layout.setHorizontalGroup(
            rSPanelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelTextIcon6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(316, Short.MAX_VALUE))
        );
        rSPanelBorder2Layout.setVerticalGroup(
            rSPanelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelBorder2Layout.createSequentialGroup()
                .addGroup(rSPanelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelTextIcon6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelBorder1.add(rSPanelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, -1, 50));

        rSPanelBorder3.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelBorder3.setBgBorder(new java.awt.Color(204, 182, 128));

        rSLabelTextIcon8.setForeground(new java.awt.Color(51, 51, 51));
        rSLabelTextIcon8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        rSLabelTextIcon8.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PHONE);
        rSLabelTextIcon8.setSizeIcon(30.0F);

        lblTelefono.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(153, 153, 153));
        lblTelefono.setText("Telefono");

        javax.swing.GroupLayout rSPanelBorder3Layout = new javax.swing.GroupLayout(rSPanelBorder3);
        rSPanelBorder3.setLayout(rSPanelBorder3Layout);
        rSPanelBorder3Layout.setHorizontalGroup(
            rSPanelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelTextIcon8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
        );
        rSPanelBorder3Layout.setVerticalGroup(
            rSPanelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelTextIcon8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelBorder1.add(rSPanelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, 60));

        rSPanelBorder4.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelBorder4.setBgBorder(new java.awt.Color(204, 182, 128));
        rSPanelBorder4.setBorderTop(false);

        rSLabelTextIcon9.setForeground(new java.awt.Color(51, 51, 51));
        rSLabelTextIcon9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        rSLabelTextIcon9.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EMAIL);
        rSLabelTextIcon9.setSizeIcon(30.0F);

        lblCorreo.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(153, 153, 153));
        lblCorreo.setText("Correo");

        javax.swing.GroupLayout rSPanelBorder4Layout = new javax.swing.GroupLayout(rSPanelBorder4);
        rSPanelBorder4.setLayout(rSPanelBorder4Layout);
        rSPanelBorder4Layout.setHorizontalGroup(
            rSPanelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelTextIcon9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(316, Short.MAX_VALUE))
        );
        rSPanelBorder4Layout.setVerticalGroup(
            rSPanelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelTextIcon9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelBorder1.add(rSPanelBorder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, 60));

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEstatusActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEstatusActionPerformed
    {//GEN-HEADEREND:event_btnEstatusActionPerformed

        int newEstatus = (arregloDatos.getValue("estatus").equals("Activo") ? 2 : 1);
        boolean resultado = MetodosBD.actualizarEstatusPaciente((int) arregloDatos.getValue("id"), newEstatus);
        if (resultado)
        {
            dispose();
            TablaContenidoPacientes.listarPacientes(tablaContenidoPacientes2.tblPacientes, tabSelecc, null);
            actualizarNumPacientes();
            if (newEstatus == 1)
            {
                MetodosAux.mostrarAlerta("Muy bien hecho", "Paciente Activado con Exito", 1);
            } else
            {
                if (newEstatus == 2)
                {
                    MetodosAux.mostrarAlerta("Muy bien hecho", "Paciente Desactivado con Exito", 1);
                } else
                {
                    MetodosAux.mostrarAlerta("Error", "No se pudo completar la acción", 2);
                }

            }
        }

    }//GEN-LAST:event_btnEstatusActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCerrarActionPerformed
    {//GEN-HEADEREND:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

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
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(InfoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(InfoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(InfoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(InfoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                InfoUsuarios dialog = new InfoUsuarios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonIconOne btnCerrar;
    private newscomponents.RSButtonIcon_new btnEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblEstatus;
    private RSMaterialComponent.RSPanelMaterialImage lblFoto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel pnlFondo;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon6;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon8;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon9;
    private RSMaterialComponent.RSPanelBorder rSPanelBorder1;
    private RSMaterialComponent.RSPanelBorder rSPanelBorder2;
    private RSMaterialComponent.RSPanelBorder rSPanelBorder3;
    private RSMaterialComponent.RSPanelBorder rSPanelBorder4;
    private RSMaterialComponent.RSPanelBorderGradient rSPanelBorderGradient1;
    // End of variables declaration//GEN-END:variables
}
