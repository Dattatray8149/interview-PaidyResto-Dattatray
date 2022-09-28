package test.paidy.food;

import java.util.Date;

public class FoodItem {

    private String foodName;
    private int timeRequiredToPrepare;
    private int quantity;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getTimeRequiredToPrepare() {
        return timeRequiredToPrepare;
    }

    public void setTimeRequiredToPrepare(int timeRequiredToPrepare) {
        this.timeRequiredToPrepare = timeRequiredToPrepare;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "foodName='" + foodName + '\'' +
                ", timeRequiredToPrepare=" + timeRequiredToPrepare +
                ", quantity=" + quantity +
                '}';
    }
}
