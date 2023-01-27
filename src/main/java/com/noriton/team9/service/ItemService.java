package com.noriton.team9.service;

import com.noriton.team9.domain.Item;
import com.noriton.team9.domain.Orders;
import com.noriton.team9.domain.Sample;
import com.noriton.team9.repository.ItemRepository;
import com.noriton.team9.repository.SampleRepository;
import com.noriton.team9.request.ItemCreationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    public final ItemRepository itemRepository;
    public final SampleRepository sampleRepository;

    public List<Item> readItems(){
        return itemRepository.findAll();
    }

    public Item readItem(Long itemId){
        Optional<Item> item = itemRepository.findById(itemId);
        if(item.isPresent()){
            return item.get();
        }

        throw new EntityNotFoundException("Can't find any item under given ID");
    }

    public Item createItem(ItemCreationRequest item) {
        Optional<Sample> sample = sampleRepository.findById(item.getSampleId());
        if (!sample.isPresent()) {
            throw new EntityNotFoundException("Sample Not Found");
        }
        Item itemToCreate = new Item();
        BeanUtils.copyProperties(item, itemToCreate);

        //가격 측정
        int totalCost = (item.getLaborCost() + item.getMaterialCost() + item.getCirculationCost()) * 2;
        itemToCreate.setPrice(totalCost);
        itemToCreate.setCount(0);
        itemToCreate.setSample(sample.get());
        return itemRepository.save(itemToCreate);
    }

    /**
     * 아이템 삭제 -> 관리자가 상품 등록 취소
     * */
    @Transactional
    public void deleteItem(Long itemId){
        itemRepository.deleteById(itemId);
    }

    /**
     * 아이템 수정 -> 관리자가 상품 수정
     * */
    @Transactional
    public Item updateItem(Long itemId, ItemCreationRequest request){
        Optional<Item> getItem = itemRepository.findById(itemId);
        if(!getItem.isPresent()){
            throw new EntityNotFoundException("Item is not present in the database");
        }
        Item item = getItem.get();
        item.setName(request.getName());

        //가격 측정
        int totalPrice = (request.getLaborCost() + request.getMaterialCost() + request.getCirculationCost()) * 2;
        item.setPrice(totalPrice);
        item.setStockQuantity(request.getStockQuantity());
        Optional<Sample> getSample = sampleRepository.findById(request.getSampleId());
        if(getSample.isPresent()){
            item.setSample(getSample.get());
        }
        else{
            throw new EntityNotFoundException("Sample is not found in the database");
        }
        return itemRepository.save(item);
    }

}
