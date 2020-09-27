package services;

import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;


// Type your code
//Create a class called as FareCalculator.
//FareCalculator should extend the Booking Class and should use the booking method defined in Booking Class.
//FareCalculator has 4 methods as mentioned below.
//public double book(Hotel hotel)
//public double book(Flight flight)
//public double book(Train train)
//public double book(Bus bus)
//Each method should return the total fare

public class FareCalculator extends Booking{
	double total_rate;
	public double book(Hotel hotel) {
		
//		Check-In date should be less than Check-Out date.
//		Single occupancy can be given only for 1 guest.
//		If there are 3 guests then the rooms alloted should be 1 Double Occupancy room and 1 Single Occupancy.
//		Calculate the total fare after these conditions are met.
		if(hotel.getFromdate().isBefore(hotel.getTodate())) { 
			return booking(hotel.getNoOfPersons(), hotel.getRates());
			}
//			else if(h.getNoOfPersons()==3) {
//				String Occupancy = "One double"+"One single";
//				return booking(h.getNoOfPersons(), h.getRates());
//			}
//			
		return 0;}
		
	public double book(Flight flight) {
//		If one way trip is selected then departure date is not considered for fare calculation.
//		For round trips Start date should be less than return date.
		if(flight.getFrom().compareTo(flight.getTo())>0 && flight.getTriptype().contentEquals("round-trip")){
			return booking(flight.getNoOfPersons(), flight.getRates())*2;
		}
		 else {
			 return booking(flight.getNoOfPersons(), flight.getRates());
		}
		
	}
	public double book(Train train) {
		return booking(train.getNoOfPersons(), train.getRates());
		
	}
	public double book(Bus bus) {
		return booking(bus.getNoOfPersons(), bus.getRates());
		
	}
}