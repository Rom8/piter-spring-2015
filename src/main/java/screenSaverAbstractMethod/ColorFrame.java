package screenSaverAbstractMethod;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Jeka on 15/10/2015.
 */
public abstract class ColorFrame extends JFrame {

    private Color color;

    @PostConstruct
    private void init() {
        setSize(100,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void fly(){
        Random random = new Random();
        setLocation(random.nextInt(1000),random.nextInt(768));
        color = getColor();
        getContentPane().setBackground(color);
        repaint();
    }

    protected abstract Color getColor() ;


}
