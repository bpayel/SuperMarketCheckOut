package SuperMarketCheckOut;
import java.util.TreeMap;

public class SpecialPriceItemDict {
	public static TreeMap<String, SKUItems> itemMap = new TreeMap<String, SKUItems>();
	static {
		itemMap.put("A", new SKUItems("A", 3, 130.0));
		itemMap.put("B", new SKUItems("B", 2, 45.0));
		itemMap.put("C", new SKUItems("C", 5, 80.0));
	}
}
