package com;

public class UploadSummaryDto {
	
	
	private int totalRows;
	private int savedRows;
	private int skippedRows;
	private String message;
	
	public UploadSummaryDto() {
		super();
	}

	public UploadSummaryDto(int totalRows, int savedRows, int skippedRows, String message) {
		super();
		this.totalRows = totalRows;
		this.savedRows = savedRows;
		this.skippedRows = skippedRows;
		this.message = message;
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

	@Override
	public String toString() {
		return "UploadSummaryDto [totalRows=" + totalRows + ", savedRows=" + savedRows + ", skippedRows=" + skippedRows
				+ ", message=" + message + "]";
	}

}
	