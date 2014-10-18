package uk.me.paulswilliams.clockworksmsplay.daos;

import uk.me.paulswilliams.clockworksmsplay.Coordinate;

import java.sql.*;

public class UserDao {
    public Coordinate getPositionForUser(int userId) throws SQLException {
        String sql = "SELECT latitude, longitude from positions where user_id = ?";
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/smsplayground", "smsplayground", "itsasecret");
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
}
