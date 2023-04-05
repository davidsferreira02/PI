package com.example.demo.out_of_band;

import lombok.Builder;
import lombok.Data;


@Data @Builder
public class ReceiveInvitationFilter  {
    private String alias;
    private Boolean autoAccept;
    private String mediationId;
    private Boolean useExistingConnection;
}
