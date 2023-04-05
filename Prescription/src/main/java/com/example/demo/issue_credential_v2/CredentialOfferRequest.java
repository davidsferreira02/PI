package com.example.demo.issue_credential_v2;



import org.hyperledger.acy_py.generated.model.CredentialPreview;

import java.util.UUID;

public class CredentialOfferRequest {
    private Boolean autoIssue;
    private Boolean autoRemove;
    private String comment;
    private UUID connectionId;
    private CredentialPreview credentialPreview;
    private CredentialExchangeFree filter;
    private Boolean trace;

}
