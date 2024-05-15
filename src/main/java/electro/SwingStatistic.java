package electro;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

import java.util.Objects;
import javax.swing.*;
import javax.swing.table.*;

import CellRenderers.StatisticsRedForeground;
import HeaderRenderers.*;
import org.jfree.chart.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class SwingStatistic extends JPanel {
	private JComboBox<Object> dropper;
	private JTable initials;
	private JTable presence;
	private JPanel leftPanel;
	private JScrollPane scrollLeft;
	private JPanel rightPanel;
	private JScrollPane scrollRight;
	private JButton renew;
	private JPanel sortPanel;
	DefaultPieDataset dataSet;
	JFreeChart pieChart;
	
	private JRadioButton byAlphabetUp;
	private JRadioButton byAlphabetDown;
	private JRadioButton byRatingUp;
	private JRadioButton byRatingDown;

	SwingStatistic(Connection conn, DB_Handler dbh, JTable presenceTable, JComboBox<Object> dropperAttendance) {
		this.setBounds(0, 0, 1300, 655);
		this.setLayout(null);
		this.add(createDropper(conn, dbh, presenceTable, dropperAttendance));
		this.add(initialsTable(conn, dbh));
		this.add(InitialiseAttendanceTable(dropper, conn, dbh));
		this.add(createRenew());
		this.add(addSortPanel());

		scrollLeft.setVerticalScrollBar(scrollRight.getVerticalScrollBar());					//	connect left and right scroll bars
	}
	
	JButton createRenew() {
		renew = new JButton(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Pictures/Reload.png"))).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		renew.setBounds(1220, 10, 30, 30);
		renew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dropper.setSelectedItem(dropper.getSelectedItem());
			}
		});
		return renew;
	}

	JPanel initialsTable(Connection conn, DB_Handler dbh) {
		// filling left panel
		leftPanel = new JPanel();
		leftPanel.setBounds(50, 50, 400, 500);
		leftPanel.setLayout(new BorderLayout());
		// table of initials
		initials = new JTable(25, 2);
		initials.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				super.mouseClicked(event);
				if(event.getButton() == MouseEvent.BUTTON1){
					int pres = 0;
					for(int i = 0; i < 3; i++){
						pres += (int)presence.getValueAt(initials.rowAtPoint(event.getPoint()), i);
					}
					pieChart.setTitle((String)(initials.getValueAt(initials.rowAtPoint(event.getPoint()), 1)));
					dataSet.setValue("Present", pres);
					dataSet.setValue("Absent", (int)presence.getValueAt(initials.rowAtPoint(event.getPoint()), 5));
					dataSet.setValue("Illness", (int)presence.getValueAt(initials.rowAtPoint(event.getPoint()), 3));
				}
			}
		});
		initials.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(initials.getColumnModel().getColumn(1).getHeaderValue() == "Initials(a - z)"){
					byAlphabetDown.setSelected(true);
					dropper.setSelectedItem(dropper.getSelectedItem());
				}else if(initials.getColumnModel().getColumn(1).getHeaderValue() == "Initials(z - a)") {
					byAlphabetUp.setSelected(true);
					dropper.setSelectedItem(dropper.getSelectedItem());
				}else {
					byAlphabetUp.setSelected(true);
					dropper.setSelectedItem(dropper.getSelectedItem());
				}
			}
		});
		initials.setRowHeight(25);
		initials.setCellSelectionEnabled(false);
		initials.setEnabled(false);
		scrollLeft = new JScrollPane(initials);
		leftPanel.add(scrollLeft);
		return leftPanel;
	}

	JPanel InitialiseAttendanceTable(JComboBox<Object> dropper, Connection conn, DB_Handler dbh) {
		// filling right panel
		rightPanel = new JPanel();
		rightPanel.setBounds(460, 50, 790, 500);
		rightPanel.setLayout(new BorderLayout());
		//Creates a sample dataset
		dataSet = new DefaultPieDataset();

		// based on the dataset we create the chart
		pieChart = ChartFactory.createPieChart("", dataSet, false, false, false);

		// Adding chart into a chart panel
		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setBounds(rightPanel.getWidth() - 380, 10, 370, 370);
		rightPanel.add(chartPanel);


		// table of presence
		DefaultTableModel rightModel = new DefaultTableModel(initials.getRowCount(), 6) {
			@Override
			public Class<String> getColumnClass(int colIndex) {
				return String.class;
			}
		};
		presence = new JTable(rightModel);
		presence.setBounds(0, 0, 75, 1000);
		presence.getColumnModel().getColumn(3).setHeaderRenderer(new Zero("Illness"));
		presence.getColumnModel().getColumn(4).setMaxWidth(0);
		presence.getColumnModel().getColumn(4).setMinWidth(0);
		presence.getColumnModel().getColumn(4).setPreferredWidth(0);
		presence.getColumnModel().getColumn(5).setHeaderValue("Absence(1 - n)");
		presence.getColumnModel().getColumn(5).setPreferredWidth(100);
		presence.setRowHeight(25);
		presence.setCellSelectionEnabled(false);
		presence.setEnabled(false);
		presence.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(presence.getColumnModel().getColumn(5).getHeaderValue() == "Absence(1 - n)") {
					byRatingDown.setSelected(true);
					dropper.setSelectedItem(dropper.getSelectedItem());
				}else {
					byRatingUp.setSelected(true);
					dropper.setSelectedItem(dropper.getSelectedItem());
				}
			}
		});
		scrollRight = new JScrollPane(presence, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		presence.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		rightPanel.add(scrollRight);
		return rightPanel;
	}
	JComboBox<Object> createDropper(Connection conn, DB_Handler dbh, JTable presenceTable, JComboBox<Object> dropperAttendance) {
		Object[] groups = getAllGroups(conn, dbh);
		dropper = new JComboBox<>(groups);
		dropper.setBounds(50, 20, 100, 20);
		dropper.addActionListener(new ActionListener() {														// adding listener to dropper
			public void actionPerformed(ActionEvent e) {
				try {
					if (presenceTable.getColumnCount() >= 5) {
						dropperAttendance.setSelectedItem(dropper.getSelectedItem());
						int basicHours[] = new int[3];
//					getTableBasicHours(presenceTable, basicHours);
						getDatabaseBasicHours(conn, dbh, basicHours);
						presence.getColumnModel().getColumn(0).setHeaderRenderer(new Lecture("Lc (" + basicHours[0] + ")"));
						presence.getColumnModel().getColumn(1).setHeaderRenderer(new Practice("Pr (" + basicHours[1] + ")"));
						presence.getColumnModel().getColumn(2).setHeaderRenderer(new Laboratory("Lab (" + basicHours[2] + ")"));
						clearTable(0);

						if (byAlphabetUp.isSelected()) {
							renewInitialsByAlphabetUp(conn, dbh, chooseGroup(conn, dbh));
							initials.getColumnModel().getColumn(1).setHeaderValue("Initials(a - z)");
						} else if (byAlphabetDown.isSelected()) {
							renewInitialsByAlphabetDown(conn, dbh, chooseGroup(conn, dbh));
							initials.getColumnModel().getColumn(1).setHeaderValue("Initials(z - a)");
						} else if (byRatingUp.isSelected()) {
							renewInitialsByRatingUp(conn, dbh, chooseGroup(conn, dbh));
							presence.getColumnModel().getColumn(5).setHeaderValue("Absence(1 - n)");
						} else if (byRatingDown.isSelected()) {
							renewInitialsByRatingDown(conn, dbh, chooseGroup(conn, dbh));
							presence.getColumnModel().getColumn(5).setHeaderValue("Absence(n - 1)");
						}
//					renewInitials(conn, dbh, input, chooseGroup(conn, dbh));		

						initials.getColumnModel().getColumn(0).setMaxWidth(20);
						ArrayList<Integer[]> list = new ArrayList<Integer[]>();
//					getTableAttendance(presenceTable, list);			// incorrect data
						getAttendance(conn, dbh, list);
						int row = 0;
						for (Integer[] obj : list) {
							presence.setValueAt(obj[0], row, 0);
							presence.setValueAt(obj[1], row, 1);
							presence.setValueAt(obj[2], row, 2);
							presence.setValueAt(obj[3], row, 3);
							presence.setValueAt(obj[4], row, 4);
							presence.setValueAt(obj[5], row, 5);
							row++;
						}
						presence.setDefaultRenderer(Object.class, new StatisticsRedForeground());
					}else {
						JOptionPane.showMessageDialog(null, "Not enough data for statistics!", "WARNING", JOptionPane.ERROR_MESSAGE);
						dropper.setSelectedItem(dropper.getSelectedItem());
					}
					} catch(Exception ex){
						ex.printStackTrace();
					}
			}
		});
		return dropper;
	}
	JPanel addSortPanel() {
		sortPanel = new JPanel();
		sortPanel.setVisible(false);
		sortPanel.setBounds(185, 20, 300, 20);
		sortPanel.setLayout(new GridLayout());
		ButtonGroup group = new ButtonGroup();
		
		byAlphabetDown = new JRadioButton("AD");	byAlphabetDown.setSize(30, 30);		byAlphabetUp = new JRadioButton("AU");		byAlphabetUp.setSize(30, 30);		byAlphabetUp.setSelected(true);
		byRatingUp = new JRadioButton("RU");			byRatingUp.setSize(30, 30);	byRatingDown = new JRadioButton("RD");		byRatingDown.setSize(30, 30);
		group.add(byAlphabetUp);		group.add(byAlphabetDown);		group.add(byRatingUp);		group.add(byRatingDown);
		sortPanel.add(byAlphabetUp);		sortPanel.add(byAlphabetDown);		sortPanel.add(byRatingUp);		sortPanel.add(byRatingDown);
				
		return sortPanel;
	}
	Object[] getAllGroups(Connection conn, DB_Handler dbh) {
		ArrayList<String> groups = new ArrayList<String>();
		String input = "SELECT Name FROM group_id";
		try {
			PreparedStatement prep = conn.prepareStatement(input);
			ResultSet set = prep.executeQuery();
			while(set.next()) {
				groups.add(set.getString(1));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return groups.toArray();
	}
	void getAttendance(Connection conn, DB_Handler dbh, ArrayList<Integer[]> groupList) throws SQLException {
		for(int i = 0; i < initials.getRowCount(); i++) {
		Integer[] list = {0, 0, 0, 0, 0, 0};
		String input = "select presence_value, lecture_id from attendance where group_id = ? and student_id = " + getID(conn, dbh, i);
		PreparedStatement prep = conn.prepareStatement(input);
		prep.setInt(1, chooseGroup(conn, dbh));
		ResultSet set = prep.executeQuery();
		while(set.next()) {
			if(set.getInt("lecture_id") == 1) {
				if(set.getInt("presence_value") == 1 || set.getInt("presence_value") == 2) {
					list[0]++;	//	increment lecture amount if presence_value = 1 or 2
				}else if(set.getInt("presence_value") == 3) {
					list[3]++;	//	//	increment illness amount if presence_value = 0
				}else if(set.getInt("presence_value") == -1) {
					list[4]++;	//	//	increment illness amount if presence_value = 0
				}else if(set.getInt("presence_value") == 0) {
					list[5]++;	//	//	increment illness amount if presence_value = 0
				}
			} else if(set.getInt("lecture_id") == 2) {
				if(set.getInt("presence_value") == 1 || set.getInt("presence_value") == 2) {
					list[1]++;	//	increment practice amount if presence_value = 1 or 2
				}else if(set.getInt("presence_value") == 3) {
					list[3]++;	//	increment illness amount if presence_value = 0
				}else if(set.getInt("presence_value") == -1) {
					list[4]++;	//	//	increment illness amount if presence_value = 0
				}else if(set.getInt("presence_value") == 0) {
					list[5]++;	//	//	increment illness amount if presence_value = 0
				}				
			}else if(set.getInt("lecture_id") == 3) {
				if(set.getInt("presence_value") == 1 || set.getInt("presence_value") == 2) {
					list[2]++;	//	increment practice amount if presence_value = 1 or 2
				}else if(set.getInt("presence_value") == 3) {
					list[3]++;	//	increment illness amount if presence_value = 0
				}else if(set.getInt("presence_value") == -1) {
					list[4]++;	//	//	increment illness amount if presence_value = 0
				}else if(set.getInt("presence_value") == 0) {
					list[5]++;	//	//	increment absence amount if presence_value = 0
				}
			}
		}
		groupList.add(list);
		}
	}
	void getTableAttendance(JTable presenceTable, ArrayList<Integer[]> groupList) {
		for(int row = 0; row < initials.getRowCount(); row++) {
			Integer[] list = {0, 0, 0, 0, 0};
			for(int col = 0; col < presenceTable.getColumnCount(); col++) {
				if(presenceTable.getColumnModel().getColumn(col).getHeaderRenderer().getClass() == new Lecture().getClass()) {
					if(presenceTable.getValueAt(row, col) == "Присутній" || presenceTable.getValueAt(row, col) == "Запізнився") {
						list[0]++;	//	increment lecture amount if presence_value = 1 or 2
					}else if(presenceTable.getValueAt(row, col) == "Захворів") {
						list[3]++;	//	//	increment illness amount if presence_value = 0
					}else if(presenceTable.getValueAt(row, col) == " - ") {
						list[4]++;	//	//	increment illness amount if presence_value = 0
					}
				} else if(presenceTable.getColumnModel().getColumn(col).getHeaderRenderer().getClass() == new Practice().getClass()) {
					if(presenceTable.getValueAt(row, col) == "Присутній" || presenceTable.getValueAt(row, col) == "Запізнився") {
						list[1]++;	//	increment practice amount if presence_value = 1 or 2
					}else if(presenceTable.getValueAt(row, col) == "Захворів") {
						list[3]++;	//	increment illness amount if presence_value = 0
					}else if(presenceTable.getValueAt(row, col) == " - ") {
						list[4]++;	//	//	increment illness amount if presence_value = 0
					}
				}else if(presenceTable.getColumnModel().getColumn(col).getHeaderRenderer().getClass() == new Laboratory().getClass()) {
					if(presenceTable.getValueAt(row, col) == "Присутній" || presenceTable.getValueAt(row, col) == "Запізнився") {
						list[2]++;	//	increment practice amount if presence_value = 1 or 2
					}else if(presenceTable.getValueAt(row, col) == "Захворів") {
						list[3]++;	//	increment illness amount if presence_value = 0
					}else if(presenceTable.getValueAt(row, col) == " - ") {
						list[4]++;	//	//	increment illness amount if presence_value = 0
					}
				}
			}
		groupList.add(list);
//		System.out.println(Arrays.toString(list));
		}
	}
	Integer getID(Connection conn, DB_Handler dbh, int row) throws SQLException {
		String input = "SELECT id FROM students WHERE initials = ?";
		PreparedStatement prst = conn.prepareStatement(input);
		prst.setString(1, (String)(initials.getValueAt(row, 1)));
		ResultSet rSet = prst.executeQuery();
		while(rSet.next()) {
			return rSet.getInt("id");
		}
		return 0;
	}
	void getDatabaseBasicHours(Connection conn, DB_Handler dbh, int[] array) throws SQLException {
		String input = "select lecture, practice, laboratory, sum from basic_hours where group_id = " + chooseGroup(conn, dbh);
		PreparedStatement prep = conn.prepareStatement(input);
		ResultSet rSet = prep.executeQuery();
		while(rSet.next()) {
			array[0] = rSet.getInt("lecture");
			array[1] = rSet.getInt("practice");
			array[2] = rSet.getInt("laboratory");
//			array[3] = rSet.getInt("sum");
		}
	}
	void getTableBasicHours(JTable presenceTable, int[] array) {
		for(int col = 0; col < presenceTable.getColumnCount(); col++) {
			if(presenceTable.getColumnModel().getColumn(col).getHeaderRenderer().getClass() == new Lecture().getClass()) {
				array[0] += 1;
			}else if(presenceTable.getColumnModel().getColumn(col).getHeaderRenderer().getClass() == new Practice().getClass()) {
				array[1] += 1;
			}else if(presenceTable.getColumnModel().getColumn(col).getHeaderRenderer().getClass() == new Laboratory().getClass()) {
				array[2] += 1;
			}
		}
	}
	void clearTable(int col) {
		for(int i = col; i < presence.getColumnCount(); i++) {
			for (int row = 0; row < presence.getRowCount(); row++) {
				presence.getModel().setValueAt(null, row, i);
			}
		}
	}
	void renewInitials(Connection conn, DB_Handler dbh, int choice) throws SQLException{
		String input = "SELECT initials FROM students WHERE group_id = ?";
		PreparedStatement prs = conn.prepareStatement(input);
		prs.setString(1, Integer.toString(choice));
		ResultSet rs = prs.executeQuery();
		initials.setModel(DbUtils.resultSetToTableModel(rs));
	}
	void renewInitialsByAlphabetUp(Connection conn, DB_Handler dbh, int choice) throws SQLException{
		String input = "SELECT initials FROM students WHERE group_id = ? ORDER BY initials";				// adding data to initials table
		PreparedStatement prs = conn.prepareStatement(input);
		prs.setString(1, Integer.toString(choice));
		ResultSet rs = prs.executeQuery();
		initials.setModel(DbUtils.resultSetToTableModel(rs));
	}
	void renewInitialsByAlphabetDown(Connection conn, DB_Handler dbh, int choice) throws SQLException{
		String input = "SELECT initials FROM students WHERE group_id = ? ORDER BY initials DESC";				// adding data to initials table
		PreparedStatement prs = conn.prepareStatement(input);
		prs.setString(1, Integer.toString(choice));
		ResultSet rs = prs.executeQuery();
		initials.setModel(DbUtils.resultSetToTableModel(rs));
	}
	void renewInitialsByRatingUp(Connection conn, DB_Handler dbh, int choice) throws SQLException{
		String input = "SELECT initials FROM("
				+ "	SELECT MAX(initials) AS initials, COUNT(initials) AS amount"
				+ "	FROM("
				+ "		SELECT students.initials, attendance.presence_value"
				+ "		FROM students JOIN attendance ON students.id = attendance.student_id"
				+ "		WHERE students.group_id = ? AND attendance.presence_value = 0"
				+ "	) AS whatever"
				+ "	GROUP BY initials ORDER BY amount DESC"
				+ ") AS anything;";
		PreparedStatement prs = conn.prepareStatement(input);
		prs.setString(1, Integer.toString(choice));
		ResultSet rs = prs.executeQuery();
		initials.setModel(DbUtils.resultSetToTableModel(rs));
	}
	void renewInitialsByRatingDown(Connection conn, DB_Handler dbh, int choice) throws SQLException{
		String input = "SELECT initials FROM("
				+ "	SELECT MAX(initials) AS initials, COUNT(initials) AS amount"
				+ "	FROM("
				+ "		SELECT students.initials, attendance.presence_value"
				+ "		FROM students JOIN attendance ON students.id = attendance.student_id"
				+ "		WHERE students.group_id = ? AND attendance.presence_value = 0"
				+ "	) AS whatever"
				+ "	GROUP BY initials ORDER BY amount"
				+ ") AS anything;";
		PreparedStatement prs = conn.prepareStatement(input);
		prs.setString(1, Integer.toString(choice));
		ResultSet rs = prs.executeQuery();
		initials.setModel(DbUtils.resultSetToTableModel(rs));
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
}
