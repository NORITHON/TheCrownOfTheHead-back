package com.noriton.team9.controller;

import com.noriton.team9.request.LikeRequest;
import com.noriton.team9.request.SampleCreationRequest;
import com.noriton.team9.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/sample")
    public ResponseEntity readSamples(){
        return ResponseEntity.ok(sampleService.readSamples());
    }

    @GetMapping("/sample/{sampleId}")
    public ResponseEntity readSample(@PathVariable Long sampleId){
        return ResponseEntity.ok(sampleService.readSample(sampleId));
    }

    @PostMapping("/sample")
    public ResponseEntity createSample(@RequestBody SampleCreationRequest request){
        return ResponseEntity.ok(sampleService.createSample(request));
    }

    @PostMapping("/sample/like")
    public ResponseEntity likeSample(@RequestBody LikeRequest request){
        return ResponseEntity.ok(sampleService.likeSample(request));
    }

    @PostMapping("/sample/unlike")
    public ResponseEntity unlikeSample(@RequestBody LikeRequest request){
        return ResponseEntity.ok(sampleService.unlikeSample(request));
    }

    @GetMapping("/sample/desc")
    public ResponseEntity readSamplesByLike(){
        return ResponseEntity.ok(sampleService.readSamplesByLike());
    }

}
