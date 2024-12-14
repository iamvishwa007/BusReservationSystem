package reservationsystem;

public class Bus {
    private int Bus_No;
    private boolean Ac;
    private int Total_Capacity;
    private double basePrice;
    private boolean busAvailable;
    Bus(int Bus_No,boolean Ac,int Capacity,double baseprice){
    	this.Bus_No=Bus_No;
    	this.Ac=Ac;
    	this.Total_Capacity=Capacity;
    	this.basePrice=baseprice;
    	this.busAvailable=true;
    }
    public boolean isBusAvailable() {
    	return busAvailable;
    }
    public void setBusAvailable(boolean busAvailable) {
    	this.busAvailable=busAvailable;
    }
    public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public int getTotal_Capacity() {
		return Total_Capacity;
	}

	public void setTotal_Capacity(int total_Capacity) {
		Total_Capacity = total_Capacity;
	}

	public int getBus_No() {
		return Bus_No;
	}
	public void setBus_No(int bus_No) {
		Bus_No = bus_No;
	}
	public boolean isAc() {
		return Ac;
	}
	public void setAc(boolean ac) {
		Ac = ac;
	}
	public void  displayInfo() {
		System.out.println("===========================================================");
		System.out.println("Bus_No=" + Bus_No + "\nAc=" + Ac + "\nTotal_Capacity=" + Total_Capacity+"\nRent per day="+basePrice);
		System.out.println("===========================================================");
	}
    
}
