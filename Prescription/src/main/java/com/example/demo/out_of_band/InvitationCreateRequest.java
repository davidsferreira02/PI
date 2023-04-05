package com.example.demo.out_of_band;

import lombok.*;
import org.hyperledger.acy_py.generated.model.AttachmentDef;
import org.hyperledger.aries.api.connection.ConnectionRecord;


import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class InvitationCreateRequest {
    /**
     * List of mime types in order of preference that should be in the response
     * example: List [ "didcomm/aip1", "didcomm/aip2;env=rfc19" ]
     */
    private List<String> accept;
    private String alias;
    @Singular
    private List<AttachmentDef> attachments;
    @Builder.Default
    private List<String> handshakeProtocols = List.of(
            ConnectionRecord.ConnectionProtocol.DID_EXCHANGE_V1.getValue(),
            ConnectionRecord.ConnectionProtocol.CONNECTION_V1.getValue());
    /** Identifier for active mediation record to be used */
    private String mediationId;
    private Object metadata;
    private String myLabel;
    /**
     * OOB protocol version
     * example: 1.1
     */
    private String protocolVersion;
    private Boolean usePublicDid;
}
