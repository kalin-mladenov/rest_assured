package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "payment_transaction")
public class VoidTransaction {


        @JsonProperty("reference_id")
        private String referenceId;
        @JsonProperty("transaction_type")
        private String transactionType;


        /**
         *
         * @param transactionType
         * @param referenceId
         */
        public VoidTransaction(String referenceId, String transactionType) {
            super();
            this.referenceId = referenceId;
            this.transactionType = transactionType;
        }

        public String getReferenceId() {
            return referenceId;
        }

        public void setReferenceId(String referenceId) {
            this.referenceId = referenceId;
        }

        public String getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(String transactionType) {
            this.transactionType = transactionType;
        }

    }

