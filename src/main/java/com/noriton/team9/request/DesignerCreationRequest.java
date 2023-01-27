package com.noriton.team9.request;

import com.noriton.team9.domain.Sample;
import lombok.Data;

import java.util.List;

@Data
public class DesignerCreationRequest {
    private String loginId;
    private String password;
}
