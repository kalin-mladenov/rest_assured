package pojo;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "payment_transaction")
public class VoidTransaction {



        private String reference_id;
        private String transaction_type;

        /**
         * No args constructor for use in serialization
         *
         */
        public VoidTransaction() {
        }

        /**
         *
         * @param transaction_type
         * @param reference_id
         */
        public VoidTransaction(String reference_id, String transaction_type) {
            super();
            this.reference_id = reference_id;
            this.transaction_type = transaction_type;
        }

        public String getReference_id() {
            return reference_id;
        }

        public void setReference_id(String reference_id) {
            this.reference_id = reference_id;
        }

        public String getTransaction_type() {
            return transaction_type;
        }

        public void setTransaction_type(String transaction_type) {
            this.transaction_type = transaction_type;
        }

    }

