package electro;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

import java.util.Objects;
import javax.swing.*;

public class SwingChange extends JPanel {
	private JComboBox<Object> dropper;
	private JButton addStudent;
	private JTable initials;
	private JButton renew;
	private ArrayList<String> dates = new ArrayList<String>();
	private ArrayList<String> lectures = new ArrayList<String>();
	private JTextField field;
	private JTextField field2;
	private JTextField field3;

	SwingChange(Connection conn, DB_Handler dbh) {
		this.setBounds(0, 0, 1300, 655);
		this.setLayout(null);

		JLabel headerADD = new JLabel("Add student:");
		headerADD.setBounds(50, 60, 150, 30);
		headerADD.setFont(new Font(null, Font.PLAIN, 16));
		this.add(headerADD);
		JLabel text = new JLabel("Enter name:");
		text.setBounds(50, 175, 150, 30);
		field = new JTextField();
		field.setBounds(50, 210, 150, 30);
		JLabel text2 = new JLabel("Enter surname:");
		text2.setBounds(50, 100, 150, 30);
		field2 = new JTextField();
		field2.setBounds(50, 135, 150, 30);
		JLabel text3 = new JLabel("Enter third name:");
		text3.setBounds(50, 250, 150, 30);
		field3 = new JTextField();
		field3.setBounds(50, 285, 150, 30);
		JLabel chooseGroup = new JLabel("Choose group:");
		chooseGroup.setBounds(70, 25, 150, 30);
		this.add(chooseGroup);
		this.add(createDropper(conn, dbh));
		addStudent = new JButton("ADD");
		addStudent.setBounds(50, 325, 90, 30);
		addStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
//					System.out.println(field.getText());
					if (field.getText() == null || field2.getText() == null || field3.getText() == null) {
						JDialog dialog = new JDialog();
						dialog.setBounds(300, 300, 200, 100);
						dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						dialog.setResizable(false);
						dialog.setLayout(null);
						JLabel label = new JLabel("Fill all the fields please!");
						label.setBounds(35, 15, 130, 30);
						dialog.add(label);
						dialog.setVisible(true);
					} else {
						getDates(conn, dbh, dates);
						getLectures(conn, dbh, lectures, dates);
						InsertIntoStudents(conn, dbh, field, field2, field3);
						insertIntoAttendance(conn, dbh, dates, lectures);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JLabel headerREMOVE = new JLabel("Remove student:");
		headerREMOVE.setBounds(320, 60, 150, 30);
		headerREMOVE.setFont(new Font(null, Font.PLAIN, 16));
		this.add(headerREMOVE);
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(320, 120, 300, 215);
		leftPanel.setLayout(new BorderLayout());
		initials = new JTable(25, 2);
		initials.getColumnModel().getColumn(0).setHeaderValue("Initials");
		initials.setRowHeight(25);
		initials.setCellSelectionEnabled(true);
		JButton delete = new JButton("DELETE");
		delete.setBounds(320, 340, 90, 30);
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					AdditionalWindows.RemoveStudent remStud = new AdditionalWindows().new RemoveStudent(conn, dbh,
							initials, dropper, chooseGroup(conn, dbh, dropper), dates);
					remStud.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		this.add(delete);
		JScrollPane scrollLeft = new JScrollPane(initials);
		leftPanel.add(scrollLeft);

		JLabel groupADD = new JLabel("Add group: ");
		groupADD.setBounds(640, 60, 150, 30);
		groupADD.setFont(new Font(null, Font.PLAIN, 16));
		this.add(groupADD);
		JLabel groupName = new JLabel("Enter name:");
		groupName.setBounds(640, 100, 150, 30);
		JTextField groupNameField = new JTextField();
		groupNameField.setBounds(640, 135, 150, 30);
		JButton addGroup = new JButton("ADD");
		addGroup.setBounds(640, 175, 90, 30);
		addGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				String input = "INSERT INTO group_id(Name) VALUES(?);";
				try {
					PreparedStatement prep = conn.prepareStatement(input);
					prep.setString(1, groupNameField.getText());
					prep.execute();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
//		JButton deleteGroup = new JButton("Delete current group (must be empty)");
//		deleteGroup.setBounds(640, 210, 250, 40);
//		deleteGroup.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent event) {
//					String input = "DELETE FROM group_id WHERE Name = ?";
//					try {
//						PreparedStatement prep = conn.prepareStatement(input);
//						prep.setString(1, (String)dropper.getSelectedItem());
//						prep.execute();
//						createDropper(conn, dbh);
//					}catch(SQLException ex) {
//						ex.printStackTrace();
//					}
//			}
//		});

		this.add(groupName);	this.add(groupNameField);	this.add(addGroup);
//		this.add(deleteGroup);
		this.add(leftPanel);	this.add(addStudent);
		this.add(text);			this.add(field);
		this.add(text2);			this.add(field2);
		this.add(text3);			this.add(field3);
		this.add(createRenew());
	}

	void InsertIntoStudents(Connection conn, DB_Handler dbh, JTextField field, JTextField field2, JTextField field3)
			throws SQLException {
		String input = "INSERT INTO students(group_id, name, second_name, third_name, initials, card_number)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement prep = conn.prepareStatement(input);
		prep.setInt(1, chooseGroup(conn, dbh, dropper));
		prep.setString(2, field.getText());
		prep.setString(3, field2.getText());
		prep.setString(4, field3.getText());
		prep.setString(5,
				(field2.getText() + " " + field.getText().charAt(0) + "." + field3.getText().charAt(0) + "."));
		prep.setInt(6, 12345);
		prep.executeUpdate();
	}

	void insertIntoAttendance(Connection conn, DB_Handler dbh, ArrayList<String> dates, ArrayList<String> lectures)
			throws SQLException {
		int lastIndex = 0;
		String lastInsert = "SELECT id FROM students WHERE id = last_insert_rowid();";
		PreparedStatement prep = conn.prepareStatement(lastInsert);
		ResultSet set = prep.executeQuery();
		while (set.next()) {
			lastIndex = set.getInt("id");
		}
		System.out.println(lastIndex);
		String input = "INSERT INTO attendance(student_id, data, lecture_id, group_id, presence_value) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement prepSt = conn.prepareStatement(input);
		int lect = 0;
		for (String str : dates) {
			prepSt.setInt(1, lastIndex);
			prepSt.setString(2, str);
			prepSt.setString(3, lectures.get(lect));
			prepSt.setInt(4, chooseGroup(conn, dbh, dropper));
			prepSt.setInt(5, -1);
			prepSt.executeUpdate();
			lect++;
		}
	}

	void getDates(Connection conn, DB_Handler dbh, ArrayList<String> dat) throws SQLException {
		String inputDate = "SELECT data FROM attendance WHERE group_id = " + chooseGroup(conn, dbh, dropper);
		PreparedStatement prep = conn.prepareStatement(inputDate);
		ResultSet rSet = prep.executeQuery();
		while (rSet.next()) {
			if (!dat.contains(rSet.getString(1))) {
				dat.add(rSet.getString(1));
			}
		}
	}

	void getLectures(Connection conn, DB_Handler dbh, ArrayList<String> lect, ArrayList<String> data)
			throws SQLException {
		for (String str : data) {
			String inputLect = "SELECT lecture_id FROM attendance WHERE group_id = " + chooseGroup(conn, dbh, dropper)
					+ " AND data =  '" + str + "'";
			PreparedStatement prep = conn.prepareStatement(inputLect);
			ResultSet rSet = prep.executeQuery();
			while (rSet.next()) {
				lect.add(rSet.getString(1));
			}
		}
	}

	JButton createRenew() {
		renew = new JButton(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Pictures/Reload.png"))).getImage()
				.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		renew.setBounds(1220, 10, 30, 30);
		renew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dropper.setSelectedItem(dropper.getSelectedItem());
				field.setText(null);
				field2.setText(null);
				field3.setText(null);
			}
		});
		return renew;
	}

