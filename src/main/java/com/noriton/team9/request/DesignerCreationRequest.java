package com.noriton.team9.request;

import com.noriton.team9.domain.Sample;
import lombok.Data;

@Data
public class DesignerCreationRequest {
    private String loginId;
    private String password;
    private Long sampleId;
}
