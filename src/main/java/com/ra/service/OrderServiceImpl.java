package com.ra.service;

import com.ra.dto.responseDto.ResponseOrder;
import com.ra.entity.Orders;
import com.ra.entity.User;
import com.ra.exception.CustomException;
import com.ra.repository.IOrderRepository;
import com.ra.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrderRepository orderRepository;
    @Autowired
    IUserRepository userRepository;

    @Override
    public List<ResponseOrder> findAll() {
        List<ResponseOrder> list = orderRepository.findAll().stream().map(item -> ResponseOrder.builder()
                        .recipient_name(item.getUser().getUserName())
                        .note(item.getNote())
                        .status(item.getStatus())
                        .create_date(item.getCreate_date())
                        .phone(item.getPhone())
                        .address(item.getAddress())
                        .order_id(item.getOrder_id())
                        .build())
                         .toList();

        return list;
    }


    @Override
    public Orders save(Integer idUser, ResponseOrder requestOrder) throws CustomException {
        Optional<User> optionalUsers = userRepository.findById(idUser);
        if (optionalUsers.isPresent()) {
            User user = optionalUsers.get();
            Orders orders = Orders.builder().user(user)
                    .note(requestOrder.getNote())
                    .recipient_name(user.getUserName())
                    .create_date(requestOrder.getCreate_date())
                    .phone(requestOrder.getPhone())
                    .address(requestOrder.getAddress())
                    .status(1)
                    .build();
            return orderRepository.save(orders);
        }
        throw new CustomException("user not found");
    }

    @Override
    public ResponseOrder findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
