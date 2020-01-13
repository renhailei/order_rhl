package com.fh.service.impl;

import com.fh.dao.OrderDao;
import com.fh.dao.ProductDao;
import com.fh.entity.po.Order;
import com.fh.entity.po.Product;
import com.fh.entity.vo.DataTablesData;
import com.fh.entity.vo.OrderStr;
import com.fh.entity.vo.TableSearch;
import com.fh.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private ProductDao productDao;

    @Override
    public DataTablesData queryOrderList(TableSearch search) {
        long count = orderDao.queryCount();
        List<OrderStr> order = orderDao.queryOrderList(search);
        DataTablesData data = new DataTablesData();
        data.setData(order);
        data.setDraw(search.getDraw());
        data.setRecordsFiltered((int)count);
        data.setRecordsTotal((int)count);
        return data;
    }

    @Override
    public List<Product> queryProductList() {
        return productDao.queryProductList();
    }

    @Override
    public void addOrder(Order order) {
        order.setIsDel(0);
        orderDao.addOrder(order);
    }

    @Override
    public List<Product> queryProductById(Integer id) {
        return productDao.queryProductById(id);
    }

    @Override
    public void updateIsdel(Integer id) {
        orderDao.updateIsdel(id);
    }

    @Override
    public OrderStr queryOrderByIdList(Integer id) {
        return orderDao.queryOrderByIdList(id);
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }
}
