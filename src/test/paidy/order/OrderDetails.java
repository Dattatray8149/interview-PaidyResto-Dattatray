package test.paidy.order;

import test.paidy.food.FoodItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDetails {

    private int orderID;
    private int tableNumber;
    private Date dateTimeOfOrder;
    private List<FoodItem> orderedFoodItemList = new ArrayList<>();

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getDateTimeOfOrder() {
        return dateTimeOfOrder;
    }

    public void setDateTimeOfOrder(Date dateTimeOfOrder) {
        this.dateTimeOfOrder = dateTimeOfOrder;
    }

    public List<FoodItem> getOrderedFoodItemList() {
        return orderedFoodItemList;
    }

    public void setOrderedFoodItemList(List<FoodItem> orderedFoodItemList) {
        this.orderedFoodItemList = orderedFoodItemList;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderID=" + orderID +
                ", tableNumber=" + tableNumber +
                ", dateTimeOfOrder=" + dateTimeOfOrder +
                ", orderedFoodItemList=" + orderedFoodItemList +
                '}';
    }
}
