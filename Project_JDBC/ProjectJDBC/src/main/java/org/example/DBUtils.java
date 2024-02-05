package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    //1-сделать соединение с БД
    //2-отправлять туда запросы
    private static String dbURL = "jdbc:h2:tcp://localhost:9092/mem:testdb"; //ключевое слово  путь к папке -classpath. такой путь так как компиируется после выполнения кода, и проще найти
    private static String dbUsername = "user";
    private static String dbPassword = "pass";

    public static Connection getConnection() {// метод для соединения



//        String dbURL = null;
//        String dbUsername = "user";
//        String dbPassword = "pass";
//
//        FileInputStream fis; // позволяет забрать даные из файла в виде потока информации, и создать экземпляр properties
//        Properties properties = new Properties(); // класс properties так как работаем с ними
//
//        try {
//            fis = new FileInputStream("src/main/resources/config.properties"); //создаем экземпляр импут стрима, задаем путь проперти файла
//            properties.load(fis); // забираем проперти которые там есть
//            dbURL = properties.getProperty("db host");
//
//        } catch (FileNotFoundException e) { // catch в случае если возникнет ошибка чтения файла
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e); // catch для загрузки файла
//        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);//что бы создать API обращаемся к драйвер менеджеру
        } catch (
                SQLException e) { // соединение с БД может не пройти, должен быть Exception который обработает данный вариант
            throw new RuntimeException(e);
        }
        // для соединения нужно передать 3 параметра URL для БД, Username, Password
        return connection;
    }
}
