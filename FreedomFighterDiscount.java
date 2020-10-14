package assignment04;

public class FreedomFighterDiscount implements IDiscountStrategy {

	@Override
	public int getTotal(Registration reg) {
		
		//applies 25% discount to total course fees
		int discount = (int)(reg.getTotal()*0.25);
		
		return discount;
	}
}
