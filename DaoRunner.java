import dao.*;
import entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class DaoRunner {

    public static void main(String[] args) {


        var orderDao = OrderDao.getInstance();
        var order = new Order();
        order.setUserInfoId(1);
        order.setRoomId(1);
        order.getBeginTime();
        order.getEndTime();
        order.setStatus("+");
        order.setStatus("без ковров");
        orderDao.save(order);



    }

    private static void RoomDaoTestSave() {
        var roomDao = RoomDao.getInstance();
        var room = new Room();
        room.setNumber(1);
        room.setQuantityId(2);
        room.setCategoryId(2);
        room.setFloor(2);
        room.setDayPrice(BigDecimal.valueOf(100));
        roomDao.save(room);
    }

    private static void UserInfoTest() {
        var userInfoDao = UserInfoDao.getInstance();
        var userInfo = new UserInfo();
        userInfo.setFirstName("Petr");
        userInfo.setLastName("Petrov");
        userInfo.setEmail("123@mail.ru");
        userInfo.setPassword("123");
        userInfo.setRole("client");
        userInfoDao.save(userInfo);
    }

    private static void selectTest() {
        var roomDao = RoomDao.getInstance();
        var rooms = roomDao.findAll();
        System.out.println(rooms);
    }

    private static void updateTest() {
        var roomDao = RoomDao.getInstance();
        var maybeRoom = roomDao.findById(4);
        System.out.println(maybeRoom);

        maybeRoom.ifPresent(room -> {
            room.setDayPrice(BigDecimal.valueOf(200.8));
            roomDao.update(room);
        });
    }

    private static void deleteTest() {
        var roomDao = RoomDao.getInstance();
        var deleteRoomDaoResult = roomDao.delete(4);
        System.out.println(deleteRoomDaoResult);
    }

    private static void saveTest() {
        var roomDao = RoomDao.getInstance();
        var room = new Room();
        room.setNumber(123);
        room.setQuantityId(1);
        room.setCategoryId(1);
        room.setFloor(2);
        room.setDayPrice(BigDecimal.valueOf(100));

        var savedRoom = roomDao.save(room);
        System.out.println(savedRoom);
    }
}
