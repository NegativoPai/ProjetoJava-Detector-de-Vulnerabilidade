package Scanners;

public class ScanResult {
    private String message;
    private int statusCode;
    private String additionalInfo;

    public ScanResult(String message, int statusCode, String additionalInfo) {
        this.message = message;
        this.statusCode = statusCode;
        this.additionalInfo = additionalInfo;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }
}