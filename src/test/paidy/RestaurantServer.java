package test.paidy;

import java.util.ArrayList;
import java.util.List;

public class RestaurantServer {
    public static void main(String[] args) {

        // create client thread for creating order request
        List<Thread> allClientThreads= new ArrayList<>();


        for(int i=0;i<10;i++){
            ClientThreadRestoStaff client = new ClientThreadRestoStaff();
            Thread cThread= new Thread(client);
            allClientThreads.add(cThread);
            cThread.start();
        }



    }
}
