package com.example.demo;

import com.example.demo.response.CreateConnectionResponse;
import lombok.Builder;
import lombok.NonNull;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.commons.lang3.StringUtils;
import org.hyperledger.acy_py.generated.model.V20CredOfferRequest;
import org.hyperledger.acy_py.generated.model.*;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.*;

import static org.hyperledger.aries.BaseClient.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


public class Issuer {

    private final String url;
    private final String apiKey;
    private final String bearerToken;


    @Builder
    public Issuer(@Nullable String url, @Nullable String apiKey,
                  @Nullable String bearerToken) {

        this.url = StringUtils.isEmpty(url) ? "http://localhost:11000" : StringUtils.trim(url);
        this.apiKey = StringUtils.trimToEmpty(apiKey);
        this.bearerToken = StringUtils.trimToEmpty(bearerToken);
    }

/*


    // ----------------------------------------------------
    // Credential Definition - Credential Definition Operations
    // ----------------------------------------------------

    public Optional<CredentialDefinition.CredentialDefinitionResponse> credentialDefinitionsCreate(
            @NonNull CredentialDefinition.CredentialDefinitionRequest defReq) throws IOException {
        Request req = buildPost(url + "/credential-definitions", defReq);
        return call(req, CredentialDefinition.CredentialDefinitionResponse.class);
    }


    public Optional<TxnOrCredentialDefinitionSendResult> credentialDefinitionsCreate(
            @NonNull CredentialDefinition.CredentialDefinitionRequest defReq, @NonNull EndorserInfoFilter endorserInfoFilter) throws IOException {
        HttpUrl.Builder b = Objects.requireNonNull(HttpUrl
                .parse(url + "/credential-definitions")).newBuilder();
        endorserInfoFilter.buildParams(b);
        Request req = buildPost(b.toString(), defReq);
        return call(req, TxnOrCredentialDefinitionSendResult.class);
    }


    // ----------------------------------------------------
    // DID Exchange - Connection management via DID exchange
    // ----------------------------------------------------


    public Optional<ConnectionRecord> didExchangeAcceptRequest(@NonNull String connectionId,
                                                               @Nullable DidExchangeAcceptRequestFilter filter) throws IOException {
        HttpUrl.Builder b = Objects.requireNonNull(
                HttpUrl.parse(url + "/didexchange/" + connectionId + "/accept-request")).newBuilder();
        if (filter != null) {
            filter.buildParams(b);
        }
        Request req = buildPost(b.toString(), EMPTY_JSON);
        return call(req, ConnectionRecord.class);
    }


    // ----------------------------------------------------
    // Issue Credential - Credential Issue v2.0
    // ----------------------------------------------------




    public Optional<V20CredExRecordDetail> issueCredentialV2RecordsIssue(
            @NonNull String credentialExchangeId, @Nullable V20CredIssueRequest request) throws IOException {
        Request req = buildPost(url + "/issue-credential-2.0/records/" + credentialExchangeId + "/issue",
                request != null ? request : V20CredIssueRequest.builder().build());
        return call(req, V20CredExRecordDetail.class);
    }


    public void issueCredentialV2RecordsProblemReport(@NonNull String credentialExchangeId,
                                                      @NonNull V20CredIssueProblemReportRequest request) throws IOException {
        Request req = buildPost(url + "/issue-credential-2.0/records/" + credentialExchangeId + "/problem-report",
                request);
        call(req);
    }


    public Optional<V20CredExRecord> issueCredentialV2RecordsSendOffer(
            @NonNull String credentialExchangeId, @NonNull V10CredentialBoundOfferRequest offerRequest) throws IOException {
        return issueCredentialV2RecordsSendOffer(
                credentialExchangeId, V1ToV2IssueCredentialConverter.toV20CredBoundOfferRequest(offerRequest));
    }


    public Optional<V20CredExRecord> issueCredentialV2RecordsSendOffer(
            @NonNull String credentialExchangeId, @NonNull V20CredBoundOfferRequest offerRequest) throws IOException {
        Request req = buildPost(url + "/issue-credential-2.0/records/" + credentialExchangeId + "/send-offer",
                offerRequest);
        return call(req, V20CredExRecord.class);
    }


    public Optional<V20CredExRecord> issueCredentialV2RecordsSendRequest(
            @NonNull String credentialExchangeId, @NonNull V20CredRequestRequest request) throws IOException {
        Request req = buildPost(url + "/issue-credential-2.0/records/" + credentialExchangeId + "/send-request",
                request);
        return call(req, V20CredExRecord.class);
    }


    public Optional<V20CredExRecordDetail> issueCredentialV2RecordsStore(@NonNull String credentialExchangeId,
                                                                         @Nullable V20CredStoreRequest request) throws IOException {
        Request req = buildPost(url + "/issue-credential-2.0/records/" + credentialExchangeId + "/store",
                request != null ? request : EMPTY_JSON);
        return call(req, V20CredExRecordDetail.class);
    }


    public Optional<V20CredExRecord> issueCredentialV2Send(@NonNull V1CredentialProposalRequest request)
            throws IOException {
        return issueCredentialV2Send(V1ToV2IssueCredentialConverter.toV2CredentialSendRequest(request));
    }

    public Optional<V20CredExRecord> issueCredentialV2Send(@NonNull V2CredentialExchangeFree request)
            throws IOException {
        Request req = buildPost(url + "/issue-credential-2.0/send", request);
        return call(req, V20CredExRecord.class);
    }


    public Optional<V20CredExRecord> issueCredentialV2SendOffer(@NonNull V20CredOfferRequest request)
            throws IOException {
        Request req = buildPost(url + "/issue-credential-2.0/send-offer", request);
        return call(req, V20CredExRecord.class);
    }

    public Optional<V20CredExRecord> issueCredentialV2SendProposal(@NonNull V1CredentialProposalRequest request)
            throws IOException {
        return issueCredentialV2SendProposal(V1ToV2IssueCredentialConverter.toV20CredExFree(request));
    }


    public Optional<V20CredExRecord> issueCredentialV2SendProposal(@NonNull V2CredentialExchangeFree request)
            throws IOException {
        Request req = buildPost(url + "/issue-credential-2.0/send-proposal", request);
        return call(req, V20CredExRecord.class);
    }


  public  Optional<V20CredExRecord> issueCredentialV2SendRequest(@NonNull V20CredRequestFree request)
            throws IOException {
        Request req = buildPost(url + "/issue-credential-2.0/send-request", request);
        return call(req, V20CredExRecord.class);
    }*/


