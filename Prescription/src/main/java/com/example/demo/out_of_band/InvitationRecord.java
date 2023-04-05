package com.example.demo.out_of_band;


import com.google.gson.JsonElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hyperledger.aries.api.out_of_band.InvitationMessageTranslator;
import org.hyperledger.aries.api.out_of_band.OOBRecord;


@Data @NoArgsConstructor
    public class InvitationRecord implements InvitationMessageTranslator {
        private String createdAt;
        private String updatedAt;
        private String inviMsgId;


        private JsonElement invitation;

        private String invitationId;
        private String invitationUrl;
        private String oobId;
        private OOBRecord.OOBState state;
        private Boolean trace;
    }

