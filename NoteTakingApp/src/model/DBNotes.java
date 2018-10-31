package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBNotes implements INotesData {
    private Connection conn;

    public DBNotes() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:notesdb.sqlite");

            //JDBC quirk
            Class.forName("org.sqlite.JDBC"); //fix our project classpath
            System.out.println("Connected to DB");
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(
                    "Cannot connect to DB: " + e.getMessage());
        }
    }

    @Override
    public void addNotes(String tableName, String body, String other) {
        try {
            Statement stmt = conn.createStatement();

            //execute() is for insert, update or delete
            String newQuote = "INSERT INTO " + tableName + " VALUES (null,'" + body + "'";
            if (!tableName.equals("todos")) {
                newQuote += ", '" + other + "'";
            }
            newQuote += ")";
            System.out.println("body: " + body + "other: " + other);

            stmt.execute(newQuote);
            if (tableName.equals("todos")) {
                addToDo(body, other);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(
                    "Error inserting quote: " + e.getMessage());
        }
    }

    public void addToDo(String title, String todo) {
        try {
            Statement stmt = conn.createStatement();

            int todoid = stmt.getGeneratedKeys().getInt(1);
            String newToDo = "INSERT INTO " + "todos" + " VALUES (" + todoid + ", '" + title + "'),";
            String titleId = "SELECT id FROM todos WHERE title = " + title;

            //int keyid = stmt.getGeneratedKeys().getInt(0);
            String listItem = "INSERT INTO " + "todoitems" + " VALUES (" + 2 + ", " + false +
                    ", '" + todo + "', " + todoid + ")";

            System.out.println("todo id: " + todoid);
            System.out.println("new todo: " + newToDo);
            System.out.println("title id: " + titleId);
            System.out.println("List item: " + listItem);
            stmt.execute(newToDo);
            //stmt.execute(titleId);
            //stmt.execute(listItem);
        } catch (SQLException e) {
            throw new IllegalStateException(
                    "Error inserting quote: " + e.getMessage());
        }
    }

    public void addToDoItems(boolean done, String todo, int listId) {
//        try {
//            Statement stmt = conn.createStatement();
//
//            //execute() is for insert, update or delete
//            String newQuote = "INSERT INTO " + tableName + " VALUES (null,'" + body + "'";
//            if (!tableName.equals("todos")) {
//                newQuote += ", '" + other + "'";
//            }
//            newQuote += ")";
//            System.out.println("body: " + body + "other: " + other);
//            if (tableName == "todos") {
//                String insertItem = "INSERT INTO " + "todoitems" + " VALUES (null, false,'" +
//                        other + ", null";
//            }
//            System.out.println(newQuote);
//            stmt.execute(newQuote);
//        } catch (SQLException e) {
//            throw new IllegalStateException(
//                    "Error inserting quote: " + e.getMessage());
//        }
    }
}