    // ----------------------------------------------------
    // Out Of Band - Out-of-band connection
    // ----------------------------------------------------


   /* public Optional<InvitationRecord> outOfBandCreateInvitation(
            @NonNull InvitationCreateRequest request) throws IOException {
        HttpUrl.Builder b = Objects.requireNonNull(HttpUrl.parse(url + "/out-of-band/create-invitation")).newBuilder();
        Request req = new Issuer(b.build().toString(), request);
        return call(req, InvitationRecord.class);
    }*/






/*

    // ----------------------------------------------------
    // Schema - Schema operations
    // ----------------------------------------------------


    public Optional<SchemaSendResponse> schemas(@NonNull SchemaSendRequest schema) throws IOException {
        Request req = buildPost(url + "/schemas", schema);
        return call(req, SchemaSendResponse.class);
    }


    public Optional<TxnOrSchemaSendResult> schemas(
            @NonNull SchemaSendRequest schema, @NonNull EndorserInfoFilter endorserInfoFilter) throws IOException {
        HttpUrl.Builder b = Objects.requireNonNull(HttpUrl
                .parse(url + "/schemas")).newBuilder();
        endorserInfoFilter.buildParams(b);
        Request req = buildPost(b.toString(), schema);
        return call(req, TxnOrSchemaSendResult.class);
    }

    // ----------------------------------------------------
    // Internal
    // ----------------------------------------------------

    private Request buildPost(String u, Object body) {
        return request(u)
                .post(jsonBody(gson.toJson(body)))
                .build();
    }

    private Request buildPut(String u, Object body) {
        return request(u)
                .put(jsonBody(gson.toJson(body)))
                .build();
    }

    private Request buildPatch(String u, Object body) {
        return request(u)
                .patch(jsonBody(gson.toJson(body)))
                .build();
    }

    private Request buildGet(String u) {
        return request(u)
                .get()
                .build();
    }

    private Request buildDelete(String u) {
        return request(u)
                .delete()
                .build();
    }

    private Request.Builder request(String u) {
        Request.Builder b = new Request.Builder()
                .url(u)
                .header(X_API_KEY, apiKey);
        if (StringUtils.isNotEmpty(bearerToken)) {
            b.header(AUTHORIZATION, BEARER + bearerToken);
        }
        return b;
    }

*/
}