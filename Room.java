
package hotel.management.system;

import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener
{
	JTable table;
	JLabel lblRoomNumber,lblAvailability,lblCleanStatus,lblPrice,lblBed;
        JButton back;

	Room()
        {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
            Image i2 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(500,0,600,600);
            add(image);
            
            lblRoomNumber = new JLabel("Room Number");
            lblRoomNumber.setBounds(10, 10, 100, 20);
	    add(lblRoomNumber);
                
            lblAvailability = new JLabel("Availability");
            lblAvailability.setBounds(120, 10, 100, 20);
            add(lblAvailability);

            lblCleanStatus = new JLabel("Clean Status");
            lblCleanStatus.setBounds(230, 10, 100, 20);
            add(lblCleanStatus);

            lblPrice = new JLabel("Price");
            lblPrice.setBounds(330, 10, 100, 20);
            add(lblPrice);

            lblBed = new JLabel("Bed Type");
            lblBed.setBounds(410, 10, 100, 20);
            add(lblBed);
            
            table = new JTable();
            table.setBounds(0, 40, 500, 400);
            add(table);
                
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from room");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            back = new JButton("Back");
            back.setBounds(200,500,120,30);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            add(back);
            back.addActionListener(this);
            
            setBounds(300, 200, 1050, 600);
            setVisible(true);
            
	}
        
        public void actionPerformed(ActionEvent ae)
        {
            setVisible(false);
            new Reception();
        }
        
        public static void main(String[] args) 
        {
            new Room();
	}

}
