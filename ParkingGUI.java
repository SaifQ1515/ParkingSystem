package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ParkingGUI extends JFrame implements ActionListener {
    // GUI components for sign-up panel
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton signUpButton;

    // GUI components for login panel
    private JLabel emailLoginLabel;
    private JTextField emailLoginTextField;
    private JLabel passwordLoginLabel;
    private JPasswordField passwordLoginField;
    private JButton loginButton;

    // GUI components for role selection panel
    private JRadioButton studentButton;
    private JRadioButton facultyButton;
    private JRadioButton staffButton;
    private JRadioButton visitorButton;
    private JButton selectButton;

    // GUI components for lot selection panel
    private JLabel selectLotLabel;
    private JComboBox<String> lotComboBox;
    private JButton selectLotButton;

    // GUI components for lot confirmation panel
    private JLabel lotConfirmationLabel;
    private JLabel lotSelectedLabel;
    private JButton bookALotButton;

    // User credentials
    private String email;
    private String password;
    private String role;
    
    
    //confirmation space panel
    private JLabel spaceLabel;
    private JTextField spaceField;
    private JLabel numHours;
    private JTextField hoursField;
    private JLabel licensePlate;
    private JTextField licensePlateField;
    private JButton confirmInfo;
    
    
    //payment panel
    private JLabel cardnum;
    private JTextField cardnumField;
    private JLabel cvv;
    private JTextField cvvField;
    private JLabel expiry;
    private JTextField expiryField;
    private JLabel address;
    private JTextField addressField;
    private JLabel paymentMethod;
    private JRadioButton credit;
    private JRadioButton debit;
    private JLabel firstName;
    private JLabel lastName;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton continueButton;
    
    
    //Final Page
    private JButton endBooking;
    private JButton extendBooking;
    private JButton cancelBooking;
    
    public ParkingGUI() {
        // Set up the window
        setTitle("Sign Up or Log In");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the GUI components for the welcome panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Welcome to my application!");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        JButton signUpOptionButton = new JButton("Sign Up");
        signUpOptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                showSignUpPanel();
            }
        });
        buttonPanel.add(signUpOptionButton);

        JButton logInOptionButton = new JButton("Log In");
        logInOptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                showLogInPanel();
            }
        });
        buttonPanel.add(logInOptionButton);

        mainPanel.add(buttonPanel);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    // Show the sign-up panel
    private void showSignUpPanel() {
        // Create the GUI components for the sign-up panel
        emailLabel = new JLabel("Email:");
        emailTextField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(this);

        // Add the components to the window
        JPanel signUpPanel = new JPanel();
        signUpPanel.setLayout(new GridLayout(3, 2));
        signUpPanel.add(emailLabel);
        signUpPanel.add(emailTextField);
        signUpPanel.add(passwordLabel);
        signUpPanel.add(passwordField);
        signUpPanel.add(new JLabel());
        signUpPanel.add(signUpButton);

        setContentPane(signUpPanel);
        pack();
        setLocationRelativeTo(null);
    }

    // Show the log-in panel
    private void showLogInPanel() {
        // Create the GUI components for the log-in panel
        emailLoginLabel = new JLabel("Email:");
        emailLoginTextField = new JTextField(20);
        passwordLoginLabel = new JLabel("Password:");
        passwordLoginField = new JPasswordField(20);
        loginButton = new JButton("Log In");
        loginButton.addActionListener(this);

        // Add the components to the window
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));
        loginPanel.add(emailLoginLabel);
        loginPanel.add(emailLoginTextField);
        loginPanel.add(passwordLoginLabel);
        loginPanel.add(passwordLoginField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);

        setContentPane(loginPanel);
        pack();
        setLocationRelativeTo(null);
    }

    // Show the role selection panel
    private void showRoleSelectionPanel() {
        // Create the GUI components for the role selection panel
        JLabel roleSelectionLabel = new JLabel("Select your role:");
        studentButton = new JRadioButton("Student");
        facultyButton = new JRadioButton("Faculty");
        staffButton = new JRadioButton("Staff");
        visitorButton = new JRadioButton("Visitor");

        // Add the radio buttons to a button group so only one can be selected at a time
        ButtonGroup roleButtonGroup = new ButtonGroup();
        roleButtonGroup.add(studentButton);
        roleButtonGroup.add(facultyButton);
        roleButtonGroup.add(staffButton);
        roleButtonGroup.add(visitorButton);

        // Add a button to confirm the selected role
        selectButton = new JButton("Select");
        selectButton.addActionListener(this);

        // Add the components to the window
        JPanel roleSelectionPanel = new JPanel();
        roleSelectionPanel.setLayout(new BoxLayout(roleSelectionPanel, BoxLayout.Y_AXIS));
        roleSelectionPanel.add(roleSelectionLabel);
        roleSelectionPanel.add(studentButton);
        roleSelectionPanel.add(facultyButton);
        roleSelectionPanel.add(staffButton);
        roleSelectionPanel.add(visitorButton);
        roleSelectionPanel.add(selectButton);

        setContentPane(roleSelectionPanel);
        pack();
        setLocationRelativeTo(null);
    }

    // Show the lot selection panel
    private void showLotSelectionPanel() {
        // Create the GUI components for the lot selection panel
        selectLotLabel = new JLabel("Select a lot:");
        String[] lotOptions = {"Lot A", "Lot B", "Lot C", "Lot D"};
        lotComboBox = new JComboBox<>(lotOptions);
        selectLotButton = new JButton("Select");
        selectLotButton.addActionListener(this);

        // Add the components to the window
        JPanel lotSelectionPanel = new JPanel();
        lotSelectionPanel.setLayout(new BoxLayout(lotSelectionPanel, BoxLayout.Y_AXIS));
        lotSelectionPanel.add(selectLotLabel);
        lotSelectionPanel.add(lotComboBox);
        lotSelectionPanel.add(selectLotButton);

        setContentPane(lotSelectionPanel);
        pack();
        setLocationRelativeTo(null);
    }

    // Show the lot confirmation panel
    private void showLotConfirmationPanel() {
        // Create the GUI components for the lot confirmation panel
        spaceLabel = new JLabel("Space#:");
        spaceField = new JTextField(20);
        numHours = new JLabel("Duration");
        hoursField = new JTextField(3);
        licensePlate = new JLabel("Enter License Plate");
        licensePlateField = new JTextField(20);
        confirmInfo = new JButton("confirm");
        confirmInfo.addActionListener(this);
        
        
        

        // Add the components to the window
        JPanel lotConfirmationPanel = new JPanel();
        lotConfirmationPanel.setLayout(new BoxLayout(lotConfirmationPanel, BoxLayout.Y_AXIS));
        lotConfirmationPanel.add(spaceLabel);
        lotConfirmationPanel.add(spaceField);
        lotConfirmationPanel.add(numHours);
        lotConfirmationPanel.add(hoursField);
        lotConfirmationPanel.add(licensePlate);
        lotConfirmationPanel.add(licensePlateField);
        lotConfirmationPanel.add(confirmInfo);

        setContentPane(lotConfirmationPanel);
        pack();
        setLocationRelativeTo(null);
    }
    private void showPaymentMethod() {
         cardnum = new JLabel("Card Number");
         cardnumField= new JTextField(20);
         cvv = new JLabel("CVV");
         cvvField = new JTextField(3);
         expiry = new JLabel("Expiry");
         expiryField = new JTextField(20);
         address = new JLabel("Address");
         addressField = new JTextField(30);
         paymentMethod = new JLabel("what is the payment method?");
         ButtonGroup paymentButtonGroup = new ButtonGroup();
         credit = new JRadioButton("Credit");
         debit =new JRadioButton("Debit");
         paymentButtonGroup.add(credit);
         paymentButtonGroup.add(debit);
         
         firstName = new JLabel("First Name");
         firstNameField =new JTextField(20);
         lastName = new JLabel("Last Name");
         lastNameField = new JTextField(20);
         continueButton = new JButton ("Continue");
         continueButton.addActionListener(this);
    	
         JPanel showPaymentMethod = new JPanel();
         showPaymentMethod.setLayout(new BoxLayout(showPaymentMethod, BoxLayout.Y_AXIS));
         showPaymentMethod.add(paymentMethod);
         showPaymentMethod.add(credit);
         showPaymentMethod.add(debit);
         showPaymentMethod.add(firstName);
         showPaymentMethod.add(firstNameField);
         showPaymentMethod.add(lastName);
         showPaymentMethod.add(lastNameField);
         showPaymentMethod.add(address);
         showPaymentMethod.add(addressField);
         showPaymentMethod.add(cardnum);
         showPaymentMethod.add(cardnumField);
         showPaymentMethod.add(expiry);
         showPaymentMethod.add(expiryField);
         showPaymentMethod.add(cvv);
         showPaymentMethod.add(cvvField);
         showPaymentMethod.add(continueButton);
         
         setContentPane(showPaymentMethod);
         pack();
         setLocationRelativeTo(null);
    	
    }
    
    private void finalPage() {
    	endBooking = new JButton("Confirm all");
    	extendBooking = new JButton("Extend booking");
    	cancelBooking = new JButton(" Cancel and Return to login screen");
    	JPanel finalPage = new JPanel();
    	
    	finalPage.setLayout(new BoxLayout(finalPage, BoxLayout.Y_AXIS));
    	finalPage.add(endBooking);
    	endBooking.addActionListener(this);
    	finalPage.add(extendBooking);
    	extendBooking.addActionListener(this);
    	finalPage.add(cancelBooking);
    	cancelBooking.addActionListener(this);
    	
    	
    	
        setContentPane(finalPage);
        pack();
        setLocationRelativeTo(null);
    	
    	
    	
    	
    	
    	
    }
 // Handle sign-up button clicks

    
 // Handle button clicks
    public void actionPerformed(ActionEvent event) {
    	if (event.getSource() == signUpButton) {
            // Get the email and password
            String email = emailTextField.getText();
            String password = new String(passwordField.getPassword());

            // Check if the email or password is empty
            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a value for both Email and Password.");
            }
            else {
                // TODO: Process the email and password

                // Show the role selection panel
                showRoleSelectionPanel();
            }
        }
        else if (event.getSource() == selectButton) {
            // Get the selected role
            String role = "";
            if (studentButton.isSelected()) {
                role = "Student";
            } else if (facultyButton.isSelected()) {
            	role = "Faculty";
            	} else if (staffButton.isSelected()) {
            	role = "Staff";
            	} else if (visitorButton.isSelected()) {
            	role = "Visitor";
            	}
            // Check if a role was selected
            if (role.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a role.");
            }
        }
        
        if (event.getSource() == signUpButton && ! (email.isEmpty() || password.isEmpty()) ) {
            // Retrieve the user's email and password from the text fields
            email = emailTextField.getText();
            password = new String(passwordField.getPassword());

            // Show the role selection panel
            showRoleSelectionPanel();
        } else if (event.getSource() == loginButton) {
            // Retrieve the user's email and password from the text fields
            email = emailLoginTextField.getText();
            password = new String(passwordLoginField.getPassword());

            // TODO: Implement login functionality

        } else if (event.getSource() == selectButton) {
            // Retrieve the user's selected role
            if (studentButton.isSelected()) {
                role = "student";
            } else if (facultyButton.isSelected()) {
                role = "faculty";
            } else if (staffButton.isSelected()) {
                role = "staff";
            } else if (visitorButton.isSelected()) {
                role = "visitor";
            }

            // Show the lot selection panel
            showLotSelectionPanel();
            
        }
        if(event.getSource() == selectLotButton) {
        	showLotConfirmationPanel();
        }
        if (event.getSource()== confirmInfo) {
        	showPaymentMethod();
        }
        if (event.getSource()== continueButton) {
        	finalPage();
        }
        if (event.getSource()== extendBooking) {
        	showLotConfirmationPanel();
        }
        if (event.getSource()== cancelBooking) {
        	showLogInPanel();
        }
        if(event.getSource()== endBooking) {
        	JOptionPane.showMessageDialog(this, "Thank you for Booking, a reciept will be emailed");
        }
    }

    public static void main(String[] args) {
        ParkingGUI gui = new ParkingGUI();
        gui.setVisible(true);
    }
    }

