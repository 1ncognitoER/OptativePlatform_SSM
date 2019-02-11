package com.czy.op.serviceImpl;

import java.util.LinkedList;
import java.util.List;

import com.czy.op.model.Car;
import com.czy.op.dao.CarDao;
import com.czy.op.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("carService")
public class CarServiceImpl implements CarService {
	/*属性*/
	@Resource
	private CarDao carDao;

	/**
	 * 查询所有车辆信息
	 * @return
	 */
	public List<Car> selectAllCar() {
		return carDao.selectAllCar();
	}

	/**
	 * 根据条件查询
	 * @param car
	 * @return
	 */
	public List<Car> selectCar(Car car) {
		String priceStr = car.getCarWarranty();// 获取存放在carWarranty变量中的数据
		int priceMin = 0;
		int priceMax = 0;
		switch (priceStr) {
		case "〈10W":
			priceMin = 0;
			priceMax = 10;
			break;
		case "10W-20W":
			priceMin = 10;
			priceMax = 20;
			break;
		case "20W-30W":
			priceMin = 20;
			priceMax = 30;
			break;
		case "30W-50W":
			priceMin = 30;
			priceMax = 50;
			break;
		case "50W-100W":
			priceMin = 50;
			priceMax = 100;
			break;
		case "〉100W":
			priceMin = 100;
			priceMax = 9999;
			break;
		default:
			priceMin = -1;
			priceMax = -1;
			break;
		}
		Car carInf = new Car(car.getCarLevel(), car.getCarIntake(), car.getCarGearbox(), car.getCarDriveMode(), priceMin, priceMax);
		return carDao.selectCar(carInf);
	}

	/**
	 * 搜索功能
	 * @param lowerCarName
	 * @return
	 */
	public List<Car> searchCar(String lowerCarName){
		List<Car> carInf = carDao.searchAllCarName();// 查询所有车辆的名称和id
		List carIdList = new LinkedList();// 用以保存匹配的id
		carIdList.clear();// 清空集合
		for (Car car:carInf) {
			if(car.getCarName().toLowerCase().contains(lowerCarName)){// 统一转化为小写来匹配
				carIdList.add(car.getCarId());// 如果名称匹配，记录id号
			}
		}
		return carDao.searchCarByMuchID(carIdList);// 根据匹配的id集合查询信息
//		if (carIdList.size() != 0){
//			System.out.println("not null");
//			return carDao.searchCarByMuchID(carIdList);// 根据匹配的id集合查询信息
//		} else {
//			System.out.println("null");
//			return null;// 没有匹配返回空
//		}
	}

//	/**
//	 * 根据名称查询车辆信息
//	 * @param car
//	 * @return
//	 */
//	public List<Car> searchCar(Car car) {
//		return carDao.searchCar(car);
//	}

	/**
	 * 根据车辆id查询
	 * @param car
	 * @return
	 */
	public Car selectCarById(Car car) {
		return carDao.selectCarById(car);
	}

	/**
	 * 查询所有车辆平牌
	 * @return
	 */
	public List<Car> selectAllBrand() {
		return carDao.selectAllBrand();
	}

	/**
	 * 根据品牌查询
	 * @param car
	 * @return
	 */
	public List<Car> selectCarNameByBrand(Car car) {
		return carDao.selectCarNameByBrand(car);
	}

	/**
	 * 根据查询车辆id查询图片信息及部分汽车配置参数
	 * @param car
	 * @return
	 */
	public List<Car> searchCarImagesDetail(Car car) {
		return carDao.searchCarImagesDetail(car);
	}
	
}
