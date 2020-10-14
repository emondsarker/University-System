package assignment04;

public class AcademicExcellenceDiscount implements IDiscountStrategy {

	@Override
	public int getTotal(Registration reg) {
		
		//applies 20% discount to total course fees
		int discount = (int)(reg.getTotal()*0.20);
		
		return discount;
	}
}
