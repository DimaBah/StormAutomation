package project.by.stormnet.functional.tests.db;

import by.stormnet.core.utils.DatabaseUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DBTest {
    private static final String READ_SQL = "SELECT * FROM Users WHERE age > 18;";
    private static final String UPDATE_SQL = "UPDATE Users SET first_name = 'Petrovich' WHERE last_name = 'Test'";
    private static final String DELETE_SQL = "DELETE FROM Users WHERE age = 26";
    private static final String UPDATE_CHECK = "SELECT * FROM Users WHERE first_name = 'Petrovich'";
    private static final String DELETE_CHECK = "SELECT * FROM Users";

    @BeforeClass
    public void before(){
        DatabaseUtils.createTable();
    }

    @Test
    public void insertUserTableTest(){
        Assert.assertTrue(DatabaseUtils.insertData(createInsertUserStatements()), "Data is not inserted");
    }

    @Test
    public void readTest(){
        List<String> str = DatabaseUtils.read(READ_SQL);
        System.out.println(str.size());
//        System.out.println(str.get(0));
        Assert.assertEquals(str.size(), 4, "bad luck....");

    }

    @Test
    public void updateTest(){
        DatabaseUtils.updateAndDelete(UPDATE_SQL);
        List<String> str = DatabaseUtils.read(UPDATE_CHECK);
        Assert.assertEquals(str.size(), 1, "bad luck....");
    }

    @Test
    public void deleteTest(){
        DatabaseUtils.updateAndDelete(DELETE_SQL);
        List<String> str = DatabaseUtils.read(DELETE_CHECK);
        Assert.assertEquals(str.size(), 4, "bad luck....");
    }

    private List<String> createInsertUserStatements(){
        List<String> statements = new ArrayList<>();
        statements.add("INSERT INTO Users VALUES (100, 'Ivan', 'Ivanov', 18)");
        statements.add("INSERT INTO Users VALUES (101, 'Petr', 'Petrov', 20)");
        statements.add("INSERT INTO Users VALUES (102, 'Sidor', 'Sidorov', 22)");
        statements.add("INSERT INTO Users VALUES (103, 'Vasya', 'Vasin', 24)");
        statements.add("INSERT INTO Users VALUES (104, 'Tets', 'Test', 26)");
        return statements;
    }

    @AfterClass
    public void cleaning(){
        DatabaseUtils.dropTable();
    }
}
