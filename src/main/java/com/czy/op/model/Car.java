package com.czy.op.model;

import java.util.List;

public class Car {
    private int carId;
    private float carPrice;
    private String carBrand;
    private String carName;
    private String carLevel;
    private String carEngine;
    private String carIntake;
    private int carTorque;
    private String carFuelModel;
    private String carGearbox;
    private String carDriveMode;
    private int carLength;
    private int carWidth;
    private int carHeight;
    private int carWheelbase;
    private int carSpeed;
    private float carFuelConsumption;
    private String carWarranty;
    private int carlogo;
    //一对一
    private Image imgLogo;
    //一对多
    private List<Image> imgList;

    public Car() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Car(int carId, float carPrice, String carBrand, String carName, Image imgLogo) {
        super();
        this.carId = carId;
        this.carPrice = carPrice;
        this.carBrand = carBrand;
        this.carName = carName;
        this.imgLogo = imgLogo;
    }

    public Car(String carLevel, String carIntake, String carGearbox, String carDriveMode, String carWarranty) {
        super();
        this.carLevel = carLevel;
        this.carIntake = carIntake;
        this.carGearbox = carGearbox;
        this.carDriveMode = carDriveMode;
        this.carWarranty = carWarranty;
    }

    public Car(String carLevel, String carIntake, String carGearbox, String carDriveMode, int carLength, int carWidth) {
        super();
        this.carLevel = carLevel;
        this.carIntake = carIntake;
        this.carGearbox = carGearbox;
        this.carDriveMode = carDriveMode;
        this.carLength = carLength;
        this.carWidth = carWidth;
    }

    public Car(int carId, float carPrice, String carBrand, String carName, String carLevel, String carEngine,
               String carIntake, int carTorque, String carFuelModel, String carGearbox, String carDriveMode, int carLength,
               int carWidth, int carHeight, int carWheelbase, int carSpeed, float carFuelConsumption, String carWarranty,
               int carlogo, Image imgLogo) {
        super();
        this.carId = carId;
        this.carPrice = carPrice;
        this.carBrand = carBrand;
        this.carName = carName;
        this.carLevel = carLevel;
        this.carEngine = carEngine;
        this.carIntake = carIntake;
        this.carTorque = carTorque;
        this.carFuelModel = carFuelModel;
        this.carGearbox = carGearbox;
        this.carDriveMode = carDriveMode;
        this.carLength = carLength;
        this.carWidth = carWidth;
        this.carHeight = carHeight;
        this.carWheelbase = carWheelbase;
        this.carSpeed = carSpeed;
        this.carFuelConsumption = carFuelConsumption;
        this.carWarranty = carWarranty;
        this.carlogo = carlogo;
        this.imgLogo = imgLogo;
    }

    public Car(int carId, float carPrice, String carBrand, String carName, String carLevel, String carEngine,
               String carIntake, int carTorque, String carFuelModel, String carGearbox, String carDriveMode, int carLength,
               int carWidth, int carHeight, int carWheelbase, int carSpeed, float carFuelConsumption, String carWarranty,
               int carlogo, Image imgLogo, List<Image> imgList) {
        super();
        this.carId = carId;
        this.carPrice = carPrice;
        this.carBrand = carBrand;
        this.carName = carName;
        this.carLevel = carLevel;
        this.carEngine = carEngine;
        this.carIntake = carIntake;
        this.carTorque = carTorque;
        this.carFuelModel = carFuelModel;
        this.carGearbox = carGearbox;
        this.carDriveMode = carDriveMode;
        this.carLength = carLength;
        this.carWidth = carWidth;
        this.carHeight = carHeight;
        this.carWheelbase = carWheelbase;
        this.carSpeed = carSpeed;
        this.carFuelConsumption = carFuelConsumption;
        this.carWarranty = carWarranty;
        this.carlogo = carlogo;
        this.imgLogo = imgLogo;
        this.imgList = imgList;
    }

    @Override
    public String toString() {
        return "Car [carId=" + carId + ", carPrice=" + carPrice + ", carBrand=" + carBrand + ", carName=" + carName
                + ", carLevel=" + carLevel + ", carEngine=" + carEngine + ", carIntake=" + carIntake + ", carTorque="
                + carTorque + ", carFuelModel=" + carFuelModel + ", carGearbox=" + carGearbox + ", carDriveMode="
                + carDriveMode + ", carLength=" + carLength + ", carWidth=" + carWidth + ", carHeight=" + carHeight
                + ", carWheelbase=" + carWheelbase + ", carSpeed=" + carSpeed + ", carFuelConsumption="
                + carFuelConsumption + ", carWarranty=" + carWarranty + ", carlogo=" + carlogo + ", imgLogo=" + imgLogo
                + ", imgList=" + imgList + "]";
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public float getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(float carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarLevel() {
        return carLevel;
    }

    public void setCarLevel(String carLevel) {
        this.carLevel = carLevel;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

    public String getCarIntake() {
        return carIntake;
    }

    public void setCarIntake(String carIntake) {
        this.carIntake = carIntake;
    }

    public int getCarTorque() {
        return carTorque;
    }

    public void setCarTorque(int carTorque) {
        this.carTorque = carTorque;
    }

    public String getCarFuelModel() {
        return carFuelModel;
    }

    public void setCarFuelModel(String carFuelModel) {
        this.carFuelModel = carFuelModel;
    }

    public String getCarGearbox() {
        return carGearbox;
    }

    public void setCarGearbox(String carGearbox) {
        this.carGearbox = carGearbox;
    }

    public String getCarDriveMode() {
        return carDriveMode;
    }

    public void setCarDriveMode(String carDriveMode) {
        this.carDriveMode = carDriveMode;
    }

    public int getCarLength() {
        return carLength;
    }

    public void setCarLength(int carLength) {
        this.carLength = carLength;
    }

    public int getCarWidth() {
        return carWidth;
    }

    public void setCarWidth(int carWidth) {
        this.carWidth = carWidth;
    }

    public int getCarHeight() {
        return carHeight;
    }

    public void setCarHeight(int carHeight) {
        this.carHeight = carHeight;
    }

    public int getCarWheelbase() {
        return carWheelbase;
    }

    public void setCarWheelbase(int carWheelbase) {
        this.carWheelbase = carWheelbase;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }

    public float getCarFuelConsumption() {
        return carFuelConsumption;
    }

    public void setCarFuelConsumption(float carFuelConsumption) {
        this.carFuelConsumption = carFuelConsumption;
    }

    public String getCarWarranty() {
        return carWarranty;
    }

    public void setCarWarranty(String carWarranty) {
        this.carWarranty = carWarranty;
    }

    public int getCarlogo() {
        return carlogo;
    }

    public void setCarlogo(int carlogo) {
        this.carlogo = carlogo;
    }

    public Image getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(Image imgLogo) {
        this.imgLogo = imgLogo;
    }

    public List<Image> getImgList() {
        return imgList;
    }

    public void setImgList(List<Image> imgList) {
        this.imgList = imgList;
    }


}
