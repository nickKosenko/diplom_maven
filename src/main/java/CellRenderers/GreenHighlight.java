package CellRenderers;

import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;

public class GreenHighlight extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);
		if (isSelected) {
			cell.setBackground(Color.green);
		}
		return cell;
	}
}
