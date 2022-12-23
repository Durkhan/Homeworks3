package com.notesapp.homework3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.notesapp.homework3.R
import com.notesapp.homework3.databinding.ViewNotesBinding
import com.notesapp.homework3.model.Notes
import com.notesapp.homework3.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class NotesViewFragment : Fragment() {

    private var _binding: ViewNotesBinding? = null
    private val viewModel : NotesViewModel by viewModels()
    private var isSaved:Boolean=true

    private val args:NotesViewFragmentArgs by navArgs()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ViewNotesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (args.note!=null){
            binding.title.setText(args.note?.title.toString())
            binding.body.setText(args.note?.body.toString())
            binding.saveButton.setOnClickListener {
                isSaved=false
                updateNote()
                findNavController().navigate(R.id.action_ViewNotesFragment_to_NotesFragment)
            }
        }else{
            binding.saveButton.setOnClickListener {
                isSaved=false
                saveNote()
                findNavController().navigate(R.id.action_ViewNotesFragment_to_NotesFragment)
            }
        }


    }

    private fun updateNote() {
        if(!binding.body.text.toString().isEmpty()){
            val note = Notes(binding.title.text.toString(),binding.body.text.toString())
            note.id=args.note?.id
            viewModel.update(note)
        }
    }

    private fun saveNote() {
        if(!binding.body.text.toString().isEmpty()){
            val note = Notes(binding.title.text.toString(),binding.body.text.toString())
            viewModel.insert(note)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
    // check not yet saved with save button in View Destroy
        if (isSaved){
            if (args.note!=null){
                updateNote()
            }else{
                saveNote()
            }

        }

        _binding = null
    }


}