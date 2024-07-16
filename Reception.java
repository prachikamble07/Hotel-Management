package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener
{
    JButton newCustomer,rooms,department,allEmployee,manager,customer,searchRoom,update,roomStatus,pickup,checkout,logout;
    Reception()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        add(newCustomer);
        newCustomer.addActionListener(this);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        add(rooms);
        rooms.addActionListener(this);
        
        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        add(department);
        department.addActionListener(this);
        
        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        add(allEmployee);
        allEmployee.addActionListener(this);
        
        customer = new JButton("Customer Info");
        customer.setBounds(10,190,200,30);
        customer.setBackground(Color.BLACK);
        customer.setForeground(Color.WHITE);
        add(customer);
        customer.addActionListener(this);
        
        manager = new JButton("Manager Info");
        manager.setBounds(10,230,200,30);
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.WHITE);
        add(manager);
        manager.addActionListener(this);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);
        checkout.addActionListener(this);
        
        update = new JButton("Pending Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);
        update.addActionListener(this);
        
        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10,350,200,30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        add(roomStatus);
        roomStatus.addActionListener(this);
        
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        add(pickup);
        pickup.addActionListener(this);
        
        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        add(searchRoom);
        searchRoom.addActionListener(this);
        
        logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);
        logout.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);

        setBounds(350,200,800,570);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == newCustomer)
        {
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource() == rooms)
        {
            setVisible(false);
            new Room();
        }
        else if(ae.getSource() == department)
        {
            setVisible(false);
            new Department();
        }
        else if(ae.getSource() == allEmployee)
        {
            setVisible(false);
            new Employee();
        }
        else if(ae.getSource() == manager)
        {
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource() == customer)
        {
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource() == searchRoom)
        {
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource() == update)
        {
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource() == roomStatus)
        {
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource() == pickup)
        {
            setVisible(false);
            new PickUp();
        }
        else if(ae.getSource() == checkout)
        {
            setVisible(false);
            new CheckOut();
        }
        else if(ae.getSource() == logout)
        {
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String args[])
    {
        new Reception();
    }
}
