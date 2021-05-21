package candlesticks;

import data.stock;

/*
 * This class contains calculations that detects the
 * Bullish Engulfing two-day candlestick pattern
 * that is often an indicator that traders use to 
 * detect upswings in stock price
 */

public class bullishEngulfing {
	
	public static boolean check(stock s, int today, int yesterday) {
		
		double yesterdayLow = s.lows.get(yesterday);
		double yesterdayHigh = s.highs.get(yesterday);
		double todayOpen = s.opens.get(today);
		double todayClose = s.closes.get(today);
		boolean downtrend = checkDowntrend(s, today);
		
		if(todayOpen < yesterdayLow && todayClose > yesterdayHigh) {
			if(downtrend) {
				return true;
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
