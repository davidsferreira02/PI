package com.example.demo.service;


import com.example.demo.aca.IssuerHelper;
import com.example.demo.aca.dto.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class IssuerService implements PrescriptionService{

    @NonNull
    private final IssuerHelper issuerHelper;





    public CreateInvitationResponseDTO createConnection() {
        CreateInvitationResponseDTO createConnection = issuerHelper.outOfBandCreateInvitation();
        return createConnection;
    }

    public AcceptRequestResponseDTO acceptConnectionInvitationRequest(AcceptRequestDTO acceptRequestDTO)  {

        return issuerHelper.didExchangeAcceptRequest(acceptRequestDTO);
    }


    public SchemaResponseDTO schema(SchemaDTO schemaDTO) {
        return issuerHelper.schema(schemaDTO);
    }

    public CredentialDefinitionResponseDTO credentialDefinition(CredentialDefinitionDTO credentialDefinitionDTO){
        return issuerHelper.credentialDefinition(credentialDefinitionDTO);
    }
    public SendOfferResponseDTO sendOffer(SendOfferDTO sendOfferDTO){
        return issuerHelper.sendOffer(sendOfferDTO);
    }


    public IssueCredentialsResponseDTO issueCredentials(){
        return issuerHelper.issueCredentials();
    }

    public void savePrescription(PrescriptionDTO prescriptionDTO) {

        SendProposalDTO sendProposalDTO=new SendProposalDTO();
        SendProposalDTO.CredentialPreview credentialPreview=sendProposalDTO.new CredentialPreview();
        SendProposalDTO.Attribute attributes=sendProposalDTO.new Attribute();

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
        attributes.setName("expiredAt");
        attributes.setMine_type("yyyy-MM-dd");
        attributes.setValue(prescriptionDTO.getExpiredAt().toString());
        attributes.setName("createdAt");
        attributes.setMine_type("yyyy-MM-dd");
        attributes.setValue(prescriptionDTO.getCreatedAt().toString());
        attributes.setName("medication");
        attributes.setMine_type("plain/text");
        attributes.setValue(prescriptionDTO.getMedication());






    }









}
