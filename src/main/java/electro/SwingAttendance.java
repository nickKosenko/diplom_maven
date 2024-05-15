package electro;

import java.awt.*;
import HeaderRenderers.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import CellRenderers.*;

class SwingAttendance extends JPanel {
	JComboBox<Object> dropper;
	private JButton renew;
	private JTable initials;
	JTable presence;
	private JPanel leftPanel;
	private JScrollPane scrollLeft;
	private JPanel rightPanel;
	private JScrollPane scrollRight;
	ArrayList<String> dates = new ArrayList<String>();
	private ArrayList<String> lectures = new ArrayList<String>();

	SwingAttendance(Connection conn, DB_Handler dbh) {
		this.setBounds(0, 0, 1300, 655);
		this.setLayout(null);
		this.add(createDropper(conn, dbh));
		this.add(InitialsTable(conn, dbh));
		this.add(presenceTable(dropper, conn, dbh, this));
		this.add(createRenew());
		this.add(createAddButton(conn, dbh));
//		this.add(addSortPanel());
		scrollLeft.setVerticalScrollBar(scrollRight.getVerticalScrollBar());					//	connect left and right scroll bars
	}
	JButton createRenew() {
		renew = new JButton(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Pictures/Reload.png"))).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		renew.setBounds(1220, 10, 30, 30);
		renew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dropper.setSelectedItem(dropper.getSelectedItem());
				dropper.setSelectedItem(dropper.getSelectedItem());
			}
		});
		return renew;
	}
	JButton createAddButton(Connection conn, DB_Handler dbh) {
//		ArrayList<String> dates = new ArrayList<String>();
//		getDates(conn, dbh, dates);
		renew = new JButton(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Pictures/Plus.png"))).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		renew.setBounds(1180, 10, 30, 30);
		renew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(initials.getRowCount() == 0){
					JOptionPane.showMessageDialog(null, "Add a student first!", "WARNING", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						AdditionalWindows.SetDate window = new AdditionalWindows().new SetDate(presence, initials, conn, dbh, chooseGroup(conn, dbh), dates, dropper);
						window.setVisible(true);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		return renew;
	}
	
	JPanel InitialsTable(Connection conn, DB_Handler dbh) {
		leftPanel = new JPanel();																		// filling left panel
		leftPanel.setBounds(50, 50, 400, 500);
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBackground(Color.GREEN);
		initials = new JTable(25, 2);																	// table of initials
//		initials.getColumnModel().getColumn(0).setHeaderValue("Initials");
		initials.setRowHeight(25);
		initials.setCellSelectionEnabled(false);
		initials.setEnabled(false);
		scrollLeft = new JScrollPane(initials);
		leftPanel.add(scrollLeft);
		return leftPanel;
	}

	JPanel presenceTable(JComboBox<Object> dropper, Connection conn, DB_Handler dbh, SwingAttendance window) {
		rightPanel = new JPanel();														// filling right panel
		rightPanel.setBounds(460, 50, 790, 515);
		rightPanel.setLayout(new BorderLayout());
//		DefaultTableModel rightModel = new DefaultTableModel(initials.getRowCount(), getBasicHours(conn, dbh)[3]) {						// table of presence
		DefaultTableModel rightModel = new DefaultTableModel(initials.getRowCount(), 100){
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
			@Override
			public Class<String> getColumnClass(int colIndex) {	return String.class;	}};
		presence = new JTable(rightModel);
		presence.setRowHeight(25);
		presence.setCellSelectionEnabled(true);
		presence.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent me) { }
			@Override
			public void mouseReleased(MouseEvent me) { }
			@Override
			public void mouseEntered(MouseEvent me) { }
			@Override
			public void mouseExited(MouseEvent me) { }
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
//					ArrayList<String> dates = new ArrayList<String>();
//					getDates(conn, dbh, dates);
					if(e.getButton() == MouseEvent.BUTTON3) {
//						System.out.println("Right pressed!");
					}else {
						presence.getColumnModel().getColumn(presence.columnAtPoint(e.getPoint())).setCellRenderer(new GreenHighlight());
						if(presence.getColumnModel().getColumn(presence.columnAtPoint(e.getPoint())).getHeaderRenderer().getClass() == new Zero().getClass()) {
							AdditionalWindows.AddPresence awp = new AdditionalWindows().
									new AddPresence(e, e.getX(), e.getY(), (String)(initials.getValueAt(presence.rowAtPoint(e.getPoint()), 0)),
											presence, initials, conn, dbh, chooseGroup(conn, dbh), dates, window, dropper);
							awp.setVisible(true);
						} else{
							if(presence.getValueAt(presence.rowAtPoint(e.getPoint()), presence.columnAtPoint(e.getPoint())) == null) {
								AdditionalWindows.AddPresence awp = new AdditionalWindows().
										new AddPresence(e, e.getX(), e.getY(), (String)(initials.getValueAt(presence.rowAtPoint(e.getPoint()), 0)),
												presence, initials, conn, dbh, chooseGroup(conn, dbh), dates, 0, window, dropper);
								awp.setVisible(true);
							} else if(presence.getValueAt(presence.rowAtPoint(e.getPoint()), presence.columnAtPoint(e.getPoint())) == " - ") {
								AdditionalWindows.AddPresence awp = new AdditionalWindows().
//										new AddPresence(e, e.getX(), e.getY(), (String)(initials.getValueAt(presence.rowAtPoint(e.getPoint()), 0)),
										new AddPresence(e, e.getX(), e.getY(), (String)(initials.getValueAt(presence.rowAtPoint(e.getPoint()), 1)),
												presence, initials, conn, dbh, chooseGroup(conn, dbh), dates, 0, window, dropper);
								awp.setVisible(true);
							} else {
								AdditionalWindows.ChangePresence awp = new AdditionalWindows().
//										new ChangePresence(e, e.getX(), e.getY(), (String)(initials.getValueAt(presence.rowAtPoint(e.getPoint()), 0)),
										new ChangePresence(e, e.getX(), e.getY(), (String)(initials.getValueAt(presence.rowAtPoint(e.getPoint()), 1)),
												presence, initials, conn, dbh, chooseGroup(conn, dbh), dates, window, dropper);
								awp.setVisible(true);
							}
						}
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		presence.getTableHeader().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
//				ArrayList<String> dates = new ArrayList<String>();
//				getDates(conn, dbh, dates);
				try {
					if(e.getButton() == MouseEvent.BUTTON3) {
						AdditionalWindows.RemoveDate window = new AdditionalWindows().new RemoveDate(conn, dbh, presence, chooseGroup(conn, dbh), dates, lectures, e, dropper);
						window.setVisible(true);
					}else {
						window.setEnabled(false);
						if(presence.getColumnModel().getColumn(presence.columnAtPoint(e.getPoint())).getHeaderRenderer().getClass() != new Zero().getClass()) {
							AdditionalWindows.ChangeLectureType lt = new AdditionalWindows().new ChangeLectureType(e, e.getX(), e.getY(),
									presence, chooseGroup(conn, dbh), dates, conn, dbh, window, dropper);
							lt.setVisible(true);
						}
					}
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		scrollRight = new JScrollPane(presence, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		presence.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		rightPanel.add(scrollRight);
		return rightPanel;
	}
	JComboBox<Object> createDropper(Connection conn, DB_Handler dbh) {
		Object[] groups = getAllGroups(conn, dbh);
		dropper = new JComboBox<>(groups);
		dropper.setBounds(50, 20, 100, 20);
		dates = new ArrayList<String>();
		lectures = new ArrayList<String>();
		dropper.addActionListener(new ActionListener() {														// adding listener to dropper
			public void actionPerformed(ActionEvent e) {
				try {
					clearTable(0);
					dates.clear();
					lectures.clear();
					renewInitials(conn, dbh, chooseGroup(conn, dbh));								
					initials.getColumnModel().getColumn(0).setMaxWidth(20);
					getDates(conn, dbh, dates);
//					System.out.println("Dates for group " + dropper.getSelectedItem() + " are " + dates);
					getLectures(conn, dbh, lectures, dates);
//					System.out.println(lectures);	
					int col = 0;
					for (String str : dates) {
						presence.getColumnModel().getColumn(col).setHeaderRenderer((TableCellRenderer)(chooseRenderer(lectures.get(col), str)));		
						//	TODO		warning!!!		there might be a mistake in code!!
						ArrayList<String> column = getPresenceColumn(conn, dbh, str);
						for(int row = 0; row < column.size(); row++) {
							presence.setValueAt(column.get(row), row, col);
						}
						presence.getColumnModel().getColumn(col).setCellRenderer(new PrresenceRedHighlight());
						col++;
					}
					hideColumns(dates.size(), 0);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		return dropper;
	}
	void hideColumns(int datesAmount, int width) {
		int colAmount = presence.getColumnCount();
		for(int i = datesAmount; i < colAmount; i++) {
			presence.getColumnModel().getColumn(i).setMinWidth(width);
			presence.getColumnModel().getColumn(i).setMaxWidth(width);
		}
		int rowCount = presence.getRowCount();
		for(int i = initials.getRowCount(); i < rowCount; i++) {
			presence.setRowHeight(i, 1);
		}
	}
	void clearTable(int col) {
		for(int i = col; i < presence.getColumnCount(); i++) {
			presence.getColumnModel().getColumn(i).setHeaderRenderer(new Zero(" "));
			presence.getColumnModel().getColumn(i).setMinWidth(75);
			presence.getColumnModel().getColumn(i).setMaxWidth(75);
			for (int row = 0; row < presence.getRowCount(); row++) {
				presence.getModel().setValueAt(null, row, i);
				presence.getColumnModel().getColumn(i).setHeaderRenderer(new Zero(" "));
				presence.getColumnModel().getColumn(i).setMinWidth(75);
				presence.getColumnModel().getColumn(i).setMaxWidth(75);
			}
		}
		int rowCount = presence.getRowCount();
		for(int i = initials.getRowCount(); i < rowCount; i++) {
			presence.setRowHeight(i, 25);
		}
	}
	void renewInitials(Connection conn, DB_Handler dbh, int choice) throws SQLException{
		String input = "SELECT initials FROM students WHERE group_id = ? ORDER BY initials";				// adding data to initials table
		PreparedStatement prs = conn.prepareStatement(input);
		prs.setString(1, Integer.toString(choice));
		ResultSet rs = prs.executeQuery();
		initials.setModel(DbUtils.resultSetToTableModel(rs));
	}
	void getDates(Connection conn, DB_Handler dbh, ArrayList<String> dat){
		try {
			String input = "SELECT data FROM attendance WHERE group_id = " + chooseGroup(conn, dbh);							// adding data to presence table
			PreparedStatement prep = conn.prepareStatement(input);
			ResultSet rSet = prep.executeQuery();
			while (rSet.next()) {
				if (!dat.contains(rSet.getString(1))) {
					dat.add(rSet.getString(1));
				}
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	int[] getBasicHours(Connection conn, DB_Handler dbh) {
		int array[] = new int[4];
		try {
		String input = "select lecture, practice, laboratory, sum from basic_hours where group_id = " + chooseGroup(conn, dbh);
		PreparedStatement prep = conn.prepareStatement(input);
		ResultSet rSet = prep.executeQuery();
		while(rSet.next()) {
			array[0] = rSet.getInt("lecture");
			array[1] = rSet.getInt("practice");
			array[2] = rSet.getInt("laboratory");
			array[3] = rSet.getInt("sum");
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return array;
	}	
	void getLectures(Connection conn, DB_Handler dbh, ArrayList<String> lect, ArrayList<String> data) throws SQLException{
		for(String str : data) {
			String inputLect = "SELECT lecture_id FROM attendance WHERE group_id = " + chooseGroup(conn, dbh) + " AND data =  '" + str + "'";
			PreparedStatement prep = conn.prepareStatement(inputLect);
			ResultSet rSet = prep.executeQuery();
			rSet.next();
			lect.add(rSet.getString(1));
		}
	}
	ArrayList<String> getPresenceColumn(Connection conn, DB_Handler dbh, String date) throws SQLException {
		ArrayList<String> column = new ArrayList<String>();
		for(int i = 0; i < initials.getRowCount(); i++) {
			String exist = "SELECT COUNT(*) FROM attendance WHERE student_id = " + getID(conn, dbh, (String)(initials.getValueAt(i, 1))) + " AND data = '" + date + "'";
			PreparedStatement prep = conn.prepareStatement(exist);
			ResultSet set = prep.executeQuery();
			while(set.next()) {
				if(set.getInt(1) == 0) {
					column.add(" - ");
				}else if(set.getInt(1) == 1){
					String input = "SELECT presence_value FROM attendance WHERE data = '" + date
							+ "' AND group_id = " + chooseGroup(conn, dbh) + " AND student_id = '" + getID(conn, dbh, (String)(initials.getValueAt(i, 1))) + "'";
					PreparedStatement stat = conn.prepareStatement(input);
					ResultSet rSet = stat.executeQuery();
					while (rSet.next()) {
						switch ("" + rSet.getInt("presence_value")) {
						case "-1": column.add(" - ");						break;
						case  "1":	column.add("illness");		break;
						case  "2":	column.add("present");		break;
						case  "0":	column.add("absent");	break;
						case  "3":	column.add("late");			break;
						}
					}
				}
			}
		}
//		System.out.println(column);
		return column;
	}
	int getID(Connection conn, DB_Handler dbh, String initials) {
		try {
			String input = "SELECT id FROM students WHERE initials = '" + initials + "'";
			PreparedStatement prst = conn.prepareStatement(input);
			ResultSet rSet = prst.executeQuery();
			while(rSet.next()) {
				return rSet.getInt("id");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	int chooseGroup(Connection conn, DB_Handler dbh) throws SQLException {
		int choice = 0;
		String input = "SELECT id FROM group_id WHERE Name = '" + (String) dropper.getSelectedItem() + "'";
		PreparedStatement prep = conn.prepareStatement(input);
		ResultSet set = prep.executeQuery();
		while(set.next()) {
			choice = set.getInt("id");
		}
		return choice;
	}
	Object[] getAllGroups(Connection conn, DB_Handler dbh) {
		ArrayList<String> groups = new ArrayList<String>();
		String input = "SELECT Name FROM group_id";
		try {
			Statement prep = conn.createStatement();
			ResultSet set = prep.executeQuery(input);
			while(set.next()) {
				groups.add(set.getString("Name"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return groups.toArray();
	}
	Object chooseRenderer(String lecture, String date) {
		switch(lecture) {
		case "1": return new Lecture(date);
		case "2": return new Practice(date);
		case "3": return new Laboratory(date);
		}
		return null;
	}
}