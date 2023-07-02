package com.itis.thirdapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.itis.thirdapplication.databinding.FragmentMusicBinding
import com.itis.thirdapplication.utils.showSnackbar

class MusicFragment : Fragment(R.layout.fragment_music) {

    private var binding: FragmentMusicBinding? = null
    private var adapter: MusicAdapter? = null

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
        adapter = MusicAdapter(
            list = MusicRepository.list,
            glide = Glide.with(this),
            onItemClick = { music ->
                findNavController().navigate(
                    R.id.action_musicFragment_to_musicInfoFragment,
                    MusicInfoFragment.createBundle(music.id)
                )
                binding?.root?.showSnackbar(music.name)
            }
        )
        binding?.rvMusic?.adapter = adapter
        // binding?.rvMusic?.layoutManager = GridLayoutManager(requireContext(), 2)
    }
}