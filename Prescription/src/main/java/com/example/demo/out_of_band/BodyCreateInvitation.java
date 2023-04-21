package com.example.demo.out_of_band;

import lombok.Builder;
import lombok.Singular;
import org.hyperledger.acy_py.generated.model.AttachmentDef;
import org.hyperledger.aries.api.connection.ConnectionRecord;

import java.util.List;

public class BodyCreateInvitation {

    private List<String> accept;
    private String alias;
    @Singular
    private List<AttachmentDef> attachments;
    @Builder.Default
    private List<String> handshakeProtocols = List.of(
            ConnectionRecord.ConnectionProtocol.DID_EXCHANGE_V1.getValue(),
            ConnectionRecord.ConnectionProtocol.CONNECTION_V1.getValue());

    private String mediationId;
    private Object metadata;
    private String myLabel;

    private String protocolVersion;
    private Boolean usePublicDid;

    public BodyCreateInvitation(List<String> accept, String alias, List<AttachmentDef> attachments, List<String> handshakeProtocols, String mediationId, Object metadata, String myLabel, String protocolVersion, Boolean usePublicDid) {
        this.accept = accept;
        this.alias = alias;
        this.attachments = attachments;
        this.handshakeProtocols = handshakeProtocols;
        this.mediationId = mediationId;
        this.metadata = metadata;
        this.myLabel = myLabel;
        this.protocolVersion = protocolVersion;
        this.usePublicDid = usePublicDid;
    }
}

