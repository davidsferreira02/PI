package com.example.demo.response;

import org.hyperledger.acy_py.generated.model.InvitationMessage;
import org.hyperledger.acy_py.generated.model.InvitationRecord;
import org.hyperledger.aries.api.out_of_band.CreateInvitationFilter;
import org.hyperledger.aries.api.out_of_band.InvitationCreateRequest;

public class CreateConnectionResponse {


    InvitationMessage message;
    String state ;
    String msg_id;


    public CreateConnectionResponse(InvitationMessage message, String state, String msg_id) {
        this.message = message;
        this.state = state;
        this.msg_id = msg_id;
    }

}
