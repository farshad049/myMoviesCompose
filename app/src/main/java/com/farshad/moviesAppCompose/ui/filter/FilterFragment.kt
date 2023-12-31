package com.farshad.moviesAppCompose.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.asLiveData
import com.farshad.moviesAppCompose.databinding.FragmentFilterBinding
import com.farshad.moviesAppCompose.ui.filter.epoxy.FilterFragmentEpoxyController
import com.farshad.moviesAppCompose.ui.filter.epoxy.FilterOnClicks
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChanged

@AndroidEntryPoint
class FilterFragment:Fragment() {
    private var _binding: FragmentFilterBinding? = null
    private val binding get() = _binding!!
    private val filterViewModel: FilterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilterBinding.inflate(inflater , container , false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val onClicks= FilterOnClicks(filterViewModel)
        val controller = FilterFragmentEpoxyController(onClicks)


        filterViewModel.combinedDataForFilterEpoxy.distinctUntilChanged().asLiveData().observe(viewLifecycleOwner){data->
            controller.setData(data)
        }

        binding.epoxyRecyclerView.setController(controller)






















    }//FUN



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}