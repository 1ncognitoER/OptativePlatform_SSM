package com.czy.op.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.czy.op.model.Car;
import com.czy.op.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*@Controller是springMVC的注解*/
@Controller
public class CarContorllor {
    /* 属性 */
    /* @Resource注解 实现service的自动填充 */
    @Resource
    private CarService carService;

    /**
     * 查询所有车辆信息
     * @return
     */
    @RequestMapping("selectAllCar")
    @ResponseBody
    public Object selectAllCar() {
        return carService.selectAllCar();
    }

    /**
     * 根据条件查询
     * @param request
     * @return
     */
    @RequestMapping("selectCar")
    @ResponseBody
    public Object selectCar(HttpServletRequest request) {
        String level = request.getParameter("level");
        String intake = request.getParameter("intake");
        String gearbox = request.getParameter("gearbox");
        String driveMode = request.getParameter("driveMode");
        String priceStr = request.getParameter("price");
        Car carInf = new Car(level, intake, gearbox, driveMode, priceStr);
        return carService.selectCar(carInf);
    }

    /**
     * 根据名称查询车辆信息
     * @param carName
     * @return
     */
    @RequestMapping("searchCar")
    @ResponseBody
    public Object searchCar(String carName) {
//        Car car = new Car(0, 0, null, carName, null);
//        return carService.searchCar(car);
		String lowerCarName = carName.toLowerCase();//将名称都搜索条件转化为小写字母
		return carService.searchCar(lowerCarName);
    }

    /**
     * 查询车辆详细信息
     * @param carId
     * @param request
     * @return
     */
    @RequestMapping("selectCarById")
    public String selectCarById(String carId, HttpServletRequest request) {
        int carid = Integer.parseInt(carId);
        Car car = new Car(carid, 0, null, null, null);
        Car carDetail = carService.selectCarById(car);
        request.setAttribute("carDetail", carDetail);
        return "detail";
    }

    /**
     * 查询所有车辆的品牌
     * @return
     */
    @RequestMapping("selectAllBrand")
    @ResponseBody
    public Object selectAllBrand() {
        return carService.selectAllBrand();
    }

    /**
     * 根据品牌查询该品牌所有车辆名称
     * @param brand
     * @return
     */
    @RequestMapping("selectCarNameByBrand")
    @ResponseBody
    public Object selectCarNameByBrand(String brand) {
        Car car = new Car(0, 0, brand, null, null);
        return carService.selectCarNameByBrand(car);
    }

    /**
     * 查询车辆详细信息
     * @param carid
     * @return
     */
    @RequestMapping("addToCompare")
    @ResponseBody
    public Object addToCompare(String carid) {
        int carId = Integer.parseInt(carid);
        Car car = new Car(carId, 0, null, null, null);
        return carService.selectCarById(car);
    }

    /**
     * 根据查询车辆id查询图片信息及部分汽车配置参数
     * @param carid
     * @return
     */
    @RequestMapping("searchCarImagesDetail")
    @ResponseBody
    public Object searchCarImagesDetail(String carid) {
        int carId = Integer.parseInt(carid);
        Car car = new Car(carId, 0, null, null, null);
        System.out.println(carService.searchCarImagesDetail(car));
        return carService.searchCarImagesDetail(car);
    }

}
