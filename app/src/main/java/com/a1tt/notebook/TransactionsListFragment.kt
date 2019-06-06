package com.a1tt.notebook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.synthetic.main.card_transaction.view.*

class TransactionsListFragment: Fragment() {
    lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: TargetAppAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.transactions_recycler, container, false)
        mRecyclerView = view.findViewById(R.id.transactions_recycler) as RecyclerView
        mRecyclerView.layoutManager = LinearLayoutManager(activity)

        mAdapter = TargetAppAdapter()
        mRecyclerView.adapter = mAdapter

        val observer = Observer<ArrayList<Transaction>> {
            newTransaction -> mAdapter.setData(newTransaction!!)
        }

        val model = ViewModelProviders.of(this@TransactionsListFragment).get(TransactionViewModel::class.java)

        model.getData()!!.observe(this, observer)

        return view
    }

    inner class TargetAppHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(p0: View?) {

        }

        private val transactionValue: TextView = itemView.transaction_value
        private val transactionType: TextView = itemView.transaction_type
        private val icon: ImageView = itemView.imageView2

        fun bindTransaction(transaction: Transaction) {
            transactionValue.text = transaction.transactionValue
            transactionType.text = transaction.transactionsType
        }
    }

    inner class TargetAppAdapter : RecyclerView.Adapter<TargetAppHolder>() {

        private var transactionList = ArrayList<Transaction>()

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TargetAppHolder {
            val layoutInflater: LayoutInflater = LayoutInflater.from(activity)
            val view: View = layoutInflater.inflate(R.layout.card_transaction, p0, false)
            return TargetAppHolder(view)
        }

        override fun getItemCount(): Int {
            return transactionList.size
        }

        override fun onBindViewHolder(holder: TargetAppHolder, position: Int) {
            holder.bindTransaction(transactionList[position])
        }

        fun setData(newList: ArrayList<Transaction>) {
            val postDiffCallback = PostDiffCallback(transactionList, newList)
            val diffResult = DiffUtil.calculateDiff(postDiffCallback)

            transactionList.clear()

            transactionList.add(newList[0])
            transactionList.add(newList[0])
            transactionList.add(newList[0])
            transactionList.add(newList[0])
            transactionList.add(newList[0])
            transactionList.add(newList[0])
            transactionList.add(newList[0])
            transactionList.add(newList[0])
            transactionList.add(newList[0])
            transactionList.add(newList[0])
            transactionList.add(newList[0])
            transactionList.add(newList[0])

            diffResult.dispatchUpdatesTo(this)
        }

        internal inner class PostDiffCallback(private val oldPosts: ArrayList<Transaction>, private val newPosts: ArrayList<Transaction>) :
            DiffUtil.Callback() {

            override fun getOldListSize(): Int {
                return oldPosts.size
            }

            override fun getNewListSize(): Int {
                return newPosts.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldPosts[oldItemPosition].equals(newPosts[newItemPosition])
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldPosts[oldItemPosition].equals(newPosts[newItemPosition])
            }
        }
    }
}