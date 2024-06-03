package lk.ijse.helloshoesbackend.service.iml;

import jakarta.transaction.Transactional;
import lk.ijse.helloshoesbackend.dto.ItemDTO;
import lk.ijse.helloshoesbackend.entity.GenderEntity;
import lk.ijse.helloshoesbackend.entity.ItemEntity;
import lk.ijse.helloshoesbackend.entity.OccasionEntity;
import lk.ijse.helloshoesbackend.entity.VarietyEntity;
import lk.ijse.helloshoesbackend.exception.NotFoundException;
import lk.ijse.helloshoesbackend.repository.GenderDao;
import lk.ijse.helloshoesbackend.repository.InventoryDao;
import lk.ijse.helloshoesbackend.repository.OccasionDao;
import lk.ijse.helloshoesbackend.repository.VarietyDao;
import lk.ijse.helloshoesbackend.service.InventoryService;
import lk.ijse.helloshoesbackend.util.Mapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private final Mapping mapping;
    @Autowired
    private final InventoryDao inventoryDao;
    private final GenderDao genderServiceDao;
    private final OccasionDao occasionServiceDao;
    private final VarietyDao varietyServiceDao;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity itemEntity = mapping.toItemEntity(itemDTO);
        itemEntity.setItemCode(generateItemCode(itemDTO));
        Optional<GenderEntity> genderEntity = genderServiceDao.findById(itemDTO.getGenderCode());
        if (genderEntity.isPresent()){
            GenderEntity genderEntity1 = genderEntity.get();
            itemEntity.setGenderEntity(genderEntity1);
        };
        Optional<OccasionEntity> occasionEntity = occasionServiceDao.findById(itemDTO.getOccasionCode());
        if (occasionEntity.isPresent()){
            OccasionEntity occasionEntity1 = occasionEntity.get();
            itemEntity.setOccasionEntity(occasionEntity1);
        }
        Optional<VarietyEntity> varietyEntity = varietyServiceDao.findById(itemDTO.getVarietyCode());
        if (varietyEntity.isPresent()){
            VarietyEntity varietyEntity1 = varietyEntity.get();
            itemEntity.setVarietyEntity(varietyEntity1);
        }
        inventoryDao.save(itemEntity);
    }

    @Override
    public ItemDTO getItem(String id) {
        if(!inventoryDao.existsById(id)){throw new NotFoundException("Item not found.");}
        return mapping.toItemDTO(inventoryDao.findById(id));
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapping.toItemDTOList(inventoryDao.findAll());
    }

    @Override
    public void updateItem(String itemDesc, String pic, String id) {
        System.out.println(id);
        Optional<ItemEntity> itemEntityOptional = inventoryDao.findById(id);
        System.out.println(itemEntityOptional);
        if (itemEntityOptional.isEmpty()) {
            throw new NotFoundException("Item not found.");
        }

        ItemEntity itemEntity = itemEntityOptional.get();
        itemEntity.setItemDesc(itemDesc);
        itemEntity.setPic(pic);

        inventoryDao.save(itemEntity);
    }

    @Override
    public void deleteItem(String id) {
        if(!inventoryDao.existsById(id)){throw new NotFoundException("Item not found.");}
        inventoryDao.deleteById(id);
    }
    private String generateItemCode(ItemDTO itemDTO) {

        StringBuilder prefixBuilder = new StringBuilder();

        if (!itemDTO.getVarietyCode().equals("-1")) {
            prefixBuilder.append(itemDTO.getVarietyCode());
        }
        if (!itemDTO.getOccasionCode().equals("-1")) {
            prefixBuilder.append(itemDTO.getOccasionCode());
        }
        if (!itemDTO.getGenderCode().equals("-1")) {
            prefixBuilder.append(itemDTO.getGenderCode());
        }

        String prefix = prefixBuilder.toString();

        String lastItemCodeStartingWithPrefix =
                inventoryDao.findLastItemCodeStartingWithPrefix(
                        prefix
                );

        return (lastItemCodeStartingWithPrefix != null)
                ? String.format("%s%05d", prefix, Integer.parseInt(lastItemCodeStartingWithPrefix.replace(prefix, "")) + 1)
                : prefix + "00001";
    }
}
