package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener
{
    JButton add,cancel;
    JTextField tfroom,tfprice;
    JComboBox typecombo,availablecombo,cleancombo;
    AddRoom()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(330,200,940,470);
        
        JLabel heading = new JLabel("ADD ROOMS");
        heading.setBounds(150,20,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(heading);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(60,80,120,30);
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("AVAILABLE");
        lblavailable.setBounds(60,130,120,30);
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblavailable);
        
        String availableOptions[]={"Available","Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lblClean = new JLabel("Cleaning Status");
        lblClean.setBounds(60,180,120,30);
        lblClean.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblClean);
        
        String cleanOptions[]={"Cleaned","Dirty"};
        cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(60,230,120,30);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setBounds(60,280,120,30);
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbltype);
        
        String typeOptions[]={"Single Bed","Double Bed"};
        typecombo = new JComboBox(typeOptions);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);
        
        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,370);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            String roomnumber = tfroom.getText();
            String availability = (String)availablecombo.getSelectedItem();
            String status = (String)cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String)typecombo.getSelectedItem();
            
            try
            {
                Conn conn = new Conn();
                String str = "insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                setVisible(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new AddRoom();
    }
}
