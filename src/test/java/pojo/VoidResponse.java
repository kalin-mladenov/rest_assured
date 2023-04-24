package pojo;


import com.fasterxml.jackson.annotation.JsonProperty;

public class VoidResponse {
    @JsonProperty("unique_id")
    private String uniqueId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("usage")
    private String usage;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("transaction_time")
    private String transactionTime;
    @JsonProperty("message")
    private String message;

    /**
     * No args constructor for use in serialization
     *
     */
    public VoidResponse() {
    }

    /**
     *
     * @param amount
     * @param usage
     * @param transactionTime
     * @param message
     * @param uniqueId
     * @param status
     */
    public VoidResponse(String uniqueId, String status, String usage, Integer amount, String transactionTime, String message) {
        super();
        this.uniqueId = uniqueId;
        this.status = status;
        this.usage = usage;
        this.amount = amount;
        this.transactionTime = transactionTime;
        this.message = message;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
