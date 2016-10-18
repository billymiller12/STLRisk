package riskHelpers;

import county.County;

public class Card {
	private int symbol;
	private County county;
	public Card(County county) {
		int a=Helpers.randomInt();
		if (a<=33)	{
			this.symbol=1;
		}
		if (33<=a&&a<=66)	{
			this.symbol=2;
		}
		if (66<=a&&a<=100)	{
			this.symbol=3;
		}
		this.county = county;

	}

	public Card()	{
		this.symbol=4;
		this.county=null;
	}

	public int getSymbol() {
		return symbol;
	}
	public County getCounty() {
		return county;
	}

}
