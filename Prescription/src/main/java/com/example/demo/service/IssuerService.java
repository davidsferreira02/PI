package com.example.demo.service;


import com.example.demo.aca.AriesClient;
import com.example.demo.aca.HolderHelper;
import com.example.demo.aca.IssuerHelper;
import com.example.demo.aca.dto.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.sendgrid.SendGridProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class IssuerService implements PrescriptionService {

    @NonNull
    private final IssuerHelper issuerHelper;
    @NonNull
    private final HolderService holderService;

    @NonNull
    private final AriesClient issuerClient;


    public CreateInvitationResponseDTO createConnection() {
        CreateInvitationResponseDTO createConnection = issuerHelper.outOfBandCreateInvitation();
        return createConnection;
    }

    public AcceptRequestResponseDTO acceptConnectionInvitationRequest(AcceptRequestDTO acceptRequestDTO) {

        return issuerHelper.didExchangeAcceptRequest(acceptRequestDTO);
    }

    public ConnectionsResponseDTO connections() {
        return issuerHelper.connections();

    }


    public SchemaResponseDTO schema(SchemaDTO schemaDTO) {
        return issuerHelper.schema(schemaDTO);
    }

    public CredentialDefinitionResponseDTO credentialDefinition(CredentialDefinitionDTO credentialDefinitionDTO) {
        return issuerHelper.credentialDefinition(credentialDefinitionDTO);
    }

    public SendOfferResponseDTO sendOffer(SendOfferDTO sendOfferDTO) {
        return issuerHelper.sendOffer(sendOfferDTO);
    }


    public IssueCredentialsResponseDTO issueCredentials(IssueCredentialsDTO issueCredentialsDTO) {
        return issuerHelper.issueCredentials(issueCredentialsDTO);
    }

    public GetOfferResponseDTO getOffer(GetOfferDTO getOfferDTO){
        return issuerHelper.getOffer(getOfferDTO);
    }

    @Override
    public void savePrescription(PrescriptionDTO prescriptionDTO) {

        CreateInvitationResponseDTO createInvitationResponseDTO = createConnection();
        ReceivedInvitationResponseDTO receivedInvitationResponseDTO = holderService.receivedConnection(createInvitationResponseDTO.getInvitation());
        AcceptRequestResponseDTO acceptRequestResponseDTO = acceptConnectionInvitationRequest(new AcceptRequestDTO(createInvitationResponseDTO.getInviMsgId()));
        List<SendProposalDTO.Attribute> listAttributes = new ArrayList<>();
        SendProposalDTO sendProposalDTO = new SendProposalDTO();
        SendProposalDTO.CredentialPreview credentialPreview = sendProposalDTO.new CredentialPreview();
        SendProposalDTO.Attribute title = sendProposalDTO.new Attribute();
        SendProposalDTO.Attribute patientName = sendProposalDTO.new Attribute();
        SendProposalDTO.Attribute doctorName = sendProposalDTO.new Attribute();
        SendProposalDTO.Attribute dosage = sendProposalDTO.new Attribute();
        SendProposalDTO.Attribute medication = sendProposalDTO.new Attribute();
        sendProposalDTO.setConnection_id(receivedInvitationResponseDTO.getConnection_id());
        SendProposalDTO.Filter filter =sendProposalDTO.new Filter();
        title.setName("title");
        title.setMine_type("plain/text");
        title.setValue(prescriptionDTO.getTitle());
        listAttributes.add(title);
        patientName.setName("patientName");
        patientName.setMine_type("plain/text");
        patientName.setValue(prescriptionDTO.getPatientName());
        listAttributes.add(patientName);
        doctorName.setName("doctorName");
        doctorName.setMine_type("plain/text");
        doctorName.setValue(prescriptionDTO.getDoctorName());
        listAttributes.add(doctorName);
        dosage.setName("dosage");
        dosage.setMine_type("plain/text");
        dosage.setValue(prescriptionDTO.getDosage());
        listAttributes.add(dosage);
        medication.setName("medication");
        medication.setMine_type("plain/text");
        medication.setValue(prescriptionDTO.getMedication());
        listAttributes.add(medication);
        credentialPreview.setAttributes(listAttributes);
       sendProposalDTO.setCredentialPreview(credentialPreview);
       sendProposalDTO.setFilter(filter);
        SendProposalResponseDTO sendProposalResponseDTO = holderService.sendProposal(sendProposalDTO);

      GetOfferResponseDTO  getOfferResponseDTO=getOffer(new GetOfferDTO(sendProposalResponseDTO.getThread_id()));
        SendOfferResponseDTO sendOfferResponseDTO = sendOffer(new SendOfferDTO(getOfferResponseDTO.getCred_ex_id()));
        SendRequestDTO sendRequestDTO = new SendRequestDTO(sendOfferResponseDTO.getCred_ex_id());
        SendRequestResponseDTO sendRequestResponseDTO = holderService.sendRequest(sendRequestDTO);
        IssueCredentialsDTO issueCredentialsDTO = new IssueCredentialsDTO(sendRequestResponseDTO.getCred_ex_id());
        IssueCredentialsResponseDTO issueCredentialsResponseDTO = issueCredentials(issueCredentialsDTO);
        StoreCredentialsDTO storeCredentialsDTO = new StoreCredentialsDTO(issueCredentialsDTO.getCred_ex_id());
        StoreCredentialsResponseDTO storeCredentialsResponseDTO = holderService.storeCredentials(storeCredentialsDTO);

    }
}



