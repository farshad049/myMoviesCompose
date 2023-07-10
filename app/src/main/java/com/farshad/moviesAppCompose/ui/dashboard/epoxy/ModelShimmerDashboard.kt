package com.farshad.moviesAppCompose.ui.dashboard.epoxy

import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelDashboardShimmerBinding
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel

 class ModelShimmerDashboard
     : ViewBindingKotlinModel<ModelDashboardShimmerBinding>(R.layout.model_dashboard_shimmer){
    override fun ModelDashboardShimmerBinding.bind() {
        shimmerLayout.startShimmer()
    }

}
