package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Handles the retrieval of all of the stock data 
 * Uses a line by line scanner technique rather than json - plan to change to a better way
 */

public class dataRetriever {
	
	/*
	 * key needed to access data (this is a 150 api call per minute key) (paid for)
	 * **LEFT OUT FOR PRIVACY**
	 */
	
	private static final String KEY = "";
	
	public ArrayList<String> getTickers(String start) throws IOException {
		
		File file = new File("tickers.txt");
		Scanner scan = new Scanner(file);
		ArrayList<String> tickers = new ArrayList<>();
		boolean ready = false;
		

		while (scan.hasNextLine()) {
			
			String ticker = scan.next();
			
			if(ticker.equals(start)) {
				ready = true;
			}
			if(ready) {
				tickers.add(ticker);
			}
			scan.nextLine();
		}
		
		scan.close();
		return tickers;

	}
	
	public stock load(String ticker, String date) throws IOException, NumberFormatException {
		
		BufferedReader buff = new BufferedReader(setUpConnection(ticker));
		String line = buff.readLine();
		String stock = ticker;
		ArrayList<Long> volumes = new ArrayList<>();
		ArrayList<Double> opens = new ArrayList<>();
		ArrayList<Double> closes = new ArrayList<>();
		ArrayList<Double> highs = new ArrayList<>();
		ArrayList<Double> lows = new ArrayList<>();
		ArrayList<String> dates = new ArrayList<>();

		boolean ready = false;

		while (line != null) {
			if (line.contains(date)) {
				ready = true;
			}

			if (ready) 
			{

				if (line.contains("6. volume")) {
					line = line.trim();
					String toAdd = line.substring(14, line.lastIndexOf('"'));
					volumes.add(Long.parseLong(toAdd));
				} else if (line.contains("1. open")) {
					line = line.trim();
					String toAdd = line.substring(12, line.lastIndexOf('"'));
					opens.add(Double.parseDouble(toAdd));
				} else if (line.contains("4. close")) {
					line = line.trim();
					String toAdd = line.substring(13, line.lastIndexOf('"'));
					closes.add(Double.parseDouble(toAdd));
				} else if (line.contains("2. high")) {
					line = line.trim();
					String toAdd = line.substring(12, line.lastIndexOf('"'));
					highs.add(Double.parseDouble(toAdd));
				} else if (line.contains("3. low")) {
					line = line.trim();
					String toAdd = line.substring(11, line.lastIndexOf('"'));
					lows.add(Double.parseDouble(toAdd));
				}  else if (line.contains("{") && line.contains("-")) {
					line = line.trim();
					String toAdd = line.substring(1, 11);
					dates.add(toAdd);
				}			
			}
			line = buff.readLine();
		}
		return new stock(stock, volumes, opens, highs, lows, closes, dates);
	}
	
	private static InputStreamReader setUpConnection(String ticker) throws IOException {
		URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=" + ticker
				+ "&outputsize=full&apikey=" + KEY);
		URLConnection urlC = url.openConnection();
		InputStreamReader in = new InputStreamReader(urlC.getInputStream());
		return in;
	}

}
