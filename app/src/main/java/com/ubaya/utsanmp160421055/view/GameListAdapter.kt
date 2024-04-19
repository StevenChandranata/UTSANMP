package com.ubaya.utsanmp160421055.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.ubaya.utsanmp160421055.databinding.GameListItemBinding
import com.ubaya.utsanmp160421055.model.Game

class GameListAdapter (val gameList:ArrayList<Game>)
    : RecyclerView.Adapter<GameListAdapter.gameViewHolder>() {
    class gameViewHolder(var binding: GameListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GameListAdapter.gameViewHolder {
        val binding = GameListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GameListAdapter.gameViewHolder(binding)
    }
    override fun onBindViewHolder(holder: gameViewHolder, position: Int) {
        val picasso = Picasso.Builder(holder.itemView.context)
        picasso.listener { picasso, uri, exception ->
            exception.printStackTrace()
        }
        picasso.build().load(gameList[position].imageUrl)
            .into(holder.binding.imagePhoto, object: Callback {
                override fun onSuccess() {
                    holder.binding.progressBar.visibility = View.INVISIBLE
                    holder.binding.imagePhoto.visibility = View.VISIBLE
                }

                override fun onError(e: Exception?) {
                    Log.e("picasso_error", e.toString())
                }
            })

        holder.binding.txtTitleRead.text =gameList[position].title
        holder.binding.txtCreator.text ="@" +gameList[position].creatorUsername
        holder.binding.txtDescription.text =gameList[position].description

        holder.binding.btnRead.setOnClickListener {
            val gameId = gameList[position].idGame
            val action = GamelistFragmentDirections.actiongameDetailFragment(gameId.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun updategameList(newgameList: ArrayList<Game>) {
        gameList.clear()
        gameList.addAll(newgameList)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return gameList.size
    }
}