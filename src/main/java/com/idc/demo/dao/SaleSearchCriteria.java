package com.idc.demo.dao;

import org.jfree.data.time.Quarter;

public class SaleSearchCriteria {
    public final String country;
    public final Quarter quarter;

    private SaleSearchCriteria(Builder builder) {
        country = builder.country;
        quarter = builder.quarter;
    }

    /**
     * {@code SaleSearchCriteria} builder static inner class
     */
    public static final class Builder {
        private String country;
        private Quarter quarter;

        public Builder() {

        }

        /**
         * Sets the {@code country} and returns a reference to this Builder enabling method chaining.
         *
         * @param value the {@code country} to set
         * @return a reference to this Builder
         */
        public Builder country(String value) {
            country = value;
            return this;
        }

        /**
         * Sets the {@code quarter} and returns a reference to this Builder enabling method chaining.
         *
         * @param value the {@code quarter} to set
         * @return a reference to this Builder
         */
        public Builder quarter(Quarter value){
            quarter = value;
            return this;
        }

        /**
         * Returns a {@code SaleSearchCriteria} built from the parameters previously set.
         *
         * @return a {@code SaleSearchCriteria} built with parameters of this {@code SaleSearchCriteria.Builder}
         */
        public SaleSearchCriteria build() {
            return new SaleSearchCriteria(this);
        }
    }
}
