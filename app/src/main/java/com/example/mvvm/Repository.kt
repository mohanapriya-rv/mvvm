package com.example.mvvm

class Repository {

    fun SortTypes(): MFSortScheme{
        val scheme = MFSortScheme(
            sortOptions =listOf<MFSchemeSortOption>(
                MFSchemeSortOption(MFSchemeSortOption.ONE_YEAR_RETURNS),
                MFSchemeSortOption(MFSchemeSortOption.THREE_YEAR_RETURNS),
                MFSchemeSortOption(MFSchemeSortOption.FIVE_YEAR_RETURNS),
                MFSchemeSortOption(MFSchemeSortOption.A_Z),
                MFSchemeSortOption(MFSchemeSortOption.FI_RATED)
            ), selectedSortOption = MFSchemeSortOption(MFSchemeSortOption.A_Z)
        )
        println(scheme)
        return scheme
    }


}