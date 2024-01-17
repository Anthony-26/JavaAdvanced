package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.TreeMap;

public class Fractal {
    
    private TreeMap<LocalDate, BigDecimal> bearishFractals;
    private TreeMap<LocalDate, BigDecimal> bullishFractals;


    public Fractal() {
    }

    public Fractal(TreeMap<LocalDate,BigDecimal> bearishFractals, TreeMap<LocalDate,BigDecimal> bullishFractals) {
        this.bearishFractals = bearishFractals;
        this.bullishFractals = bullishFractals;
    }

    public TreeMap<LocalDate,BigDecimal> getBearishFractals() {
        return this.bearishFractals;
    }

    public void setBearishFractals(TreeMap<LocalDate,BigDecimal> bearishFractals) {
        this.bearishFractals = bearishFractals;
    }

    public TreeMap<LocalDate,BigDecimal> getBullishFractals() {
        return this.bullishFractals;
    }

    public void setBullishFractals(TreeMap<LocalDate,BigDecimal> bullishFractals) {
        this.bullishFractals = bullishFractals;
    }


}
