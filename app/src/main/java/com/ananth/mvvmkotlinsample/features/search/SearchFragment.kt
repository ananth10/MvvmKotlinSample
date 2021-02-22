package com.ananth.mvvmkotlinsample.features.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ananth.mvvmkotlinsample.databinding.FragmentSearchBinding
import com.ananth.mvvmkotlinsample.features.search.SearchFragmentDirections
import com.ananth.mvvmkotlinsample.utils.UserManager
import org.koin.android.viewmodel.ext.android.sharedViewModel

class SearchFragment() : Fragment() {

    private val viewModel:SearchViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=FragmentSearchBinding.inflate(inflater,container,false)
        context?:return binding.root
        if(viewModel.isUserLoggedIn()){
            navigateToProfile(viewModel.getUserName())
        }
        binding.BtSubmit.setOnClickListener {
            val userName=binding.TetUserName.text.toString()
            if(userName.isNullOrEmpty()){
                Toast.makeText(requireActivity(), "Enter username", Toast.LENGTH_SHORT).show()
            }else {
                navigateToProfile(userName)
            }
        }
        return binding.root
    }

    private fun navigateToProfile(userName: String) {
        val direction =
            SearchFragmentDirections.navigateToProfile(
                userName
            )
        findNavController().navigate(direction)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment()
    }
}