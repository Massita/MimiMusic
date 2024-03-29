package com.massita.mimimusic.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.massita.mimimusic.R
import com.massita.mimimusic.ui.adapters.TrackListAdapter
import com.massita.mimimusic.viewmodel.SongViewModel
import com.massita.mimimusic.viewmodel.TrackListViewModel
import kotlinx.android.synthetic.main.fragment_artist_detail.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ArtistDetailFragment : Fragment() {
    private val args: ArtistDetailFragmentArgs by navArgs()

    val trackListViewModel: TrackListViewModel by viewModel { parametersOf(args.selectedUser) }
    val songViewModel: SongViewModel by sharedViewModel()

    private lateinit var trackListAdapter: TrackListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artist_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    fun setupRecyclerView() {
        trackListAdapter = TrackListAdapter(songViewModel)

        trackRecyclerView.apply {
            val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            val dividerItemDecoration = DividerItemDecoration(context, mLayoutManager.orientation)
            addItemDecoration(dividerItemDecoration)
            layoutManager = mLayoutManager
            setHasFixedSize(true)
            adapter = trackListAdapter
        }

        trackListViewModel.trackList.observe(this, Observer { trackListAdapter.submitList(it) })
    }

}
