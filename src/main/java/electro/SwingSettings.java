package electro;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class SwingSettings extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;

    SwingSettings(Connection conn, DB_Handler dbh, String host, String port, String name){
        this.setBounds(0, 0, 1300, 655);
        this.setLayout(null);
        JLabel chooseGroup = new JLabel("Current Data Base configurations:");
        chooseGroup.setBounds(50, 60, 300, 30);
        chooseGroup.setFont(new Font(null, Font.PLAIN, 16));
        this.add(chooseGroup);

        JLabel text1 = new JLabel("DB Host:");			text1.setBounds(50, 175, 150, 30);
        field1 = new JTextField();								    field1.setBounds(50, 210, 150, 30);

        JLabel text2 = new JLabel("DB Port:");		    text2.setBounds(50, 100, 150, 30);
        field2 = new JTextField();							        field2.setBounds(50, 135, 150, 30);

        JLabel text3 = new JLabel("DB Name:");		    text3.setBounds(50, 250, 150, 30);
        field3 = new JTextField();								    field3.setBounds(50, 285, 150, 30);
        field1.setEnabled(false);    field2.setEnabled(false);    field3.setEnabled(false);
        field1.setText(host);       field2.setText(port);       field3.setText(name);

        this.add(text1);		this.add(field1);
        this.add(text2);		this.add(field2);
        this.add(text3);		this.add(field3);
    }

    String getProperties(String propName) {
        String propValue = "";
        Properties prop = new Properties();
        try{
            prop.load(new FileInputStream(new File("dbConfigs.properties")));
            propValue = prop.getProperty(propName);
        }catch(IOException ex) {
            ex.printStackTrace();
        }
        return propValue;
    }

}
