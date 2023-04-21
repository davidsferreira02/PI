package com.example.demo.response;

import org.hyperledger.aries.api.connection.ConnectionAcceptance;
import org.hyperledger.aries.api.connection.ConnectionRecord;
import org.hyperledger.aries.api.connection.ConnectionState;
import org.hyperledger.aries.api.connection.ConnectionTheirRole;
import org.hyperledger.aries.api.did_exchange.DidExchangeAcceptRequestFilter;

public class AcceptRequestResponse {

    private ConnectionAcceptance accept;
    private String alias;
    private String connectionId;
    private String createdAt;
    private String errorMsg;
    private String inboundConnectionId;
    private String invitationKey;
    private ConnectionRecord.InvitationMode invitationMode;
    private String invitationMsgId;
    private String myDid;
    private String requestId;
    private String rfc23State;
    private ConnectionRecord.RoutingState routingState;
    private ConnectionState state;
    private String theirDid;
    private String theirLabel;
    private String theirPublicDid;
    private ConnectionTheirRole theirRole;
    private String updatedAt;

    public AcceptRequestResponse(ConnectionAcceptance accept, String alias, String connectionId, String createdAt, String errorMsg, String inboundConnectionId, String invitationKey, ConnectionRecord.InvitationMode invitationMode, String invitationMsgId, String myDid, String requestId, String rfc23State, ConnectionRecord.RoutingState routingState, ConnectionState state, String theirDid, String theirLabel, String theirPublicDid, ConnectionTheirRole theirRole, String updatedAt) {
        this.accept = accept;
        this.alias = alias;
        this.connectionId = connectionId;
        this.createdAt = createdAt;
        this.errorMsg = errorMsg;
        this.inboundConnectionId = inboundConnectionId;
        this.invitationKey = invitationKey;
        this.invitationMode = invitationMode;
        this.invitationMsgId = invitationMsgId;
        this.myDid = myDid;
        this.requestId = requestId;
        this.rfc23State = rfc23State;
        this.routingState = routingState;
        this.state = state;
        this.theirDid = theirDid;
        this.theirLabel = theirLabel;
        this.theirPublicDid = theirPublicDid;
        this.theirRole = theirRole;
        this.updatedAt = updatedAt;
    }
}
