package com.tyresshop.dao.impl;

import com.tyresshop.ConnectionManager;
import com.tyresshop.dao.TyresDao;
import com.tyresshop.entity.Tyres;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TyresDaoImpl implements TyresDao {
    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();

    public TyresDaoImpl() throws IOException {
    }

    @Override
    public Tyres findByIdTyres(String idTyres) throws SQLException {
        Tyres tyres = null;
        if (con != null) {
            PreparedStatement pr = con.prepareStatement("SELECT * FROM \"Tyres\" where ID=?");
            pr.setString(1, idTyres);
            ResultSet resultSet = pr.executeQuery();//return sql result

            if (resultSet.next()) {

                int id = resultSet.getInt("id");
                int heigth = resultSet.getInt("heigth");
                int width = resultSet.getInt("width");
                int radius = resultSet.getInt("radius");
                String model = resultSet.getString("model");
                String type = resultSet.getString("type");
                int price = resultSet.getInt("price");

                tyres = new Tyres(id, heigth, width, radius, model, type, price);


                return tyres;
            }
            pr.close();
            con.close();
        }
        return tyres;

    }


    @Override
    public Boolean save(Tyres tyres) throws IOException {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        if (con != null) {
            try {
                PreparedStatement pr =
                        con.prepareStatement("INSERT INTO \"Customers\" " +
                                "(ID,HEIGTH,WIDTH,RADIUS,MODEL,TYPE,PRICE) VALUES (?,?,?,?,?,?,?)");
                pr.setInt(1, tyres.getId());
                pr.setInt(2, tyres.getHeigth());
                pr.setInt(3, tyres.getWidth());
                pr.setInt(4, tyres.getRadius());
                pr.setString(5, tyres.getModel());
                pr.setString(6, tyres.getType());
                pr.setInt(7, tyres.getPrice());

                pr.executeUpdate();
                pr.close();
                con.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
