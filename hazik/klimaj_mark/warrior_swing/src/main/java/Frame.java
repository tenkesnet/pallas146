import javax.swing.*;

public class Frame extends JFrame {

    Frame(){

        GamePanel gpanel = new GamePanel();
        ImageIcon image= new ImageIcon(this.getClass().getResource("images/wow-troll-avatar.png"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(image.getImage());
        this.setTitle("Adventure");
        this.setSize(630, 630);
        this.add(gpanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();

        gpanel.startGameThread();

    }




}
