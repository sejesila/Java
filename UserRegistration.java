package com.company;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserRegistration extends JFrame {
   // public static final long
    private JPanel contentPane;
    private JTextField first_name;
    private JTextField last_name;
    private JTextField email;
    private JTextField username;
    private JTextField mobile;
    private JPasswordField passwordField;
    private JButton jButton;

 public UserRegistration() {
  setIconImage(Toolkit.getDefaultToolkit().getImage("/home/azdak/Programming/Swing/top.png"));
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(450,190,800,597);
  setResizable(false);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5,5,5,5));
  setContentPane(contentPane);
  contentPane.setLayout(null);

  JLabel jLabelNewUserReg = new JLabel("New User Register");
  jLabelNewUserReg.setFont(new Font("Times New Roman",Font.PLAIN,43));
  jLabelNewUserReg.setBounds(62,52,325,50);
  contentPane.add(jLabelNewUserReg);

  JLabel jLabelFirstName = new JLabel("First Name");
  jLabelFirstName.setFont(new Font("Tahoma",Font.PLAIN,20));
  jLabelFirstName.setBounds(48,152,164,43);
  contentPane.add(jLabelFirstName);


  JLabel jLabelLastName = new JLabel("Last Name");
  jLabelLastName.setFont(new Font("Tahoma",Font.PLAIN,20));
  jLabelLastName.setBounds(48,243,110,29);
  contentPane.add(jLabelLastName);

  JLabel lblEmailAddress = new JLabel("Email\r\n address");
  lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
  lblEmailAddress.setBounds(48, 324, 164, 36);
  contentPane.add(lblEmailAddress);

  JLabel lblUsername = new JLabel("Username");
  lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
  lblUsername.setBounds(480, 159, 159, 29);
  contentPane.add(lblUsername);

  JLabel lblPassword = new JLabel("Password");
  lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
  lblPassword.setBounds(480, 245, 99, 24);
  contentPane.add(lblPassword);

  JLabel lblMobileNumber = new JLabel("Mobile number");
  lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
  lblMobileNumber.setBounds(480, 329, 139, 26);
  contentPane.add(lblMobileNumber);


  first_name = new JTextField();
  first_name.setFont(new Font("Tahoma", Font.PLAIN, 32));
  first_name.setBounds(210, 151, 200, 50);
  contentPane.add(first_name);
  first_name.setColumns(10);

  last_name = new JTextField();
  last_name.setFont(new Font("Tahoma", Font.PLAIN, 32));
  last_name.setBounds(210, 235, 200, 50);
  contentPane.add(last_name);
  last_name.setColumns(10);

  email = new JTextField();
  email.setFont(new Font("Tahoma", Font.PLAIN, 32));
  email.setBounds(210, 320, 200, 50);
  contentPane.add(email);
  email.setColumns(10);

  username = new JTextField();
  username.setFont(new Font("Tahoma", Font.PLAIN, 32));
  username.setBounds(600, 151, 200, 50);
  contentPane.add(username);
  username.setColumns(10);

  mobile = new JTextField();
  mobile.setFont(new Font("Tahoma", Font.PLAIN, 32));
  mobile.setBounds(600, 320, 228, 50);
  contentPane.add(mobile);
  mobile.setColumns(10);

  passwordField = new JPasswordField();
  passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
  passwordField.setBounds(600, 235, 228, 50);
  contentPane.add(passwordField);

 jButton = new JButton("Register");
 jButton.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
   String firstname = first_name.getText();
   String lastname = last_name.getText();
   String emailID = email.getText();
   String userName = username.getText();
   String mobileNumber = mobile.getText();
   int len = mobileNumber.length();
   String passWord = passwordField.toString();
   String salt = PasswordUtils.getSalt(30);  //Generate salt
   String mySecurePassword = PasswordUtils.generateSecurePassword(passWord,salt); //Encrypted user password
   String user = "" + firstname;

   user += "\n";
   if (len != 10){
    JOptionPane.showMessageDialog(jButton,"Enter a valid phone number");

   }
   try{
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java","postgres","admin");
    String query = "insert into account values('"+firstname +"','"+lastname+"','"+userName+"','"+mySecurePassword+"','"+emailID+"','"+mobileNumber+"')";
    Statement sta = connection.createStatement();
    int x = sta.executeUpdate(query);
    if (x==0){
     JOptionPane.showMessageDialog(jButton,"This already exist");

    } else {
     JOptionPane.showMessageDialog(jButton,"Welcome," + user + "Your account is successfully created");

    }
    connection.close();
   }
   catch (Exception exception)
   {
    exception.printStackTrace();
   }
  }
 });
 jButton.setFont(new Font("Tahoma",Font.PLAIN,22));
 jButton.setBounds(399,447,260,75);
 contentPane.add(jButton);


 }

 public static void main(String[] args)  {
	// write your code here
  EventQueue.invokeLater(new Runnable() {
   @Override
   public void run() {
    try{
     UserRegistration frame  = new UserRegistration();
     frame.setVisible(true);
    } catch (Exception e){
     e.printStackTrace();
    }
   }
  });
    }
}
