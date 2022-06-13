package com.yuge.ing.business.transaction.different;

import com.yuge.ing.business.server.service.OrderItemService;
import com.yuge.ing.business.server.service.OrderService;
import com.yuge.ing.business.transaction.different.case1.DifferentCase1;
import com.yuge.ing.business.transaction.different.case2.DifferentCase2;
import com.yuge.ing.business.transaction.different.case3.DifferentCase3;
import com.yuge.ing.business.transaction.different.case4.DifferentCase4;
import com.yuge.ing.business.transaction.different.case5.DifferentCase5;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DifferentCaseTest {

    public static final String ORDER_NO = "111";

    @Autowired
    private DifferentCase1 differentCase1;

    @Autowired
    private DifferentCase2 differentCase2;

    @Autowired
    private DifferentCase3 differentCase3;

    @Autowired
    private DifferentCase4 differentCase4;

    @Autowired
    private DifferentCase5 differentCase5;

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
        differentCase1.handle();
    }

    @Test
    void case2Handle() {
        differentCase2.handle();
    }

    @Test
    void case3Handle() {
        differentCase3.handle();
    }

    @Test
    void case4Handle() {
        differentCase4.handle();
    }

    @Test
    void case5Handle() {
        differentCase5.handle();
    }

}