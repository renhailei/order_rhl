package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.entity.po.Order;
import com.fh.entity.vo.OrderStr;
import com.fh.entity.vo.TableSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao extends BaseMapper<Order> {

    long queryCount();

    List<OrderStr> queryOrderList(TableSearch search);

    void addOrder(Order order);

    void updateIsdel(Integer id);

    OrderStr queryOrderByIdList(Integer id);

    void updateOrder(Order order);


}