	void renewInitials(Connection conn, DB_Handler dbh, String input, int choice) throws SQLException {
		PreparedStatement prs = conn.prepareStatement(input);
		prs.setString(1, Integer.toString(choice));
		ResultSet rs = prs.executeQuery();
		initials.setModel(DbUtils.resultSetToTableModel(rs));
	}

	JComboBox<Object> createDropper(Connection conn, DB_Handler dbh) {
		Object[] groups = getAllGroups(conn, dbh);
		dropper = new JComboBox<>(groups);
		dropper.setBounds(205, 30, 100, 20);
		dropper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String input = "SELECT initials FROM students WHERE group_id = ?"; // adding data to initials table
					renewInitials(conn, dbh, input, chooseGroup(conn, dbh, dropper));
					initials.getColumnModel().getColumn(0).setMaxWidth(20);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		return dropper;
	}

	int chooseGroup(Connection conn, DB_Handler dbh, JComboBox<Object> box) {
		int choice = 0;
		String input = "SELECT id FROM group_id WHERE Name = '" + (String) box.getSelectedItem() + "'";
		try {
			PreparedStatement prep = conn.prepareStatement(input);
			ResultSet set = prep.executeQuery();
			while (set.next()) {
				choice = set.getInt("id");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return choice;
	}

	int getID(Connection conn, DB_Handler dbh, String initials) {
		try {
			String input = "SELECT id FROM students WHERE initials = '" + initials + "'";
			PreparedStatement prst = conn.prepareStatement(input);
			ResultSet rSet = prst.executeQuery();
			while (rSet.next()) {
				return rSet.getInt("id");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	Object[] getAllGroups(Connection conn, DB_Handler dbh) {
		ArrayList<String> groups = new ArrayList<>();
		String input = "SELECT Name FROM group_id";
		try {
			PreparedStatement prep = conn.prepareStatement(input);
			ResultSet set = prep.executeQuery();
			while (set.next()) {
				groups.add(set.getString(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return groups.toArray();
	}
}