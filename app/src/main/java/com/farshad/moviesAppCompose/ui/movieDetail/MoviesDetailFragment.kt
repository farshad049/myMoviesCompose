package com.farshad.moviesAppCompose.ui.movieDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.farshad.moviesAppCompose.NavGraphDirections
import com.farshad.moviesAppCompose.databinding.FragmentMoviesDetailBinding
import com.farshad.moviesAppCompose.ui.favorite.FavoriteFragmentViewModel
import com.farshad.moviesAppCompose.ui.movieDetail.epoxy.MovieDetailEpoxyController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesDetailFragment: Fragment() {
    private val viewModel: MovieDetailViewModel by viewModels()
    private val favoriteFragmentViewModel : FavoriteFragmentViewModel by viewModels()
    private val safeArg: MoviesDetailFragmentArgs by navArgs()

    private var _binding: FragmentMoviesDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesDetailBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFavoriteMovieList()

        val controller = MovieDetailEpoxyController( requireContext() ,favoriteFragmentViewModel ,::onSimilarMovieClick )

        viewModel.getMovieById(safeArg.movieId)

        viewModel.combinedData.asLiveData().observe(viewLifecycleOwner){uiModel ->
                controller.setData(uiModel)
        }



        binding.epoxyRecyclerView.setController(controller)



















    }//FUN

    private fun onSimilarMovieClick(movieId:Int ) {
        val directions= NavGraphDirections.actionGlobalToMovieDetailFragment(movieId)
        findNavController().navigate(directions)

    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}