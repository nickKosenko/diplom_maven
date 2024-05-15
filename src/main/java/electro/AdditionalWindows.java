package electro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;

import HeaderRenderers.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import CellRenderers.PrresenceRedHighlight;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

public class AdditionalWindows { // container for classes, describing all extra windows in the whole application
	class AddPresence extends JDialog { // window for setting presence value for student from initialsTable into
										// presenceTable cell
		AddPresence(MouseEvent event, int x, int y, String initials, JTable presenceTable, JTable initialsTable,
				Connection conn, DB_Handler dbh, int chooseGroup, ArrayList<String> dates, SwingAttendance window,
				JComboBox<Object> dropper) {
			this.setTitle(initials);
			this.setModalityType(DEFAULT_MODALITY_TYPE);
			this.setBounds(x, y, 300, 260);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLayout(null);
			ButtonGroup group = new ButtonGroup(); // radio buttons for choosing presence value
			JRadioButton g1 = new JRadioButton("Present");
			g1.setBounds(20, 20, 100, 30);
			JRadioButton g0 = new JRadioButton("Abcent");
			g0.setBounds(20, 60, 100, 30);
			JRadioButton g2 = new JRadioButton("Late");
			g2.setBounds(20, 100, 100, 30);
			JRadioButton g3 = new JRadioButton("Ill");
			g3.setBounds(20, 140, 100, 30);
			group.add(g1);
			group.add(g0);
			group.add(g2);
			group.add(g3);
			this.add(g1);
			this.add(g0);
			this.add(g2);
			this.add(g3);

			JButton apply = new JButton("OK");
			apply.setBounds(20, 180, 90, 30);
			this.getContentPane().add(apply);
			apply.addActionListener(new ActionListener() { // detect choice and save the presence value to DB
				@Override
				public void actionPerformed(ActionEvent ev) {

					int choice = 0;
					if (g1.isSelected()) {
						presenceTable.setValueAt(g1.getText(), presenceTable.rowAtPoint(event.getPoint()),
								presenceTable.columnAtPoint(event.getPoint()));
						choice = 1;
					} else if (g0.isSelected()) {
						presenceTable.setValueAt(g0.getText(), presenceTable.rowAtPoint(event.getPoint()),
								presenceTable.columnAtPoint(event.getPoint()));
						choice = 0;
					} else if (g2.isSelected()) {
						presenceTable.setValueAt(g2.getText(), presenceTable.rowAtPoint(event.getPoint()),
								presenceTable.columnAtPoint(event.getPoint()));
						choice = 2;
					} else if (g3.isSelected()) {
						presenceTable.setValueAt(g3.getText(), presenceTable.rowAtPoint(event.getPoint()),
								presenceTable.columnAtPoint(event.getPoint()));
						choice = 3;
					}
					try {
						String input = " UPDATE attendance SET presence_value = " + choice + "," + " WHERE data = '"
								+ dates.get(presenceTable.columnAtPoint(event.getPoint())) + "'" + " AND student_id = "
								+ getID(conn, dbh, presenceTable.rowAtPoint(event.getPoint()), initialsTable)
								+ " AND presence_value = -1";
						PreparedStatement prep = conn.prepareStatement(input);
						prep.executeUpdate();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					dispose();
					dropper.setSelectedItem(dropper.getSelectedItem());
					window.setEnabled(true);
				}
			});
		}

		AddPresence(MouseEvent event, int x, int y, String initials, JTable presenceTable, JTable initialsTable,
				Connection conn, DB_Handler dbh, int chooseGroup, ArrayList<String> dates, int i,
				SwingAttendance window, JComboBox<Object> dropper) {
			this.setTitle(initials);
			this.setModalityType(DEFAULT_MODALITY_TYPE);
			this.setBounds(50, 50, 300, 260);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLayout(null);
			ButtonGroup group = new ButtonGroup(); // radio buttons for choosing presence value
			JRadioButton g1 = new JRadioButton("Present");
			g1.setBounds(20, 20, 100, 30);
			JRadioButton g0 = new JRadioButton("Abcent");
			g0.setBounds(20, 60, 100, 30);
			JRadioButton g2 = new JRadioButton("Late");
			g2.setBounds(20, 100, 100, 30);
			JRadioButton g3 = new JRadioButton("Ill");
			g3.setBounds(20, 140, 100, 30);
			group.add(g1);
			group.add(g0);
			group.add(g2);
			group.add(g3);
			this.add(g1);
			this.add(g0);
			this.add(g2);
			this.add(g3);
			JButton apply = new JButton("OK");
			apply.setBounds(20, 180, 90, 30);
			this.getContentPane().add(apply);
			apply.addActionListener(new ActionListener() { // detect choice and save the presence value to DB
				@Override
				public void actionPerformed(ActionEvent ev) {
					int choice = 0;
					if (g1.isSelected()) {
						presenceTable.setValueAt(g1.getText(), presenceTable.rowAtPoint(event.getPoint()),
								presenceTable.columnAtPoint(event.getPoint()));
						choice = 1;
					} else if (g0.isSelected()) {
						presenceTable.setValueAt(g0.getText(), presenceTable.rowAtPoint(event.getPoint()),
								presenceTable.columnAtPoint(event.getPoint()));
						choice = 0;
					} else if (g2.isSelected()) {
						presenceTable.setValueAt(g2.getText(), presenceTable.rowAtPoint(event.getPoint()),
								presenceTable.columnAtPoint(event.getPoint()));
						choice = 2;
					} else if (g3.isSelected()) {
						presenceTable.setValueAt(g3.getText(), presenceTable.rowAtPoint(event.getPoint()),
								presenceTable.columnAtPoint(event.getPoint()));
						choice = 3;
					}
					try {
						String input = " UPDATE attendance SET presence_value = " + choice
								+ " WHERE presence_value = -1" + " AND data = '"
								+ dates.get(presenceTable.columnAtPoint(event.getPoint())) + "'" + " AND student_id = "
								+ getID(conn, dbh, initialsTable.rowAtPoint(event.getPoint()), initialsTable);
						PreparedStatement prep = conn.prepareStatement(input);
						prep.executeUpdate();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					dispose();
					dropper.setSelectedItem(dropper.getSelectedItem());
					presenceTable.getColumnModel().getColumn(presenceTable.columnAtPoint(event.getPoint()))
							.setCellRenderer(new PrresenceRedHighlight());
				}
			});
		}
	}

	class SetDate extends JDialog {
		SetDate(JTable presenceTable, JTable initialsTable, Connection conn, DB_Handler dbh, int chooseGroup,
				ArrayList<String> dates, JComboBox<Object> dropper) {
			this.setTitle("Set Date");
			this.setModalityType(DEFAULT_MODALITY_TYPE);
			this.setBounds(300, 300, 200, 260);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLayout(null);
			ButtonGroup groupLect = new ButtonGroup();
			JRadioButton lect1 = new JRadioButton("Lection");
			lect1.setBounds(20, 20, 130, 30);
			JRadioButton lect2 = new JRadioButton("Practice");
			lect2.setBounds(20, 60, 130, 30);
			JRadioButton lect3 = new JRadioButton("Laboratory");
			lect3.setBounds(20, 100, 130, 30);
			groupLect.add(lect1);
			groupLect.add(lect2);
			groupLect.add(lect3);
			this.add(lect1);
			this.add(lect2);
			this.add(lect3);
			UtilDateModel model = new UtilDateModel(); // adding JDatePicker to window
			Properties prop = new Properties();
			prop.put("text.today", "Today");
			prop.put("text.month", "Month");
			prop.put("text.year", "Year");
			JDatePanelImpl panel = new JDatePanelImpl(model, prop);
			JDatePickerImpl picker = new JDatePickerImpl(panel, new DateLabelFormatter());
			picker.setBounds(20, 140, 120, 25);
			this.getContentPane().add(picker);
			JButton apply = new JButton("OK");
			apply.setBounds(20, 180, 90, 30);
			this.getContentPane().add(apply);
			apply.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String reportDate = "";
					if (apply == e.getSource()) {
						Date selectedDate = (Date) picker.getModel().getValue();
						DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
						reportDate = df.format(selectedDate);
					}
					if (checkDate(conn, dbh, reportDate, chooseGroup) == false) {
						JOptionPane.showMessageDialog(null, "Choose another date!", "WARNING",
								JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							int lect_id = 0;
							if (lect1.isSelected()) {
								lect_id = 1;
							} else if (lect2.isSelected()) {
								lect_id = 2;
							} else if (lect3.isSelected()) {
								lect_id = 3;
							} else if (!lect1.isSelected() && lect2.isSelected()) {
								lect_id = 1;
							}
							String input = "INSERT or ignore INTO attendance(student_id, data, lecture_id, group_id, presence_value) VALUES(?, ?, ?, ?, ?)";
							PreparedStatement prep = conn.prepareStatement(input);
							for (int row = 0; row < initialsTable.getRowCount(); row++) {
//								System.out.println("ID = " + getID(conn, dbh, row, initialsTable));
								prep.setInt(1, getID(conn, dbh, row, initialsTable));
								prep.setString(2, reportDate);
								prep.setInt(3, lect_id);
								prep.setInt(4, chooseGroup);
								prep.setInt(5, -1);
								prep.execute();
							}
							dispose();
							// TODO optimize the renew process
							dropper.setSelectedItem(dropper.getSelectedItem());
							String changeHours = "";
							switch (lect_id) {
							case 1:
								changeHours = "UPDATE basic_hours SET lecture = lecture + 1 WHERE group_id = ?";
								break;
							case 2:
								changeHours = "UPDATE basic_hours SET practice = practice + 1 WHERE group_id = ?";
								break;
							case 3:
								changeHours = "UPDATE basic_hours SET laboratory = laboratory + 1 WHERE group_id = ?";
								break;
							}
							PreparedStatement prepSt = conn.prepareStatement(changeHours);
							prepSt.setInt(1, chooseGroup);
							prepSt.executeUpdate();
							showColumn(dates.size(), presenceTable);
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
				}
			});
		}
	}

