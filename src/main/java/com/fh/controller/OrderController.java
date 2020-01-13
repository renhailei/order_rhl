package com.fh.controller;

import com.fh.entity.po.Order;
import com.fh.entity.po.Product;
import com.fh.entity.vo.DataTablesData;
import com.fh.entity.vo.OrderStr;
import com.fh.entity.vo.TableSearch;
import com.fh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("order")
@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("queryOrderList")
    public DataTablesData queryOrderList(TableSearch search){
        DataTablesData data = orderService.queryOrderList(search);
        return data;
    }

    @RequestMapping("queryProductList")
    public Map queryProductList(){
        Map map = new HashMap();
        try {
            List<Product> product = orderService.queryProductList();
            map.put("code",200);
            map.put("data",product);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",201);
            map.put("remark",e.getMessage());
        }
        return map;
    }

    @PostMapping("queryProductById")
    public Map queryProductById(Integer id){
        Map map = new HashMap();
        try {
            List<Product> product = orderService.queryProductById(id);
            map.put("code", "200");
            map.put("data", product);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "201");
            map.put("remark", e.getMessage());
        }
        return map;
    }

    @RequestMapping("addOrder")
    public Map addOrder(Order order){
        Map map = new HashMap();
        try {
            orderService.addOrder(order);
            map.put("code",200);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",201);
            map.put("remark",e.getMessage());
        }
        return map;
    }

    @PostMapping("updateIsdel")
    public Map updateIsdel(Integer id){
        Map map = new HashMap();
        try {
            orderService.updateIsdel(id);
            map.put("code", "200");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "201");
            map.put("remark", e.getMessage());
        }
        return map;
    }

    @PostMapping("queryOrderByIdList")
    public Map queryOrderByIdList(Integer id){
        Map map = new HashMap();
        try {
            OrderStr order = orderService.queryOrderByIdList(id);
            map.put("code", "200");
            map.put("data", order);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "201");
            map.put("remark", e.getMessage());
        }
        return map;
    }

    @PostMapping("updateOrder")
    public Map updateOrder(Order order){
        Map map = new HashMap();
        try {
            orderService.updateOrder(order);
            map.put("code", "200");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "201");
            map.put("remark", e.getMessage());
        }
        return map;
    }
}
