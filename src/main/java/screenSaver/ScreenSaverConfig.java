package screenSaver;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by Jeka on 15/10/2015.
 */
@Configuration
@ComponentScan(basePackages = "screenSaver")
public class ScreenSaverConfig {
    private Random random = new Random();


    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Scope(value = "twoSeconds", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color randomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

    }
}





