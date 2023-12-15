package com.ra.service;
import com.ra.dto.requestDto.RequestOrderDetail;
import com.ra.dto.responseDto.ResponseOrderDetail;
import com.ra.entity.OrderDetail;
import com.ra.entity.Orders;
import com.ra.entity.Product;
import com.ra.exception.CustomException;
import com.ra.repository.IOrderDetailRepository;
import com.ra.repository.IOrderRepository;
import com.ra.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    IOrderDetailRepository orderDetailRepository;
    @Autowired
    IOrderRepository orderRepository;
    @Autowired
    IProductRepository productRepository;

    @Override
    public OrderDetail saveOrderDetailById(Integer idOrder, RequestOrderDetail requestOrderDetail) throws CustomException {
        Orders orders = orderRepository.findById(idOrder).get() ;
        if (orders != null ) {
            Product product = productRepository.findById(requestOrderDetail.getProduct_id()).get();
            OrderDetail orderDetail = OrderDetail.builder()
                    .orders(orders)
                    .product(product)
                    .price(requestOrderDetail.getPrice())
                    .quantity(requestOrderDetail.getQuantity())
                    .build();
            return orderDetailRepository.save(orderDetail) ;
        }
        throw new CustomException("Khong ton tai gio hang cua nguoi dung");
    }

    @Override
    public List<ResponseOrderDetail> findAllByOrderId(Integer orderId) throws CustomException {
        List<OrderDetail> orderDetails = orderDetailRepository.findOrderDetailByOrderId(orderId);
        if (orderDetails != null && !orderDetails.isEmpty()) {
            return orderDetails.stream()
                    .map(orderDetail -> ResponseOrderDetail.builder()
                            .orderDetail_id(orderDetail.getOrderDetail_id())
                            .quantity(orderDetail.getQuantity())
                            .price(orderDetail.getPrice())
                            .order_id(orderDetail.getOrders().getOrder_id())
                            .userName(orderDetail.getOrders().getUser().getUser_name())
                            .product(orderDetail.getProduct())
                            .build())
                            .collect(Collectors.toList());
        }
        throw new CustomException("Khong ton don hang chi tiet");
    }


}
