package CellRenderers;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class PrresenceRedHighlight extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,	int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if (table.getValueAt(row, column) == " - ") {										// Only for specific cell
//			c.setFont(/* special font */);
//			// you may want to address isSelected here too
//			c.setForeground(/* special foreground color */);
			c.setBackground(new Color(240, 128, 128));
		} else {
			c.setBackground(Color.white);
		}
		return c;
	}
}