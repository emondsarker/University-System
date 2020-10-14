package assignment04;

public class MinorityGroupDiscount implements IDiscountStrategy{

	@Override
	public int getTotal(Registration reg) {
		
		//applies 10% discount to total course fees
		int discount = (int)(reg.getTotal()*0.10);
		
		return discount;
	}
}
