package com.farshad.moviesAppCompose.ui.search.epoxy

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging3.PagingDataEpoxyController
import com.farshad.moviesAppCompose.R
import com.farshad.moviesAppCompose.databinding.ModelExeptionErrorBinding
import com.farshad.moviesAppCompose.epoxy.LoadingEpoxyModel
import com.farshad.moviesAppCompose.epoxy.ViewBindingKotlinModel
import com.farshad.moviesAppCompose.data.model.domain.DomainMovieModel
import com.farshad.moviesAppCompose.ui.search.SearchDataSource
import java.util.*

class SearchEpoxyController(
    private val onMovieClick:(Int , String)-> Unit
):PagingDataEpoxyController<DomainMovieModel>() {

    var localException: SearchDataSource.LocalException?=null
        set(value) {
            field=value
            if (localException !=null){
                //if localException is not null .immediately run "addModels" block of code,otherwise it will run "buildItemModel"
                requestForcedModelBuild()
            }
        }



    override fun buildItemModel(currentPosition: Int, item: DomainMovieModel?): EpoxyModel<*> {
        return MovieListModelSearchFragment(item!!,onMovieClick)
            .id(UUID.randomUUID().toString())
    }



    override fun addModels(models: List<EpoxyModel<*>>) {

        if (localException != null){
            //show error information
            LocalExceptionErrorEpoxyModel(localException!!).id(UUID.randomUUID().toString()).addTo(this)
            return
        }


        if (models.isEmpty()){
            LoadingEpoxyModel().id(UUID.randomUUID().toString()).addTo(this)
            return
        }

        super.addModels(models)
    }







    data class LocalExceptionErrorEpoxyModel(val localException: SearchDataSource.LocalException)
        : ViewBindingKotlinModel<ModelExeptionErrorBinding>(R.layout.model_exeption_error){
        override fun ModelExeptionErrorBinding.bind() {
            tvErrorTitle.text=localException.title
            tvErrorDescription.text=localException.description
        }
        //let this to take whole span count
        override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int): Int {
            return totalSpanCount
        }

    }





}