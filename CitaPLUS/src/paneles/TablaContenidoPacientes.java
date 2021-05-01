/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import RSMaterialComponent.RSTableMetroCustom;
import formularios_Detalles.InfoPacientes;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import metodosAux.SysConfigs;
import metodosAux.MetodosAux;
import metodosAux.RSButtonsAction;
import metodosAux.RSButtonsRenderer;
import metodosBD.MetodosBD;

/**
 *
 * @author Kevin
 */
public class TablaContenidoPacientes extends javax.swing.JPanel
{

    /**
     * Creates new form tablaContenidoCitas
     */
    public TablaContenidoPacientes()
    {
        initComponents();
        listarPacientes(tblPacientes, 1, jTBuscarPaciente.getText().trim());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
    }

    /**
     * Método encargado de mostrar graficamente los datos de los pacientes
     * dentro de la tabla correspondiente
     *
     * @param tabla tabla de pacientes
     * @param tab categoria seleccionada
     * @param filtro Nombre de un paciente en especifico (Para busqueda filtrada
     * y puede ser null)
     */
    public static void listarPacientes(RSTableMetroCustom tabla, int tab, String filtro)
    {
        if (filtro == null)
        {
            filtro = "";
        }
        String[] columnas =
        {
            "id", "accion", "nombre", "apellidoPaterno", "apellidoMaterno", "sexo", "telefonoP", "correo", "estatusPac"
        };
        MetodosAux.listarTablas(MetodosBD.rsListarPacientes(tab, filtro), tabla, columnas);

        //Definimos la posicion donde estara la columna que contendra los botones
        TableColumn column = tabla.getColumnModel().getColumn(1);
        column.setCellRenderer(new RSButtonsRenderer());
        String classname = "paneles.TablaContenidoPacientes";
        String metodoVer = "viewInfo";
        String metodoEditar = "editInfo";
        Object[] params =
        {
            classname, metodoVer, metodoEditar
        };
        //El 0 de aqui es de donde agarrara el parametro para activar los botones
        column.setCellEditor(new RSButtonsAction(tabla, 0, params));
    }

    /**
     * M;etodo que actualiza el titulo que se depliega en la parte inferior
     * dependiendo del tab que se seleccione
     *
     * @param tab tab seleccionado
     */
    public static void actualizarTitulo(int tab)
    {
        switch (tab)
        {
            case 1:
                JLTitulo.setText("Clientes Activos");
                JLTitulo.setForeground(SysConfigs.cl_activos);
                break;
            case 2:
                JLTitulo.setText("Clientes Inactivos");
                JLTitulo.setForeground(SysConfigs.cl_inactivos);
                break;
            case 0:
                JLTitulo.setText("Todos los Clientes");
                JLTitulo.setForeground(SysConfigs.cl_todos);
                break;

        }
    }

    public void viewInfo(Object value)
    {
        new InfoPacientes(null, true, MetodosBD.getPaciente(value.toString())).setVisible(true);
    }

    public void editInfo(Object value)
    {
        JOptionPane.showMessageDialog(null, "Editar info de ID: " + value);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new RSMaterialComponent.RSTableMetroCustom();
        JLTitulo = new RSMaterialComponent.RSLabelTextIcon();
        jTBuscarPaciente = new RSMaterialComponent.RSTextFieldMaterialIcon();

        setBackground(new java.awt.Color(255, 255, 255));

        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String []
            {
                "id", "Accion", "Nombre", "Apellido Paterno", "Apellido Materno", "Sexo", "Teléfono", "Correo", "Estatus"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tblPacientes.setBackgoundHead(new java.awt.Color(26, 117, 159));
        tblPacientes.setBackgoundHover(new java.awt.Color(26, 117, 159));
        tblPacientes.setBorderRows(null);
        tblPacientes.setColorPrimaryText(new java.awt.Color(26, 117, 159));
        tblPacientes.setColorSecondary(new java.awt.Color(255, 255, 255));
        tblPacientes.setColorSecundaryText(new java.awt.Color(26, 117, 159));
        tblPacientes.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        tblPacientes.setFontHead(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        tblPacientes.setFontRowHover(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        tblPacientes.setFontRowSelect(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        tblPacientes.setHighHead(40);
        tblPacientes.setRowHeight(35);
        tblPacientes.setSelectionBackground(new java.awt.Color(26, 117, 159));
        jScrollPane1.setViewportView(tblPacientes);
        if (tblPacientes.getColumnModel().getColumnCount() > 0)
        {
            tblPacientes.getColumnModel().getColumn(0).setMinWidth(0);
            tblPacientes.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblPacientes.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        JLTitulo.setForeground(new java.awt.Color(51, 153, 0));
        JLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLTitulo.setText("Pacientes Activos");
        JLTitulo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON);
        JLTitulo.setSizeIcon(30.0F);

        jTBuscarPaciente.setForeground(new java.awt.Color(26, 117, 159));
        jTBuscarPaciente.setToolTipText("Buscar por nombre o apellido paterno");
        jTBuscarPaciente.setColorIcon(new java.awt.Color(26, 117, 159));
        jTBuscarPaciente.setColorMaterial(new java.awt.Color(26, 117, 159));
        jTBuscarPaciente.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jTBuscarPaciente.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        jTBuscarPaciente.setPhColor(new java.awt.Color(26, 117, 159));
        jTBuscarPaciente.setPlaceholder("Buscar paciente");
        jTBuscarPaciente.setSelectionColor(new java.awt.Color(26, 117, 159));
        jTBuscarPaciente.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTBuscarPacienteActionPerformed(evt);
            }
        });
        jTBuscarPaciente.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jTBuscarPacienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 458, Short.MAX_VALUE)
                        .addComponent(jTBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTBuscarPacienteActionPerformed
    {//GEN-HEADEREND:event_jTBuscarPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBuscarPacienteActionPerformed

    private void jTBuscarPacienteKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTBuscarPacienteKeyReleased
    {//GEN-HEADEREND:event_jTBuscarPacienteKeyReleased
        System.out.println(jTBuscarPaciente.getText().trim());
        listarPacientes(tblPacientes, Pacientes.tabSelecc, jTBuscarPaciente.getText().trim());

    }//GEN-LAST:event_jTBuscarPacienteKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static RSMaterialComponent.RSLabelTextIcon JLTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private RSMaterialComponent.RSTextFieldMaterialIcon jTBuscarPaciente;
    public RSMaterialComponent.RSTableMetroCustom tblPacientes;
    // End of variables declaration//GEN-END:variables
}
