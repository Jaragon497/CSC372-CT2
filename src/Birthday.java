import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class Birthday {

    private JFrame frame;
    private JTextField userBirthday;
    private JLabel label;

    // Default constructor
    public Birthday (){

        // Create frame for application
        frame = new JFrame();
        frame.setSize(400,200);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Birthday Calculator");

        // Create text field
        userBirthday = new JTextField();

        JButton button = new JButton("Calculate age!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAge();
            }
        });

        // Create label for output
        label = new JLabel("Enter birthday: YYYY-MM-DD");
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
        // Set layout for text/button/output
        panel.setLayout(new GridLayout(0,1));
        panel.add(userBirthday);
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
//        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Birthday();
    }

    public void calculateAge(){
        // If input is bad, handle error
        try {
            LocalDate currentDate = LocalDate.now();
            LocalDate birthDate = LocalDate.parse(userBirthday.getText());
            Period dist = Period.between(birthDate, currentDate);
            int ageYears = dist.getYears();
            int ageMonths = dist.getMonths();
            int ageDays = dist.getDays();
            label.setText(ageYears + " years, " + ageMonths + " months, and " + ageDays + " days old!");
        } catch (Exception e) {
            label.setText("Invalid date format!");
        }
    }
}
