public class Agent_Container {


    String ident;
    int http_port;
    int admin_port;
    String prefix;
    Boolean noauto;
    String seed;
    int aip;
    String endorser_role;
    boolean revocation;

    String connection_id;

    int connection_ready;

    String cred_state[] = {};

    String last_credential_received;

    String last_proof_received;


    public Agent_Container(String ident, int http_port, int admin_port, String prefix, Boolean noauto, String seed, int aip, String endorser_role, boolean revocation) {
        this.ident = ident;
        this.http_port = http_port;
        this.admin_port = admin_port;
        this.prefix = prefix;
        this.noauto = noauto;
        this.seed = seed;
        this.aip = aip;
        this.endorser_role = endorser_role;
        this.revocation = revocation;
    }

    public Boolean detect_connection() {
        return false;
    }

    public Boolean connection_ready() {
        if(connection_ready==2){
            return true;
        }
        return false;
    }

    public void handle_oob_invitation() {
        System.out.println("handle__oob_invitation");
    }

    public void handle_out_of_band() {
        System.out.println("handle_out_of_band()");
    }

}