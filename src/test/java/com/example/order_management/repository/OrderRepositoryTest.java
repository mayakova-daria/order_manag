package com.example.order_management.repository;

package com.example.order_management.repository;

import com.example.order_management.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testSaveAndFindOrder() {
        Order order = new Order();
        order.setTotalCost(150.50);
        order.setCreatedAt(LocalDateTime.now());


        Order savedOrder = orderRepository.save(order);

        assertThat(savedOrder.getId()).isNotNull();

        Order foundOrder = orderRepository.findById(savedOrder.getId()).orElse(null);
        assertThat(foundOrder).isNotNull();
        assertThat(foundOrder.getTotalCost()).isEqualTo(150.50);
    }
}
