package candlesticks;

import data.stock;

/*
 * This class contains calculations that detects the
 * hammer one-day candlestick that is often an indicator
 * that traders use to detect upswings in stock price
 */

public class hammer {
	
	/*
	 * collection of bounds that different properties
	 * of the candlestick must fall between
	 * (these can be changed)
	 */
	
	private static final double DAY_CHANGE = 3.5; //%
	private static final double OPEN_LOW_MIN = 6.0; //%
	private static final double OPEN_LOW_MAX = 14.0; //%
	private static final double HIGH_CLOSE_MIN = 0; //%
	private static final double HIGH_CLOSE_MAX = 0.9; //%
	private static final double HIGH_LOW_MIN = 10.0; //%
	private static final double HIGH_LOW_MAX = 20.0; //%
	
	public static boolean check(stock s, int today) {
		
		double open = s.opens.get(today);
		double high = s.highs.get(today);
		double low = s.lows.get(today);
		double close = s.closes.get(today);
		double yesterdayClose = s.closes.get(today);
		boolean downtrend = checkDowntrend(s, today);
		
		double dayChange = ((close / open) - 1) * 100;
		double openLow = ((open / low) - 1) * 100;
		double highClose = ((high / close) - 1) * 100;
		double highLow = ((high / low) - 1) * 100;
		
		if(dayChange <= DAY_CHANGE && downtrend) {
			if(openLow >= OPEN_LOW_MIN && openLow <= OPEN_LOW_MAX) {
				if(highClose >= HIGH_CLOSE_MIN && highClose <= HIGH_CLOSE_MAX) {
					if(highLow >= HIGH_LOW_MIN && highLow <= HIGH_LOW_MAX) {
						if(close < yesterdayClose) {
							return true;
						}
					}
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
