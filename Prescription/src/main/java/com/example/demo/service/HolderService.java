package com.example.demo.service;


import com.example.demo.aca.HolderHelper;
import com.example.demo.aca.dto.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HolderService implements PrescriptionService {

    @NonNull
    private final HolderHelper holderHelper;
    @NonNull
    private final IssuerService issuerService;


    public ReceivedInvitationResponseDTO receivedConnection(InvitationDTO invitationDTO) {

        ReceivedInvitationResponseDTO receivedInvitationResponseDTO = holderHelper.outOfBandReceiveInvitation(invitationDTO);
        holderHelper.didExchangeAcceptInvitation(receivedInvitationResponseDTO.getConnection_id());
        return receivedInvitationResponseDTO;
    }

    public ConnectionsResponseDTO connections() {
        return holderHelper.connections();

    }

    public SendProposalResponseDTO sendProposal(SendProposalDTO sendProposalDTO) {
        return holderHelper.sendProposal(sendProposalDTO);
    }

    public SendRequestResponseDTO sendRequest(SendRequestDTO sendRequestDTO) {
        return holderHelper.sendRequest(sendRequestDTO);
    }

    public GetCredentialsResponseDTO getCredentials() {
        return holderHelper.getCredentials();
    }

    public StoreCredentialsResponseDTO storeCredentials(StoreCredentialsDTO storeCredentialsDTO) {
        return holderHelper.storeCredentials(storeCredentialsDTO);
    }

    @Override
    public void savePrescription(PrescriptionDTO prescriptionDTO) {

        SendProposalDTO sendProposalDTO = new SendProposalDTO();
        SendProposalDTO.CredentialPreview credentialPreview = sendProposalDTO.new CredentialPreview();
        SendProposalDTO.Attribute attributes = sendProposalDTO.new Attribute();

        attributes.setName("title");
        attributes.setMine_type("plain/text");
        attributes.setValue(prescriptionDTO.getTitle());
        attributes.setName("patientName");
        attributes.setMine_type("plain/text");
        attributes.setValue(prescriptionDTO.getPatientName());
        attributes.setName("doctorName");
        attributes.setMine_type("plain/text");
        attributes.setValue(prescriptionDTO.getDoctorName());
        attributes.setName("dosage");
        attributes.setMine_type("plain/text");
        attributes.setValue(prescriptionDTO.getDosage());
   /*     attributes.setName("expiredAt");
        attributes.setMine_type("yyyy-MM-dd");
        attributes.setValue(prescriptionDTO.getExpiredAt().toString());
        attributes.setName("createdAt");
        attributes.setMine_type("yyyy-MM-dd");
        attributes.setValue(prescriptionDTO.getCreatedAt().toString());*/
        attributes.setName("medication");
        attributes.setMine_type("plain/text");
        attributes.setValue(prescriptionDTO.getMedication());
        SendProposalResponseDTO sendProposalResponseDTO = sendProposal(sendProposalDTO);
        SendOfferDTO sendOfferDTO = new SendOfferDTO(sendProposalResponseDTO.getCred_ex_id());
        SendOfferResponseDTO sendOfferResponseDTO = issuerService.sendOffer(sendOfferDTO);
        SendRequestDTO sendRequestDTO = new SendRequestDTO(sendProposalResponseDTO.getCred_ex_id());
        SendRequestResponseDTO sendRequestResponseDTO = sendRequest(sendRequestDTO);
        IssueCredentialsDTO issueCredentialsDTO = new IssueCredentialsDTO(sendOfferResponseDTO.getCred_ex_id());
        issuerService.issueCredentials(issueCredentialsDTO);
        StoreCredentialsDTO storeCredentialsDTO = new StoreCredentialsDTO(sendRequestResponseDTO.getCred_ex_id());
        StoreCredentialsResponseDTO storeCredentialsResponseDTO =storeCredentials(storeCredentialsDTO);


    }


}
