package com.example.demo.connection;

import io.micrometer.common.lang.Nullable;

public class ConnectionFilter {
    @Nullable private String alias;
    @Nullable private ConnectionRecord.ConnectionProtocol connectionProtocol;
    @Nullable private String invitationKey;
    @Nullable private String myDid;
    @Nullable private ConnectionState state;
    @Nullable private String theirDid;
    @Nullable private String theirPublicDid;
    @Nullable private ConnectionTheirRole theirRole;
}
