package SuperMarketCheckOut;
public class MainClass {
	static PricingService pricingService;
	static CheckOut co;
	public static void assert_equal(Double price, String item) {
		for(int i=0;i<item.length();i++) {
			co.scan(Character.toString(item.charAt(i)));
		}
		Double total = co.CalculateMyOrderTotal();
		if(!price.equals(total))
			System.out.println("Fail: Expected " +  price + "Calculated:  " + total);
		else
			System.out.println("Success");

	}
	public static void main(String[] args) {
		pricingService = new PriceLoader();
		co= new CheckOut(pricingService);
		co.scan("A");
		co.scan("A");
		co.scan("B");
		Double OrderTotal = co.CalculateMyOrderTotal();
		System.out.println("Name" + "Quantity");
		System.out.println("Total is : " + OrderTotal);
		assert_equal(0.0, "");
		assert_equal(50.0, "A");
		assert_equal(80.0, "AB");
		assert_equal(115.0, "CDBA");
		assert_equal(100.0, "AA");
		assert_equal(130.0, "AAA");
		assert_equal(175.0, "AAABB");
		
	}
	
	

}
