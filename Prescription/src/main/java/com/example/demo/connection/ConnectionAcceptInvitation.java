package com.example.demo.connection;

public class ConnectionAcceptInvitation {
    private String mediationId;

    /** My URL endpoint */
    private String myEndpoint;

    /** Label for connection */
    private String myLabel;

    public ConnectionAcceptInvitation(String mediationId, String myEndpoint, String myLabel) {
        this.mediationId = mediationId;
        this.myEndpoint = myEndpoint;
        this.myLabel = myLabel;
    }
}
