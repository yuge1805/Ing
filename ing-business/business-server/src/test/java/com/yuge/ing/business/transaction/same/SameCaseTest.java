package com.yuge.ing.business.transaction.same;

import com.yuge.ing.business.server.service.OrderItemService;
import com.yuge.ing.business.server.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SameCaseTest {

    public static final String ORDER_NO = "111";

    @Autowired
    private SameCase1 sameCase1;

    @Autowired
    private SameCase2 sameCase2;

    @Autowired
    private SameCase3 sameCase3;

    @Autowired
    private SameCase4 sameCase4;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @BeforeEach
    public void delete() {
        orderService.deleteByOrderNo(ORDER_NO);
        orderItemService.deleteByOrderNo(ORDER_NO);
    }

    @Test
    void case1Handle() {
        sameCase1.handle();
    }

    @Test
    void case2Handle() {
        sameCase2.handle();
    }

    @Test
    void case3Handle() {
        sameCase3.handle();
    }

    @Test
    void case4Handle() {
        sameCase4.handle();
    }
}