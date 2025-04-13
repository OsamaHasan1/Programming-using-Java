package myPackage;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Student> phoneNumbers = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("The Garden Academy");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel lbl = new JLabel("Welcome to the garden academy!");
        lbl.setBounds(20, 20, 200, 25);
        frame.add(lbl);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 60, 80, 25);
        frame.add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 60, 160, 25);
        frame.add(nameField);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(20, 100, 120, 25);
        frame.add(phoneLabel);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(150, 100, 160, 25);
        frame.add(phoneField);

        JCheckBox chk = new JCheckBox("I agree to all terms and conditions");
        chk.setBounds(20, 140, 250, 25);
        frame.add(chk);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(20, 180, 100, 25);
        frame.add(registerButton);

        JButton coursesButton = new JButton("Go to Courses");
        coursesButton.setBounds(150, 180, 150, 25);
        coursesButton.setVisible(false);
        frame.add(coursesButton);

        JButton admin = new JButton("Login as admin");
        admin.setBounds(20, 220, 150, 25);
        frame.add(admin);

        // Action Listener for the Register Button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phoneText = phoneField.getText();
                if (!name.isEmpty() && !phoneText.isEmpty()) {
                    students.add(new Student(name, phoneText));
                    JOptionPane.showMessageDialog(frame, "Student added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    coursesButton.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields correctly", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action Listener for the Courses Button
        coursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Courses();
            }
        });

        // Mouse Listener for the Admin Button
        admin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    JFrame adminFrame = new JFrame("Admin");
                    adminFrame.setSize(400, 400);
                    adminFrame.setLayout(null);

                    JLabel pinLabel = new JLabel("Enter your admin pin:");
                    pinLabel.setBounds(20, 20, 200, 25);
                    adminFrame.add(pinLabel);

                    JTextField pinField = new JTextField();
                    pinField.setBounds(20, 60, 160, 25);
                    adminFrame.add(pinField);

                    JButton submitPin = new JButton("Submit");
                    submitPin.setBounds(20, 100, 100, 25);
                    adminFrame.add(submitPin);

                    submitPin.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String pin = pinField.getText();
                            if (pin.equals("8471") || pin.equals("2801") || pin.equals("9452")) {
                                JFrame studentFrame = new JFrame("Students' Information");
                                studentFrame.setSize(400, 400);
                                studentFrame.setLayout(null);

                                int y = 20;
                                for (Student student : students) {
                                    JLabel studentLabel = new JLabel(students.toString());
                                    studentLabel.setBounds(20, y, 350, 25);
                                    studentFrame.add(studentLabel);
                                    y += 30;
                                }

                                studentFrame.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(adminFrame, "Error: Incorrect PIN", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });

                    adminFrame.setVisible(true);
                }
            }
        });

        // Key Listener for the Name Field
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c)) {
                    e.consume();  // Ignore non-letter characters
                }
            }
        });

        // Mouse Motion Listener for the Frame
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                lbl.setText("Mouse at (" + e.getX() + ", " + e.getY() + ")");
            }
        });

        frame.setVisible(true);
    }

    private static void Courses() {
        JFrame courseFrame = new JFrame("Courses");
        courseFrame.setSize(400, 400);
        courseFrame.setLayout(null);

        JLabel courseLabel = new JLabel("Choose the course you want to purchase");
        courseLabel.setBounds(60, 20, 300, 25);
        courseFrame.add(courseLabel);

        String[] courses = {
            "Mathematics - Mr. Mohammed Ziad",
            "Chemistry - Mr. Tareq Mohammed",
            "Physics - Mr. Ahmed Al-tamimi",
            "Biology - Mr. Mousa Al-Zamil",
            "Arabic - Mr. Hassan Salhab"
        };

        int y = 60;
        for (int i = 0; i < courses.length; i++) {
            String course = courses[i];
            JButton courseButton = new JButton(course);
            courseButton.setBounds(20, y, 350, 30);
            courseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Payment();
                }
            });
            courseFrame.add(courseButton);
            y += 40;
        }

        courseFrame.setVisible(true);
    }

    private static void Payment() {
        JFrame paymentFrame = new JFrame("Payment");
        paymentFrame.setSize(400, 400);
        paymentFrame.setLayout(null);

        JLabel paymentLabel = new JLabel("Please enter your bank information");
        paymentLabel.setBounds(20, 20, 200, 25);
        paymentFrame.add(paymentLabel);

        JLabel cardNumberLabel = new JLabel("Card number:");
        cardNumberLabel.setBounds(20, 60, 120, 25);
        paymentFrame.add(cardNumberLabel);
        JTextField cardNumberField = new JTextField();
        cardNumberField.setBounds(150, 60, 160, 25);
        paymentFrame.add(cardNumberField);

        JLabel cscLabel = new JLabel("CSC:");
        cscLabel.setBounds(20, 100, 100, 25);
        paymentFrame.add(cscLabel);
        JTextField cscField = new JTextField();
        cscField.setBounds(150, 100, 160, 25);
        paymentFrame.add(cscField);

        JLabel expiryLabel = new JLabel("Expiry date:");
        expiryLabel.setBounds(20, 140, 120, 25);
        paymentFrame.add(expiryLabel);
        JTextField expiryField = new JTextField();
        expiryField.setBounds(150, 140, 160, 25);
        paymentFrame.add(expiryField);

        JButton submitPayment = new JButton("Submit payment");
        submitPayment.setBounds(150, 180, 150, 25);
        paymentFrame.add(submitPayment);

        JLabel paymentDone = new JLabel("");
        paymentDone.setBounds(150, 220, 200, 25);
        paymentFrame.add(paymentDone);

        submitPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentDone.setText("Course successfully purchased!");
            }
        });

        paymentFrame.setVisible(true);
    }
}