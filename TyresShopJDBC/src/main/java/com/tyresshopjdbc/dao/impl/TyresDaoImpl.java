package com.tyresshopjdbc.dao.impl;

import com.tyresshopjdbc.ConnectionManager;
import com.tyresshopjdbc.dao.TyresDao;
import com.tyresshopjdbc.entity.Transaction;
import com.tyresshopjdbc.entity.Tyres;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TyresDaoImpl implements TyresDao {

    ConnectionManager connectionManager = new ConnectionManager();

    Connection connection = connectionManager.getConnection();

    public TyresDaoImpl() throws IOException {
    }


    @Override
    public Tyres findByIdTyres(int idTyres) throws SQLException {

        if (connection != null) {

            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM \"tyres\" WHERE ID=?");

            preparedStatement.setInt(1, idTyres);

            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                int heigth = resultSet.getInt("heigth");
                int width = resultSet.getInt("width");
                int radius = resultSet.getInt("radius");
                String model = resultSet.getString("model");
                String type = resultSet.getString("type");
                int price = resultSet.getInt("price");

                return new Tyres(idTyres, heigth, width, radius, model, type, price);

            }

        }

        return null;
    }

    @Override
    public List<Tyres> getAll() throws SQLException {
        List<Tyres> tyresList = new ArrayList<>();
        if (connection != null) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM \"tyres\"");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int heigth = resultSet.getInt("heigth");
                int width = resultSet.getInt("width");
                int radius = resultSet.getInt("radius");
                String model = resultSet.getString("model");
                String type = resultSet.getString("type");
                int price = resultSet.getInt("price");

                Tyres tyres = new Tyres(heigth,width,radius,model,type,price);
                tyresList.add(tyres);
            }

        }

        return tyresList;
    }




    @Override
    public Boolean saveTyres(Tyres tyres) throws IOException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();

        if (connection != null) {
            try {
                PreparedStatement preparedStatement
                        = connection.prepareStatement("INSERT INTO \"tyres\"" +
                        "(HEIGTH,WIDTH,RADIUS,MODEL,TYPE,PRICE) VALUES (?,?,?,?,?,?)");

                preparedStatement.setInt(1, tyres.getHeigth());
                preparedStatement.setInt(2, tyres.getWidth());
                preparedStatement.setInt(3, tyres.getRadius());
                preparedStatement.setString(4, tyres.getModel());
                preparedStatement.setString(5, tyres.getType());
                preparedStatement.setInt(6, tyres.getPrice());

                preparedStatement.executeUpdate();
                return true;

            } catch (SQLException sqlExc) {

                sqlExc.printStackTrace();

            } catch (Exception exc) {

                exc.printStackTrace();

            }

        }
        return false;
    }

}
