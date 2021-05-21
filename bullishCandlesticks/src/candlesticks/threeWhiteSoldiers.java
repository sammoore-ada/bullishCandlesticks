package candlesticks;

import data.stock;

public class threeWhiteSoldiers {

	/*
	 * the three white soldiers pattern consists
	 * of three consecutive large (in this case, greater than 4%, but can vary)
	 * green candlesticks after a downtrend. This shows strong buying pressure 
	 * and must be on high volume as well
	 */
	
	public static boolean check(stock s, int dayOne, int dayTwo, int dayThree) {
		double dayOneOpen = s.opens.get(dayOne);
		double dayOneClose = s.closes.get(dayOne);
		double dayTwoOpen = s.opens.get(dayTwo);
		double dayTwoClose = s.closes.get(dayTwo);
		double dayThreeOpen = s.opens.get(dayThree);
		double dayThreeClose = s.closes.get(dayThree);
		boolean downtrend = checkDowntrend(s, dayOne);
		
		double dayOneGain = ((dayOneClose / dayOneOpen) - 1) * 100;
		double dayTwoGain = ((dayTwoClose / dayTwoOpen) - 1) * 100;
		double dayThreeGain = ((dayThreeClose / dayThreeOpen) - 1) * 100;
		
		if(dayOneGain >= 4 && dayTwoGain >= 4 && dayThreeGain  >= 4) {
			if(dayTwoOpen >= dayOneClose && dayThreeOpen >= dayTwoClose) {
				if(downtrend) {
					return true;
				}
			}
		}
		return false;
	}
	/*
	 * Simple method to check if the stock price
	 * has been moving downwards over the last 
	 * month. This does not always mean it is in a downtrend and
	 * it will require more studying, but it will phase out
	 * many false bullish engulfing candlestick patterns
	 */
	
	public static boolean checkDowntrend(stock s, int day) {
		
		double lastMonthClose = s.closes.get(day + 20);
		double todayClose = s.closes.get(day);
		
		return (todayClose < lastMonthClose);
		
	}

}
