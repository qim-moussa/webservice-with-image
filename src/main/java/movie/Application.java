/**
 * Created by moussa on 22/11/15.
 */
package movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(value = {"movie.controllers","movie.models"})
@EnableJpaRepositories("movie")
@EnableConfigurationProperties(PictureProperties.class)

public class Application extends WebMvcConfigurerAdapter {

    @Autowired
    private PictureProperties properties;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/backdrop/**")
                .addResourceLocations("file://"+properties.getBackdropPath())
                .setCachePeriod(3600);

        registry.addResourceHandler("/poster/**")
                .addResourceLocations("file://"+properties.getPosterPath())
                .setCachePeriod(3600);
    }

}
