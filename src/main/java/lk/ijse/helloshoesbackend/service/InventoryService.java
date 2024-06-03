package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.dto.ItemDTO;

import java.util.List;

public interface InventoryService {

    ItemDTO getItem(String id);

    List<ItemDTO> getAllItems();

    void updateItem(String itemDesc, String pic,String id);

    void deleteItem(String id);

    void saveItem(ItemDTO itemDTO);
}
