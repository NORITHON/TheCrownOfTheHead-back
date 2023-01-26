package com.noriton.team9.service;

import com.noriton.team9.domain.Sample;
import com.noriton.team9.repository.SampleRepository;
import com.noriton.team9.request.SampleCreationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SampleService {
    public final SampleRepository sampleRepository;

    public List<Sample> readSamples(){
        return sampleRepository.findAll();
    }

    public Sample readSample(Long sampleId){
        Optional<Sample> sample = sampleRepository.findById(sampleId);
        System.out.println("111");
        if(sample.isPresent()) {
            return sample.get();
        }

        throw new EntityNotFoundException("Can't find any sample under given ID");
    }

    public Sample createSample(SampleCreationRequest sample){
        Sample sampleToCreate = new Sample();
        BeanUtils.copyProperties(sample, sampleToCreate);
        return sampleRepository.save(sampleToCreate);
    }
}
