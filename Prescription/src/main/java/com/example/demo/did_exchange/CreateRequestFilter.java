package com.example.demo.did_exchange;

import lombok.Builder;
import lombok.NonNull;

public class CreateRequestFilter {

    private String theirPublicDid;

    /** Alias for connection */
    private String alias;

    /** Identifier for active mediation record to be used */
    private String mediationId;

    /** My URL endpoint */
    private String myEndpoint;

    /** Label for connection request */
    private String myLabel;

    /** Use public did for this connection */
    private Boolean usePublicDid;

    @Builder
    public CreateRequestFilter(@NonNull String theirPublicDid, String alias, String mediationId,
                               String myEndpoint, String myLabel, Boolean usePublicDid) {
        this.theirPublicDid = theirPublicDid;
        this.alias = alias;
        this.mediationId = mediationId;
        this.myEndpoint = myEndpoint;
        this.myLabel = myLabel;
        this.usePublicDid = usePublicDid;
    }
}
