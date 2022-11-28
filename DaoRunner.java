import dao.*;
import entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class DaoRunner {

    public static void main(String[] args) {


        var categoryRoomDao = CategoryRoomDao.getInstance();
        var all = categoryRoomDao.findAll();
        System.out.println(all);
        var byId = categoryRoomDao.findById(1);
        System.out.println(byId);
//        byId.ifPresent(categoryRoom -> {
//            categoryRoom.setCategory("Standart");
//            categoryRoomDao.update(categoryRoom);
//        });
        var categoryRoom = new CategoryRoom();
//        categoryRoom.setCategory("Luxury");
//        categoryRoomDao.save(categoryRoom);

        var roleDao = RoleDao.getInstance();
        var all1 = roleDao.findAll();
        System.out.println(all1);
        var byId1 = roleDao.findById(1);
        System.out.println(byId1);
//        byId1.ifPresent(role -> {
//            role.setRoleInfo("Administrator");
//            roleDao.update(role);
//        });
//        var role = new Role();
//        role.setRoleInfo("Visitor");
//        roleDao.save(role);

        var orderDao = OrderDao.getInstance();
        var all2 = orderDao.findAll();
        System.out.println(all2);
        var byId2 = orderDao.findById(4);
        System.out.println(byId2);

        var instance = QuantityBedDao.getInstance();
        var all3 = instance.findAll();
        System.out.println(all3);
        updateQuantity.;

        var roomDao = RoomDao.getInstance();
        var all4 = roomDao.findAll();
        System.out.println(all4);

        var infoDao = UserInfoDao.getInstance();
        var all5 = infoDao.findAll();
        System.out.println(all5);


    }

    private static void updateQuantityBed() {
        var quantityBedDao = QuantityBedDao.getInstance();
        var qua = quantityBedDao.findById(1);
        System.out.println(qua);
        qua.ifPresent(quantityBed -> {
            quantityBed.setQuantity("Двухместный номер");
            quantityBedDao.update(quantityBed);
        });
    }

    private static void orderUpdate() {
        var orderDao = OrderDao.getInstance();
        var maybeOrder = orderDao.findById(1);
        maybeOrder.ifPresent(order -> {
            order.setStatus("Свободно");
            order.setMessage("На рассмотрении");
            orderDao.update(order);
        });
    }

    private static void saveOrder() {
        var orderDao = OrderDao.getInstance();
        var order = new Order();
        order.setUserInfoId(1);
        order.setRoomId(1);
        order.setBeginTimeOfTheOrder(LocalDateTime.of(2022,11,22,14,15,00));
        order.setEndTimeOfTheOrder(LocalDateTime.of(2022,11,23,14,15,00));
        order.setStatus("Reserved");
        order.setMessage("In Processing");
        orderDao.save(order);
    }

    private static void saveUserInfo() {
        var userInfoDao = UserInfoDao.getInstance();
        var userInfo = new UserInfo();
        userInfo.setFirstName("Petr");
        userInfo.setLastName("Petrov");
        userInfo.setEmail("123@mail.ru");
        userInfo.setAmount(2000);
        userInfo.setPassword("moloko");
        userInfo.setRoleId(2);
        userInfoDao.save(userInfo);
    }


//        var maybeOrder = orderDao.findById(1);
//        maybeOrder.ifPresent(order -> {
//            order.setStatus("согласовано");
//            orderDao.update(order);
//        });








    private static void RoomDaoTestSave() {
        var roomDao = RoomDao.getInstance();
        var room = new Room();
        room.setNumberRoom(1);
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
        userInfo.setRoleId(2);
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
        room.setNumberRoom(123);
        room.setQuantityId(1);
        room.setCategoryId(1);
        room.setFloor(2);
        room.setDayPrice(BigDecimal.valueOf(100));

        var savedRoom = roomDao.save(room);
        System.out.println(savedRoom);
    }
}
