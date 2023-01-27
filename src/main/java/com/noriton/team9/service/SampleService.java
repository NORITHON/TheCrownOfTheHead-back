package com.noriton.team9.service;

import com.noriton.team9.domain.*;
import com.noriton.team9.repository.DesignerRepository;
import com.noriton.team9.repository.MemberRepository;
import com.noriton.team9.repository.SampleLikeRepository;
import com.noriton.team9.repository.SampleRepository;
import com.noriton.team9.request.LikeRequest;
import com.noriton.team9.request.SampleCreationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SampleService {
    public final SampleRepository sampleRepository;
    public final DesignerRepository designerRepository;
    public final MemberRepository memberRepository;
    private final SampleLikeRepository sampleLikeRepository;

    public List<Sample> readSamples(){
        return sampleRepository.findAll();
    }

    public Sample readSample(Long sampleId){
        Optional<Sample> sample = sampleRepository.findById(sampleId);
        if(sample.isPresent()) {
            return sample.get();
        }

        throw new EntityNotFoundException("Can't find any sample under given ID");
    }

    public Sample createSample(SampleCreationRequest sample){
        Optional<Designer> designer = designerRepository.findById(sample.getDesignerId());
        System.out.println(sample.getDesignerId());
        if(!designer.isPresent()){
            throw new EntityNotFoundException("Designer not found");
        }

        Sample sampleToCreate = new Sample();
        BeanUtils.copyProperties(sample, sampleToCreate);
        sampleToCreate.settingDesigner(designer.get());
//        sampleToCreate.setLikeCount(0);
        return sampleRepository.save(sampleToCreate);
    }

    /**
     * 샘플 삭제 -> 디자이너가 샘플 등록 취소
     * */
    @Transactional
    public void deleteSample(Long sampleId){
        sampleRepository.deleteById(sampleId);
    }

    /**
     * 샘플 좋아요 누르기
     * */
    @Transactional
    public Sample likeSample(LikeRequest request) {
        Sample sample;
        List<SampleLike> sl = sampleLikeRepository.findbySampleAndMember(request.getSampleId(),request.getMemberId());
        if(sl.size() > 0) {
            sl.get(0).setStatus(LikeStatus.LIKE);
            Optional<Sample> getSample = sampleRepository.findById(request.getSampleId());
            Sample s = getSample.get();

            s.setLikeCount(s.getLikeCount() + 1);
            sample = s;
        }
        else{
            Member member = memberRepository.findOne(request.getMemberId());
            Optional<Sample> getSample = sampleRepository.findById(request.getSampleId());
            Sample s = getSample.get();

//        sample.getLikedMembers().add(member);
//        sample.setLikeCount(sample.getLikeCount() + 1);
//        member.getLikedSamples().add(sample);
//        memberRepository.save(member);
            SampleLike sampleLike = new SampleLike();
            sampleLike.setMember(member);
            sampleLike.setSample(s);
            sampleLike.setStatus(LikeStatus.LIKE);
            sampleLikeRepository.save(sampleLike);

            List<SampleLike>  likeList = sampleLikeRepository.findBySampleId(request.getSampleId());
            s.setLikeCount(likeList.size());
            sample = s;
        }

        return sample;
    }

    @Transactional
    public Sample unlikeSample(LikeRequest request) {
        Optional<Sample> getSample = sampleRepository.findById(request.getSampleId());
        Sample sample = getSample.get();

        List<SampleLike>  likeList = sampleLikeRepository.findBySampleId(request.getSampleId());
        sample.setLikeCount(likeList.size());

//        sampleLikeRepository.deleteOne(request.getSampleId(), request.getMemberId());
        List<SampleLike> sampleLike = sampleLikeRepository.findbySampleAndMember(request.getSampleId(),request.getMemberId());
        sampleLike.get(0).setStatus(LikeStatus.UNLIKE);
        sampleLikeRepository.save(sampleLike.get(0));
        sample.setLikeCount(sample.getLikeCount() - 1);
        return sample;
    }

    public List<Sample> readSamplesByLike() {
        List<Sample> list = sampleRepository.findAll();
//        Collections.sort(list);
        return list;
    }
}
