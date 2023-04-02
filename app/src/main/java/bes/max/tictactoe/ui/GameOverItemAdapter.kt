package bes.max.tictactoe.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import bes.max.tictactoe.R

class GameOverItemAdapter(
    private val context: Context,
    private val dataset: List<Char>?
    ) : RecyclerView.Adapter<GameOverItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val item: ImageView = view.findViewById(R.id.recycler_view_gameover_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_gameover_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dataset?.size ?: 0

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        when (dataset?.get(position)) {
            'X' -> holder.item.setImageResource(R.drawable.ic_cell_x)
            '0' -> holder.item.setImageResource(R.drawable.ic_cell_0)
            else -> holder.item.setImageResource(R.drawable.ic_cell_empty)
        }

    }
}