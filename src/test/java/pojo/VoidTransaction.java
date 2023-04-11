package pojo;
public class VoidTransaction {

    private VoidTransaction__1 payment_transaction;

    /**
     * No args constructor for use in serialization
     *
     */
    public VoidTransaction() {
    }

    /**
     *
     * @param payment_transaction
     */
    public VoidTransaction(VoidTransaction__1 payment_transaction) {
        super();
        this.payment_transaction = payment_transaction;
    }

    public VoidTransaction__1 getPayment_transaction() {
        return payment_transaction;
    }

    public void setPayment_transaction(VoidTransaction__1 payment_transaction) {
        this.payment_transaction = payment_transaction;
    }

}
