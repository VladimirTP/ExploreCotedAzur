package com.example.explorecotedazur.ui.mainFragments.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.explorecotedazur.databinding.FragmentMainBinding
import com.example.explorecotedazur.ui.mainFragments.home.MainCategoriesViewModel
import com.example.explorecotedazur.ui.mainFragments.home.adapters.CategoriesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel by viewModels<MainCategoriesViewModel>()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMainCategories()

        viewModel.liveData.observe(viewLifecycleOwner) {mainCategoryDataList ->

            val adapter = CategoriesAdapter(mainCategoryDataList) {
                val action = when (it.categoriesName) {
                    "Cafes" -> MainFragmentDirections.actionMainFragmentToPopularCafesFragment()
                    "Events" -> MainFragmentDirections.actionMainFragmentToEventsFragment()
                    "Yacht Renting" -> MainFragmentDirections.actionMainFragmentToYachtFragment()
                    "Best places" -> MainFragmentDirections.actionMainFragmentToBestPlaceToVisitFragment()
                    else -> {MainFragmentDirections.actionMainFragmentToPopularCafesFragment()}
                }
                findNavController ().navigate(action)
            }

            binding.rvMainCategories.adapter = adapter
            binding.rvMainCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}