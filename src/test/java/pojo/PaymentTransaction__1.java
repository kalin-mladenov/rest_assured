package pojo;
public class PaymentTransaction__1 {

    private String card_number;
    private String cvv;
    private String expiration_date;
    private String amount;
    private String usage;
    private String transaction_type;
    private String card_holder;
    private String email;
    private String address;

    /**
     * No args constructor for use in serialization
     *
     */
    public PaymentTransaction__1() {
    }

    /**
     *
     * @param transaction_type
     * @param cvv
     * @param amount
     * @param address
     * @param usage
     * @param card_holder
     * @param card_number
     * @param email
     * @param expiration_date
     */
    public PaymentTransaction__1(String card_number, String cvv, String expiration_date, String amount, String usage, String transaction_type, String card_holder, String email, String address) {
        super();
        this.card_number = card_number;
        this.cvv = cvv;
        this.expiration_date = expiration_date;
        this.amount = amount;
        this.usage = usage;
        this.transaction_type = transaction_type;
        this.card_holder = card_holder;
        this.email = email;
        this.address = address;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}