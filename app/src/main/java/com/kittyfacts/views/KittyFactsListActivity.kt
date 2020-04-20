package com.kittyfacts.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kittyfacts.R
import com.kittyfacts.models.FactResponse
import com.kittyfacts.viewmodels.KittyFactsListViewModel
import com.kittyfacts.views.adapters.FactListAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class KittyFactsListActivity : AppCompatActivity() {

    private val kittyFactsListViewModel: KittyFactsListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kitty_facts)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_facts)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.addItemDecoration(
            DividerItemDecoration(recyclerView.context, (recyclerView.layoutManager as LinearLayoutManager).orientation)
        )

        kittyFactsListViewModel.getFacts()
        kittyFactsListViewModel.factsList.observe(this, Observer(function = fun(response: FactResponse?) {
            response?.let {
                var factsListAdapter: FactListAdapter = FactListAdapter(response.all)
                recyclerView.adapter = factsListAdapter
            }
        }))


    }
}
