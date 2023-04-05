package com.example.demo.out_of_band;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import org.hyperledger.acy_py.generated.model.AttachDecorator;

import java.lang.reflect.Type;
import java.util.List;


@Data @Builder
public class InvitationMessage<T> {

    /** Used to deserialize RFC0067 service types */
    public static final Type RFC0067_TYPE = new TypeToken<InvitationMessage<InvitationMessageService>>(){}.getType();

    /** Used to deserialize DID string service types */
    public static final Type STRING_TYPE = new TypeToken<InvitationMessage<String>>(){}.getType();

    @SerializedName("@id")
    private String atId;

    @SerializedName("@type")
    private String atType;

    private String label;

    @SerializedName("goal_code")
    private String goalCode;

    private String goal;



    private List<String> accept;

    @Builder.Default
    @SerializedName("handshake_protocols")
    private List<String> handshakeProtocols = List.of("did:sov:BzCbsNYhMrjHiqZDTUASHg;spec/didexchange/1.0");

    @SerializedName("requests~attach")
    private List<AttachDecorator> requestsAttach;


    @Singular
    private List<T> services;


    @Data @Builder
    public static class InvitationMessageService {

        private String did;

        private String id;

        @SerializedName("recipientKeys")
        private List<String> recipientKeys;

        @SerializedName("routingKeys")
        private List<String> routingKeys;

        @SerializedName("serviceEndpoint")
        private String serviceEndpoint;

        private List<String> accept;

        private String type;
    }
}
