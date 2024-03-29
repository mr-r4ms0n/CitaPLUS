/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios_Detalles;

import alertas.MyJOP;
import interfaces.MenuUsuario;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import rojeru_san.complementos.RSUtilities;
import metodosAux.*;
import metodosBD.MetodosBD;
import paneles.Citas;
import static paneles.Citas.tabSelecc;
import static paneles.Citas.tablaContenidoCitas21;
import peticionesHTTPS.POST;
import rojeru_san.complementos.RSEffectFade;

/**
 *
 * @author David Vergara
 */
public class InfoCitas extends javax.swing.JDialog
{

    RSObjectArray arregloDatos = new RSObjectArray();
    boolean error_Canc = false;

    /**
     * Creates new form FormPacientes
     */
    public InfoCitas(java.awt.Frame parent, boolean modal, RSObjectArray datos)
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

        lblFecha.setText(datos.getValue("fechaCita").toString());
        lblHoraCita.setText(datos.getValue("horaCita").toString());
        lblEstatus.setText(datos.getValue("estatusCita").toString());
        lblNombrePaciente.setText(datos.getValue("nombrePaciente").toString());
        lblNombreServicio.setText(datos.getValue("nombreServicio").toString());
        lblNombreAtiende.setText(datos.getValue("nombreUsuario").toString());
        lblUsuarioRegistro1.setText(datos.getValue("usuarioRegistro").toString());
        //lblUsuarioActualizo.setText(datos.getValue("usuarioEdito").toString());
        lblFechaRegistro.setText(MetodosAux.ToDate(datos.getValue("fechaRegistro").toString()));
        //lblFechaEdito.setText(datos.getValue("fechaEdito").equals("Sin Editar") ? "Sin Editar" : MetodosAux.ToDate(datos.getValue("fechaEdito").toString()));
        lblFechaCancelo.setText(datos.getValue("fechaCancelo").equals("Sin Cancelar") ? "Sin Cancelar" : MetodosAux.ToDate(datos.getValue("fechaCancelo").toString()));
        lblFechaAtendio.setText(datos.getValue("fechaAtendida").equals("Sin Atender") ? "Sin Atender" : MetodosAux.ToDate(datos.getValue("fechaAtendida").toString()));
        jTextArea1.setText((datos.getValue("descripcionCancelo").toString().equals("Sin Cancelar")) ? "" : datos.getValue("descripcionCancelo").toString());
        
               
         
               
        //arreglo.add("", resultado.getString("NombreAtiende"));
                
                
                
                
            

        //Para habilitar o inhabilitar el boton de cancelar cita
        btnCancelarCita.setVisible((datos.getValue("estatusCita").equals("Proxima")));
        //Para habilitar o inhabilitar el boton de marcarCita
        btnAtenderCita.setVisible((datos.getValue("estatusCita").equals("Proxima")));
        jTextArea1.setEditable((datos.getValue("descripcionCancelo").equals("Sin Cancelar")) && (datos.getValue("estatusCita").equals("Proxima")));
        jTextArea1.setFocusable((datos.getValue("descripcionCancelo").equals("Sin Cancelar")) && (datos.getValue("estatusCita").equals("Proxima")));

