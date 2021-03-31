package SuperMarketCheckOut;

public class PriceLoader extends PricingService{
	public PriceLoader() {
	}

	@Override
	public Double checkOfferPrice(String item, Integer quantity) {
		Double price=0.0;
		if(SpecialPriceItemDict.itemMap.containsKey(item)) {
			SKUItems spItem = SpecialPriceItemDict.itemMap.get(item);
			if(spItem.quantity == quantity) {
				price = spItem.unitPrice;
			}
			else {
				int exact = quantity/spItem.quantity;
				int rem = quantity%spItem.quantity;
				price = exact * spItem.unitPrice;
				price += getPrice(item, rem);
			}
		}
		else {
			price = getPrice(item, quantity);
		}
		return price;
	}
	
	@Override
	public Double getPrice(String item, Integer quantity){
		Double price=0.0;
		price = SKUItemPriceDict.itemPriceMap.get(item);
		price = price * quantity;
		return price;
	}

}
