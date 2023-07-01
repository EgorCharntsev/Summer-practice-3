package com.itis.thirdapplication

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.itis.thirdapplication.databinding.ItemMusicBinding

class MusicItem(
    private val binding : ItemMusicBinding
) : ViewHolder(binding.root) {
    fun onBind(music : Music) {
        binding.run {
            tvTitle.text = music.name
            tvDesc.text = music.author
        }
    }
}