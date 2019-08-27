package com.massita.mimimusic.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.massita.mimimusic.R
import com.massita.mimimusic.ui.adapters.TopListAdapter
import com.massita.mimimusic.viewmodel.TopListViewModel
import kotlinx.android.synthetic.main.fragment_top_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class TopListFragment : Fragment() {

    val topListViewModel: TopListViewModel by viewModel()

    private lateinit var topListAdapter: TopListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        topListAdapter = TopListAdapter()

        topListRecyclerView.apply {
            val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            layoutManager = mLayoutManager
            setHasFixedSize(true)
            adapter = topListAdapter
        }

        topListViewModel.topList.observe(this, Observer { topListAdapter.submitList(it) })
    }

}
