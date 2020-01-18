package com.zhanarys.hiberdemo;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author zh.turemuratov on 1/14/20
 */
public class SimpleJDBC {


    public static void main(String[] args) throws SystemException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = null;
            for (int i = 0; i < 100; i++) {
                 con = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/seguridad", "postgres", "postgres");
            }

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from table_name");

            while (rs.next())
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));


        } catch (Exception e) {
            System.out.println(e);
        }
    }


}



