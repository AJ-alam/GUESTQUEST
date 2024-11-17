import java.sql.*;

abstract class Booking {
    protected String CNIC;
    protected String address;
    protected String contact;
    protected String maritalStatus;
    protected String duration;
    protected String booking;
    protected String date;
    protected String id;

    public Booking(String CNIC, String address, String contact, String maritalStatus, String duration, String booking, String date, String id) {
        this.CNIC = CNIC;
        this.address = address;
        this.booking = booking;
        this.contact = contact;
        this.date = date;
        this.duration = duration;
        this.id = id;
        this.maritalStatus = maritalStatus;
    }

    public abstract void saveEvent();
}

class ECOCOMYROOMS extends Booking {
    public ECOCOMYROOMS(String CNIC, String address, String contact, String maritalStatus, String duration, String booking, String date, String id) {
        super(CNIC, address, contact, maritalStatus, duration, booking, date, id);
    }

    @Override
    public void saveEvent() {
        int User_id = Integer.parseInt(id);
        String insertQuery = "INSERT INTO booking (CNIC, ADDRESS, CONTACT_NUMBER, MARITAL_STATUS, DURATION, BOOKING, BOOKING_DATE, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(insertQuery)) {

            pstmt.setString(1, CNIC);
            pstmt.setString(2, address);
            pstmt.setString(3, contact);
            pstmt.setString(4, maritalStatus);
            pstmt.setString(5, duration);
            pstmt.setString(6, booking);
            pstmt.setString(7, date);
            pstmt.setInt(8, User_id); // Set user_id

            pstmt.executeUpdate();
            System.out.println("Room booked successfully");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

class ROYALROOM extends Booking {
    public ROYALROOM(String CNIC, String address, String contact, String maritalStatus, String duration, String booking, String date, String id) {
        super(CNIC, address, contact, maritalStatus, duration, booking, date, id);
    }

    @Override
    public void saveEvent() {
        int User_id = Integer.parseInt(id);
        String insertQuery = "INSERT INTO booking (CNIC, ADDRESS, CONTACT_NUMBER, MARITAL_STATUS, DURATION, BOOKING, BOOKING_DATE, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(insertQuery)) {

            pstmt.setString(1, CNIC);
            pstmt.setString(2, address);
            pstmt.setString(3, contact);
            pstmt.setString(4, maritalStatus);
            pstmt.setString(5, duration);
            pstmt.setString(6, booking);
            pstmt.setString(7, date);
            pstmt.setInt(8, User_id); // Set user_id

            pstmt.executeUpdate();
            System.out.println("Room booked successfully");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

class LUXURYROOM extends Booking {
    public LUXURYROOM(String CNIC, String address, String contact, String maritalStatus, String duration, String booking, String date, String id) {
        super(CNIC, address, contact, maritalStatus, duration, booking, date, id);
    }

    @Override
    public void saveEvent() {
        int User_id = Integer.parseInt(id);
        String insertQuery = "INSERT INTO booking (CNIC, ADDRESS, CONTACT_NUMBER, MARITAL_STATUS, DURATION, BOOKING, BOOKING_DATE, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(insertQuery)) {

            pstmt.setString(1, CNIC);
            pstmt.setString(2, address);
            pstmt.setString(3, contact);
            pstmt.setString(4, maritalStatus);
            pstmt.setString(5, duration);
            pstmt.setString(6, booking);
            pstmt.setString(7, date);
            pstmt.setInt(8, User_id); // Set user_id

            pstmt.executeUpdate();
            System.out.println("Room booked successfully");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

class SHAHVILLAS extends Booking {
    public SHAHVILLAS(String CNIC, String address, String contact, String maritalStatus, String duration, String booking, String date, String id) {
        super(CNIC, address, contact, maritalStatus, duration, booking, date, id);
    }

    @Override
    public void saveEvent() {
        int User_id = Integer.parseInt(id);
        String insertQuery = "INSERT INTO booking (CNIC, ADDRESS, CONTACT_NUMBER, MARITAL_STATUS, DURATION, BOOKING, BOOKING_DATE, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(insertQuery)) {

            pstmt.setString(1, CNIC);
            pstmt.setString(2, address);
            pstmt.setString(3, contact);
            pstmt.setString(4, maritalStatus);
            pstmt.setString(5, duration);
            pstmt.setString(6, booking);
            pstmt.setString(7, date);
            pstmt.setInt(8, User_id); // Set user_id

            pstmt.executeUpdate();
            System.out.println("Room booked successfully");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

public class RoomFactory {
    public static Booking createBooking(String CNIC, String address, String contact, String maritalStatus, String duration, String booking, String date, String id) {
        switch (booking) {
            case "ECOCOMY ROOMS":
                return new ECOCOMYROOMS(CNIC, address, contact, maritalStatus, duration, booking, date, id);
            case "ROYAL ROOM":
                return new ROYALROOM(CNIC, address, contact, maritalStatus, duration, booking, date, id);
            case "LUXURY ROOM":
                return new LUXURYROOM(CNIC, address, contact, maritalStatus, duration, booking, date, id);
            case "SHAH VILLAS":
                return new SHAHVILLAS(CNIC, address, contact, maritalStatus, duration, booking, date, id);
            default:
                throw new IllegalArgumentException("Unknown room type: " + booking);
        }
    }
}

