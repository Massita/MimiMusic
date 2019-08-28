package com.massita.mimimusic.ui.fragments


import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.massita.mimimusic.R
import com.massita.mimimusic.viewmodel.SongViewModel
import kotlinx.android.synthetic.main.fragment_media_player.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 */
class MediaPlayerFragment : Fragment() {

    val songViewModel: SongViewModel by sharedViewModel()
    private var mediaPlayer : MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_media_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        setupControl()
    }

    fun setupControl() {
        playPauseButton.setOnClickListener {
            mediaPlayer?.let {
                if(it.isPlaying) {
                    pauseSong()
                } else {
                    continueSong()
                }
            }

        }
    }

    fun setupViewModel() {
        songViewModel.song.observe(this, Observer { playSong(it.streamUrl) })
    }

    fun setupPlayer() {

        mediaPlayer = MediaPlayer()
        mediaPlayer?.setOnCompletionListener {
            // Set Button to play
        }
    }

    fun playSong(streamUrl: String) {
        releasePlayer()
        setupPlayer()

        songTitle.text = getString(R.string.loading)
        mediaPlayer?.apply {
            setAudioStreamType(AudioManager.STREAM_MUSIC)
            setDataSource(streamUrl)
            prepareAsync()
            setOnPreparedListener{
                continueSong()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

    fun pauseSong() {
        mediaPlayer?.pause()
        playPauseButton.setImageResource(android.R.drawable.ic_media_play)
        songTitle.text = getString(R.string.paused, songViewModel.song.value?.title)
    }

    fun continueSong() {
        mediaPlayer?.start()
        playPauseButton.setImageResource(android.R.drawable.ic_media_pause)
        songTitle.text = getString(R.string.playing, songViewModel.song.value?.title)
    }

    fun releasePlayer() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

}
