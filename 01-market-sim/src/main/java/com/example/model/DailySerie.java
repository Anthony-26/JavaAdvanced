package com.example.model;

import java.math.BigDecimal;

public class DailySerie {

    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private int volume;

    public DailySerie(BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, int volume) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

}
