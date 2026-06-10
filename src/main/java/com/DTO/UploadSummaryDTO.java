package com.DTO;

public class UploadSummaryDTO {

    private int totalRows;

    private int savedRows;

    private int skippedRows;

    private String message;

    public UploadSummaryDTO() {
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getSavedRows() {
        return savedRows;
    }

    public void setSavedRows(int savedRows) {
        this.savedRows = savedRows;
    }

    public int getSkippedRows() {
        return skippedRows;
    }

    public void setSkippedRows(int skippedRows) {
        this.skippedRows = skippedRows;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}