import java.awt.*;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize= 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;

    public final int maxScreenCol = 16;
    public final int maxScreenWidth= 16;

    public final int screenWidth= tileSize * maxScreenWidth;
    public final int screenHeight = tileSize * maxScreenCol;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    Warrior player = new Warrior(this,keyH);
    TileManager tileM = new TileManager(this);

    int FPS = 144;
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        int nanoToSec = 1000000000;
        double drawInterval= nanoToSec/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(gameThread !=null){
        currentTime = System.nanoTime();
        delta+= (currentTime - lastTime) / drawInterval;
        timer += (currentTime - lastTime);
        lastTime = currentTime;

        if(delta>=1) {
            update();
            repaint();
            delta--;
            drawCount++;
        }
        if(timer >= 1000000000){
            System.out.println("FPS:"+drawCount);
            drawCount = 0;
            timer = 0;
        }
        }
    }

    public void update(){
        player.update();

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;


        tileM.draw(g2);
        player.draw(g2);

        g2.dispose();
    }


}