        lbl_Error_Cancelacion.setForeground(SysConfigs.bg_white);
    }

    public InfoCitas(java.awt.Frame parent, boolean modal)
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
        rSPanelBorderGradient1 = new RSMaterialComponent.RSPanelBorderGradient();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new RSMaterialComponent.RSButtonIconOne();
        lblNombre = new javax.swing.JLabel();
        lblNombrePaciente = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        btnCancelarCita = new newscomponents.RSButtonIcon_new();
        btnAtenderCita = new newscomponents.RSButtonIcon_new();
        lblNombre3 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblHoraCita = new javax.swing.JLabel();
        lblNombre6 = new javax.swing.JLabel();
        lblNombre7 = new javax.swing.JLabel();
        lblNombre8 = new javax.swing.JLabel();
        lblNombreServicio = new javax.swing.JLabel();
        lblNombreAtiende = new javax.swing.JLabel();
        lblEstatus = new javax.swing.JLabel();
        lblNombre12 = new javax.swing.JLabel();
        lblFechaRegistro = new javax.swing.JLabel();
        lblNombre14 = new javax.swing.JLabel();
        lblUsuarioActualizo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblNombre18 = new javax.swing.JLabel();
        lblNombre19 = new javax.swing.JLabel();
        lblUsuarioRegistro1 = new javax.swing.JLabel();
        lblNombre20 = new javax.swing.JLabel();
        lblFechaEdito = new javax.swing.JLabel();
        lblFechaCancelo = new javax.swing.JLabel();
        lblNombre21 = new javax.swing.JLabel();
        lblNombre22 = new javax.swing.JLabel();
        lblFechaAtendio = new javax.swing.JLabel();
        lbl_Error_Cancelacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        pnlFondo.setBackground(new java.awt.Color(0, 0, 0));

        rSPanelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelBorder1.setBgBorder(new java.awt.Color(204, 182, 128));
        rSPanelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelBorderGradient1.setBgShade(new java.awt.Color(204, 182, 128));
        rSPanelBorderGradient1.setColorPrimario(new java.awt.Color(144, 224, 239));
        rSPanelBorderGradient1.setColorSecundario(new java.awt.Color(204, 182, 128));
        rSPanelBorderGradient1.setGradiente(RSMaterialComponent.RSPanelBorderGradient.Gradiente.CIRCULAR);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("Información de la Cita");

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
                .addContainerGap(219, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(140, 140, 140)
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

        rSPanelBorder1.add(rSPanelBorderGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 110));

        lblNombre.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre del paciente");
        rSPanelBorder1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 200, 40));

        lblNombrePaciente.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombrePaciente.setForeground(new java.awt.Color(102, 102, 102));
        lblNombrePaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombrePaciente.setText("Paciente");
        rSPanelBorder1.add(lblNombrePaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 630, 40));

        lblNombre2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre2.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre2.setText("Hora de la cita");
        rSPanelBorder1.add(lblNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 200, 40));

        btnCancelarCita.setBackground(new java.awt.Color(216, 43, 43));
        btnCancelarCita.setText("Cancelar cita");
        btnCancelarCita.setBackgroundHover(new java.awt.Color(255, 51, 51));
        btnCancelarCita.setEnabled(false);
        btnCancelarCita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelarCita.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnCancelarCita.setRound(20);
        btnCancelarCita.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelarCitaActionPerformed(evt);
            }
        });
        rSPanelBorder1.add(btnCancelarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 760, 140, 41));

        btnAtenderCita.setBackground(new java.awt.Color(68, 165, 160));
        btnAtenderCita.setText("Marcar atendida");
        btnAtenderCita.setBackgroundHover(new java.awt.Color(57, 140, 136));
        btnAtenderCita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAtenderCita.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAtenderCita.setRound(20);
        btnAtenderCita.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAtenderCitaActionPerformed(evt);
            }
        });
        rSPanelBorder1.add(btnAtenderCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 760, 160, -1));

        lblNombre3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre3.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre3.setText("Estatus cita");
        rSPanelBorder1.add(lblNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 200, 40));

        lblFecha.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(102, 102, 102));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("Fecha de la cita");
        rSPanelBorder1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 200, 40));

        lblHoraCita.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblHoraCita.setForeground(new java.awt.Color(102, 102, 102));
        lblHoraCita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoraCita.setText("Hora de la cita");
        rSPanelBorder1.add(lblHoraCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 200, 40));

        lblNombre6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre6.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre6.setText("Fecha de la cita");
        rSPanelBorder1.add(lblNombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 200, 40));

        lblNombre7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre7.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre7.setText("Servicio requerido");
        rSPanelBorder1.add(lblNombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 200, 40));

        lblNombre8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre8.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre8.setText("Atiende");
        rSPanelBorder1.add(lblNombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 200, 40));

        lblNombreServicio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombreServicio.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreServicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreServicio.setText("Servicio");
        rSPanelBorder1.add(lblNombreServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 200, 40));

        lblNombreAtiende.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombreAtiende.setForeground(new java.awt.Color(102, 102, 102));
        lblNombreAtiende.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreAtiende.setText("Atiende");
        rSPanelBorder1.add(lblNombreAtiende, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 200, 40));

        lblEstatus.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblEstatus.setForeground(new java.awt.Color(102, 102, 102));
        lblEstatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstatus.setText("Estatus");
        rSPanelBorder1.add(lblEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 200, 40));

        lblNombre12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre12.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre12.setText("Motivo de cancelación");
        rSPanelBorder1.add(lblNombre12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 200, 20));

        lblFechaRegistro.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblFechaRegistro.setForeground(new java.awt.Color(102, 102, 102));
        lblFechaRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaRegistro.setText("Fecha registro");
        rSPanelBorder1.add(lblFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 130, 40));

        lblNombre14.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre14.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre14.setText("Usuario actualizo:");
        rSPanelBorder1.add(lblNombre14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 200, 40));

        lblUsuarioActualizo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblUsuarioActualizo.setForeground(new java.awt.Color(102, 102, 102));
        lblUsuarioActualizo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuarioActualizo.setText("Actualizo");
        rSPanelBorder1.add(lblUsuarioActualizo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 310, 40));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 182, 128)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        rSPanelBorder1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 580, 110));

        lblNombre18.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre18.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre18.setText("Fecha registro");
        rSPanelBorder1.add(lblNombre18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 130, 40));

        lblNombre19.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre19.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre19.setText("Usuario registro:");
        rSPanelBorder1.add(lblNombre19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 190, 40));

        lblUsuarioRegistro1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblUsuarioRegistro1.setForeground(new java.awt.Color(102, 102, 102));
        lblUsuarioRegistro1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuarioRegistro1.setText("Registro");
        rSPanelBorder1.add(lblUsuarioRegistro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 340, 40));

        lblNombre20.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre20.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre20.setText("Fecha edito");
        rSPanelBorder1.add(lblNombre20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 130, 40));

        lblFechaEdito.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblFechaEdito.setForeground(new java.awt.Color(102, 102, 102));
        lblFechaEdito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaEdito.setText("Fecha cancelo");
        rSPanelBorder1.add(lblFechaEdito, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 130, 40));

        lblFechaCancelo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblFechaCancelo.setForeground(new java.awt.Color(102, 102, 102));
        lblFechaCancelo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaCancelo.setText("Fecha atendio");
        rSPanelBorder1.add(lblFechaCancelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 130, 40));

        lblNombre21.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre21.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre21.setText("Fecha cancelo");
        rSPanelBorder1.add(lblNombre21, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 130, 40));

        lblNombre22.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblNombre22.setForeground(new java.awt.Color(204, 182, 128));
        lblNombre22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre22.setText("Fecha atendio");
        rSPanelBorder1.add(lblNombre22, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, 130, 40));

        lblFechaAtendio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblFechaAtendio.setForeground(new java.awt.Color(102, 102, 102));
        lblFechaAtendio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFechaAtendio.setText("Fecha atendio");
        rSPanelBorder1.add(lblFechaAtendio, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, 130, 40));

        lbl_Error_Cancelacion.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        lbl_Error_Cancelacion.setForeground(new java.awt.Color(255, 0, 0));
        lbl_Error_Cancelacion.setText("Error en el asunto de cancelación");
        rSPanelBorder1.add(lbl_Error_Cancelacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 760, 200, -1));

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSPanelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCerrarActionPerformed
    {//GEN-HEADEREND:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCancelarCitaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelarCitaActionPerformed
    {//GEN-HEADEREND:event_btnCancelarCitaActionPerformed
        if (error_Canc)
        {
            if (MyJOP.myJOPShowConfirmDialog(null, "Esta seguro que desea cancelar esta cita?") == 1)
            {
                String vNombrePaciente = arregloDatos.getValue("nombrePaciente").toString();
                String vFechaCita = arregloDatos.getValue("fechaCita").toString();
                String vPacienteCorreo = arregloDatos.getValue("correoPaciente").toString();
                String vHoraCita=arregloDatos.getValue("horaCita").toString();
                String vServicio = arregloDatos.getValue("nombreServicio").toString();
                
                Object arr[] =
                {
                    3,
                    jTextArea1.getText(),
                    MetodosAux.getFecha(),
                    arregloDatos.getValue("id")
                };
                boolean actualizarCancelar = MetodosBD.actualizarEstatusCita(arr);
                if (actualizarCancelar)
                {
                    POST.mEnviarCorreoCita("cancelar", vNombrePaciente, vFechaCita, vHoraCita, vServicio, vPacienteCorreo);
                    MetodosAux.mostrarAlerta("Muy bien hecho", "Cita cancelada con Exito", 1);
                    dispose();
                    tablaContenidoCitas21.listarCitas(tablaContenidoCitas21.tblCitas, tabSelecc, null);
                    Citas.actualizarNumCitas();
                } else
                {
                    MetodosAux.mostrarAlerta("Error", "Ocurro un error al cancelar la Cita", 2);
                }
            }
        }
    }//GEN-LAST:event_btnCancelarCitaActionPerformed

    private void btnAtenderCitaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAtenderCitaActionPerformed
    {//GEN-HEADEREND:event_btnAtenderCitaActionPerformed
        if (MyJOP.myJOPShowConfirmDialog(null, "Esta seguro que desea marcar como atendida esta cita?") == 1)
        {
            Object arr[] =
            {
                2,
                MetodosAux.getFecha(),
                arregloDatos.getValue("id")
            };
            boolean actualizarCancelar = MetodosBD.actualizarEstatusCita(arr);
            if (actualizarCancelar)
            {
                MetodosAux.mostrarAlerta("Muy bien hecho", "Cita atendida con Exito", 1);
                dispose();
                tablaContenidoCitas21.listarCitas(tablaContenidoCitas21.tblCitas, tabSelecc, null);
                Citas.actualizarNumCitas();
            } else
            {
                MetodosAux.mostrarAlerta("Error", "Ocurro un error al atender la Cita", 2);
            }
        }
    }//GEN-LAST:event_btnAtenderCitaActionPerformed

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTextArea1KeyReleased
    {//GEN-HEADEREND:event_jTextArea1KeyReleased
        if (jTextArea1.getText().length() >= 10)
        {
            error_Canc = true;
            lbl_Error_Cancelacion.setForeground(SysConfigs.bg_white);
            btnCancelarCita.setEnabled(true);
        } else
        {
            error_Canc = false;
            lbl_Error_Cancelacion.setForeground(SysConfigs.bg_danger);
            btnCancelarCita.setEnabled(false);
        }
    }//GEN-LAST:event_jTextArea1KeyReleased

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
            java.util.logging.Logger.getLogger(InfoCitas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(InfoCitas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(InfoCitas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(InfoCitas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            public void run()
            {
                InfoCitas dialog = new InfoCitas(new javax.swing.JFrame(), true);
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
    private newscomponents.RSButtonIcon_new btnAtenderCita;
    private newscomponents.RSButtonIcon_new btnCancelarCita;
    private RSMaterialComponent.RSButtonIconOne btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblEstatus;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaAtendio;
    private javax.swing.JLabel lblFechaCancelo;
    private javax.swing.JLabel lblFechaEdito;
    private javax.swing.JLabel lblFechaRegistro;
    private javax.swing.JLabel lblHoraCita;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre12;
    private javax.swing.JLabel lblNombre14;
    private javax.swing.JLabel lblNombre18;
    private javax.swing.JLabel lblNombre19;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre20;
    private javax.swing.JLabel lblNombre21;
    private javax.swing.JLabel lblNombre22;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblNombreAtiende;
    private javax.swing.JLabel lblNombrePaciente;
    private javax.swing.JLabel lblNombreServicio;
    private javax.swing.JLabel lblUsuarioActualizo;
    private javax.swing.JLabel lblUsuarioRegistro1;
    private javax.swing.JLabel lbl_Error_Cancelacion;
    private javax.swing.JPanel pnlFondo;
    private RSMaterialComponent.RSPanelBorder rSPanelBorder1;
    private RSMaterialComponent.RSPanelBorderGradient rSPanelBorderGradient1;
    // End of variables declaration//GEN-END:variables
}
