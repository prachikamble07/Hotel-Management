
package hotel.management.system;

import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener
{
	JTable table;
	JLabel lblRoomNumber,lblAvailability,lblCleanStatus,lblPrice,lblBed;
        JButton back,submit;
        JComboBox bedType;
        JCheckBox available;
        
	SearchRoom()
        {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            
            JLabel text = new JLabel("Search for Room");
            text.setFont(new Font("Tahoma",Font.PLAIN,20));
            text.setBounds(400,30,200,30);
            add(text);
                
            JLabel lblbed = new JLabel("Bed Type");
            lblbed.setBounds(50, 100, 100, 20);
            add(lblbed);
            
            bedType = new JComboBox(new String[]{"Single Bed","Double Bed"});
            bedType.setBounds(150,100,150,25);
            bedType.setBackground(Color.WHITE);
            add(bedType);
            
            lblRoomNumber = new JLabel("Room Number");
            lblRoomNumber.setBounds(50, 160, 100, 20);
	    add(lblRoomNumber);
            
            available = new JCheckBox("Only display Available");
            available.setBounds(600,100,150,25);
            available.setBackground(Color.WHITE);
            add(available);
            
            lblAvailability = new JLabel("Availability");
            lblAvailability.setBounds(270, 160, 100, 20);
            add(lblAvailability);

            lblCleanStatus = new JLabel("Clean Status");
            lblCleanStatus.setBounds(450, 160, 100, 20);
            add(lblCleanStatus);

            lblPrice = new JLabel("Price");
            lblPrice.setBounds(670, 160, 100, 20);
            add(lblPrice);

            lblBed = new JLabel("Bed Type");
            lblBed.setBounds(870, 160, 100, 20);
            add(lblBed);
            
            table = new JTable();
            table.setBounds(0, 200, 1000, 300);
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
            
            submit = new JButton("Submit");
            submit.setBounds(300,520,120,30);
            submit.setBackground(Color.BLACK);
            submit.setForeground(Color.WHITE);
            add(submit);
            submit.addActionListener(this);
            
            back = new JButton("Back");
            back.setBounds(500,520,120,30);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            add(back);
            back.addActionListener(this);
            
            setBounds(300, 200, 1000, 600);
            setVisible(true);
            
	}
        
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource() == submit)
            {
                try
                {
                    String query1 = "select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                    String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";
                    
                    Conn c = new Conn();
                    ResultSet rs;
                    if(available.isSelected())
                    {
                        rs = c.s.executeQuery(query2);
                    }
                    else
                    {
                        rs = c.s.executeQuery(query1);
                    }
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                setVisible(false);
                new Reception();
            }
        }
        
        public static void main(String[] args) 
        {
            new SearchRoom();
	}

}
