package com.itis.thirdapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.itis.thirdapplication.databinding.ItemMusicBinding

class MusicAdapter(
    private var list: List<Music>,
    private val glide: RequestManager,
    private val onItemClick: (Music) -> Unit,
) : RecyclerView.Adapter<MusicItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicItem = MusicItem(
        ItemMusicBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onItemClick = onItemClick,
    )

    override fun onBindViewHolder(holder: MusicItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size
}