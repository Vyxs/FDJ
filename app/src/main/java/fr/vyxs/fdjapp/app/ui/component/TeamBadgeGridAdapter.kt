package fr.vyxs.fdjapp.app.ui.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fr.vyxs.fdjapp.R
import fr.vyxs.fdjapp.databinding.ItemTeamBadgeBinding
import fr.vyxs.fdjapp.domain.model.TeamBadge

class TeamBadgeGridAdapter(
    private val onTeamBadgeClick: (TeamBadge) -> Unit
) : ListAdapter<TeamBadge, TeamBadgeGridAdapter.TeamBadgeViewHolder>(TeamBadgeDiffCallback) {

    companion object TeamBadgeDiffCallback : DiffUtil.ItemCallback<TeamBadge>() {
        override fun areItemsTheSame(oldItem: TeamBadge, newItem: TeamBadge): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: TeamBadge, newItem: TeamBadge): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamBadgeViewHolder {
        return TeamBadgeViewHolder(
            ItemTeamBadgeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TeamBadgeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onTeamBadgeClick(item)
        }
    }

    override fun onViewRecycled(holder: TeamBadgeViewHolder) {

        super.onViewRecycled(holder)
        holder.itemView.setOnClickListener(null)
    }

    class TeamBadgeViewHolder(private var binding: ItemTeamBadgeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(teamBadge: TeamBadge) {
            binding.badge.load(teamBadge.url) {
                crossfade(true)
                placeholder(R.drawable.ic_pending)
                error(R.drawable.ic_broken_image)
            }
        }
    }
}