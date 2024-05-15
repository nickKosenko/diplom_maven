package HeaderRenderers;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;

public class Zero extends JLabel implements TableCellRenderer {
	public Zero() {
//     setFont(new Font("Consolas", Font.BOLD, 14));
//		setOpaque(true);
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
        setBorder(BorderFactory.createEtchedBorder());
		setText("");
	}
	public Zero(String value) {
//      setFont(new Font("Consolas", Font.BOLD, 14));
//		setOpaque(true);
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEtchedBorder());
		setText(value);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
//        setText(value.toString());
		return this;
	}
}
