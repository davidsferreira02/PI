package com.example.demo.invitation;

public class CreateInvitationParam {
    private String alias;
    private Boolean autoAccept;
    private Boolean multiUse;
    private Boolean isPublic;

    public CreateInvitationParam(String alias, Boolean autoAccept, Boolean multiUse, Boolean isPublic) {
        this.alias = alias;
        this.autoAccept = autoAccept;
        this.multiUse = multiUse;
        this.isPublic = isPublic;
    }
}
