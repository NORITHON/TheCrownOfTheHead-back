package com.noriton.team9.service;

import com.noriton.team9.domain.Item;
import com.noriton.team9.repository.ItemRepository;
import com.noriton.team9.request.ItemCreationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    public final ItemRepository itemRepository;

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

    public Item createItem(ItemCreationRequest item){
        Item itemToCreate = new Item();
        BeanUtils.copyProperties(item, itemToCreate);
        return itemRepository.save(itemToCreate);
    }
}
