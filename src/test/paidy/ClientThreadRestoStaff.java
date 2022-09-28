package test.paidy;

import test.paidy.food.FoodItem;
import test.paidy.food.FoodMenu;
import test.paidy.order.OrderDetails;
import test.paidy.order.OrdersCache;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientThreadRestoStaff implements  Runnable{

    // a global counter for order number starting 1000
    static AtomicInteger counter = new AtomicInteger(1000);
    static AtomicInteger tableNumberCounter = new AtomicInteger(0);




    @Override
    public void run() {

        System.out.println("Starting "+Thread.currentThread()+" for order.....");



        OrderDetails order= createOrder();
        AtomicInteger orderNumber= orderFood(order);

        System.out.println(" Ordered food . Order number ="+orderNumber+"  food details="+order);



        System.out.println("Getting CurrentOrderStatus "+ getCurrentOrderStatus());
    }

    private OrderDetails createOrder(){
        ThreadLocalRandom random = ThreadLocalRandom.current();

        OrderDetails newOrder = new OrderDetails();
        newOrder.setDateTimeOfOrder(new Date());
        int desertIndex = random.nextInt(0, 2);
        int foodQuatity = random.nextInt(1,4);
        int foodPreparationTimeInMinutes= random.nextInt(5,15); //random time in minutes

        newOrder.setTableNumber(tableNumberCounter.addAndGet(1)); // assuming only few tables are there
        List<FoodItem> orderedFoodItemList = new ArrayList<>();

        //starters
        FoodItem starter = new FoodItem();
        starter.setFoodName(FoodMenu.starters.get(desertIndex));
        starter.setQuantity(foodQuatity);
        starter.setTimeRequiredToPrepare(foodPreparationTimeInMinutes);
        newOrder.setOrderedFoodItemList(orderedFoodItemList);
        orderedFoodItemList.add(starter);

        //main course
        FoodItem mainCourse = new FoodItem();
        mainCourse.setFoodName(FoodMenu.mainCourse.get(desertIndex));
        mainCourse.setQuantity(foodQuatity);
        mainCourse.setTimeRequiredToPrepare(foodPreparationTimeInMinutes);
        newOrder.setOrderedFoodItemList(orderedFoodItemList);
        orderedFoodItemList.add(mainCourse);
        //desert
        FoodItem desert = new FoodItem();
        desert.setFoodName(FoodMenu.deserts.get(desertIndex));
        desert.setQuantity(foodQuatity);
        desert.setTimeRequiredToPrepare(foodPreparationTimeInMinutes);
        newOrder.setOrderedFoodItemList(orderedFoodItemList);
        orderedFoodItemList.add(desert);

        newOrder.setOrderedFoodItemList(orderedFoodItemList);

        return newOrder;
    }

    public Map<Integer, OrderDetails> getCurrentOrderStatus(){

        // making sure only one thread can read
        synchronized (OrdersCache.getAllOrdersCache()){
            return OrdersCache.getAllOrdersCache();
        }

    }

    //returns order ID after placing order
    private AtomicInteger orderFood(OrderDetails newOrder){

        counter.addAndGet(1);
        newOrder.setOrderID(counter.get());
        synchronized (OrdersCache.getAllOrdersCache()) {
            OrdersCache.getAllOrdersCache().put(counter.get(), newOrder);
        }

        return counter;

    }

    public OrderDetails checkOrderStatus(int orderNumber){
        synchronized (OrdersCache.getAllOrdersCache()) {
            return OrdersCache.getAllOrdersCache().get(orderNumber);
        }
    }

}
