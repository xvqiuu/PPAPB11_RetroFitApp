package com.example.retrofitapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.databinding.ItemTeamsBinding
import com.example.retrofitapp.model.Data

class TeamAdapter(private val listTeams: List<Data>) :
    RecyclerView.Adapter<TeamAdapter.ItemTeamViewHolder>() {

    inner class ItemTeamViewHolder(private val binding: ItemTeamsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data) {
            with(binding) {
                idTxt.text = data.id.toString()
                nameTxt.text = data.name
                divisionTxt.text = data.division
                cityTxt.text = data.city

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamAdapter.ItemTeamViewHolder {
        val binding = ItemTeamsBinding.inflate(
            LayoutInflater.from(parent.context),parent,
            false)
        return ItemTeamViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listTeams.size
    }

    override fun onBindViewHolder(holder: TeamAdapter.ItemTeamViewHolder, position: Int) {
        holder.bind(listTeams[position])
    }
}