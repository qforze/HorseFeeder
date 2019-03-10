package com.loloc.horsefeeder.data;

import java.util.ArrayList;
import java.util.List;

public class RowItem {

    private String supplement;
    private int amount;

    public RowItem(String supplement, Integer amount) {

        this.supplement = supplement;
        this.amount = amount;
    }

    public String getSupplement() {
        return supplement;

    }

    public void setSupplement(String supplement) {

        this.supplement = supplement;

    }

    public Integer getAmount() {
        return amount;

    }

    public void setAmount(int amount) {

        this.amount = amount;

    }
}