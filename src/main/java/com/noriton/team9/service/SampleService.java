package com.noriton.team9.service;

import com.noriton.team9.domain.Designer;
import com.noriton.team9.domain.Sample;
import com.noriton.team9.repository.DesignerRepository;
import com.noriton.team9.repository.SampleRepository;
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
        return sampleRepository.save(sampleToCreate);
    }

    /**
     * 샘플 삭제 -> 디자이너가 샘플 등록 취소
     * */
    @Transactional
    public void deleteSample(Long sampleId){
        sampleRepository.deleteById(sampleId);
    }
}
