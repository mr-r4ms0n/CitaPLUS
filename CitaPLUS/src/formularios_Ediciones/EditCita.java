/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios_Ediciones;

import interfaces.MenuUsuario;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.Date;
import java.sql.Time;
import metodosAux.MetodosAux;
import metodosAux.RSObjectArray;
import metodosAux.Validaciones;
import metodosBD.MetodosBD;
import paneles.Citas;
import static paneles.Citas.tabSelecc;
import static paneles.Citas.tablaContenidoCitas21;
import peticionesHTTPS.POST;
import rojeru_san.complementos.RSUtilities;

/**
 *
 * @author David Vergara
 */
public class EditCita extends javax.swing.JDialog
{

    boolean pacientCorrect = true;
    boolean serviceCorrect = true;
    boolean horaCorrect = true;
    boolean atenderaCorrect = true;
    boolean fechaCorrect = true;

    int id;

    public EditCita(RSObjectArray datos)
    {

        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        RSUtilities.setOpaqueWindow(this, false);
        RSUtilities.setOpacityComponent(pnlFondo, 150);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        setShape(forma);
        MetodosBD.mostrarDatosCombo(CMPaciente, "pacientes");
        MetodosBD.mostrarDatosCombo(CMServicio, "servicios");
        MetodosBD.mostrarDatosCombo(CMAtendera, "medicos");
        iniCampos();

        //Rellenamos los campos
        id = (int) datos.getValue("id");
        CMPaciente.setSelectedItem(datos.getValue("nombrePaciente"));
        CMHora.setSelectedItem(datos.getValue("horaCita"));
        CMAtendera.setSelectedItem(datos.getValue("nombreUsuario"));
        CMServicio.setSelectedItem(datos.getValue("nombreServicio"));
        CMFecha.setText(MetodosAux.ToDate(datos.getValue("fechaCita").toString()));
        //Para inhabilitar que se cambie al paciente, en su lugar se tendra que hacer una cita nueva
        CMPaciente.setEnabled(false);
    }

    private EditCita()
    {

    }

