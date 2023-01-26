package com.noriton.team9.service;

import com.noriton.team9.domain.Designer;
import com.noriton.team9.domain.Item;
import com.noriton.team9.domain.Member;
import com.noriton.team9.domain.Sample;
import com.noriton.team9.repository.DesignerRepository;
import com.noriton.team9.repository.SampleRepository;
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


    public List<Designer> readDesigners(){
        return designerRepository.findAll();
    }

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

    public Designer login(String loginId, String password){
        List<Designer> getDesigners = designerRepository.findByLoginId(loginId);
        if(getDesigners.size() == 0) return new Designer();
        int flag = 0;   // 비밀번호가 일치한 member가 없는 경우
        int designerIdx=0;
        for(int i=0; i<getDesigners.size(); i++){
            if(getDesigners.get(i).getPassword().compareTo(password) == 0) {
                flag = 1;
                designerIdx = i;
                break;
            }
        }

        if(flag == 0) return new Designer();
        return getDesigners.get(designerIdx);
    }
}
