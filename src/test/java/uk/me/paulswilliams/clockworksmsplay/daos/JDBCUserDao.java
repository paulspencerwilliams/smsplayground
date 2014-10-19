package uk.me.paulswilliams.clockworksmsplay.daos;

import cucumber.api.java.After;
import uk.me.paulswilliams.clockworksmsplay.Coordinate;

import java.sql.*;

public class JDBCUserDao {

    public Coordinate getPositionForUser(int userId) throws SQLException {
        String sql = "SELECT latitude, longitude from positions where user_id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return new Coordinate(
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"));
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    @After
    public void deleteAllUsers() throws SQLException {
        String sql = "DELETE from positions";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/smsplayground", "smsplayground", "itsasecret");
    }
}
