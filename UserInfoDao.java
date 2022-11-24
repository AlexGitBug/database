package dao;

import entity.UserInfo;
import exception.DaoException;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserInfoDao {
    private static final UserInfoDao INSTANCE = new UserInfoDao();

    private static final String DELETE_SQL = """
            DELETE FROM user_info
            WHERE id  = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO user_info (first_name, last_name, email, password, role)
            VALUES (?, ?, ?, ?, ?)
            """;

    private static final String UPDATE_SQL = """
            UPDATE user_info
            SET first_name = ?,
                last_name = ?,
                last_name = ?,
                password = ?,
                role = ?
            WHERE id = ?
            """;
    private static final String FIND_ALL_SQL = """
            SELECT id,
                   first_name,
                   last_name,
                   email,
                   password,
                   role
                FROM user_info
            """;
    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id = ?
            """;


    private UserInfoDao() {
    }

    public List<UserInfo> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<UserInfo> usersInfo = new ArrayList<>();
            while (resultSet.next()) {
                usersInfo.add(buildUsersInfo(resultSet));
            }
            return usersInfo;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public Optional<UserInfo> findById(int id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);

            var resultSet = preparedStatement.executeQuery();
            UserInfo userInfo = null;
            if (resultSet.next()) {
                userInfo = buildUsersInfo(resultSet);
            }
            return Optional.ofNullable(userInfo);
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    private static UserInfo buildUsersInfo(ResultSet resultSet) throws SQLException {
        return new UserInfo(
                resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("last_name"),
                resultSet.getString("password"),
                resultSet.getString("role")
        );
    }

    public void update(UserInfo userInfo) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, userInfo.getFirstName());
            preparedStatement.setString(2, userInfo.getLastName());
            preparedStatement.setString(3, userInfo.getEmail());
            preparedStatement.setString(4, userInfo.getPassword());
            preparedStatement.setString(5, userInfo.getRole());
            preparedStatement.setInt(6, userInfo.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public UserInfo save(UserInfo userInfo) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, userInfo.getFirstName());
            preparedStatement.setString(2, userInfo.getLastName());
            preparedStatement.setString(3, userInfo.getEmail());
            preparedStatement.setString(4, userInfo.getPassword());
            preparedStatement.setString(5, userInfo.getRole());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                userInfo.setId(generatedKeys.getInt("id"));
            }
            return userInfo;
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

    public static UserInfoDao getInstance() {
        return INSTANCE;
    }

}

