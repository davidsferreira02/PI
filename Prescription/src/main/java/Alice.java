import com.google.gson.JsonObject;

import java.util.List;

public class Alice {

    String ident;
    int http_port;
    int admin_port;
    boolean no_auto;
    int aip;
    String endorser_role;

    int connection_ready;









    public Alice(String ident, int http_port, int admin_port, boolean no_auto, int aip, String endorser_role) {
        this.ident = ident;
        this.http_port = http_port;
        this.admin_port = admin_port;
        this.no_auto = no_auto;
        this.aip = aip;
        this.endorser_role = endorser_role;
    }


    public Boolean detect_connection(){
        if(connection_ready!=0)
            return true;

        return false;

    }

    public Boolean connection_ready(){

        if(connection_ready==2)
            return true;
        return false;
    }

    public void input_invitation(Agent_Container agent_container){


    }


    public void main(int args){

    }

    public void createInvitation(String mediationId, JsonObject metadata, List<String> recipientKeys,List<String> routingKeys,String serviceEndpoint){




    }



}
