package com.xk.orm;

import java.math.BigDecimal;
import java.util.Date;

public class Pole extends CommonEntity{
    private double longtitude;

    private double latitude;

    private double positionmethod;

    private double height;

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getPositionmethod() {
		return positionmethod;
	}

	public void setPositionmethod(double positionmethod) {
		this.positionmethod = positionmethod;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}