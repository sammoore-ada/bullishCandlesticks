package test;

import java.io.IOException;
import java.util.ArrayList;

import candlesticks.bullishEngulfing;
import candlesticks.hammer;
import candlesticks.invertedHammer;
import candlesticks.piercingLine;
import candlesticks.threeWhiteSoldiers;
import data.stock;
import data.dataRetriever;

public class dailyRun {

	private static final String date = "2021-05-13"; //enter day to check for candlesticks
	private static final String firstTicker = "PFG"; // default is PFG (first ticker in list)

	public static void main(String args[]) throws IOException, InterruptedException {

		dataRetriever dr = new dataRetriever();
		
		ArrayList<String> tickers = dr.getTickers(firstTicker);

		System.out.println("Running " + tickers.size() + " tickers");
		System.out.println("____________________");


		for (String ticker : tickers) {

			stock s = dr.load(ticker, date);
			run(s);
		}

	}

	/*
	 * facilitator method
	 */

	public static void run(stock s) {

		if (s.lows.size() < 50) {
			return;
		}

			
		if(bullishEngulfing.check(s, 0, 1)) {
			System.out.println(s.ticker+": Bullish Engulfing pattern on "+s.dates.get(0));
		}
		if(hammer.check(s, 0)) {
			System.out.println(s.ticker+": Hammer Candlestick on "+s.dates.get(0));
		}
		if(invertedHammer.check(s, 0)) {
			System.out.println(s.ticker+": Inverted Hammer Candlestick on "+s.dates.get(0));
		}
		if(piercingLine.check(s, 0, 1)) {
			System.out.println(s.ticker+": Piercing Line pattern on "+s.dates.get(0));
		}
		if(threeWhiteSoldiers.check(s, 0, 1, 2)) {
			System.out.println(s.ticker+": Three White Soldiers patter on "+s.dates.get(0));
		}
		

	}
}
