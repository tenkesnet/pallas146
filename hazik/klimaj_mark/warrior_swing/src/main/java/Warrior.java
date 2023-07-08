import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Warrior extends Fighter {
    private static final double critMultiplier = 2;
    private int critChance= 0;
    GamePanel gp;
    KeyHandler keyH;
    public Warrior(Fighter fighter, int critChance) {
        super(fighter.getName(), fighter.getMaxHealthPoints(), fighter.getDamagePoints(), fighter.getSpeed());
        this.critChance = critChance;
    }

    public Warrior(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    };

    private boolean isCrit() {
        return (this.critChance >= (Math.random() * 100));
    }

    @Override
    public int dealingDamage() {
        if (isCrit()) {
            System.out.println(this.getName() + " kritikusat ütött! Sebzése: " +
                    (int) (this.getDamagePoints() * critMultiplier));
            return (int) (this.getDamagePoints() * critMultiplier);
        }
        return super.dealingDamage();
    }

    @Override
    public void printStats() {
        super.printStats();
        System.out.println(this.getCritChance() + "% kritikus esélye van.");
    }

    public int getCritChance() {
        return critChance;
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        moveSpeed = 4;
    }

    public void getPlayerImage(){
            try{
                getPImage = ImageIO.read(getClass().
                        getResourceAsStream("warrior.png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
    }
    public void update() {

        if(keyH.downPressed || keyH.upPressed || keyH.leftPressed || keyH.rightPressed)

        {

        if(keyH.upPressed){
            y-=moveSpeed;
            direction = 1;
        }if(keyH.downPressed){
            y+=moveSpeed;
            direction = 2;
        }if(keyH.leftPressed){
            x-=moveSpeed;
            direction = 3;
        }if(keyH.rightPressed){
            x+=moveSpeed;
            direction = 4;
        }
        spriteCounter++;
        if(spriteCounter>60){
            if(spriteNum == 1){
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = getPImage.getSubimage
                (32,1006,88,110);;
        switch(direction) {
            case 1:
                if (spriteNum == 1){
                    image = getPImage.getSubimage
                    (426,168,88,110);
                }
                if(spriteNum == 2){
                    image = getPImage.getSubimage
                            (539,164,88,110);
                }break;
             case 2:
                 if(spriteNum == 1){
                image = getPImage.getSubimage
                        (654,842,88,110);}
                 if(spriteNum == 2){
                     image = getPImage.getSubimage
                             (558,851,88,110);
                 }
                 break;
            case 3:
                if(spriteNum == 1){
            image = getPImage.getSubimage
                    (665,1122,88,90);}
                if(spriteNum == 2){
                    image = getPImage.getSubimage
                            (653,583,88,90);
                }
                break;
            case 4:
                if(spriteNum == 1){
                image = getPImage.getSubimage
                        (562,1134,88,90);}
                if(spriteNum == 2){
                    image = getPImage.getSubimage
                            (449,1126,88,90);
                }
                break;

        }
        g2.drawImage(image,x,y, 88, 110, null);
    }

}



