import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.awt.Desktop;
import java.net.URL;

public class Main extends JFrame {
    private JLabel jsLoginTitle;
    private JTextField kattintsIdeAControllerTextField;
    private JPanel MainPanel;
    private JTextField textField;
    private JButton kattintsIdeAControllerButton;
    private JLabel jsCreatedBy;

    public Main(){
        setContentPane(MainPanel);
        setTitle("Pallas146 - BackendApp");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,200);
        setLocationRelativeTo(null);
        setVisible(true);
        kattintsIdeAControllerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String URL = textField.getText();
                try{
                    Desktop.getDesktop().browse(new URL(URL).toURI());
                }catch (Exception exception){
                    exception.printStackTrace();
                }
                /*JOptionPane.showMessageDialog(Main.this,"Welcome: " + URL);*/
            }
        });
    }

    public static void main(String[] args) {
        new Main();

    }
}
