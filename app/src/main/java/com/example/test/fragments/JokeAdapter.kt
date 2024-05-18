package com.example.test.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.FragmentJokesBinding
import com.example.test.databinding.JokeItemBinding
import com.example.test.models.Joke


class JokeAdapter: RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    private var jokesList: ArrayList<Joke> = arrayListOf()

    fun setItems(jokes: List<Joke>) {
        val diffUtil = JokeDiffUtil(jokesList, jokes)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        jokesList = jokes as ArrayList<Joke>
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        return JokeViewHolder(
            JokeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return jokesList.size
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokesList[position])
    }

    inner class JokeViewHolder(private val binding: JokeItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(joke: Joke) {
            with(binding) {
                binding.jokeSetUp.text = joke.setup
                binding.jokePunchline.text = joke.punchline
            }
        }

    }



}