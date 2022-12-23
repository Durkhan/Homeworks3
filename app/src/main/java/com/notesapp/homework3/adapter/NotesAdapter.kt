package com.notesapp.homework3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.notesapp.homework3.databinding.NotesListsitemBinding
import com.notesapp.homework3.fragments.NotesFragmentDirections
import com.notesapp.homework3.model.Notes

class NotesAdapter(): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    private var listofnotes= emptyList<Notes>()


    @SuppressLint("NotifyDataSetChanged")
    fun setNotesList(listofnotes: List<Notes>) {
        this.listofnotes = listofnotes
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotesViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val binding=NotesListsitemBinding.inflate(inflater,parent,false)
        return NotesViewHolder(binding)
    }



    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
             holder.binding.itemTextTitlem.text=listofnotes[position].title
             holder.binding.itemTextSubTitle.text=listofnotes[position].body
        //Handle item click
        holder.itemView.setOnClickListener {
            val navDirection = NotesFragmentDirections.actionNotesFragmentToViewNotesFragment(listofnotes[position])
            it.findNavController().navigate(navDirection)
        }
    }

    override fun getItemCount(): Int {
        if(listofnotes.isNotEmpty()){
            return listofnotes.size
        }
        return 0
    }

    class NotesViewHolder(val binding: NotesListsitemBinding): RecyclerView.ViewHolder(binding.root) {}

}