package dao;

import entity.Room;
import exception.DaoException;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomDao {

    private static final RoomDao INSTANCE = new RoomDao();
    private static final String DELETE_SQL = """
            DELETE FROM room
            WHERE id  = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO room (number, quantity_id, category_id, floor, day_price)
            VALUES (?, ?, ?, ?, ?)
            """;

    private static final String UPDATE_SQL = """
            UPDATE room
            SET number = ?,
                quantity_id = ?,
                category_id = ?,
                floor = ?,
                day_price = ?
            WHERE id = ?
            """;
    private static final String FIND_ALL_SQL = """
            SELECT id,
                   number,
                   quantity_id,
                   category_id,
                   floor,
                   day_price
                FROM room
            """;
    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id = ?
            """;



    private RoomDao() {
    }

    public List<Room> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Room> rooms = new ArrayList<>();
            while (resultSet.next()) {
                rooms.add(buildRoom(resultSet));
            }
            return rooms;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }
    public Optional<Room> findById(int id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);

            var resultSet = preparedStatement.executeQuery();
            Room room = null;
            if (resultSet.next()) {
                room = buildRoom(resultSet);
            }
            return Optional.ofNullable(room);
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    private static Room buildRoom(ResultSet resultSet) throws SQLException {
        return new Room(
                resultSet.getInt("id"),
                resultSet.getInt("number"),
                resultSet.getInt("quantity_id"),
                resultSet.getInt("category_id"),
                resultSet.getInt("floor"),
                resultSet.getBigDecimal("day_price")
        );
    }

    public void update(Room room) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setInt(1, room.getNumber());
            preparedStatement.setInt(2, room.getQuantityId());
            preparedStatement.setInt(3, room.getCategoryId());
            preparedStatement.setInt(4, room.getFloor());
            preparedStatement.setBigDecimal(5, room.getDayPrice());
            preparedStatement.setInt(6, room.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public Room save(Room room) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, room.getNumber());
            preparedStatement.setInt(2, room.getQuantityId());
            preparedStatement.setInt(3, room.getCategoryId());
            preparedStatement.setInt(4, room.getFloor());
            preparedStatement.setBigDecimal(5, room.getDayPrice());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                room.setId(generatedKeys.getInt("id"));
            }
            return room;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public boolean delete(int id) {
        try (Connection connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public static RoomDao getInstance() {
        return INSTANCE;
    }

}