    /**
     * Método encargado de incializar los campos del formulario y los coloca por
     * default
     */
    public void iniCampos()
    {
        this.error_paciente.setForeground(Color.white);
        this.error_fecha.setForeground(Color.white);
        this.error_hora.setForeground(Color.white);
        this.error_servicio.setForeground(Color.white);
        this.error_atendera.setForeground(Color.white);
        this.CMHora.setSelectedIndex(0);
        this.CMPaciente.setSelectedIndex(0);
        this.CMAtendera.setSelectedIndex(0);
        this.CMServicio.setSelectedIndex(0);
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
        CMPaciente = new RSMaterialComponent.RSComboBox();
        jLabel8 = new javax.swing.JLabel();
        error_paciente = new javax.swing.JLabel();
        btnModificar = new newscomponents.RSButtonIcon_new();
        jLabel9 = new javax.swing.JLabel();
        error_hora = new javax.swing.JLabel();
        CMHora = new RSMaterialComponent.RSComboBox();
        jLabel10 = new javax.swing.JLabel();
        error_fecha = new javax.swing.JLabel();
        error_servicio = new javax.swing.JLabel();
        CMServicio = new RSMaterialComponent.RSComboBox();
        jLabel11 = new javax.swing.JLabel();
        error_atendera = new javax.swing.JLabel();
        CMAtendera = new RSMaterialComponent.RSComboBox();
        jLabel12 = new javax.swing.JLabel();
        rSPanelMaterialGradient1 = new RSMaterialComponent.RSPanelMaterialGradient();
        btnCerrar = new RSMaterialComponent.RSButtonIconOne();
        jLabel1 = new javax.swing.JLabel();
        CMFecha = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pnlFondo.setBackground(new java.awt.Color(0, 0, 0));

        rSPanelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelBorder1.setBgBorder(new java.awt.Color(26, 117, 159));

        CMPaciente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        CMPaciente.setColorArrow(new java.awt.Color(26, 117, 159));
        CMPaciente.setColorBorde(new java.awt.Color(26, 117, 159));
        CMPaciente.setColorFondo(new java.awt.Color(26, 117, 159));
        CMPaciente.setColorSeleccion(new java.awt.Color(26, 117, 159));
        CMPaciente.setDisabledIdex("0");
        CMPaciente.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        CMPaciente.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                CMPacienteItemStateChanged(evt);
            }
        });
        CMPaciente.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CMPacienteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel8.setText("Fecha cita*");

        error_paciente.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        error_paciente.setText("Etiqueta de Error");

        btnModificar.setBackground(new java.awt.Color(68, 165, 160));
        btnModificar.setText("Guardar Cambios");
        btnModificar.setBackgroundHover(new java.awt.Color(57, 140, 136));
        btnModificar.setEnabled(false);
        btnModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnModificar.setRound(20);
        btnModificar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel9.setText("Hora cita*");

        error_hora.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        error_hora.setText("Etiqueta de Error");

        CMHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "07:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30" }));
        CMHora.setColorArrow(new java.awt.Color(26, 117, 159));
        CMHora.setColorBorde(new java.awt.Color(26, 117, 159));
        CMHora.setColorFondo(new java.awt.Color(26, 117, 159));
        CMHora.setColorSeleccion(new java.awt.Color(26, 117, 159));
        CMHora.setDisabledIdex("0");
        CMHora.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        CMHora.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                CMHoraItemStateChanged(evt);
            }
        });
        CMHora.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CMHoraActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel10.setText("Paciente*");

        error_fecha.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        error_fecha.setText("Etiqueta de Error");

        error_servicio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        error_servicio.setText("Etiqueta de Error");

        CMServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        CMServicio.setColorArrow(new java.awt.Color(26, 117, 159));
        CMServicio.setColorBorde(new java.awt.Color(26, 117, 159));
        CMServicio.setColorFondo(new java.awt.Color(26, 117, 159));
        CMServicio.setColorSeleccion(new java.awt.Color(26, 117, 159));
        CMServicio.setDisabledIdex("0");
        CMServicio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        CMServicio.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                CMServicioItemStateChanged(evt);
            }
        });
        CMServicio.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CMServicioActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel11.setText("Servicio*");

        error_atendera.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        error_atendera.setText("Etiqueta de Error");

        CMAtendera.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        CMAtendera.setColorArrow(new java.awt.Color(26, 117, 159));
        CMAtendera.setColorBorde(new java.awt.Color(26, 117, 159));
        CMAtendera.setColorFondo(new java.awt.Color(26, 117, 159));
        CMAtendera.setColorSeleccion(new java.awt.Color(26, 117, 159));
        CMAtendera.setDisabledIdex("0");
        CMAtendera.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        CMAtendera.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                CMAtenderaItemStateChanged(evt);
            }
        });
        CMAtendera.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CMAtenderaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel12.setText("Atenderá*");

        rSPanelMaterialGradient1.setBgShade(new java.awt.Color(26, 117, 159));
        rSPanelMaterialGradient1.setColorPrimario(new java.awt.Color(26, 117, 159));
        rSPanelMaterialGradient1.setColorSecundario(new java.awt.Color(160, 187, 200));
        rSPanelMaterialGradient1.setGradiente(RSMaterialComponent.RSPanelMaterialGradient.Gradiente.CIRCULAR);

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

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editar Cita");

        javax.swing.GroupLayout rSPanelMaterialGradient1Layout = new javax.swing.GroupLayout(rSPanelMaterialGradient1);
        rSPanelMaterialGradient1.setLayout(rSPanelMaterialGradient1Layout);
        rSPanelMaterialGradient1Layout.setHorizontalGroup(
            rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelMaterialGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        rSPanelMaterialGradient1Layout.setVerticalGroup(
            rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelMaterialGradient1Layout.createSequentialGroup()
                .addGroup(rSPanelMaterialGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelMaterialGradient1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelMaterialGradient1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        CMFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 117, 159), 2));
        CMFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        CMFecha.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        CMFecha.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                CMFechaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                CMFechaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout rSPanelBorder1Layout = new javax.swing.GroupLayout(rSPanelBorder1);
        rSPanelBorder1.setLayout(rSPanelBorder1Layout);
        rSPanelBorder1Layout.setHorizontalGroup(
            rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                        .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(error_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                        .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CMPaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rSPanelBorder1Layout.createSequentialGroup()
                                .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CMServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(error_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CMAtendera, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(error_atendera, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                        .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(CMFecha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(error_fecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(error_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                                .addComponent(CMHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
            .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(rSPanelMaterialGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rSPanelBorder1Layout.setVerticalGroup(
            rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                .addComponent(rSPanelMaterialGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CMPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error_paciente)
                .addGap(18, 18, 18)
                .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(48, 48, 48))
                    .addComponent(CMHora, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(error_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error_fecha))
                .addGap(18, 18, 18)
                .addGroup(rSPanelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(error_servicio))
                    .addGroup(rSPanelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMAtendera, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(error_atendera)))
                .addGap(36, 36, 36)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CMPacienteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CMPacienteActionPerformed
    {//GEN-HEADEREND:event_CMPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CMPacienteActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnModificarActionPerformed
    {//GEN-HEADEREND:event_btnModificarActionPerformed
        pacientCorrect = MetodosAux.validarBox(CMPaciente, error_paciente, "required");
        serviceCorrect = MetodosAux.validarBox(CMServicio, error_servicio, "required");
        horaCorrect = MetodosAux.validarBox(CMHora, error_hora, "required");
        atenderaCorrect = MetodosAux.validarBox(CMAtendera, error_atendera, "required");

        if (atenderaCorrect && pacientCorrect && serviceCorrect && horaCorrect && fechaCorrect)
        {
            int pacienteId = MetodosBD.buscarPacienteNombre(CMPaciente.getSelectedItem().toString());
            String pacienteCorreo = MetodosBD.buscarPacienteCorreo(CMPaciente.getSelectedItem().toString());
            String fechaCita = MetodosAux.ToDate2(CMFecha.getText());
            Time horaCita = MetodosAux.ObtenerHoraMySQL(CMHora.getSelectedItem().toString());
            int medicoId = MetodosBD.buscarMedicoNombre(CMAtendera.getSelectedItem().toString());
            int servicioId = MetodosBD.buscarServicioNombre(CMServicio.getSelectedItem().toString());
            //Como se edito se va a registrar la fecha en que se edito y el usuario que se encargo de realizar la edicion
            Object[] datosUpdate =
            {
                pacienteId,
                fechaCita,
                horaCita,
                medicoId,
                servicioId,
            };
            boolean modificacionCorr = MetodosBD.actualizarCita(datosUpdate, id);
            if (modificacionCorr)
            {
                POST.mEnviarCorreoCita("modificar", CMPaciente.getSelectedItem().toString(), fechaCita, CMHora.getSelectedItem().toString(), CMServicio.getSelectedItem().toString(), pacienteCorreo);
                MetodosAux.mostrarAlerta("Muy bien hecho", "Cita Actualizada con Exito", 1);
                dispose();
                tablaContenidoCitas21.listarCitas(tablaContenidoCitas21.tblCitas, tabSelecc, null);
                Citas.actualizarNumCitas();
            } else
            {
                MetodosAux.mostrarAlerta("Error", "Ocurro un error al Actualizar la Cita", 2);
            }
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCerrarActionPerformed
    {//GEN-HEADEREND:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void CMPacienteItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_CMPacienteItemStateChanged
    {//GEN-HEADEREND:event_CMPacienteItemStateChanged
        pacientCorrect = MetodosAux.validarBox(CMPaciente, error_paciente, "required");
        btnModificar.setEnabled((pacientCorrect && fechaCorrect && horaCorrect && serviceCorrect && atenderaCorrect));
    }//GEN-LAST:event_CMPacienteItemStateChanged

    private void CMHoraItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_CMHoraItemStateChanged
    {//GEN-HEADEREND:event_CMHoraItemStateChanged
        horaCorrect = MetodosAux.validarBox(CMHora, error_hora, "required");
        btnModificar.setEnabled((pacientCorrect && fechaCorrect && horaCorrect && serviceCorrect && atenderaCorrect));
    }//GEN-LAST:event_CMHoraItemStateChanged

    private void CMHoraActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CMHoraActionPerformed
    {//GEN-HEADEREND:event_CMHoraActionPerformed

    }//GEN-LAST:event_CMHoraActionPerformed

    private void CMServicioItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_CMServicioItemStateChanged
    {//GEN-HEADEREND:event_CMServicioItemStateChanged
        serviceCorrect = MetodosAux.validarBox(CMServicio, error_servicio, "required");
        btnModificar.setEnabled((pacientCorrect && fechaCorrect && horaCorrect && serviceCorrect && atenderaCorrect));
    }//GEN-LAST:event_CMServicioItemStateChanged

    private void CMServicioActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CMServicioActionPerformed
    {//GEN-HEADEREND:event_CMServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CMServicioActionPerformed

    private void CMAtenderaItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_CMAtenderaItemStateChanged
    {//GEN-HEADEREND:event_CMAtenderaItemStateChanged
        atenderaCorrect = MetodosAux.validarBox(CMAtendera, error_atendera, "required");
        btnModificar.setEnabled((pacientCorrect && fechaCorrect && horaCorrect && serviceCorrect && atenderaCorrect));
    }//GEN-LAST:event_CMAtenderaItemStateChanged

    private void CMAtenderaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CMAtenderaActionPerformed
    {//GEN-HEADEREND:event_CMAtenderaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CMAtenderaActionPerformed

    private void CMFechaKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_CMFechaKeyReleased
    {//GEN-HEADEREND:event_CMFechaKeyReleased
        fechaCorrect = Validaciones.validarFecha(CMFecha.getText(), error_fecha);
        btnModificar.setEnabled((pacientCorrect && fechaCorrect && horaCorrect && serviceCorrect && atenderaCorrect));
    }//GEN-LAST:event_CMFechaKeyReleased

    private void CMFechaKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_CMFechaKeyTyped
    {//GEN-HEADEREND:event_CMFechaKeyTyped
        Validaciones.entradaLetrasNum(evt, 3);
        if (CMFecha.getText().length() == 10)
        {
            evt.consume();
        }

    }//GEN-LAST:event_CMFechaKeyTyped

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
            java.util.logging.Logger.getLogger(EditCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(EditCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(EditCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(EditCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new EditCita().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSComboBox CMAtendera;
    private javax.swing.JFormattedTextField CMFecha;
    private RSMaterialComponent.RSComboBox CMHora;
    private RSMaterialComponent.RSComboBox CMPaciente;
    private RSMaterialComponent.RSComboBox CMServicio;
    private RSMaterialComponent.RSButtonIconOne btnCerrar;
    private newscomponents.RSButtonIcon_new btnModificar;
    private javax.swing.JLabel error_atendera;
    private javax.swing.JLabel error_fecha;
    private javax.swing.JLabel error_hora;
    private javax.swing.JLabel error_paciente;
    private javax.swing.JLabel error_servicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnlFondo;
    private RSMaterialComponent.RSPanelBorder rSPanelBorder1;
    private RSMaterialComponent.RSPanelMaterialGradient rSPanelMaterialGradient1;
    // End of variables declaration//GEN-END:variables
}
