package com.noriton.team9.controller;

import com.noriton.team9.request.ItemCreationRequest;
import com.noriton.team9.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    /**
     * 아직승인되지 않은 아이템 불러오기 - 관리자 페이지
     * */
    @GetMapping("/item/waiting")
    public ResponseEntity readWaitingItems(){
        return ResponseEntity.ok(itemService.readWaitingItem());
    }

    /**
     * 승인 대기중인 아이템 불러오기 by memberId - 마이페이지
     * */
    @PostMapping("/item/myPage/{memberId}")
    public ResponseEntity readWaitingItemsByMemberId(@PathVariable Long memberId){
        return ResponseEntity.ok(itemService.readWaitingItemsByMemberId(memberId));
    }
}