	class ChangePresence extends JDialog { // window for setting presence value for student from initialsTable into
											// presenceTable cell
		ChangePresence(MouseEvent event, int x, int y, String initials, JTable presenceTable, JTable initialsTable,
				Connection conn, DB_Handler dbh, int chooseGroup, ArrayList<String> dates, SwingAttendance window,
				JComboBox<Object> dropper) {
			this.setTitle(initials);
			this.setModalityType(DEFAULT_MODALITY_TYPE);
			this.setBounds(x, y, 300, 260);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLayout(null);
			ButtonGroup group = new ButtonGroup(); // radio buttons for choosing presence value
			JRadioButton g1 = new JRadioButton("Present");
			g1.setBounds(20, 20, 100, 30);
			JRadioButton g0 = new JRadioButton("Abcent");
			g0.setBounds(20, 60, 100, 30);
			JRadioButton g2 = new JRadioButton("Late");
			g2.setBounds(20, 100, 100, 30);
			JRadioButton g3 = new JRadioButton("Ill");
			g3.setBounds(20, 140, 100, 30);
			group.add(g1);
			group.add(g0);
			group.add(g2);
			group.add(g3);
			this.add(g1);
			this.add(g0);
			this.add(g2);
			this.add(g3);

			JButton change = new JButton("CHANGE"); // changing data in DB about person
			change.setBounds(20, 180, 90, 30);
			this.getContentPane().add(change);
			change.addActionListener((ev) -> {
				try {
					String input = "UPDATE attendance " + "SET presence_value = ? " + "WHERE student_id = "
							+ getID(conn, dbh, initialsTable.rowAtPoint(event.getPoint()), initialsTable)
							+ " AND data = '" + dates.get(presenceTable.columnAtPoint(event.getPoint())) + "'";
					PreparedStatement prep = conn.prepareStatement(input);
					if (g1.isSelected()) {
						prep.setInt(1, 1);
					} else if (g0.isSelected()) {
						prep.setInt(1, 0);
					} else if (g2.isSelected()) {
						prep.setInt(1, 2);
					} else if (g3.isSelected()) {
						prep.setInt(1, 3);
					}
					prep.executeUpdate();
					dispose();
					dropper.setSelectedItem(dropper.getSelectedItem());
//					window.setEnabled(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
		}
	}

	void showColumn(int datesAmount, JTable presence) {
		presence.getColumnModel().getColumn(datesAmount).setMinWidth(75);
		presence.getColumnModel().getColumn(datesAmount).setMaxWidth(75);
	}

	int getID(Connection conn, DB_Handler dbh, int row, JTable table) {
		try {
			String input = "SELECT id FROM students WHERE initials = ?";
			PreparedStatement prst = conn.prepareStatement(input);
//			prst.setString(1, (String) (table.getValueAt(row, 0)));
			prst.setString(1, (String) (table.getValueAt(row, 1)));
			ResultSet rSet = prst.executeQuery();
			while (rSet.next()) {
//				System.out.println("id for " + (String) (table.getValueAt(row, 0)) + " is " + rSet.getInt("id"));
				return rSet.getInt("id");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	int getLectureType(Class<?> check) {
		if (check == new Lecture().getClass()) {
			return 1;
		} else if (check == new Practice().getClass()) {
			return 2;
		} else if (check == new Laboratory().getClass()) {
			return 3;
		}
		return 0;
	}

	void saveToDb(Connection conn, DB_Handler dbh, int group_id, String initials, JTable presenceTable,
			JTable initialsTable, MouseEvent event, int choice, ArrayList<String> dates, String reportedDate,
			int lect_id) {
		try {
			String input = "insert into attendance(data, group_id, student_id, lecture_id, presence_value) values(?, ?, ?, ?, ?)";
			PreparedStatement prep = conn.prepareStatement(input);
			prep.setString(1, reportedDate);
			prep.setInt(2, group_id);
			prep.setInt(3, getID(conn, dbh, initialsTable.rowAtPoint(event.getPoint()), initialsTable));
			prep.setInt(4, lect_id);
			prep.setInt(5, choice);
			prep.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	boolean checkDate(Connection conn, DB_Handler dbh, String newDate, int chooseGroup) {
		String exist = "SELECT COUNT(*) FROM attendance WHERE data = '" + newDate + "' AND group_id = " + chooseGroup;
		try {
			PreparedStatement prep = conn.prepareStatement(exist);
			ResultSet set = prep.executeQuery();
			while (set.next()) {
				if (set.getInt(1) > 0) {
					return false;
				} else {
					return true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	class ChangeLectureType extends JDialog {
		ChangeLectureType(MouseEvent event, int x, int y, JTable table, int chooseGroup, ArrayList<String> dates,
				Connection conn, DB_Handler dbh, SwingAttendance window, JComboBox<Object> dropper) {
			this.setTitle("Set new Date");
			this.setModalityType(DEFAULT_MODALITY_TYPE);
			this.setBounds(x, y, 300, 220);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLayout(null);
			ButtonGroup group = new ButtonGroup();
			JRadioButton g1 = new JRadioButton("Lecture");
			g1.setBounds(20, 20, 130, 30);
			JRadioButton g2 = new JRadioButton("Practice");
			g2.setBounds(20, 60, 130, 30);
			JRadioButton g3 = new JRadioButton("Laboratory");
			g3.setBounds(20, 100, 130, 30);
			JPanel l1 = new JPanel();
			l1.setBounds(180, 20, 100, 30);
			l1.setBackground(Color.WHITE);
			this.getContentPane().add(l1);
			JPanel l2 = new JPanel();
			l2.setBounds(180, 60, 100, 30);
			l2.setBackground(Color.BLUE);
			this.getContentPane().add(l2);
			JPanel l3 = new JPanel();
			l3.setBounds(180, 100, 100, 30);
			l3.setBackground(Color.YELLOW);
			this.getContentPane().add(l3);
			group.add(g1);
			group.add(g2);
			group.add(g3);
			this.add(g1);
			this.add(g2);
			this.add(g3);
			UtilDateModel model = new UtilDateModel(); // adding JDatePicker to window
			Properties prop = new Properties();
			prop.put("text.today", "Today");
			prop.put("text.month", "Month");
			prop.put("text.year", "Year");
			JDatePanelImpl panel = new JDatePanelImpl(model, prop);
			JDatePickerImpl picker = new JDatePickerImpl(panel, new DateLabelFormatter());
			picker.setBounds(160, 140, 120, 25);
			this.getContentPane().add(picker);
			JButton change = new JButton("CHANGE"); // adding apply button to window
			change.setBounds(20, 140, 90, 30);
			change.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String reportDate = "";
					if (change == e.getSource()) {
						Date selectedDate = (Date) picker.getModel().getValue();
						DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
						reportDate = df.format(selectedDate);
					}
//					System.out.println(reportDate);
					int lecture_id = 0;
					if (g1.isSelected()) {
						table.getColumnModel().getColumn(table.columnAtPoint(event.getPoint()))
								.setHeaderRenderer(new Lecture(reportDate));
						lecture_id = 1;
					} else if (g2.isSelected()) {
						table.getColumnModel().getColumn(table.columnAtPoint(event.getPoint()))
								.setHeaderRenderer(new Practice(reportDate));
						lecture_id = 2;
					} else if (g3.isSelected()) {
						table.getColumnModel().getColumn(table.columnAtPoint(event.getPoint()))
								.setHeaderRenderer(new Laboratory(reportDate));
						lecture_id = 3;
					}
					dispose();
					window.setEnabled(true);

					String input = " UPDATE attendance SET data = '" + reportDate + "'," + " lecture_id = " + lecture_id
							+ " WHERE group_id = " + chooseGroup + " AND data = '"
							+ dates.get(table.columnAtPoint(event.getPoint())) + "'";
					try {
						PreparedStatement prep = conn.prepareStatement(input);
						prep.executeUpdate();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					dropper.setSelectedItem(dropper.getSelectedItem());
				}
			});
			this.getContentPane().add(change);
		}
	}

	class DateLabelFormatter extends AbstractFormatter { // date formatter only for JDatePicker
		private String datePattern = "dd-MM-yyyy";
		private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}
			return "";
		}
	}

	class RemoveStudent extends JDialog {
		public RemoveStudent(Connection conn, DB_Handler dbh, JTable initialsTable, JComboBox<Object> dropper,
				int group, ArrayList<String> dates) {
			this.setTitle("Are you sure?");
			this.setModalityType(DEFAULT_MODALITY_TYPE);
			this.setBounds(200, 200, 300, 150);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLayout(null);
			JLabel label = new JLabel("Please confirm the action: ");
			label.setBounds(30, 10, 200, 30);
			this.add(label);
			JLabel del = new JLabel("Delete - " + initialsTable.getValueAt(initialsTable.getSelectedRow(), 1));
			del.setBounds(30, 40, 200, 30);
			this.add(del);
			JButton cancel = new JButton("CANCEL");
			cancel.setBounds(80, 75, 90, 30);
			cancel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			this.add(cancel);
			JButton remove = new JButton("OK");
			remove.setBounds(180, 75, 90, 30);
			remove.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						removePresence(conn, dbh, initialsTable, dates);
						String input = "DELETE FROM students WHERE initials = '"
								+ initialsTable.getValueAt(initialsTable.getSelectedRow(), 1) + "' AND group_id = "
								+ group;
						PreparedStatement prepSt = conn.prepareStatement(input);
						prepSt.executeUpdate();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					dispose();
					dropper.setSelectedItem(dropper.getSelectedItem());

				}
			});
			this.add(remove);
		}

		void removePresence(Connection conn, DB_Handler dbh, JTable initialsTable, ArrayList<String> dates)
				throws SQLException {
			String input = "SELECT id FROM students WHERE initials = ?";
			PreparedStatement prSt = conn.prepareStatement(input);
			prSt.setString(1, (String) initialsTable.getValueAt(initialsTable.getSelectedRow(), 1));
			ResultSet set = prSt.executeQuery();
			int id = 0;
			while (set.next()) {
				id = set.getInt("id");
			}
			for (String str : dates) {
				String delete = "DELETE FROM attendance WHERE student_id = ? AND data = ?";
				PreparedStatement prep = conn.prepareStatement(delete);
				prep.setInt(1, id);
				prep.setString(2, str);
				prep.executeUpdate();
//				System.out.println("Deleting from attendance student_id = " + id + " AND data = " + str);
			}
		}
	}

	class RemoveDate extends JDialog {
		RemoveDate(Connection conn, DB_Handler dbh, JTable presenceTable, int group, ArrayList<String> dates,
				ArrayList<String> lectures, MouseEvent event, JComboBox<Object> dropper) {
			this.setTitle("Are you sure?");
			this.setModalityType(DEFAULT_MODALITY_TYPE);
			this.setBounds(200, 200, 300, 150);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setLayout(null);
			JLabel label = new JLabel("Please confirm the action: ");
			label.setBounds(30, 10, 200, 30);
			this.add(label);
			JLabel del = new JLabel("Delete - " + dates.get(presenceTable.columnAtPoint(event.getPoint())));
			del.setBounds(30, 40, 200, 30);
			this.add(del);
			JButton cancel = new JButton("CANCEL");
			cancel.setBounds(80, 75, 90, 30);
			cancel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			this.add(cancel);
			JButton remove = new JButton("OK");
			remove.setBounds(180, 75, 90, 30);
			remove.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						String input = "DELETE FROM attendance WHERE group_id = ? AND data = ?";
						PreparedStatement prep = conn.prepareStatement(input);
						prep.setInt(1, group);
						prep.setString(2, dates.get(presenceTable.columnAtPoint(event.getPoint())));
						prep.executeUpdate();
						dispose();
						String changeHours = "";
						switch (lectures.get(dates.indexOf(dates.get(presenceTable.columnAtPoint(event.getPoint()))))) {
						case "1":
							changeHours = "UPDATE basic_hours SET lecture = lecture - 1 WHERE group_id = ?";
							break;
						case "2":
							changeHours = "UPDATE basic_hours SET practice = practice - 1 WHERE group_id = ?";
							break;
						case "3":
							changeHours = "UPDATE basic_hours SET laboratory = laboratory - 1 WHERE group_id = ?";
							break;
						}
						PreparedStatement prepSt = conn.prepareStatement(changeHours);
						prepSt.setInt(1, group);
						prepSt.executeUpdate();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					dropper.setSelectedItem(dropper.getSelectedItem());
				}
			});
			this.add(remove);
		}
	}

	class ChooseDB extends JFrame {
		String path;
		JButton create = new JButton("Create New");
		JLabel label = new JLabel("Please point on a DataBase file or create a new one");

		public String getPath() {
			return path;
		}

		ChooseDB() {
			int choice = JOptionPane.showConfirmDialog(this, "The database is missing, choose a new one",
					"DataBase ERROR", JOptionPane.YES_NO_OPTION);
			if (choice == 0) {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					JFileChooser chooser = new JFileChooser();
					chooser.setCurrentDirectory(new File("C:\\Users\\User\\Desktop"));
					chooser.showOpenDialog(null);
					path = "jdbc:sqlite:" + chooser.getSelectedFile().getAbsolutePath();
					setProperties("dbPath", path + ".db");
					try {
						System.out.println("PATH = " + path);

						SQLiteConfig config = new SQLiteConfig();
						config.setEncoding(SQLiteConfig.Encoding.UTF8);
						Connection conn = DriverManager.getConnection(path + ".db", config.toProperties());
//							Connection conn = DriverManager.getConnection(path + ".db");

						if (conn != null) {
							createTables(conn, path);
						}
					} catch (SQLException exc) {
						exc.printStackTrace();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				dispose();
			} else {
				dispose();
			}
		}

		void createTables(Connection conn, String path) throws SQLException {
			String[] request = {
					"CREATE TABLE attendance (\n"
							+ "    id INTEGER DEFAULT (1) NOT NULL PRIMARY KEY ON CONFLICT IGNORE AUTOINCREMENT,\n"
							+ "    data TEXT NOT NULL DEFAULT '0000-00-00',\n" + "    group_id INTEGER NOT NULL,\n"
							+ "    student_id INTEGER NOT NULL,\n" + "    lecture_id INTEGER NOT NULL DEFAULT '0',\n"
							+ "    presence_value INTEGER NOT NULL DEFAULT '-1'\n" + ");",

					"PRAGMA encoding = DEFAULT;",

					"CREATE TABLE `basic_hours` (\n" + "    `id` INTEGER NOT NULL ,\n"
							+ "    `group_id` INTEGER NOT NULL,\n" + "    `lecture` INTEGER NOT NULL DEFAULT '0',\n"
							+ "    `practice` INTEGER NOT NULL DEFAULT '0',\n"
							+ "    `laboratory` INTEGER NOT NULL DEFAULT '0',\n" + "    `sum` INTEGER NOT NULL,\n"
							+ "    PRIMARY KEY (`id`)\n" + ");",

					"CREATE TABLE `group_id` (\n" + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" + "Name TEXT NOT NULL"
							+ ");\n",

					"INSERT INTO group_id (Name) VALUES (1, 'Ø²Ä - 11');\n",
					"INSERT INTO group_id (Name) VALUES (2, 'Ø²Ä - 12');\n",
					"INSERT INTO group_id (Name) VALUES (3, 'ÏÄ - 11');\n",
					"INSERT INTO group_id (Name) VALUES (4, 'ÏÄ - 12');\n",
					"INSERT INTO group_id (Name) VALUES (5, 'ÏÄ - 13');\n",
					"INSERT INTO group_id (Name) VALUES (6, 'ÏÄ - 14');\n",
					"INSERT INTO group_id (Name) VALUES (7, '²ÑÄ - 11');\n",
					"INSERT INTO group_id (Name) VALUES (8, '²ÑÄ - 12');\n",
					"INSERT INTO group_id (Name) VALUES (9, 'Ê²Ä - 11');\n",
					"INSERT INTO group_id (Name) VALUES (10, 'Ê²Ä - 12');\n",
					"INSERT INTO group_id (Name) VALUES (11, 'ÊÍÄ - 11');\n",
					"INSERT INTO group_id (Name) VALUES (12, 'ÊÍÄ - 12');",

					"CREATE TABLE `lectures_id` (\n" + "`id` INTEGER NOT NULL ,\n" + "`type` TEXT NOT NULL,\n"
							+ "PRIMARY KEY (`id`, `type`)" + ");",

					"CREATE TABLE `presence_values` (\n" + "`id` INTEGER NOT NULL ,\n" + "`value` TEXT NOT NULL,\n"
							+ "PRIMARY KEY (`id`, `value`)" + ");",

					"CREATE TABLE students ("
							+ "id INTEGER DEFAULT (- 1) NOT NULL PRIMARY KEY ON CONFLICT IGNORE AUTOINCREMENT,"
							+ "group_id INTEGER NOT NULL DEFAULT (- 1)," + "name TEXT NOT NULL,"
							+ "second_name TEXT NOT NULL," + "third_name TEXT NOT NULL," + "initials TEXT NOT NULL,"
							+ "card_number INTEGER NOT NULL" + ");\n", };
			Statement stat = conn.createStatement();
			for (String str : request) {
//				stat.execute(str);
				stat.executeUpdate(str);
			}
		}

		void setProperties(String key, String value) {
			Properties prop = new Properties();
			prop.setProperty(key, value);
			try {
				FileOutputStream stream = new FileOutputStream("dbConfigs.properties", true);
				prop.store(stream, "Remote properties");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
