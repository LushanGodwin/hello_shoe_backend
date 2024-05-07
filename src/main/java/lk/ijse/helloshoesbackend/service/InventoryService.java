package lk.ijse.helloshoesbackend.service;

import lk.ijse.helloshoesbackend.dto.ItemDTO;

import java.util.List;

public interface InventoryService {
    void saveInventory(ItemDTO itemDTO);

    ItemDTO getItem(String id);

    List<ItemDTO> getAllItem();

    void updateItem(String id, ItemDTO itemDTO);

    void deleteItem(String id);
}
