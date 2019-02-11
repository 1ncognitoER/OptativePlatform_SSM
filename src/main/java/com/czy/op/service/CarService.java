package com.czy.op.service;

import java.util.List;

import com.czy.op.model.Car;

public interface CarService {
	/**
	 * 查询所有车辆信息
	 * @return
	 */
	public List<Car> selectAllCar();

	/**
	 * 根据条件查询
	 * @param car
	 * @return
	 */
	public List<Car> selectCar(Car car);

	/**
	 * 搜索功能
	 * @param lowerCarName
	 * @return
	 */
	public List<Car> searchCar(String lowerCarName);

//	/**
//	 * 根据名称查询车辆信息
//	 * @param car
//	 * @return
//	 */
//	public List<Car> searchCar(Car car);

	/**
	 * 根据id查询车辆详细信息
	 * @param car
	 * @return
	 */
	public Car selectCarById(Car car);

	/**
	 * 查询所有车辆品牌
	 * @return
	 */
	public List<Car> selectAllBrand();

	/**
	 * 根据品牌查询该品牌所有车辆名称
	 * @param car
	 * @return
	 */
	public List<Car> selectCarNameByBrand(Car car);

	/**
	 * 根据查询车辆id查询图片信息及部分汽车配置参数
	 * @param car
	 * @return
	 */
	public List<Car> searchCarImagesDetail(Car car);
	
	
}
