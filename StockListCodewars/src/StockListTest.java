
public class StockListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
		String cd[] = new String[] {"A", "B"};
		/*"(A : 200) - (B : 1140)"*/
		System.out.println(StockList.stockSummary(art, cd));
	}

}
