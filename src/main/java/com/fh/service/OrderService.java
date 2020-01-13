package com.fh.service;

import com.fh.entity.po.Order;
import com.fh.entity.po.Product;
import com.fh.entity.vo.DataTablesData;
import com.fh.entity.vo.OrderStr;
import com.fh.entity.vo.TableSearch;

import java.util.List;

public interface OrderService {
    DataTablesData queryOrderList(TableSearch search);

    List<Product> queryProductList();

    List<Product> queryProductById(Integer id);

    void addOrder(Order order);

    void updateIsdel(Integer id);

    OrderStr queryOrderByIdList(Integer id);

    void updateOrder(Order order);
}
