
package hotel.management.system;

import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class PickUp extends JFrame implements ActionListener
{
	JTable table;
	JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
        JButton back,submit;
        Choice typeofcar;
        
	PickUp()
        {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            
            JLabel text = new JLabel("Pickup Service");
            text.setFont(new Font("Tahoma",Font.PLAIN,20));
            text.setBounds(400,30,200,30);
            add(text);
             
            JLabel lblcar = new JLabel("Type Of Car");
            lblcar.setBounds(50, 100, 100, 20);
            add(lblcar);
            
            typeofcar = new Choice();
            typeofcar.setBounds(150,100,200,25);
            typeofcar.setBackground(Color.WHITE);
            add(typeofcar);
            
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from driver");
                while(rs.next())
                {
                    typeofcar.add(rs.getString("brand"));
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            lbl1 = new JLabel("Name");
            lbl1.setBounds(30, 160, 100, 20);
	    add(lbl1);
            
            lbl2 = new JLabel("Age");
            lbl2.setBounds(200, 160, 100, 20);
            add(lbl2);

            lbl3 = new JLabel("Gender");
            lbl3.setBounds(330, 160, 100, 20);
            add(lbl3);

            lbl4 = new JLabel("Company");
            lbl4.setBounds(460, 160, 100, 20);
            add(lbl4);

            lbl5 = new JLabel("Brand");
            lbl5.setBounds(630, 160, 100, 20);
            add(lbl5);
            
            lbl6 = new JLabel("Availability");
            lbl6.setBounds(740, 160, 100, 20);
            add(lbl6);
            
            lbl7 = new JLabel("Location");
            lbl7.setBounds(870, 160, 100, 20);
            add(lbl7);
            
            table = new JTable();
            table.setBounds(0, 200, 1000, 300);
            add(table);
                
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from driver");
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
                    String query = "select * from driver where brand = '"+typeofcar.getSelectedItem()+"'";
                    
                    Conn c = new Conn();
                    ResultSet rs;
                    rs = c.s.executeQuery(query);
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
            new PickUp();
	}

}
