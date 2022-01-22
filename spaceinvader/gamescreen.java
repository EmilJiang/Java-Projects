import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Objects;


public class gamescreen implements ActionListener, KeyListener {
    public final int WIDTH = 800, HEIGHT = 800;
    public static gamescreen artp;
    private JFrame jframe;
    private Rectangle player;
    private Rectangle bullet;
    private gamescreenPanel panel;
    private boolean gameOver;
    private boolean start;
    private boolean readyFire;
    private int bulletSpeed;
    private boolean shoot;
    private int score;
    private boolean right, left;
    private boolean coll;
    private ArrayList<Rectangle> invader;
    private JButton backBtn;
    private int bxpos, bxpos1,bxpos2, bxpos3;
    private int bypos, bypos1,bypos2, bypos3;
    private int bspeed;
    private int lives;
    private int spaceout,startspaceout;
    private boolean wincondition;
    public String level;
    private int rows;
    private int invaderspeed;
    private Timer timer;
    private boolean colll;
    public gamescreen(String mode)
    {
        level = mode;
        wincondition = false;
        if(level.equals("easy")){
            lives = 3;
            spaceout = 30;
            startspaceout = 200;
            rows = 30;
            invaderspeed = 1;
            bspeed = 5;
        }
        else if(level.equals("medium")){
            lives = 3;
            spaceout = 60;
            startspaceout = 30;
            rows = 30;
            invaderspeed = 2;
            bspeed = 5;
        }
        else if(level.equals("impossible")){
            lives = 1;
            spaceout = 70;
            startspaceout = 0;
            rows = 40;
            invaderspeed = 2;
            bspeed = 8;
        }
        else if(level.equals("hard")){
            lives = 1;
            spaceout = 70;
            startspaceout = 0;
            rows = 40;
            invaderspeed = 2;
            bspeed = 8;
        }
        colll = false;
        coll = false;
        right = true;
        left = false;
        invader = new ArrayList<Rectangle>();
        shoot = false;
        bulletSpeed = 20;
        readyFire = true;
        score = 0;
        start = true;
        jframe = new JFrame();
        timer = new Timer(20, this);
        gameOver = false;
        panel = new gamescreenPanel();
        panel.setLayout(null);
        int xinterval = 0;
        int yinterval = 0;
        for(int i = 0; i<rows; i++){
            if(i%10 == 0){
                xinterval = 0;
                yinterval+=50;
            }
            xinterval += 1;
            invader.add(new Rectangle(xinterval*spaceout + startspaceout,50 +yinterval ,100,100));
        }
        player = new Rectangle(400, 750, 20, 20);
        bullet = new Rectangle(player.x+12, player.y-35, 5,20);

        backBtn = new JButton("back");
        backBtn.setOpaque(true);

        backBtn.setBorderPainted(false);
        backBtn.setFont(new Font("Arial", Font.PLAIN, 25));
        backBtn.setForeground(Color.WHITE);
        backBtn.setBackground(Color.BLACK);
        backBtn.addActionListener(this);
        backBtn.setActionCommand("menu");
        backBtn.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
        backBtn.setBounds(700,-30,100,100);
        panel.add(backBtn);

        jframe.add(panel).setBackground(Color.black);
        jframe.setTitle("Space Invaders");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(800, 800);
        jframe.addKeyListener(this);
        jframe.setResizable(false);
        jframe.setFocusable(true);
        jframe.setVisible(true);
        timer.start();
    }
    public void right()
    {
        if(player.x<750){
            player.x+=20;
        }
    }
    public void left()
    {
        if(player.x>0){
            player.x-=20;
        }
    }
    public void shoot(){
        readyFire = false;
        shoot = true;
    }

