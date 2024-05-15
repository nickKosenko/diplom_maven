package CellRenderers;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class StatisticsRedForeground  extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,	int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if(table.getValueAt(row, 4) != null && (int)table.getValueAt(row, 4) != 0) {
			c.setBackground(Color.RED);
		}else {
			c.setBackground(Color.WHITE);
		}
//			c.setForeground(Color.RED);
		return c;
	}
}