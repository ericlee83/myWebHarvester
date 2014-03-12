package com.commons.utils.web;

public class RealEstateMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		RealEstateWebHarvester webHarvester = new RealEstateWebHarvester();
		webHarvester.start();

		webHarvester.close();
	}

}
