package candlesticks;

import data.stock;

/*
 * the piercing line two day candlestick
 * pattern forms in downtrends and is
 * used by traders to signal a potential
 * change of trend 
 */

public class piercingLine {

public static boolean check(stock s, int today, int yesterday) {
		
		double yesterdayOpen = s.opens.get(yesterday);
		double yesterdayClose = s.closes.get(yesterday);
		double yesterdayLow = s.lows.get(yesterday);
		double todayOpen = s.opens.get(today);
		double todayClose = s.closes.get(today);
		double todayHigh = s.highs.get(today);
		double todayLow = s.lows.get(today);
		boolean downtrend = checkDowntrend(s, today);
		boolean yesterdayRed = yesterdayClose < yesterdayOpen;
		boolean todayGreen = todayClose > todayOpen;
		
		if(yesterdayOpen > todayHigh && yesterdayClose > todayOpen) {
			if(todayLow < yesterdayLow) {
				if(downtrend && yesterdayRed && todayGreen) {
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
