package com.noriton.team9.controller;

import com.noriton.team9.request.LikeRequest;
import com.noriton.team9.request.SampleCreationRequest;
import com.noriton.team9.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    // 샘플 part
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



    //좋아요 part
    @PostMapping("/sample/like")
    public ResponseEntity likeSample(@RequestBody LikeRequest request){
        return ResponseEntity.ok(sampleService.likeSample(request));
    }

    @PostMapping("/sample/unlike")
    public ResponseEntity unlikeSample(@RequestBody LikeRequest request){
        return ResponseEntity.ok(sampleService.unlikeSample(request));
    }

//    @GetMapping("/sample/desc")
//    public ResponseEntity readSamplesByLike(){
//        return ResponseEntity.ok(sampleService.readSamplesByLike());
//    }

    /**
     * 이미 좋아요 누른 샘플 받아오기
     * */
    @GetMapping("/sample/alreadyLiked/{memberId}")
    public ResponseEntity alreadyLiked(@PathVariable Long memberId){
        return ResponseEntity.ok(sampleService.alreadyLiked(memberId));
    }

}
