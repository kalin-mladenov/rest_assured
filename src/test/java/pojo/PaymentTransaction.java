package pojo;
public class PaymentTransaction {

    private PaymentTransaction__1 payment_transaction;

    /**
     * No args constructor for use in serialization
     *
     */
    public PaymentTransaction() {
    }

    /**
     *
     * @param payment_transaction
     */
    public PaymentTransaction(PaymentTransaction__1 payment_transaction) {
        super();
        this.payment_transaction = payment_transaction;
    }

    public PaymentTransaction__1 getPayment_transaction() {
        return payment_transaction;
    }

    public void setPayment_transaction(PaymentTransaction__1 payment_transaction) {
        this.payment_transaction = payment_transaction;
    }

}