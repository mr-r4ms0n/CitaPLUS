/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import formularios_Registros.RegCitas;
import metodosBD.MetodosBD;

/**
 *
 * @author David Vergara
 */
public class Citas extends javax.swing.JPanel
{

    public static int tabSelecc = 1;
    
    /**
     * Creates new form citas
     */
    public Citas()
    {
        initComponents();
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
        tabProximas = new newscomponents.RSButtonIcon_new();
        tabCanceladas = new newscomponents.RSButtonIcon_new();
        tabTodas = new newscomponents.RSButtonIcon_new();
        tabAtendidas = new newscomponents.RSButtonIcon_new();
        tablaContenidoCitas21 = new paneles.TablaContenidoCitas();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(26, 117, 159)));

        rSLabelTextIcon1.setForeground(new java.awt.Color(144, 224, 239));
        rSLabelTextIcon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon1.setText("Citas");
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.RECEIPT);

        rSButtonIcon_new1.setBackground(new java.awt.Color(68, 165, 160));
        rSButtonIcon_new1.setText("Agendar nueva cita");
        rSButtonIcon_new1.setBackgroundHover(new java.awt.Color(178, 218, 216));
        rSButtonIcon_new1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LOCAL_PHARMACY);
        rSButtonIcon_new1.setRound(20);
        rSButtonIcon_new1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rSButtonIcon_new1ActionPerformed(evt);
            }
        });

        tabProximas.setBackground(new java.awt.Color(255, 255, 255));
        tabProximas.setText("Proximas (0)");
        tabProximas.setBackgroundHover(new java.awt.Color(204, 182, 128));
        tabProximas.setForegroundHover(new java.awt.Color(26, 117, 159));
        tabProximas.setForegroundIcon(new java.awt.Color(233, 196, 106));
        tabProximas.setForegroundText(new java.awt.Color(26, 117, 159));
        tabProximas.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ACCESS_TIME);
        tabProximas.setRound(20);
        tabProximas.setSelected(true);
        tabProximas.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tabProximasActionPerformed(evt);
            }
        });

        tabCanceladas.setBackground(new java.awt.Color(255, 255, 255));
        tabCanceladas.setText("Canceladas (0)");
        tabCanceladas.setBackgroundHover(new java.awt.Color(239, 146, 146));
        tabCanceladas.setForegroundHover(new java.awt.Color(26, 117, 159));
        tabCanceladas.setForegroundIcon(new java.awt.Color(255, 51, 51));
        tabCanceladas.setForegroundText(new java.awt.Color(26, 117, 159));
        tabCanceladas.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REMOVE_CIRCLE);
        tabCanceladas.setRound(20);
        tabCanceladas.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tabCanceladasActionPerformed(evt);
            }
        });

        tabTodas.setBackground(new java.awt.Color(255, 255, 255));
        tabTodas.setText("Todas");
        tabTodas.setBackgroundHover(new java.awt.Color(153, 210, 221));
        tabTodas.setForegroundHover(new java.awt.Color(26, 117, 159));
        tabTodas.setForegroundIcon(new java.awt.Color(26, 117, 159));
        tabTodas.setForegroundText(new java.awt.Color(26, 117, 159));
        tabTodas.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REORDER);
        tabTodas.setRound(20);
        tabTodas.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tabTodasActionPerformed(evt);
            }
        });

        tabAtendidas.setBackground(new java.awt.Color(255, 255, 255));
        tabAtendidas.setText("Atendidas (0)");
        tabAtendidas.setBackgroundHover(new java.awt.Color(138, 191, 112));
        tabAtendidas.setFocusable(false);
        tabAtendidas.setForegroundHover(new java.awt.Color(26, 117, 159));
        tabAtendidas.setForegroundIcon(new java.awt.Color(51, 153, 0));
        tabAtendidas.setForegroundText(new java.awt.Color(26, 117, 159));
        tabAtendidas.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK_BOX);
        tabAtendidas.setRound(20);
        tabAtendidas.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tabAtendidasActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rSButtonIcon_new1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tabProximas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabAtendidas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabCanceladas, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 562, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tabProximas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabCanceladas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabTodas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabAtendidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaContenidoCitas21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablaContenidoCitas21, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabProximasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tabProximasActionPerformed
    {//GEN-HEADEREND:event_tabProximasActionPerformed
        // TODO add your handling code here:
        tabSelecc = 1;
        if (!tabProximas.isSelected())
        {
            tabTodas.setSelected(false);
            tabCanceladas.setSelected(false);
            tabAtendidas.setSelected(false);
            tabProximas.setSelected(true);
        }
       tablaContenidoCitas21.actualizarTitulo(1);
    }//GEN-LAST:event_tabProximasActionPerformed

    private void tabAtendidasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tabAtendidasActionPerformed
    {//GEN-HEADEREND:event_tabAtendidasActionPerformed
        // TODO add your handling code here:
        tabSelecc = 2;
        if (!tabAtendidas.isSelected())
        {
            tabTodas.setSelected(false);
            tabCanceladas.setSelected(false);
            tabProximas.setSelected(false);
            tabAtendidas.setSelected(true);
        }
        tablaContenidoCitas21.actualizarTitulo(2);
    }//GEN-LAST:event_tabAtendidasActionPerformed

    private void tabCanceladasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tabCanceladasActionPerformed
    {//GEN-HEADEREND:event_tabCanceladasActionPerformed
        // TODO add your handling code here:
        tabSelecc = 3;
        if (!tabCanceladas.isSelected())
        {
            tabTodas.setSelected(false);
            tabProximas.setSelected(false);
            tabAtendidas.setSelected(false);
            tabCanceladas.setSelected(true);
        }
        tablaContenidoCitas21.actualizarTitulo(3);
    }//GEN-LAST:event_tabCanceladasActionPerformed

    private void tabTodasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tabTodasActionPerformed
    {//GEN-HEADEREND:event_tabTodasActionPerformed
        // TODO add your handling code here:
        tabSelecc = 0;
        if (!tabTodas.isSelected())
        {
            tabProximas.setSelected(false);
            tabAtendidas.setSelected(false);
            tabCanceladas.setSelected(false);
            tabTodas.setSelected(true);
        }
        tablaContenidoCitas21.actualizarTitulo(0);
    }//GEN-LAST:event_tabTodasActionPerformed

    private void rSButtonIcon_new1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rSButtonIcon_new1ActionPerformed
    {//GEN-HEADEREND:event_rSButtonIcon_new1ActionPerformed
        // TODO add your handling code here:
        new RegCitas().setVisible(true);
    }//GEN-LAST:event_rSButtonIcon_new1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private newscomponents.RSButtonIcon_new rSButtonIcon_new1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private newscomponents.RSButtonIcon_new tabAtendidas;
    private newscomponents.RSButtonIcon_new tabCanceladas;
    private newscomponents.RSButtonIcon_new tabProximas;
    private newscomponents.RSButtonIcon_new tabTodas;
    public static paneles.TablaContenidoCitas tablaContenidoCitas21;
    // End of variables declaration//GEN-END:variables
}
