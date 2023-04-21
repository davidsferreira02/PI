package com.example.demo.issue_credential_v2;

import jakarta.annotation.Nonnull;

public class CredentialSendOffer {

    @Nonnull
    private String cred_ex_id;

    public CredentialSendOffer(@Nonnull String cred_ex_id) {
        this.cred_ex_id = cred_ex_id;
    }
}
