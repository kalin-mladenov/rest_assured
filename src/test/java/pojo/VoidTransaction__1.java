package pojo;

public class VoidTransaction__1 {



        private String reference_id;
        private String transaction_type;

        /**
         * No args constructor for use in serialization
         *
         */
        public VoidTransaction__1() {
        }

        /**
         *
         * @param transaction_type
         * @param reference_id
         */
        public VoidTransaction__1(String reference_id, String transaction_type) {
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

