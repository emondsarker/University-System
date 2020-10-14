package assignment04;

public class DevelopmentFeeCalculator implements IExtraFeeCalculator {

	@Override
	public int getExtraAmount(int courseTotal) {
		
		//calculates development fee (10% of course fees)
		return (int)(courseTotal*0.10);
	}
}
