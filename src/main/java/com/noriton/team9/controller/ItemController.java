package com.noriton.team9.controller;

import com.noriton.team9.request.ItemCreationRequest;
import com.noriton.team9.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/item")
    public ResponseEntity readItems(){
        return ResponseEntity.ok(itemService.readItems());
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity readItem(@PathVariable Long itemId){
        return ResponseEntity.ok(itemService.readItem(itemId));
    }

    @PostMapping("/item")
    public ResponseEntity createItem(@RequestBody ItemCreationRequest request){
        return ResponseEntity.ok(itemService.createItem(request));
    }
}
