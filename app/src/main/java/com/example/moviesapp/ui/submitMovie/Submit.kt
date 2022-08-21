package com.example.moviesapp.ui.submitMovie

import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import androidx.fragment.app.FragmentManager
import com.example.moviesapp.BaseFragment
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentSubmitBinding
import com.google.android.material.tabs.TabLayoutMediator

class Submit:BaseFragment(R.layout.fragment_submit) {
    private var _binding: FragmentSubmitBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding=FragmentSubmitBinding.bind(view)

        val adapter=ViewPagerAdapter(childFragmentManager,lifecycle)

        binding.viewPager.adapter=adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position ->
            when(position){
                0-> tab.text="upload base64"
                1-> tab.text="upload multipart"
            }
        }.attach()




    }//FUN




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
