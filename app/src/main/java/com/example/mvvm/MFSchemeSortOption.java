package com.example.mvvm;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MFSchemeSortOption {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({ONE_YEAR_RETURNS, THREE_YEAR_RETURNS, FIVE_YEAR_RETURNS, A_Z, FI_RATED})

    public @interface MFSchemeSortOptionDef {
    }

    public static final String ONE_YEAR_RETURNS = "1 Year returns";
    public static final String THREE_YEAR_RETURNS = "3 Year returns";
    public static final String FIVE_YEAR_RETURNS = "5 Year returns";
    public static final String A_Z = "A_Z";
    public static final String FI_RATED = "FI Rated";

    public final String schemeOption;

    public MFSchemeSortOption(@MFSchemeSortOptionDef String schemeOption) {
        this.schemeOption = schemeOption;
    }
}
