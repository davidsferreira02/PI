package com.example.demo;

public class Faber {

    String ident;
    int http_port;
    int admin_port;
    boolean no_auto;
    String endorser_role;
    boolean revocation;

    int connection_ready;

    public Faber(String ident, int http_port, int admin_port, boolean no_auto, String endorser_role, boolean revocation) {
        this.ident = ident;
        this.http_port = http_port;
        this.admin_port = admin_port;
        this.no_auto = no_auto;
        this.endorser_role = endorser_role;
        this.revocation = revocation;
    }


    public Boolean connection_ready(){
        if (connection_ready==2)
            return true;
        return false;
    }

    public void generate_credential_offer(){

    }

    public void generate_proof_request_web_request(){

    }
    public void main(int args){

    }
}
