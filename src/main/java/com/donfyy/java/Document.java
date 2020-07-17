package com.donfyy.java;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Document {

    @SerializedName("DocumentName")
    @Expose
    private String documentName;
    @SerializedName("DocumentNumber")
    @Expose
    private String documentNumber;
    @SerializedName("DocumentSource")
    @Expose
    private String documentSource;
    @SerializedName("DocumentType")
    @Expose
    private String documentType;
    @SerializedName("DocumentFrontImage")
    @Expose
    private String documentFrontImage;
    @SerializedName("DocumentBackImage")
    @Expose
    private String documentBackImage;
    @SerializedName("CountryCode")
    @Expose
    private String countryCode;

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentSource() {
        return documentSource;
    }

    public void setDocumentSource(String documentSource) {
        this.documentSource = documentSource;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentFrontImage() {
        return documentFrontImage;
    }

    public void setDocumentFrontImage(String documentFrontImage) {
        this.documentFrontImage = documentFrontImage;
    }

    public String getDocumentBackImage() {
        return documentBackImage;
    }

    public void setDocumentBackImage(String documentBackImage) {
        this.documentBackImage = documentBackImage;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Document() {
    }
}
