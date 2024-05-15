package electro;

import java.sql.Connection;
import javax.swing.*;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ApplicationStarter {

	public static void main(String[] args) {
		try {
			DB_Handler dbh = new DB_Handler();
//			Connection conn = dbh.getMYSQLConnection();
			Connection conn = dbh.getSQLiteConnection();
			
			JFrame frame = new JFrame("IT Presence Journal");
			frame.setLocationRelativeTo(null);
			frame.setBounds(0, 0, 1300, 655);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);

			SwingAttendance window1 = new SwingAttendance(conn, dbh);
			SwingStatistic window2 = new SwingStatistic(conn, dbh, window1.presence, window1.dropper);
			SwingChange window3 = new SwingChange(conn, dbh);

//			SwingSettings window4 = new SwingSettings(conn, dbh, dbh.dbHost, dbh.dbPort, dbh.dbName);
			
			JTabbedPane jPane = new JTabbedPane();
			jPane.setBounds(0, 0, 1300, 655);
			jPane.add("Attendance", window1);
			jPane.add("Statistics", window2);
			jPane.add("Data settings", window3);
//			jPane.add("DB Settings", window4);
			jPane.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					if(jPane.getSelectedIndex() == 1 && (window1.dates.size() < 5 || window1.dates.size() == 0)){
						JOptionPane.showMessageDialog(frame, "Not enough data for statistics", "WARNING", JOptionPane.ERROR_MESSAGE);
						jPane.setSelectedIndex(0);
					}
				}
			});
			frame.add(jPane);
			frame.setVisible(true);

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}
}