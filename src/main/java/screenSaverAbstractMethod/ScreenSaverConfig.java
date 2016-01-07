package screenSaverAbstractMethod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.*;
import java.util.Random;

/**
 * Created by Jeka on 15/10/2015.
 */
@Configuration
@ComponentScan(basePackages = "screenSaverAbstractMethod")
public class ScreenSaverConfig {
    private Random random = new Random();

    @Bean
    public ColorFrame colorFrame(){
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return randomColor();
            }
        };
    }


    @Bean
    @Scope("prototype")
    public Color randomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

    }
}





