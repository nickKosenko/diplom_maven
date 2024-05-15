package HeaderRenderers;

import java.awt.*;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.table.*;

public class Practice extends JLabel implements TableCellRenderer {
	private String text;

	public Practice() {
//        setFont(new Font("Consolas", Font.BOLD, 14));
		setOpaque(true);
		setForeground(Color.WHITE);
		setBackground(Color.BLUE);
//        setBorder(BorderFactory.createEtchedBorder());
		setText(LocalDate.now().toString());
	}

	public Practice(String date) {
//      setFont(new Font("Consolas", Font.BOLD, 14));
		setOpaque(true);
		setForeground(Color.WHITE);
		setBackground(Color.BLUE);
//      setBorder(BorderFactory.createEtchedBorder());
		this.text = date;
		setText(date);
	}

	public String getText() {
		return this.text;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
//        setText(value.toString());
		return this;
	}
}
