package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.ItemDTO;
import lk.ijse.helloshoesbackend.entity.ItemEntity;
import lk.ijse.helloshoesbackend.exception.NotFoundException;
import lk.ijse.helloshoesbackend.repository.InventoryDao;
import lk.ijse.helloshoesbackend.service.InventoryService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private final Mapping mapping;
    @Autowired
    private final InventoryDao inventoryDao;
    @Override
    public void saveInventory(ItemDTO itemDTO) {
        itemDTO.setItem_code(generateItemCode(itemDTO));
        inventoryDao.save(mapping.toItemEntity(itemDTO));
    }

    @Override
    public ItemDTO getItem(String id) {
        Optional<ItemEntity> item = inventoryDao.findById(id);
        if(item.isEmpty()) throw new NotFoundException("Item not found");
        return mapping.toItemDTO(Optional.of(item.get()));
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return mapping.toItemDTOList(inventoryDao.findAll());
    }

    @Override
    public void updateItem(String id, ItemDTO itemDTO) {
        if(!inventoryDao.existsById(id)) throw new NotFoundException("Item Not found");
        inventoryDao.save(mapping.toItemEntity(itemDTO));
    }

    @Override
    public void deleteItem(String id) {
        inventoryDao.deleteById(id);
    }

    private String generateItemCode(ItemDTO itemDTO) {
        StringBuilder prefixBuilder = new StringBuilder();
        if (itemDTO.getGender_code() != null) {
            prefixBuilder.append(itemDTO.getGender_code());
        }
        if (itemDTO.getOccasionCode() != null) {
            prefixBuilder.append(itemDTO.getOccasionCode());
        }
        if (itemDTO.getVarietyCode() != null) {
            prefixBuilder.append(itemDTO.getVarietyCode());
        }
        String prefix = prefixBuilder.toString();

        String lastItemCodeStartingWithPrefix =
                inventoryDao.findLastItemCodeStartingWithPrefix(prefix);

        return (lastItemCodeStartingWithPrefix != null)
                ? String.format("%s%05d", prefix, Integer.parseInt(lastItemCodeStartingWithPrefix.replace(prefix, "")) + 1)
                : prefix + "00001";
    }
}
