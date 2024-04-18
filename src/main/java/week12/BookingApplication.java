package week12;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingApplication {

    private final String url = "jdbc:mysql://localhost:3306/db_assignment";
    private final String user = "root";
    private final String password = "parola1234";

    public void insertIntoAccommodationTable(String type, String bedType, long maxCapacity, String description) {
        String sqlInsertStatement = "INSERT INTO accommodation(type, bed_type, max_guests, description) values(?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            PreparedStatement psInsert = connection.prepareStatement(sqlInsertStatement);
            psInsert.setString(1, type);
            psInsert.setString(2, bedType);
            psInsert.setLong(3, maxCapacity);
            psInsert.setString(4, description);

            psInsert.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectFromAccomodationTable() {
        String sqlSelectAllPersons = "SELECT * FROM accommodation";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelectAllPersons);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                long id = rs.getLong("id");
                String type = rs.getString("type");
                String bedType = rs.getString("bed_type");
                long maxGuests = rs.getLong("max_guests");
                String description = rs.getString("description");

                System.out.println(id + ", " + type + ", " + bedType + ", " + maxGuests + ", " + description);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getAccommodationTableCount() {
        int count = 0;
        String sqlCountStatement = "SELECT COUNT(*) FROM accommodation";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = connection.prepareStatement(sqlCountStatement);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return count;
    }

    public List<Double> getPricePerRoom() {

        List<Double> result = new ArrayList<>();
        String sqlStatement = "SELECT room_fair.value FROM accommodation\n" +
                "JOIN accommodation_room_fair_relation ON accommodation.id = accommodation_room_fair_relation.accommodation_id\n" +
                "JOIN room_fair ON room_fair.id = accommodation_room_fair_relation.room_fair_id;";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = connection.prepareStatement(sqlStatement);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(rs.getDouble(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
