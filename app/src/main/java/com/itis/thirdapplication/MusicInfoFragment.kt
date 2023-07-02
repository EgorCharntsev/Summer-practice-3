package com.itis.thirdapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.thirdapplication.databinding.FragmentMusicInfoBinding

class MusicInfoFragment : Fragment(R.layout.fragment_music_info) {

    private var binding: FragmentMusicInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMusicInfoBinding.bind(view)

        val songId = arguments?.getInt(SONG_ID)
        if (songId != null) {
            val song = MusicRepository.list.single {
                it.id == songId
            }
            setInfo(song)
        }

        binding?.btnGoToBack?.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)

    private fun setInfo(song: Music) {
        binding?.run {
            title.text = "${song.name}"
            musicId.text = "${getString(R.string.id)} ${song.id}"
            musicName.text = "${getString(R.string.name)} ${song.name}"
            musicAlbum.text = "${getString(R.string.album)} ${song.album}"
            musicAuthor.text = "${getString(R.string.author)} ${song.author}"
            musicText.text = "${song.text.text}"

            Glide.with(this@MusicInfoFragment)
                .load(song.url)
                .placeholder(R.drawable.baseline_image_not_supported_24)
                .error(R.drawable.baseline_error_outline_24)
                .apply(options)
                .into(icon)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {

        private const val SONG_ID = "SONG_ID"

        fun createBundle(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(SONG_ID, id)
            return bundle
        }
    }
}