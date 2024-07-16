
package hotel.management.system;

import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Employee extends JFrame implements ActionListener
{
	JTable table;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
        JButton back;

	Employee()
        {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            
            
            l1 = new JLabel("Name");
            l1.setBounds(40, 10, 100, 20);
	    add(l1);
                
            l2 = new JLabel("Age");
            l2.setBounds(170, 10, 100, 20);
            add(l2);

            l3 = new JLabel("Gender");
            l3.setBounds(290, 10, 100, 20);
            add(l3);

            l4 = new JLabel("Job");
            l4.setBounds(400, 10, 100, 20);
            add(l4);

            l5 = new JLabel("Salary");
            l5.setBounds(540, 10, 100, 20);
            add(l5);
            
            l6 = new JLabel("Phone");
            l6.setBounds(670, 10, 100, 20);
            add(l6);
            
            l7 = new JLabel("Email");
            l7.setBounds(790, 10, 100, 20);
            add(l7);
            
            l8 = new JLabel("Aadhar");
            l8.setBounds(910, 10, 100, 20);
            add(l8);
            
            table = new JTable();
            table.setBounds(0, 40, 1000, 400);
            add(table);
                
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from employee");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            back = new JButton("Back");
            back.setBounds(420,500,120,30);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            add(back);
            back.addActionListener(this);
            
            setBounds(300, 200, 1000, 600);
            setVisible(true);
            
	}
        
        public void actionPerformed(ActionEvent ae)
        {
            setVisible(false);
            new Reception();
        }
        
        public static void main(String[] args) 
        {
            new Employee();
	}

}
