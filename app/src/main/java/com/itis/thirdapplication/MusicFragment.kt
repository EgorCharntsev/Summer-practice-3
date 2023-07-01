package com.itis.thirdapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.itis.thirdapplication.databinding.FragmentMusicBinding

class MusicFragment : Fragment(R.layout.fragment_music) {

    private var binding : FragmentMusicBinding? = null
    private var adapter : MusicAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMusicBinding.bind(view)

        initAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun initAdapter() {
        adapter = MusicAdapter(MusicRepository.list)
        binding?.rvMusic?.adapter = adapter
    }
}