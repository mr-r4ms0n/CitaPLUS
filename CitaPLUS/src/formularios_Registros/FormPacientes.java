/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios_Registros;

import RSMaterialComponent.RSTextFieldOne;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import rojeru_san.complementos.RSUtilities;
import metodosAux.*;
import metodosBD.MetodosBD;
import paneles.Pacientes;
import static paneles.Pacientes.tabSelecc;
import static paneles.Pacientes.tablaContenidoPacientes2;
import paneles.TablaContenidoPacientes;

/**
 *
 * @author David Vergara
 */
public class FormPacientes extends javax.swing.JDialog
{

    /**
     * Creates new form FormPacientes
     */
    File pic = null;

    public FormPacientes()
    {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        RSUtilities.setOpaqueWindow(this, false);
        RSUtilities.setOpacityComponent(pnlFondo, 150);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        setShape(forma);
        iniCampos();
        RSTextFieldOne rs[] =
        {
            nombre, apellidoMaterno, apellidoPaterno, telefono, correo
        };
        Validaciones.disableCP(rs);
    }

    /**
     * Método encargado de incializar los campos del formulario y los coloca por
     * default
     */
    public void iniCampos()
    {
        this.error_nombre.setForeground(Color.white);
        this.error_apellidoPaterno.setForeground(Color.white);
        this.error_apellidoMaterno.setForeground(Color.white);
        this.error_sexo.setForeground(Color.white);
        this.error_telefono.setForeground(Color.white);
        this.error_correo.setForeground(Color.white);
        this.nombre.setText(null);
        this.apellidoPaterno.setText(null);
        this.apellidoMaterno.setText(null);
        this.sexo.setSelectedIndex(0);
        this.telefono.setText(null);
        this.correo.setText(null);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new RSMaterialComponent.RSButtonIconOne();
        nombre = new RSMaterialComponent.RSTextFieldOne();
        jLabel2 = new javax.swing.JLabel();
        error_nombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        error_apellidoPaterno = new javax.swing.JLabel();
        apellidoPaterno = new RSMaterialComponent.RSTextFieldOne();
        apellidoMaterno = new RSMaterialComponent.RSTextFieldOne();
        jLabel5 = new javax.swing.JLabel();
        error_apellidoMaterno = new javax.swing.JLabel();
        telefono = new RSMaterialComponent.RSTextFieldOne();
        jLabel6 = new javax.swing.JLabel();
        error_telefono = new javax.swing.JLabel();
        correo = new RSMaterialComponent.RSTextFieldOne();
        jLabel7 = new javax.swing.JLabel();
        error_correo = new javax.swing.JLabel();
        sexo = new RSMaterialComponent.RSComboBox();
        jLabel8 = new javax.swing.JLabel();
        error_sexo = new javax.swing.JLabel();
        btnRegistrar = new newscomponents.RSButtonIcon_new();
        jlFoto = new javax.swing.JLabel();
        btnOpenFoto = new RSMaterialComponent.RSButtonIconOne();
        btnRemove = new RSMaterialComponent.RSButtonIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pnlFondo.setBackground(new java.awt.Color(0, 0, 0));

        rSPanelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelBorder1.setBgBorder(new java.awt.Color(68, 165, 160));

        jPanel1.setBackground(new java.awt.Color(68, 165, 160));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registrar Nuevo Paciente");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nombre.setForeground(new java.awt.Color(51, 51, 51));
        nombre.setBorderColor(new java.awt.Color(51, 51, 51));
        nombre.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        nombre.setPhColor(new java.awt.Color(51, 51, 51));
        nombre.setPlaceholder("Nombre");
        nombre.setSelectionColor(new java.awt.Color(51, 51, 51));
        nombre.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                nombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                nombreKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel2.setText("Nombre*");

        error_nombre.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        error_nombre.setText("Etiqueta de Error");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel3.setText("Apellido Paterno*");

        error_apellidoPaterno.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        error_apellidoPaterno.setText("Etiqueta de Error");

        apellidoPaterno.setForeground(new java.awt.Color(51, 51, 51));
        apellidoPaterno.setBorderColor(new java.awt.Color(51, 51, 51));
        apellidoPaterno.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        apellidoPaterno.setPhColor(new java.awt.Color(51, 51, 51));
        apellidoPaterno.setPlaceholder("Apellido Paterno");
        apellidoPaterno.setSelectionColor(new java.awt.Color(51, 51, 51));
        apellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                apellidoPaternoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                apellidoPaternoKeyTyped(evt);
            }
        });

        apellidoMaterno.setForeground(new java.awt.Color(51, 51, 51));
        apellidoMaterno.setBorderColor(new java.awt.Color(51, 51, 51));
        apellidoMaterno.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        apellidoMaterno.setPhColor(new java.awt.Color(51, 51, 51));
        apellidoMaterno.setPlaceholder("Apellido Materno");
        apellidoMaterno.setSelectionColor(new java.awt.Color(51, 51, 51));
        apellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                apellidoMaternoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                apellidoMaternoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel5.setText("Apellido Materno");

        error_apellidoMaterno.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        error_apellidoMaterno.setText("Etiqueta de Error");

        telefono.setForeground(new java.awt.Color(51, 51, 51));
        telefono.setBorderColor(new java.awt.Color(51, 51, 51));
        telefono.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        telefono.setPhColor(new java.awt.Color(51, 51, 51));
        telefono.setPlaceholder("Teléfono");
        telefono.setSelectionColor(new java.awt.Color(51, 51, 51));
        telefono.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                telefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                telefonoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel6.setText("Teléfono");

        error_telefono.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        error_telefono.setText("Etiqueta de Error");

        correo.setForeground(new java.awt.Color(51, 51, 51));
        correo.setBorderColor(new java.awt.Color(51, 51, 51));
        correo.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        correo.setPhColor(new java.awt.Color(51, 51, 51));
        correo.setPlaceholder("Correo");
        correo.setSelectionColor(new java.awt.Color(51, 51, 51));
        correo.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                correoKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel7.setText("Correo");

        error_correo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        error_correo.setText("Etiqueta de Error");

        sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Sexo", "Hombre", "Mujer" }));
        sexo.setColorArrow(new java.awt.Color(68, 165, 160));
        sexo.setColorBorde(new java.awt.Color(68, 165, 160));
        sexo.setColorFondo(new java.awt.Color(68, 165, 160));
        sexo.setColorSeleccion(new java.awt.Color(68, 165, 160));
        sexo.setDisabledIdex("0");
        sexo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        sexo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sexoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel8.setText("Sexo*");

        error_sexo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        error_sexo.setText("Etiqueta de Error");

        btnRegistrar.setBackground(new java.awt.Color(68, 165, 160));
        btnRegistrar.setText("Registar Paciente");
        btnRegistrar.setBackgroundHover(new java.awt.Color(57, 140, 136));
        btnRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnRegistrar.setRound(20);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRegistrarActionPerformed(evt);
            }
        });

        jlFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        btnOpenFoto.setBackground(new java.awt.Color(68, 165, 160));
        btnOpenFoto.setToolTipText("Buscar foto");
        btnOpenFoto.setBackgroundHover(new java.awt.Color(57, 140, 136));
        btnOpenFoto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FOLDER_OPEN);
        btnOpenFoto.setRound(5);
        btnOpenFoto.setSizeIcon(25.0F);
        btnOpenFoto.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOpenFotoActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(102, 102, 102));
        btnRemove.setToolTipText("Remover foto");
        btnRemove.setBackgroundHover(new java.awt.Color(117, 116, 116));
        btnRemove.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.RESTORE);
        btnRemove.setRound(5);
        btnRemove.setSizeIcon(25.0F);
        btnRemove.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelBorder1Layout = new javax.swing.GroupLayout(rSPanelBorder1);
        rSPanelBorder1.setLayout(rSPanelBorder1Layout);
        rSPanelBorder1Layout.setHorizontalGroup(
            rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelBorder1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                                .addComponent(btnOpenFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(apellidoPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(error_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(error_apellidoPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9))
                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                        .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                                .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(apellidoMaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(error_apellidoMaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(error_telefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(telefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(sexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(correo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(error_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(error_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        rSPanelBorder1Layout.setVerticalGroup(
            rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(error_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(error_apellidoPaterno))
                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                        .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOpenFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelBorder1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(sexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(error_correo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelBorder1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(error_apellidoMaterno)
                            .addComponent(error_sexo))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(error_telefono)))
                .addGap(43, 43, 43)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSPanelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSPanelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sexoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sexoActionPerformed
    {//GEN-HEADEREND:event_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRegistrarActionPerformed
    {//GEN-HEADEREND:event_btnRegistrarActionPerformed
        boolean nombreCorrect = MetodosAux.validarFormu(nombre, error_nombre, "required");
        boolean apePCorrect = MetodosAux.validarFormu(apellidoPaterno, error_apellidoPaterno, "required");
        boolean sexoCorrect = MetodosAux.validarBox(sexo, error_sexo, "required");
        FileInputStream imgPerf = null;
        if (nombreCorrect && apePCorrect && sexoCorrect)
        {
            try
            {
                if (pic != null)
                {
                    //Si la foto es por defecto
                    imgPerf = new FileInputStream(pic);
                } else
                {
                    //Dependiendo si es hombre o mujer cargamos una foto por defecto
                    imgPerf = new FileInputStream(new File("./default/"+sexo.getSelectedItem().toString()+".png"));
                }
            } catch (FileNotFoundException ex)
            {
                System.out.println("Error al transformar la imagen: " + ex);
            }
            //Si la foto la selecciona el usuario

            Object[] datosInsert =
            {
                imgPerf, nombre.getText().trim(), apellidoPaterno.getText().trim(), apellidoMaterno.getText().trim(),
                sexo.getSelectedItem().toString(), telefono.getText().trim(), correo.getText().trim()
            };

            boolean insercionCorr = MetodosBD.insertarPaciente(datosInsert);
            if (insercionCorr)
            {
                dispose();
                //Actualizamos los usuariosd de las tablas
                TablaContenidoPacientes.listarPacientes(tablaContenidoPacientes2.tblCitas, tabSelecc, null);
                //Actualizamos el contador
                Pacientes.actualizarNumPacientes();
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCerrarActionPerformed
    {//GEN-HEADEREND:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_nombreKeyTyped
    {//GEN-HEADEREND:event_nombreKeyTyped
        if (nombre.getText().length() >= 25)
        {
            evt.consume();
        }
        setTransferHandler(null);
        Validaciones.entradaLetrasNum(evt, 1);
    }//GEN-LAST:event_nombreKeyTyped

    private void apellidoPaternoKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_apellidoPaternoKeyTyped
    {//GEN-HEADEREND:event_apellidoPaternoKeyTyped
        if (apellidoPaterno.getText().length() >= 25)
        {
            evt.consume();
        }
        setTransferHandler(null);
        Validaciones.entradaLetrasNum(evt, 1);
    }//GEN-LAST:event_apellidoPaternoKeyTyped

    private void apellidoMaternoKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_apellidoMaternoKeyTyped
    {//GEN-HEADEREND:event_apellidoMaternoKeyTyped
        if (apellidoMaterno.getText().length() >= 25)
        {
            evt.consume();
        }
        Validaciones.entradaLetrasNum(evt, 1);
    }//GEN-LAST:event_apellidoMaternoKeyTyped

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_telefonoKeyTyped
    {//GEN-HEADEREND:event_telefonoKeyTyped
        if (telefono.getText().length() >= 11)
        {
            evt.consume();
        }
        Validaciones.entradaLetrasNum(evt, 2);
    }//GEN-LAST:event_telefonoKeyTyped

    private void correoKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_correoKeyTyped
    {//GEN-HEADEREND:event_correoKeyTyped
        if (correo.getText().length() >= 40)
        {
            evt.consume();
        }
        setTransferHandler(null);
    }//GEN-LAST:event_correoKeyTyped

    private void nombreKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_nombreKeyReleased
    {//GEN-HEADEREND:event_nombreKeyReleased

    }//GEN-LAST:event_nombreKeyReleased

    private void apellidoPaternoKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_apellidoPaternoKeyReleased
    {//GEN-HEADEREND:event_apellidoPaternoKeyReleased

    }//GEN-LAST:event_apellidoPaternoKeyReleased

    private void apellidoMaternoKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_apellidoMaternoKeyReleased
    {//GEN-HEADEREND:event_apellidoMaternoKeyReleased

    }//GEN-LAST:event_apellidoMaternoKeyReleased

    private void telefonoKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_telefonoKeyReleased
    {//GEN-HEADEREND:event_telefonoKeyReleased

    }//GEN-LAST:event_telefonoKeyReleased

    private void btnOpenFotoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnOpenFotoActionPerformed
    {//GEN-HEADEREND:event_btnOpenFotoActionPerformed
        pic = MetodosAux.getFoto(this);
        if (pic != null)
        {
            rsscalelabel.RSScaleLabel.setScaleLabel(jlFoto, pic.getAbsolutePath());
            System.out.println(pic.getAbsolutePath());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpenFotoActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRemoveActionPerformed
    {//GEN-HEADEREND:event_btnRemoveActionPerformed
        pic = null;
        jlFoto.setIcon(null);
    }//GEN-LAST:event_btnRemoveActionPerformed

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
            java.util.logging.Logger.getLogger(FormPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FormPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FormPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FormPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new FormPacientes().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSTextFieldOne apellidoMaterno;
    private RSMaterialComponent.RSTextFieldOne apellidoPaterno;
    private RSMaterialComponent.RSButtonIconOne btnCerrar;
    private RSMaterialComponent.RSButtonIconOne btnOpenFoto;
    private newscomponents.RSButtonIcon_new btnRegistrar;
    private RSMaterialComponent.RSButtonIconOne btnRemove;
    private RSMaterialComponent.RSTextFieldOne correo;
    private javax.swing.JLabel error_apellidoMaterno;
    private javax.swing.JLabel error_apellidoPaterno;
    private javax.swing.JLabel error_correo;
    private javax.swing.JLabel error_nombre;
    private javax.swing.JLabel error_sexo;
    private javax.swing.JLabel error_telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlFoto;
    private RSMaterialComponent.RSTextFieldOne nombre;
    private javax.swing.JPanel pnlFondo;
    private RSMaterialComponent.RSPanelBorder rSPanelBorder1;
    private RSMaterialComponent.RSComboBox sexo;
    private RSMaterialComponent.RSTextFieldOne telefono;
    // End of variables declaration//GEN-END:variables
}
