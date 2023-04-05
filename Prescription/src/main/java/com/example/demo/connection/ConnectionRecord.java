package com.example.demo.connection;

// accept-invitation

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.StringUtils;
import org.hyperledger.aries.api.connection.ConnectionAcceptance;

public class ConnectionRecord {

    private ConnectionAcceptance accept;
    private String alias;
    private String connectionId;
    private ConnectionProtocol connectionProtocol;
    private String createdAt;
    private String errorMsg;
    private String inboundConnectionId;
    private String invitationKey;
    private String invitationMode;
    private String invitationMsgId;
    private String mydid;
    private String request_id;
    private String rfc23State;
    private RoutingState routingState;
    private ConnectionState state;
    private String theirDid;
    private String theirLabel;
    private String theirPublicDid;
    private ConnectionTheirRole theirRole;
    private String updatedAt;




    public enum InvitationMode {
        @JsonProperty("once")
        @SerializedName("once")
        ONCE,

        @JsonProperty("multi")
        @SerializedName("multi")
        MULTI,

        @JsonProperty("static")
        @SerializedName("static")
        STATIC,
    }
    public enum RoutingState {
        @JsonProperty("none")
        @SerializedName("none")
        NONE,

        @JsonProperty("request")
        @SerializedName("request")
        REQUEST,

        @JsonProperty("active")
        @SerializedName("active")
        ACTIVE,

        @JsonProperty("error")
        @SerializedName("error")
        ERROR
    }

    /**
     * Tries to determine the direction of a connection
     * @return true in case the connection was not initiated by this agent
     */
    public boolean isIncomingConnection() {
        return StringUtils.isNotEmpty(invitationKey);
    }

    /**
     * Tries to determine the direction of a connection
     * @return true in case the connection was initiated by this agent
     */
    public boolean isOutgoingConnection() {
        return StringUtils.isEmpty(invitationKey);
    }

    /**
     * Tests if the event is on the receiving side of a connection. Meaning this agent
     * received an invitation.
     * @return true if this agent received the invitation
     */
    public boolean isInvitationResponse() {
        return StringUtils.isNotEmpty(invitationMsgId)
                && (ConnectionTheirRole.INVITER.equals(theirRole)
                || ConnectionTheirRole.RESPONDER.equals(theirRole));
    }

    /**
     * Tests if the event is not on the receiving side of a connection. Meaning this agent
     * created an invitation.
     * @return true if it is not an invitation event
     */
    public boolean isInvitationRequest() {
        return StringUtils.isNotEmpty(invitationMsgId)
                && (ConnectionTheirRole.INVITEE.equals(theirRole)
                || ConnectionTheirRole.REQUESTER.equals(theirRole));
    }

    /**
     * Tests if this event is a connection request
     * e.g. if --auto-accept-requests is set to false
     * @return true in case another agent wants to connect
     */
    public boolean isRequestToConnect() {
        return ConnectionAcceptance.MANUAL.equals(accept)
                && ConnectionState.REQUEST.equals(state);
    }

    public boolean stateIsInvitation() {
        return ConnectionState.INVITATION.equals(state);
    }

    public boolean stateIsRequest() {
        return ConnectionState.REQUEST.equals(state);
    }

    public boolean stateIsResponse() {
        return ConnectionState.RESPONSE.equals(state);
    }

    public boolean stateIsActive() {
        return ConnectionState.ACTIVE.equals(state);
    }

    public boolean stateIsCompleted() {
        return ConnectionState.COMPLETED.equals(state);
    }

    public boolean protocolIsConnectionV1() {
        return ConnectionProtocol.CONNECTION_V1.equals(connectionProtocol);
    }

    public boolean protocolIsIdDidExchangeV1() {
        return ConnectionProtocol.DID_EXCHANGE_V1.equals(connectionProtocol);
    }
    public enum ConnectionProtocol {


        @JsonProperty("connections/1.0")
        @SerializedName("connections/1.0")
        CONNECTION_V1("connections/1.0"),

        @JsonProperty("didexchange/1.0")
        @SerializedName("didexchange/1.0")
        DID_EXCHANGE_V1("didexchange/1.0")
        ;
        private final String value;


    }

}