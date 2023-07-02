package com.itis.thirdapplication

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.thirdapplication.databinding.ItemMusicBinding

class MusicItem(
    private val binding : ItemMusicBinding,
    private val glide : RequestManager,
    private val onItemClick : (Music) -> Unit,
) : ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)

    fun onBind(music : Music) {
        binding.run {
            tvTitle.text = music.name
            tvDesc.text = music.author

            glide
                .load(music.url)
                .placeholder(R.drawable.baseline_image_not_supported_24)
                .error(R.drawable.baseline_error_outline_24)
                .apply(options)
                .into(binding.icon)

            root.setOnClickListener {
                onItemClick(music)
            }
        }
    }
}