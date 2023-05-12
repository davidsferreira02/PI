package com.example.demo.aca;

import com.example.demo.aca.dto.CreateInvitationDTO;
import com.example.demo.aca.dto.CreateInvitationResponseDTO;
import com.example.demo.aca.dto.ReceiveInvitationDTO;
import com.example.demo.aca.dto.ReceivedInvitationResponseDTO;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class AriesClient {
    private final String acapyHost;
    private final RestTemplate restTemplate;
    private static final String OUTBAND_CREATE_INVITATION_PATH = "/out-of-band/create-invitation";

    private static final String OUTBAND_RECEIVED_INVITATION_PATH="/out-of-band/received-invitation";

    public AriesClient(String acapyHost, RestTemplate restTemplate) {
        this.acapyHost = acapyHost;
        this.restTemplate = restTemplate;
    }


    public CreateInvitationResponseDTO createInvitation(CreateInvitationDTO dto) {
        String url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(OUTBAND_CREATE_INVITATION_PATH).build().toUriString();
        return restTemplate.postForObject(url, dto, CreateInvitationResponseDTO.class);
    }

   public ReceivedInvitationResponseDTO receivedInvitation(ReceiveInvitationDTO dto){
       String url = UriComponentsBuilder.newInstance().scheme("http").host(acapyHost).path(OUTBAND_RECEIVED_INVITATION_PATH).build().toUriString();
       return restTemplate.postForObject(url, dto, ReceivedInvitationResponseDTO.class);

   }
}
