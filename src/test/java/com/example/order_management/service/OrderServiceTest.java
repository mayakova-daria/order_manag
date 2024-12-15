package com.example.order_management.service;

package com.example.order_management.service;

import com.example.order_management.entity.Order;
import com.example.order_management.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    public OrderServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllOrders() {
        Order order1 = new Order();
        order1.setId(1L);
        order1.setTotalCost(200.00);

        Order order2 = new Order();
        order2.setId(2L);
        order2.setTotalCost(300.00);

        when(orderRepository.findAll()).thenReturn(Arrays.asList(order1, order2));

        List<Order> orders = orderService.getAllOrders();

        assertThat(orders).hasSize(2);
        assertThat(orders.get(0).getTotalCost()).isEqualTo(200.00);
    }
}

