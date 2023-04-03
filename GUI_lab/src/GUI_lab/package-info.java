package GUI_lab;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AccumulatorGUI implements ActionListener {
    private JFrame frame;
    private JTextField numField;
    private JTextField totalField;
    private int total;

    public AccumulatorGUI() {
        // Create the GUI components
        frame = new JFrame("Accumulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        numField = new JTextField(10);
        numField.addActionListener(this);
        totalField = new JTextField("0", 10);
        totalField.setEditable(false);

        // Add the components to the frame
        JPanel panel = new JPanel();
        panel.add(new JLabel("Number: "));
        panel.add(numField);
        panel.add(new JLabel("Total: "));
        panel.add(totalField);
        frame.getContentPane().add(panel);

        // Display the frame
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Add the input number to the total and update the total field
        int num = Integer.parseInt(numField.getText());
        total += num;
        totalField.setText(Integer.toString(total));
        numField.setText("");
    }

    public static void main(String[] args) {
        AccumulatorGUI gui = new AccumulatorGUI();
    }
}
