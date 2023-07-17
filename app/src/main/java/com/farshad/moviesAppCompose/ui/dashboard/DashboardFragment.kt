package com.farshad.moviesAppCompose.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.farshad.moviesAppCompose.databinding.FragmentDashboardBinding
import com.farshad.moviesAppCompose.ui.dashboard.epoxy.DashboardEpoxyController
import com.farshad.moviesAppCompose.ui.dashboard.epoxy.DashboardOnClicks
import com.farshad.moviesAppCompose.uiCompose.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment: Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val dashboardViewModel: DashboardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val onClicks = DashboardOnClicks(findNavController())
        val controller = DashboardEpoxyController( requireContext(),onClicks)




//        dashboardViewModel.combinedData.asLiveData().observe(viewLifecycleOwner){
//            controller.setData(it.movie , it.genre)
//        }
//
//        binding.epoxyRecyclerView.setController(controller)
//
//
//
//
//        //on swipe to refresh
//        binding.swipeToRefresh.setOnRefreshListener {
//
//            dashboardViewModel.getFirstPageMovie()
//            dashboardViewModel.getAllGenres()
//
//            binding.epoxyRecyclerView.setController(controller)
//            binding.swipeToRefresh.isRefreshing = false
//        }



        binding.myComposable.setContent {
            AppTheme() {
                DashboardScreenWithViewModel(dashboardOnClicks = onClicks)
            }
        }






















    }//FUN












    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}