package assignment04;

public class BDTaxAdapter extends BDTaxCalculator implements IExtraFeeCalculator {

	@Override
	public int getExtraAmount(int courseTotal) {
		
		//converts calculated Tax from double to integer
		return (int)calculateVatAmount(courseTotal);
	}
}
