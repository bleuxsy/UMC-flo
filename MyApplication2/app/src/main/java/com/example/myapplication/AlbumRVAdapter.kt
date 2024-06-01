package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemAlbumBinding

class AlbumRVAdapter(private val  albumList : ArrayList<Album>):RecyclerView.Adapter<AlbumRVAdapter.ViewHolder>(){

    interface CommunicationInterface {
        fun sendData(album: Album)
    }


//    fun addItem(album: Album){
//        albumList.add(album)
//        notifyDataSetChanged()
//    }
//    fun removeItem(position : Int){
//        albumList.removeAt(position)
//        notifyDataSetChanged()
//    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AlbumRVAdapter.ViewHolder {
        val binding : ItemAlbumBinding = ItemAlbumBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup , false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumRVAdapter.ViewHolder, position: Int) {

        holder.bind(albumList[position])
        holder.itemView.setOnClickListener{ mItemClickListener.onItemClick(albumList[position]) }
      //  holder.binding.itemAlbumTitleTv.setOnClickListener({mItemClickListener.onRemoveAlbum(position)})
        holder.binding.itemAlbumPlayImgIv.setOnClickListener {
            mItemClickListener.onPlayAlbum(albumList[position])
        }
    }


    override fun getItemCount(): Int = albumList.size

    inner class ViewHolder(val binding: ItemAlbumBinding): RecyclerView.ViewHolder(binding.root){
//ViewHolder 내부 클래스 정의 . RecyclerView Adapter와 연결되어있음

        fun bind(album : Album){
            binding.itemAlbumTitleTv.text = album.title
            binding.itemAlbumSingerTv.text = album.singer
            binding.itemAlbumCoverImgIv.setImageResource(album.coverImg!!)
        }

    }
    interface MyItemCLickListener{
        fun onItemClick(album: Album)
        fun onPlayAlbum(album: Album)
    }


    private lateinit var mItemClickListener : MyItemCLickListener
    fun setMyItemClickListener(itemCLickListener: MyItemCLickListener){
        this.mItemClickListener = itemCLickListener
    }

}