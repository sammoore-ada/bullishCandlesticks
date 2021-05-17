# bullishCandlesticks

Many traders use candlesticks to try and predict how the stock price will change in the near future. There are many different candlesticks that traders watch for. This project reads in stock price data from alphavantage for a list of stocks and then performs calculations and tests on that data and ultimately outputs if a bullish pattern or bullish candlestick formed that day. 

It is important to note that bullish candlesticks are by no means a signal to buy the stock. If bullish patterns and candlesticks were a sure sign that the stock will go up and a trader could make a quick profit, then every trader would use them and be successful, which is not the case. Candlesticks are one of many tools that traders use if they are trying to predict a price change, but in order to win more than lose, a trader needs to develop a strategy that is a combination of creativity, technical analysis, and a high level of discipline and by no means should solely rely on a candlestick or pattern that is formed.

The candlesticks and patterns that this project detects are the hammer, inverted hammer, bullish engulfing, piercing line, and three white soldiers; these are all very common bullish patterns and reversals and can be explained in detail here -> https://www.investopedia.com/articles/active-trading/062315/using-bullish-candlestick-patterns-buy-stocks.asp - These are all candlessticks and patterns that are meant to be recognized by sight, but this project attempts to recognize them using the open, high, low, close, and volumes of the stock for a single trading day; the numbers used to detect these candlesticks and patterns were chosen by myself, the writer of the program.

There is a private key that is needed to request large amounts of data from alphavantage, so that varibale is left blank in the program. 

