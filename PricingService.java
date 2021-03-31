package SuperMarketCheckOut;

public abstract class PricingService {
	public abstract Double getPrice(String item, Integer quantity);
	public abstract Double checkOfferPrice(String item, Integer quantity);
}
