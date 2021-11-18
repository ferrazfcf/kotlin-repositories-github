package com.ferraz.felipe.kotlinRepositoriesGithub.ui.repositoriesList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import com.ferraz.felipe.kotlinRepositoriesGithub.databinding.RepositoriesFragmentBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class RepositoriesFragment : Fragment() {

    private val repositoriesViewModel by sharedViewModel<RepositoriesViewModel>()

    private var _binding: RepositoriesFragmentBinding? = null

    private val binding: RepositoriesFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RepositoriesFragmentBinding.inflate(inflater, container, false)

        Log.d("FCF1101", "Fragment")

        repositoriesViewModel.initializeObserver()

        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun RepositoriesViewModel.initializeObserver() {
        errorState.observe(viewLifecycleOwner, ::handleErrorState)
    }

    private fun handleErrorState(error: Throwable) {
        Toast.makeText(requireContext(), error.message, LENGTH_SHORT).show()
    }
}
