package com.a1tt.a1tt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class TransactionViewModel: ViewModel() {
    var transactions: MutableLiveData<ArrayList<Transaction>>? = null

    fun getData(): MutableLiveData<ArrayList<Transaction>>? {
        if (transactions == null) {

            val arrayList = arrayListOf<Transaction>()
            arrayList.addAll(listOf(
                Transaction("500 рублей", "зарплата", true),
                Transaction("500 рублей", "зарплата", true),
                Transaction("500 рублей", "зарплата", true),
                Transaction("500 рублей", "зарплата", true),
                Transaction("500 рублей", "зарплата", true),
                Transaction("500 рублей", "зарплата", true),
                Transaction("500 рублей", "зарплата", true),
                Transaction("500 рублей", "зарплата", true)
            ))

            transactions = MutableLiveData<ArrayList<Transaction>>().apply {
                postValue(arrayList)
            }
        }
        return transactions
    }
}