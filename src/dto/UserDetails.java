package dto;

public class UserDetails {

    @Override
    public String toString() {
        return "First Name:"+this.firstName+" Last Name:"+lastName+" BookingId: "+bookingId+"CHENNAI"+" TO "+destinationLocation;
    }

    private String firstName;

    private String lastName;

    private int age;

    private String destinationLocation;

    private String pricing;

    private String phNo;
    private int fare,allotedSeat;

    private String flightNo;

    private String bookingId="TCK";

    public String getBookingId() {
        return bookingId;
    }

    private static int usercount;

    public UserDetails(String firstName, String lastName, int age, String destinationLocation, String pricing,String phNo) {
        bookingId += String.format("%03d",++usercount);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.destinationLocation = destinationLocation;
        this.pricing = pricing;
        this.phNo=phNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getAllotedSeat() {
        return allotedSeat;
    }

    public void setAllotedSeat(int allotedSeat) {
        this.allotedSeat = allotedSeat;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }
}
