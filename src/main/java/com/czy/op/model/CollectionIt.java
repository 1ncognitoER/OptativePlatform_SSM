package com.czy.op.model;

import java.util.List;

public class CollectionIt {
	private int userId;
    private int carId;
    private List<Car> carList;
	public CollectionIt(int userId, int carId, List<Car> carList) {
		super();
		this.userId = userId;
		this.carId = carId;
		this.carList = carList;
	}
	public CollectionIt(int userId, int carId) {
		super();
		this.userId = userId;
		this.carId = carId;
	}
	public CollectionIt() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Collection [userId=" + userId + ", carId=" + carId + ", carList=" + carList + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public List<Car> getCarList() {
		return carList;
	}
	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}
    
}
