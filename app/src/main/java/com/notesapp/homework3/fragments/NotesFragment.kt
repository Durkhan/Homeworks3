package com.notesapp.homework3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.notesapp.homework3.adapter.NotesAdapter
import com.notesapp.homework3.databinding.ListOfNotesBinding
import com.notesapp.homework3.model.Notes
import com.notesapp.homework3.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NotesFragment : Fragment() {

    private var _binding: ListOfNotesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel :NotesViewModel by viewModels()
    private lateinit var notesAdapter: NotesAdapter
    lateinit var allNotes: List<Notes>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         allNotes= mutableListOf()
        _binding = ListOfNotesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesAdapter= NotesAdapter()
        binding.notesRecyclerView.apply {

            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = notesAdapter
        }

     viewModel.getAllNotes().observe(viewLifecycleOwner, Observer {lisOfNotes->
         lisOfNotes?.let {
             allNotes = it
             notesAdapter.setNotesList(allNotes)
         }
     })


        binding.addNote.setOnClickListener {
            val navDirection = NotesFragmentDirections.actionNotesFragmentToViewNotesFragment(null)
            it.findNavController().navigate(navDirection)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}