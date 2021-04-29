/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metodosAux;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
//Header
public class StyleHeadTable implements TableCellRenderer {

    public int hightHead = 30;
    public Font fontHead = new Font("Segoe UI Semibold", Font.BOLD, 14);
    public Color backgroundHead = new Color(0,0,0);
    public Color foregroundHead = new Color(255, 255, 255);

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int row, int column) {
        JComponent jcomponent = null;

        if (value instanceof String) {
            jcomponent = new JLabel((String) value);
            ((JLabel) jcomponent).setHorizontalAlignment(SwingConstants.LEFT);

            ((JLabel) jcomponent).setSize(hightHead, jcomponent.getWidth());
            ((JLabel) jcomponent).setPreferredSize(new Dimension(hightHead, jcomponent.getWidth()));
        }

        jcomponent.setEnabled(true);
        jcomponent.setOpaque(true);
        jcomponent.setBackground(backgroundHead);
        jcomponent.setForeground(foregroundHead);
        jcomponent.setFont(fontHead);

        return jcomponent;
    }
}
