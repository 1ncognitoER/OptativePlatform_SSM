package com.czy.op.model;

public class Image {
	private int imgId;
	private String imgPath;
	private int carId;
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Image(int imgId, String imgPath, int carId) {
		super();
		this.imgId = imgId;
		this.imgPath = imgPath;
		this.carId = carId;
	}
	public Image(String imgPath, int carId) {
		super();
		this.imgPath = imgPath;
		this.carId = carId;
	}
	public Image(int imgId, String imgPath) {
		super();
		this.imgId = imgId;
		this.imgPath = imgPath;
	}
	public int getImgId() {
		return imgId;
	}
	public void setImgId(int imgId) {
		this.imgId = imgId;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	@Override
	public String toString() {
		return "Image [imgId=" + imgId + ", imgPath=" + imgPath + ", carId=" + carId + "]";
	}
	
}
