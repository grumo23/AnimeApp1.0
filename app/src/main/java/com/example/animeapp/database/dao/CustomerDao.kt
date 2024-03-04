package com.example.animeapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.animeapp.model.Customer
import com.example.animeapp.model.CustomerWithRentals

@Dao
interface CustomerDao {

    @Query("select * from customer")
    fun list(): List<Customer>

    @Insert
    fun save(customer: Customer)

    @Transaction
    @Query("select * from customer where id = :customerId")
    fun listCustomerRentals(customerId: Int): List<CustomerWithRentals>

}