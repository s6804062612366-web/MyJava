/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

/**
 *
 * @author kokarat
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;
import java.time.Year;

class Account {
    String id, money, interestRate, openDate, firstName, lastName, birthDate, age;

    public Account(String id, String money, String interestRate, String openDate, String firstName, String lastName, String birthDate, String age) {
        this.id = id;
        this.money = money;
        this.interestRate = interestRate;
        this.openDate = openDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
    }

    public String toString() {
        return "ID: " + id + " | Name: " + firstName + " " + lastName + " | Money: " + money + " Bath\n" +
               "Interest Rate: " + interestRate + " | Open: " + openDate + "\n" +
               "Birth: " + birthDate + " | Age: " + age + " Year";
    }
}

public class AccountForm extends JFrame {
    private JTextField idField, moneyField, interestField, fNameField, lNameField, ageField;
    private JComboBox<String> oDay, oMonth, oYear, bDay, bMonth, bYear;
    private ArrayList<Account> accountList;

    public AccountForm() {
        accountList = new ArrayList<>();
        setTitle("Show Detail of Account ...");
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel headerLabel = new JLabel("ACCOUNT MONEY", SwingConstants.CENTER);
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(headerLabel);
        mainPanel.add(Box.createVerticalStrut(10));

        JPanel dataPanel = new JPanel(new GridBagLayout());
        dataPanel.setBorder(new TitledBorder("Enter Data Account Money"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        dataPanel.add(new JLabel("ID :"), gbc);
        gbc.gridx = 1;
        idField = new JTextField(10);
        dataPanel.add(idField, gbc);

        gbc.gridx = 2;
        dataPanel.add(new JLabel("MONEY :"), gbc);
        gbc.gridx = 3;
        moneyField = new JTextField(10);
        dataPanel.add(moneyField, gbc);
        
        gbc.gridx = 4;
        dataPanel.add(new JLabel("BATH :"), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        dataPanel.add(new JLabel("ANNUALINTERATE RATE :"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        interestField = new JTextField(15);
        dataPanel.add(interestField, gbc);
        gbc.gridwidth = 1;

        String[] days = new String[32];
        days[0] = "day";
        for (int i = 1; i <= 31; i++) {
            days[i] = String.valueOf(i);
        }

        String[] months = {"month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        int currentYear = Year.now().getValue();
        String[] years = new String[102];
        years[0] = "year";
        for (int i = 1; i <= 101; i++) {
            years[i] = String.valueOf(currentYear - i + 1);
        }

        gbc.gridx = 0; gbc.gridy = 2;
        dataPanel.add(new JLabel("DAY OPEN ACCOUNT :"), gbc);
        
        JPanel openDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        oDay = new JComboBox<>(days);
        oMonth = new JComboBox<>(months);
        oYear = new JComboBox<>(years);
        openDatePanel.add(oDay);
        openDatePanel.add(oMonth);
        openDatePanel.add(oYear);
        
        gbc.gridx = 1; gbc.gridwidth = 3;
        dataPanel.add(openDatePanel, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 3;
        dataPanel.add(new JLabel("FIRST NAME :"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3;
        fNameField = new JTextField(20);
        dataPanel.add(fNameField, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 4;
        dataPanel.add(new JLabel("LAST NAME :"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3;
        lNameField = new JTextField(20);
        dataPanel.add(lNameField, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 5;
        dataPanel.add(new JLabel("BIRTH DAY :"), gbc);
        
        JPanel birthDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        bDay = new JComboBox<>(days);
        bMonth = new JComboBox<>(months);
        bYear = new JComboBox<>(years);
        birthDatePanel.add(bDay);
        birthDatePanel.add(bMonth);
        birthDatePanel.add(bYear);
        
        gbc.gridx = 1; gbc.gridwidth = 3;
        dataPanel.add(birthDatePanel, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 6;
        dataPanel.add(new JLabel("AGE :"), gbc);
        
        JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        ageField = new JTextField(5);
        ageField.setEditable(false);
        agePanel.add(ageField);
        agePanel.add(new JLabel(" YEAR"));
        
        gbc.gridx = 1; gbc.gridwidth = 2;
        dataPanel.add(agePanel, gbc);
        gbc.gridwidth = 1;

        bYear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) bYear.getSelectedItem();
                if (!selected.equals("year")) {
                    int y = Integer.parseInt(selected);
                    ageField.setText(String.valueOf(currentYear - y));
                } else {
                    ageField.setText("");
                }
            }
        });

        mainPanel.add(dataPanel);
        add(mainPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveBtn = new JButton("SAVE");
        JButton showBtn = new JButton("SHOW");
        btnPanel.add(saveBtn);
        btnPanel.add(showBtn);
        
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String oDate = oDay.getSelectedItem() + " " + oMonth.getSelectedItem() + " " + oYear.getSelectedItem();
                String bDate = bDay.getSelectedItem() + " " + bMonth.getSelectedItem() + " " + bYear.getSelectedItem();
                
                Account acc = new Account(
                    idField.getText(),
                    moneyField.getText(),
                    interestField.getText(),
                    oDate,
                    fNameField.getText(),
                    lNameField.getText(),
                    bDate,
                    ageField.getText()
                );
                accountList.add(acc);
                JOptionPane.showMessageDialog(null, "Data Saved Successfully!");
            }
        });
        
        showBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (Account acc : accountList) {
                    sb.append(acc.toString()).append("\n-------------------------\n");
                }
                
                if (sb.length() == 0) {
                    JOptionPane.showMessageDialog(null, "No Data in System.");
                } else {
                    JTextArea textArea = new JTextArea(sb.toString());
                    textArea.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setPreferredSize(new Dimension(350, 200));
                    JOptionPane.showMessageDialog(null, scrollPane, "All Accounts", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        add(btnPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 420);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new AccountForm().setVisible(true);
    }
}