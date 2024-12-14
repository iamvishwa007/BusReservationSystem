package reservationsystem;
import java.util.*;
public class Booking {
     String Passenger_Name;
     int Bus_No;
     Date startDate;
     Date endDate;
     double totalRent;

     Booking(String passenger_Name, int bus_No, Date startDate, Date endDate, double totalRent) {
         this.Passenger_Name = passenger_Name;
         this.Bus_No = bus_No;
         this.startDate = startDate;
         this.endDate = endDate;
         this.totalRent = totalRent;
     }
 }
