
class FactoryExample{
	public static void main(String[] args) {
		DomesticPlan plan1 = new DomesticPlan();
		plan1.getRate();
		Plan.calculateBill(10);
		CommercialPlan plan2 = new CommercialPlan();
		plan2.getRate();
		Plan.calculateBill(10);
		InstitutionalPlan plan3 = new InstitutionalPlan();
		plan3.getRate();
		Plan.calculateBill(10);
	}
}
abstract class Plan {
	static int rate;
	void getRate() {
		rate=35;
	}

	public static void calculateBill(int units) {
		System.out.println(units*rate + " dollars");
	}


}class DomesticPlan extends Plan{

	@Override
	void getRate() {
		rate=35;
	}

}class CommercialPlan extends Plan{

	@Override
	void getRate() {
		rate=25;
	}

}class InstitutionalPlan extends Plan{

	@Override
	void getRate() {
		rate = 15;
	}

}
