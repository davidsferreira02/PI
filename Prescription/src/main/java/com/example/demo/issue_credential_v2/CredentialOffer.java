package com.example.demo.issue_credential_v2;

import com.google.gson.annotations.SerializedName;
import org.hyperledger.acy_py.generated.model.AttachDecorator;
import org.hyperledger.acy_py.generated.model.CredentialPreview;


import java.util.ArrayList;
import java.util.List;

public class CredentialOffer {
    @SerializedName("@id")
    private String id;

    @SerializedName("@type")
    private String type;

    private String comment;

    private CredentialPreview credentialPreview;

    private List<CredentialFormat> formats = new ArrayList<>();

    @SerializedName("offers~attach")
    private List<AttachDecorator> offersAttach = new ArrayList<>();

    private String replacementId;
}

