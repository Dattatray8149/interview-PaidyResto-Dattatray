package test.paidy.order;

import java.util.HashMap;
import java.util.Map;


/*
  stores all orders made by customers along with required details
  not using persistent storage like DB in order to keep it simple
 */

public class OrdersCache {
    private static Map<Integer,OrderDetails> allOrdersCache= new HashMap<>();

    public static Map<Integer,OrderDetails> getAllOrdersCache(){
        return allOrdersCache;
    }
}
