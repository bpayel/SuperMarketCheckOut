package SuperMarketCheckOut;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class CheckOut {
	public TreeMap<String, Integer> itemListMap;
	PricingService srv;
	public CheckOut(PricingService srv) {
		itemListMap = new TreeMap<String, Integer>();
		this.srv = srv;
	}
	public void scan(String item) {
		if(itemListMap.containsKey(item))
			itemListMap.put(item, itemListMap.get(item)+1);
		else
			itemListMap.put(item, 1);
	}
	public Double CalculateMyOrderTotal() {
		Double total = 0.0;
		if(itemListMap.isEmpty()) {
			System.out.println("Your cart is Empty");
			return total;
		}
		else {
			Set<String> keys = itemListMap.keySet();
			Iterator<String> itr = keys.iterator();
			while(itr.hasNext()) {
				String item = itr.next();
				Integer quantity = itemListMap.get(item);
				total += srv.checkOfferPrice(item, quantity);
			}
			itemListMap.clear();
			return total;
		}
		
		
	}

}