    public boolean collision(Rectangle a, Rectangle b,String s){
        double d = Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y,2));
        if(s.equals("player")){
            if(d<19){
                return true;
            }
        }
        else{
            if(d<23){
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(score == 300){
            gameOver = true;
            wincondition = true;
        }
        if(gameOver){
            jframe.dispose();
            gameOver = false;
            timer.stop();
            endscreen.ends = new endscreen(wincondition);
        }
        jframe.setFocusable(true);
        if(level.equals("easy")){
            if(bypos>800 || start){
                int randominvader = (int) (invader.size() * Math.random());
                bxpos = invader.get(randominvader).x;
                bypos = invader.get(randominvader).y;
            }
            bypos += bspeed;
        }
        else if(level.equals("medium")){
            if(bypos>800 || start){
                int randominvader = (int) (invader.size() * Math.random());
                bxpos = invader.get(randominvader).x;
                bypos = invader.get(randominvader).y;
            }
            if(bypos1>800 || start){
                int randominvader = (int) (invader.size() * Math.random());
                bxpos1 = invader.get(randominvader).x;
                bypos1 = invader.get(randominvader).y;
            }
            bypos += bspeed;
            bypos1 += bspeed;
        }
        else if(level.equals("impossible")){
            if(bypos>800 || start){
                int randominvader = (int) (invader.size() * Math.random());
                bxpos = invader.get(randominvader).x;
                bypos = invader.get(randominvader).y;
            }
            if(bypos1>800 || start){
                int randominvader = (int) (invader.size() * Math.random());
                bxpos1 = invader.get(randominvader).x;
                bypos1 = invader.get(randominvader).y;
            }
            if(bypos2>800 || start){
                int randominvader = (int) (invader.size() * Math.random());
                bxpos2 = invader.get(randominvader).x;
                bypos2 = invader.get(randominvader).y;
            }
            if(bypos3>800 || start){
                int randominvader = (int) (invader.size() * Math.random());
                bxpos3 = invader.get(randominvader).x;
                bypos3 = invader.get(randominvader).y;
            }
            bypos += bspeed;
            bypos1 += bspeed;
            bypos2 += bspeed;
            bypos3 += bspeed;


        }
        else if(level.equals("hard")){
            if(bypos>800 || start){
                int randominvader = (int) (invader.size() * Math.random());
                bxpos = invader.get(randominvader).x;
                bypos = invader.get(randominvader).y;
            }
            if(bypos1>800 || start){
                int randominvader = (int) (invader.size() * Math.random());
                bxpos1 = invader.get(randominvader).x;
                bypos1 = invader.get(randominvader).y;
            }
            if(bypos2>800 || start){
                int randominvader = (int) (invader.size() * Math.random());
                bxpos2 = invader.get(randominvader).x;
                bypos2 = invader.get(randominvader).y;
            }
            if(bypos3>800 || start){
                int randominvader = (int) (invader.size() * Math.random());
                bxpos3 = invader.get(randominvader).x;
                bypos3 = invader.get(randominvader).y;
            }
            bypos += bspeed;
            bypos1 += bspeed;
            bypos2 += bspeed;
            bypos3 += bspeed;
        }
        String eventName = e.getActionCommand();
        if(Objects.equals(eventName, "menu")){
            jframe.dispose();
            intro.intro1 = new intro();
        }

        if(shoot && bullet.y>-40){
            bullet.y-=bulletSpeed;
        }
        else{
            readyFire = true;
            shoot = false;
            bullet = new Rectangle(player.x+10, player.y-15, 5,20);
        }

        if(lives <= 0){
            gameOver = true;
            wincondition = false;
        }
        int max1 = 0;
        int min1 = 99999;
        int mostRight = 0;
        int mostLeft = 0;
        int mostDown = 0;
        for(int i = 0; i< invader.size();i++){
            max1 = Math.max(invader.get(i).x,max1);
            min1 = Math.min(invader.get(i).x,min1);
            mostDown = Math.max(invader.get(i).y, mostDown);
            if(mostDown == invader.get(i).y){
                mostDown = i;
            }
            if(max1 == invader.get(i).x){
                mostRight = i;
            }else if(min1 == invader.get(i).x){
                mostLeft = i;
            }
        }
        if(invader.get(mostDown).y>675){
            gameOver = true;
            wincondition = false;
        }
        if(right){
            if (!start && invader.get(mostRight).x<750){
                for(int i = 0; i< invader.size();i++){
                    invader.get(i).x+=invaderspeed;
                }
            }
            else if(invader.get(mostRight).x>=750 && !start){
                for(int i = 0; i< invader.size();i++){
                    invader.get(i).y+=25;
                }
                right = false;
                left = true;
            }
        }
        else if(left){
            if (!start && invader.get(mostLeft).x>0){
                for(int i = 0; i< invader.size();i++){
                    invader.get(i).x-=invaderspeed;
                }
            }
            else if(invader.get(mostLeft).x<=0 && !start){
                right = true;
                left = false;
                for(int i = 0; i< invader.size();i++){
                    invader.get(i).y+=25;
                }
            }
        }
        Rectangle f = new Rectangle(bxpos,bypos,0,0);
        if(level.equals("easy")){
            if(collision(player,f,"p")){
                lives-=1;
                bypos = 900;
            }
        }
        else if(level.equals("medium")){
            Rectangle f1 = new Rectangle(bxpos1,bypos1,0,0);
            if(collision(player,f,"p")){
                colll = true;
                bypos = 900;
            }
            if(collision(player,f1,"p")){
                colll = true;
                bypos1 = 900;
            }
            if(colll){
                lives-=1;
                colll = false;
            }
        }
        else if(level.equals("impossible")){
            Rectangle f1 = new Rectangle(bxpos1,bypos1,0,0);
            Rectangle f2 = new Rectangle(bxpos2,bypos2,0,0);
            Rectangle f3 = new Rectangle(bxpos3,bypos3,0,0);
            if(collision(player,f,"p")){
                colll = true;
                bypos = 900;
            }
            if(collision(player,f1,"p")){
                colll = true;
                bypos1 = 900;
            }
            if(collision(player,f2,"p")){
                colll = true;
                bypos1 = 900;
            }
            if(collision(player,f3,"p")){
                colll = true;
                bypos1 = 900;
            }
            if(colll){
                lives-=1;
                colll = false;
            }
        }
        panel.repaint();
    }
    public void repaint(Graphics g)
    {
        if(start){
            g.drawImage(new ImageIcon("images/playertest30.gif").getImage(),400,700, null);
            for(int i =0; i<invader.size(); i++){
                g.drawImage(new ImageIcon("images/invader.gif").getImage(),invader.get(i).x,invader.get(i).y, null);
            }
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("SHOOT OR MOVE TO START", 50,400);
        }
        else{
            for(int i =0; i<invader.size(); i++){
                if(!collision(invader.get(i),bullet,"player")){
                    g.drawImage(new ImageIcon("images/invader.gif").getImage(),invader.get(i).x,invader.get(i).y, null);
                }
                else{
                    coll = true;
                    invader.remove(i);
                }

            }
            g.drawImage(new ImageIcon("images/playertest30.gif").getImage(),player.x,700, null);
        }
        if(shoot && !coll){
            g.setColor(Color.white);
            g.fillRect(bullet.x, bullet.y, 5,20);
        }
        else{
            coll = false;
            readyFire = true;
            shoot = false;
            bullet = new Rectangle(player.x+12, player.y-35, 5,20);
        }
        if(!start){
            g.setColor(Color.white);
            g.fillOval(bxpos,bypos,20,20);
            if(level.equals("medium")){
                g.fillOval(bxpos1,bypos1,20,20);
            }
            else if(level.equals("impossible")){
                g.fillOval(bxpos1,bypos1,20,20);
                g.fillOval(bxpos2,bypos2,20,20);
                g.fillOval(bxpos3,bypos3,20,20);
            }
        }
        score = (rows*10) - (10* invader.size());
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("Score: ", 0,25);
        g.drawString("Lives: " ,350, 25);
        g.drawString(Integer.toString(score), 80,25);
        g.drawString(Integer.toString(lives), 425,25);

    }

    public static void main(String[] args){
        artp = new gamescreen("medium");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(start){
                start = false;
            }
            right();
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            if(start){
                start = false;
            }
            left();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(start){
                start = false;
            }
            if(readyFire){
                shoot();
            }
        }
    }
}
