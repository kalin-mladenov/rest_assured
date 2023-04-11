package pojo;

public class PaymentResponse {



        private String unique_id;
        private String status;
        private String usage;
        private Integer amount;
        private String transaction_time;
        private String message;

        /**
         * No args constructor for use in serialization
         *
         */
        public PaymentResponse() {
        }

        /**
         *
         * @param amount
         * @param usage
         * @param transaction_time
         * @param message
         * @param unique_id
         * @param status
         */
        public PaymentResponse(String unique_id, String status, String usage, Integer amount, String transaction_time, String message) {
            super();
            this.unique_id = unique_id;
            this.status = status;
            this.usage = usage;
            this.amount = amount;
            this.transaction_time = transaction_time;
            this.message = message;
        }

        public String getUnique_id() {
            return unique_id;
        }

        public void setUnique_id(String unique_id) {
            this.unique_id = unique_id;
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

        public String getTransaction_time() {
            return transaction_time;
        }

        public void setTransaction_time(String transaction_time) {
            this.transaction_time = transaction_time;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

