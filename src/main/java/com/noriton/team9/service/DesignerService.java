package com.noriton.team9.service;

import com.noriton.team9.domain.Designer;
import com.noriton.team9.repository.DesignerRepository;
import com.noriton.team9.request.DesignerCreationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DesignerService {

    private final DesignerRepository designerRepository;

    public Designer readDesigner(Long designerId) {
        Optional<Designer> designer = designerRepository.findById(designerId);

        if(designer.isPresent()){
            return designer.get();
        }

        throw new EntityNotFoundException("Can't find any Designer under given ID");
    }

    public Designer createDesigner(DesignerCreationRequest designer){
        Designer designerToCreate = new Designer();
        BeanUtils.copyProperties(designer,designerToCreate);
        return designerRepository.save(designerToCreate);
    }
}
