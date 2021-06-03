package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentList extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public StudentList() {
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Username");
        //model.addColumn("Password");
        model.addColumn("Email");
        model.addColumn("Phone");

        try {
          //  Class.forName("com.postgresql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java","postgres","admin");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account");
            ResultSet Rs = preparedStatement.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(5),Rs.getString(6)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
    }
}
