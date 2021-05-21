package data;

import java.util.ArrayList;

/*
 * Stock
 * Holds all of a stock's stock price numbers and its name
 * limit 20 years (alphavantage data) (roughly 5000 elements in each list at max)
 */

public class stock {

    public String ticker;
    public ArrayList<Long> volumes = new ArrayList<>();
    public ArrayList<Double> opens = new ArrayList<>();
    public ArrayList<Double> closes = new ArrayList<>();
    public ArrayList<Double> highs = new ArrayList<>();
    public ArrayList<Double> lows = new ArrayList<>();
    public ArrayList<String> dates = new ArrayList<>();

    public stock(String ticker,
    			ArrayList<Long> volumes,
    			ArrayList<Double> opens,
    			ArrayList<Double> highs,
    			ArrayList<Double> lows,
    			ArrayList<Double> closes,
    			ArrayList<String> dates) 
    {
    	this.ticker = ticker;
    	this.volumes = volumes;
    	this.opens = opens;
    	this.highs = highs;
    	this.lows = lows;
    	this.closes = closes;
    	this.dates = dates;
    }

 }
