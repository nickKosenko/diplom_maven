package CellRenderers;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class InitialsRedHighlight extends DefaultTableCellRenderer {
	private ArrayList<Integer> list;

	public InitialsRedHighlight(ArrayList<Integer> list) {
		this.list = list;
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		for (int initRow : list) {
			if (row == initRow) {											// Only for specific cell
//			c.setFont(/* special font */);
//			// you may want to address isSelected here too
//			c.setForeground(/* special foreground color */);
				c.setBackground(new Color(240, 128, 128));
			} else {
				c.setBackground(Color.white);
			}
		}
		return c;
	}
}
