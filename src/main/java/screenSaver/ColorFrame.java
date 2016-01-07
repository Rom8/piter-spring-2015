package screenSaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Jeka on 15/10/2015.
 */
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ColorFrame extends JFrame {
    @Autowired
    private Color color;

    @PostConstruct
    private void init() {
        System.out.println(color);
        System.out.println(color);
        System.out.println(color);
        System.out.println(color);
        setSize(100,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void fly(){
        Random random = new Random();
        setLocation(random.nextInt(1000), random.nextInt(768));
        getContentPane().setBackground(color);
        repaint();
    }

























}
