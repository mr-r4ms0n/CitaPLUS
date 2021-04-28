/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import formularios_Registros.FormPacientes;
import metodosBD.MetodosBD;

/**
 *
 * @author Kevin
 */
public class Pacientes extends javax.swing.JPanel
{

    public static int tabSelecc = 1;

    /**
     * Creates new form citas
     */
    public Pacientes()
    {
        initComponents();
        actualizarNumPacientes();
    }

    public static void actualizarNumPacientes()
    {
        int todos = MetodosBD.contarPacientes(0);
        int activos = MetodosBD.contarPacientes(1);
        int inactivos = MetodosBD.contarPacientes(2);

        if (todos != -1)
        {
            tabTodos.setText("Todos (" + todos + ")");
        }

        if (activos != -1)
        {
            tabActivos.setText("Activos (" + activos + ")");
        }

        if (inactivos != -1)
        {
            tabInactivos.setText("Inactivos (" + inactivos + ")");
        }
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

        jPanel2 = new javax.swing.JPanel();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        rSButtonIcon_new1 = new newscomponents.RSButtonIcon_new();
        tabActivos = new newscomponents.RSButtonIcon_new();
        tabInactivos = new newscomponents.RSButtonIcon_new();
        tabTodos = new newscomponents.RSButtonIcon_new();
        tablaContenidoPacientes2 = new paneles.TablaContenidoPacientes();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(26, 117, 159)));

        rSLabelTextIcon1.setForeground(new java.awt.Color(144, 224, 239));
        rSLabelTextIcon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon1.setText("Pacientes");
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON);

        rSButtonIcon_new1.setBackground(new java.awt.Color(68, 165, 160));
        rSButtonIcon_new1.setText("Nuevo Paciente");
        rSButtonIcon_new1.setBackgroundHover(new java.awt.Color(178, 218, 216));
        rSButtonIcon_new1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON_ADD);
        rSButtonIcon_new1.setRound(20);
        rSButtonIcon_new1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rSButtonIcon_new1ActionPerformed(evt);
            }
        });

        tabActivos.setBackground(new java.awt.Color(255, 255, 255));
        tabActivos.setText("Activos (0)");
        tabActivos.setBackgroundHover(new java.awt.Color(151, 194, 129));
        tabActivos.setForegroundHover(new java.awt.Color(26, 117, 159));
        tabActivos.setForegroundIcon(new java.awt.Color(233, 196, 106));
        tabActivos.setForegroundText(new java.awt.Color(26, 117, 159));
        tabActivos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON);
        tabActivos.setRound(20);
        tabActivos.setSelected(true);
        tabActivos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tabActivosActionPerformed(evt);
            }
        });

        tabInactivos.setBackground(new java.awt.Color(255, 255, 255));
        tabInactivos.setText("Inactivos");
        tabInactivos.setBackgroundHover(new java.awt.Color(239, 146, 146));
        tabInactivos.setForegroundHover(new java.awt.Color(26, 117, 159));
        tabInactivos.setForegroundIcon(new java.awt.Color(255, 51, 51));
        tabInactivos.setForegroundText(new java.awt.Color(26, 117, 159));
        tabInactivos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON);
        tabInactivos.setRound(20);
        tabInactivos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tabInactivosActionPerformed(evt);
            }
        });

        tabTodos.setBackground(new java.awt.Color(255, 255, 255));
        tabTodos.setText("Todos");
        tabTodos.setBackgroundHover(new java.awt.Color(144, 161, 194));
        tabTodos.setFocusable(false);
        tabTodos.setForegroundHover(new java.awt.Color(26, 117, 159));
        tabTodos.setForegroundIcon(new java.awt.Color(26, 117, 159));
        tabTodos.setForegroundText(new java.awt.Color(26, 117, 159));
        tabTodos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON);
        tabTodos.setRound(20);
        tabTodos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tabTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 735, Short.MAX_VALUE)
                        .addComponent(rSButtonIcon_new1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tabActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tabActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSButtonIcon_new1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tablaContenidoPacientes2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablaContenidoPacientes2, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonIcon_new1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rSButtonIcon_new1ActionPerformed
    {//GEN-HEADEREND:event_rSButtonIcon_new1ActionPerformed
        new FormPacientes().setVisible(true);
    }//GEN-LAST:event_rSButtonIcon_new1ActionPerformed

    private void tabTodosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tabTodosActionPerformed
    {//GEN-HEADEREND:event_tabTodosActionPerformed
        tabSelecc = 0;
        if (!tabTodos.isSelected())
        {
            tabTodos.setSelected(true);
            tabInactivos.setSelected(false);
            tabActivos.setSelected(false);
        }

        tablaContenidoPacientes2.listarPacientes(tablaContenidoPacientes2.tblCitas, tabSelecc, null);
        tablaContenidoPacientes2.actualizarTitulo(0);
    }//GEN-LAST:event_tabTodosActionPerformed

    private void tabInactivosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tabInactivosActionPerformed
    {//GEN-HEADEREND:event_tabInactivosActionPerformed
        tabSelecc = 2;
        if (!tabInactivos.isSelected())
        {
            tabTodos.setSelected(false);
            tabInactivos.setSelected(true);
            tabActivos.setSelected(false);
        }

        tablaContenidoPacientes2.listarPacientes(tablaContenidoPacientes2.tblCitas, tabSelecc, null);
        tablaContenidoPacientes2.actualizarTitulo(2);
    }//GEN-LAST:event_tabInactivosActionPerformed

    private void tabActivosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tabActivosActionPerformed
    {//GEN-HEADEREND:event_tabActivosActionPerformed
        tabSelecc = 1;
        if (!tabActivos.isSelected())
        {
            tabTodos.setSelected(false);
            tabInactivos.setSelected(false);
            tabActivos.setSelected(true);
        }

        tablaContenidoPacientes2.listarPacientes(tablaContenidoPacientes2.tblCitas, tabSelecc, null);
        tablaContenidoPacientes2.actualizarTitulo(1);
    }//GEN-LAST:event_tabActivosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private newscomponents.RSButtonIcon_new rSButtonIcon_new1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    public static newscomponents.RSButtonIcon_new tabActivos;
    private static newscomponents.RSButtonIcon_new tabInactivos;
    private static newscomponents.RSButtonIcon_new tabTodos;
    public static paneles.TablaContenidoPacientes tablaContenidoPacientes2;
    // End of variables declaration//GEN-END:variables
}
