package com.ferraz.felipe.kotlinRepositoriesGithub.ui.repositoriesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ferraz.felipe.kotlinRepositoriesGithub.databinding.RepositoriesFragmentBinding

class RepositoriesFragment(
    private val repositoriesViewModel: RepositoriesViewModel
) : Fragment() {

    private var _binding: RepositoriesFragmentBinding? = null

    private val binding: RepositoriesFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RepositoriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
