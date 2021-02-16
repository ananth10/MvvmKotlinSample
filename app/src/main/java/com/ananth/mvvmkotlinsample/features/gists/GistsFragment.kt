package com.ananth.mvvmkotlinsample.features.gists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ananth.mvvmkotlinsample.R
import com.ananth.mvvmkotlinsample.databinding.FragmentGistsBinding

class GistsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=FragmentGistsBinding.inflate(inflater,container,false)
        context?:return binding.root
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = GistsFragment()
    }
}