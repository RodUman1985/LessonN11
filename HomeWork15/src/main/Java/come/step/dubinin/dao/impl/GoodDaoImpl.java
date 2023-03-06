package come.step.dubinin.dao.impl;

import come.step.dubinin.confige.Connector;
import come.step.dubinin.dao.GoodDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.taglibs.standard.lang.jstl.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class GoodDaoImpl implements GoodDAO {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(GoodDaoImpl.class);


    @Override
    public Optional<Good> getByTittle(String tittle) {
        Optional<Good> good = Optional.empty();
        try (Connection connection = Connector.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM GOODS WHERE TITTLE ='"+tittle
                    +"'")){
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    good = Optional.of(new Good(rs.getLong("ID"),
                            rs.getNString("TITTLE"),
                            rs.getBigDecimal("PRICE")
                    ));
                }

            }


        } catch (SQLException tes) {
            LOGGER.error("SQLException in method getID" + tes);
        }
        return good;
    }

    @Override
    public Optional<Good> getById(long id) {
        Optional<Good> good = Optional.empty();
        try (Connection connection = Connector.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM GOODS WHERE TITTLE ='"+id
                    +"'")){
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    good = new Good(rs.getLong("ID"),
                            rs.getNString("TITTLE"),
                            rs.getBigDecimal("PRICE")
                    );
                    goodList.add(good);
                }

            }


        } catch (SQLException tes) {
            LOGGER.error("SQLException in method getID" + tes);
        }
        return good;
    }

    @Override
    public List<Good> getAll() {
        Good good = null;
        List<Good> goodList = new ArrayList<>();
        try (Connection connection = Connector.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT*FROM GOODS WHERE TITTLE ")){
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    good = new Good(rs.getLong("ID"),
                            rs.getNString("TITTLE"),
                            rs.getBigDecimal("PRICE")
                    );
                    goodList.add(good);
                }

            }


        } catch (SQLException tes) {
            LOGGER.error("SQLException in method getID" + tes);
        }
        return goodList;
    }
}
