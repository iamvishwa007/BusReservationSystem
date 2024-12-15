package reservationsystem;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class BusReservationSystem {

	public static void main(String[] args) throws ParseException {
		  Scanner sc=new Scanner(System.in);

          //To Store Bus Objects
		 /* Bus []bus=new Bus[] not efficient so we use ArrayList to store data in dynamic */
		  ArrayList<Bus> buses=new ArrayList<Bus>();
		  buses.add(new Bus(100,true,58,5000));
		  buses.add(new Bus(102,true,56,4500));
		  buses.add(new Bus(104,false,40,3000));
		  buses.add(new Bus(106,true,58,5000));
		  ArrayList<Booking> bookings=new ArrayList<>();

	        int userOpt = 0;
	        while (true) {
	            System.out.println("VK Bus Rent Booking System\n1. View Bus Information\n2. Book a Bus\n3.Return the bus\n4. Exit");
	            userOpt = sc.nextInt();
	            sc.nextLine(); // Consume leftover newline

	            if (userOpt == 1) {
	                for (Bus bus : buses) {
	                    bus.displayInfo();
	                }
	            } else if (userOpt == 2) {
	                System.out.print("Enter Passenger Name: ");
	                String name = sc.nextLine();
	                System.out.print("Enter Bus No: ");
	                int busNo = sc.nextInt();
	                System.out.print("Enter Start Date (dd-MM-yyyy): ");
	                String startDateInput=sc.next();
	                System.out.print("Enter End Date (dd-MM-yyyy): ");
	                String endDateInput = sc.next();
 
	                Date startDate = new SimpleDateFormat("dd-MM-yyyy").parse(startDateInput);
	                Date endDate = new SimpleDateFormat("dd-MM-yyyy").parse(endDateInput);

	                long days = calculateDays(startDate, endDate);
	                if (days <= 0) {
	                    System.out.println("Invalid date range. Please try again.");
	                    continue;
	                }

	                if (isBusAvailable(buses, busNo, bookings, startDate, endDate)) {
	                    double totalRent = calculateRent(buses, busNo, days);
	                    bookings.add(new Booking(name, busNo, startDate, endDate, totalRent));
	                    markBusUnavailable(buses, busNo);
	                    System.out.println("Successfully booked! Total Rent: Rs. " + totalRent);
	                } else {
	                    System.out.println("Bus is not available for the selected dates.");
	                }
	            }
	            else if(userOpt == 3) {
	            	System.out.println("Enter the bus_no");
	            	int bus_no=sc.nextInt();
	            	if(busRented(buses,bus_no)) 
	            	{
	            	for(Bus bus:buses) {
	            		if(bus.getBus_No()==bus_no) {
	            			bus.setBusAvailable(true);
	            			System.out.println("Return Successfully");
	            		}
	            	}
	            	}else {
	            		System.out.println("Invalid Bus no.....");
	            	}
	            }
	            else if (userOpt == 4) {
	                System.out.println("Thank you for using VK Bus Reservation System!");
	                break;
	            } else {
	                System.out.println("Invalid option. Please choose a valid one.");
	            }
	        }

	        sc.close();
	    }
	 public static boolean busRented(ArrayList<Bus> buses,int bus_no) {
		 for(Bus bus:buses) {
			 if(bus.getBus_No()==bus_no) {
				 if(!bus.isBusAvailable())
					 return true;
			 }
		 }
		 return false;
	 }
	 public static long calculateDays(Date startDate, Date endDate) {
	        long difference = endDate.getTime() - startDate.getTime();
	        return difference / (1000 * 60 * 60 * 24) + 1;
	    }

	 public static boolean isBusAvailable(ArrayList<Bus> buses, int busNo, ArrayList<Booking> bookings, Date startDate, Date endDate) {
	        for (Bus bus : buses) {
	            if (bus.getBus_No() == busNo && bus.isBusAvailable()) {
	                for (Booking booking : bookings) {
	                    if (booking.Bus_No == busNo && (datesOverlap(booking.startDate, booking.endDate, startDate, endDate))) {
	                        return false;
	                    }
	                }
	                return true;
	            }
	        }
	        System.out.println("Invalid Bus Number.");
	        return false;
	    }
	 public static boolean datesOverlap(Date start1, Date end1, Date start2, Date end2) {
	        return !(end1.before(start2) || start1.after(end2));
	    }

	    public static double calculateRent(ArrayList<Bus> buses, int busNo, long days) {
	        for (Bus bus : buses) {
	            if (bus.getBus_No() == busNo) {
	                return bus.getBasePrice() * days;
	            }
	        }
	        return 0;
	    }
	    public static void markBusUnavailable(ArrayList<Bus> buses, int busNo) {
	        for (Bus bus : buses) {
	            if (bus.getBus_No() == busNo) {
	                bus.setBusAvailable(false);
	                break;
	            }
	        }
	    }
}
