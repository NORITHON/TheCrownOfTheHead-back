package com.noriton.team9.controller;

import com.noriton.team9.request.DesignerCreationRequest;
import com.noriton.team9.service.DesignerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
@RequiredArgsConstructor
public class DesignerController {

    private final DesignerService designerService;

    @GetMapping("/designer/{designerId}")
    public ResponseEntity readDesigner(@PathVariable Long designerId){
        return ResponseEntity.ok(designerService.readDesigner(designerId));
    }

    @PostMapping("/designer")
    public ResponseEntity createDesigner(@RequestBody DesignerCreationRequest request){
        return ResponseEntity.ok(designerService.createDesigner(request));
    }
}
