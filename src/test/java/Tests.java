import com.example.UsersApp.DAO.UserDAO;
import com.example.UsersApp.DB_Connection.DBConnection;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void testSelectAllUsers() throws SQLException, IOException {

        assertEquals(3, UserDAO.showUserNumber());

    }

    @Test
    public void testAddUser() throws SQLException, IOException {

        UserDAO.addUser();
        assertEquals(4, UserDAO.showUserNumber());

    }


}
