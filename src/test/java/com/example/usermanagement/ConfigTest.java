
package com.example.usermanagement;

import com.example.usermanagement.config.RootConfig;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConfigTest {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(RootConfig.class)) {

            System.out.println("Spring Context : OK");

            DataSource dataSource = context.getBean(DataSource.class);

            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement();
                 ResultSet result = statement.executeQuery("SELECT 1")) {

                if (result.next()) {
                    System.out.println("Connexion H2 : OK");
                }
            }

            context.getBean(EntityManagerFactory.class);
            System.out.println("JPA / Hibernate : OK");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
