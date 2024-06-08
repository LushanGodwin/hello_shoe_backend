package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.dto.OrderDTO;

public interface SaleService {
    String getNextOrderId();

    void saveOrder(OrderDTO orderDTO);
}
