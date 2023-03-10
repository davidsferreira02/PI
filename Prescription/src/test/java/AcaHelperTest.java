import com.example.demo.aca.Aca_helper;
import com.example.demo.response.CreateCredentialDefinitionResponse;
import com.example.demo.credentials.CredentialDefinitionsRequest;
import com.example.demo.response.CreateSchemaResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@SpringBootTest(classes= Aca_helper.class)
public class AcaHelperTest {


    @Test
    public void createSchemaTest(){
        Aca_helper aca_helper=new Aca_helper();
        CreateSchemaResponse createSchemaResponse=aca_helper.createSchema(UUID.randomUUID().toString(), "1.00",new String[]{"first","Second"});
        System.out.println(createSchemaResponse.getSchema_id());

    }

    @Test

    public void createCredentialDefinition(){
        String url = "http://localhost:11000/credential-definitions";
        CredentialDefinitionsRequest credentialDefinitionsRequest =new CredentialDefinitionsRequest();
        Aca_helper aca_helper=new Aca_helper();
        CreateSchemaResponse createSchemaResponse= aca_helper.createSchema(UUID.randomUUID().toString(), "1.00",new String[]{"first","Second"});

        credentialDefinitionsRequest.setSchema_id(createSchemaResponse.getSchema_id());
        credentialDefinitionsRequest.setTag("default");
        HttpEntity<CredentialDefinitionsRequest> entity= new HttpEntity<>(credentialDefinitionsRequest);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity <CreateCredentialDefinitionResponse> res=restTemplate.exchange(url, HttpMethod.POST,entity, CreateCredentialDefinitionResponse.class);

        System.out.println(res.getBody().getCredential_definition_id());
    }
    }

