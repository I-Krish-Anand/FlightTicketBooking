package dto;

public class FlightDetails {

    @Override
    public String toString() {
        System.out.println();
        return flightNo+" "+takeOffTime+" "+fromCity+" "+landingTime+" "+toCity+" "+terminal;
    }

    private String flightNo="DAC";

    private static int routeCount=10;
    private String takeOffTime;

    public FlightDetails(String takeOffTime, String landingTime, String toCity, int terminal) {
        flightNo += String.format("%03d",++routeCount);
        this.takeOffTime = takeOffTime;
        this.landingTime = landingTime;
        this.toCity = toCity;
        this.terminal = terminal;

    }

    private final String fromCity="CHENNAI";
    private String landingTime;
    private String toCity;
    private int terminal;

    private  int  businessClass=2,economy=5,EmergencyTickets=1;

    private int[]bClassArr=new int[businessClass],eClassArr=new int[economy];

    public int[] getbClassArr() {
        return bClassArr;
    }

    public void setbClassArr(int[] bClassArr) {
        this.bClassArr = bClassArr;
    }

    public int[] geteClassArr() {
        return eClassArr;
    }

    public void seteClassArr(int[] eClassArr) {
        this.eClassArr = eClassArr;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setBusinessClass(int businessClass) {
        this.businessClass = businessClass;
    }

    public void setEconomy(int e) {
        economy = e;
    }

    public int getBusinessClass() {
        return businessClass;
    }

    public int getEconomy() {
        return economy;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public int getTerminal() {
        return terminal;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getLandingTime() {
        return landingTime;
    }

    public String getTakeOffTime() {
        return takeOffTime;
    }

    public String getToCity() {
        return toCity;
    }

    public void setLandingTime(String landingTime) {
        this.landingTime = landingTime;
    }

    public void setTakeOffTime(String takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

}
