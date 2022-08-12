package components;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author ander
 * Remodela o cabeçalho das tabelas
 */
public class TableHeader {

    public TableHeader(JTableHeader jTableHeader) {
        jTableHeader.setForeground(config.Params.COLOR_CINZA);
        jTableHeader.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        //tHeader.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        //tHeader.setColumnModel(new TableColumnModel);
        ((DefaultTableCellRenderer) jTableHeader.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.LEFT);
    }
}
