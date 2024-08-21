package com.example.techtask.repository;

import com.example.techtask.model.Order;
import com.example.techtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query("SELECT o FROM Order o WHERE o.quantity>1 ORDER BY o.createdAt DESC LIMIT 1")
    public Order findNewestMoreThanOneItem();
    @Query("SELECT o FROM Order o JOIN User u ON o.userId=u.id WHERE u.userStatus='ACTIVE' ORDER BY o.createdAt DESC")
    public List<Order> findFromActiveUsers();
}
