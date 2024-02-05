package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.DBUtils.getConnection;

public class CRUDUtils {
    private static String sqlSelect = "SELECT * from food";
    private static String sqlInsert = "INSERT INTO FOOD (FOOD_NAME,FOOD_TYPE,FOOD_EXOTIC) VALUES (  ? ,? ,?  )";
    private static Connection connection = DBUtils.getConnection();

    public static ArrayList<Food> getProductData() throws SQLException { //получить список товаров

        ResultSet rs = null;
        ArrayList<Food> products = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlSelect);
            try {
                rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String type = rs.getString(3);
                    boolean exotic = rs.getBoolean(4);
                    Food food = new Food(id, name, type, exotic);
                    products.add(food);
                }

            } catch (Exception e) {
                throw new SQLException();
            } finally {
                if (rs != null) {
                    rs.close();
                }

            }
        } catch (Exception e) {

        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return products;


    }

    public static void addProduct(Food product) throws SQLException {
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sqlInsert);
            ps.setString(1, product.getName());
            ps.setString(2, product.getType());
            ps.setBoolean(3, product.isExotic());
            ps.executeUpdate();//запрос с обновлением данных, передаем значения чтоб они обновились
        } catch (Exception e) {
            throw new SQLException();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }


//    public static void deleteProduct(int id) throws SQLException {
//        PreparedStatement preparedStatement = DBUtils.getConnection().prepareStatement("DELETE  from FOOD  WHERE FOOD_ID = ? ");
//        preparedStatement.setInt(1, id);
//        preparedStatement.executeUpdate();
//
//
//    }

    public static void clear(int id) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE  from FOOD  WHERE FOOD_ID > ? ");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

}
