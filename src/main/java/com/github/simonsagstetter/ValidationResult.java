package com.github.simonsagstetter;

import java.util.ArrayList;
import java.util.Objects;

public class ValidationResult {
        private boolean isValid = false;
        private final ArrayList<String> reasons = new ArrayList<String>();

        public ValidationResult(){}

        public boolean getIsValid(){
            return isValid;
        }

        public void setIsValid(boolean isValid){
            this.isValid = isValid;
        }

        public boolean hasReason(){
            return !reasons.isEmpty();
        }

        public ArrayList<String> getReasons(){
            return reasons;
        }

        public void addReason(String reason){
            reasons.add(reason);
        }

        public ValidationResult addReason(String reason, boolean exit){
            if(exit)setIsValid(false);
            reasons.add(reason);
            return this;
        }

        public void clearReasons(){
            this.reasons.clear();
        }

        @Override
        public String toString() {
            return "ValidationResult{" +
                    "isValid=" + isValid +
                    ", reasons=" + reasons +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            ValidationResult that = (ValidationResult) o;
            return isValid == that.isValid && Objects.equals(reasons, that.reasons);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isValid, reasons);
        }
}
