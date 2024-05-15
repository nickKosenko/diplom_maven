package HeaderRenderers;

import java.awt.*;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.table.*;

public class Lecture extends JLabel implements TableCellRenderer {
	private String text;

	public Lecture() {
//        setFont(new Font("Consolas", Font.BOLD, 14));
		setOpaque(true);
		setBackground(Color.WHITE);
//        setBorder(BorderFactory.createEtchedBorder());
		setText(LocalDate.now().toString());
	}

	public Lecture(String date) {
//      setFont(new Font("Consolas", Font.BOLD, 14));
		setOpaque(true);
		setBackground(Color.WHITE);
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
