package com.example.animeapp.model

import androidx.room.Embedded
import androidx.room.Relation

data class CustomerWithRentals(
    @Embedded val customer: Customer,
    @Relation(
        entity = Rental::class,
        parentColumn = "id",
        entityColumn = "customerId"
    )
    val rentals: List<Rental>
)
