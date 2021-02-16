package com.ananth.mvvmkotlinsample.features.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.ananth.mvvmkotlinsample.R
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.databinding.FragmentProfileBinding
import com.ananth.mvvmkotlinsample.features.SearchFragmentDirections
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.viewmodel.ext.android.sharedViewModel


class ProfileFragment : Fragment(), ProfileClickEvent {

    private val TAG = ProfileFragment::class.java.simpleName
    private val viewModel: ProfileViewModel by sharedViewModel()
    var username: String? = null
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)
        binding.handler=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        username = arguments?.getString("userName")
        viewModel.getUserProfile(username)
        viewModel.profileLiveData.observe(viewLifecycleOwner, Observer { state ->
            Log.i(TAG, state.toString())
            when (state) {
                is State.Loading -> {
                    binding.isErrorOccurred = false
                    binding.isLoading = true
                    binding.showProfileDetails = false
                }
                is State.Success -> {
                    binding.isErrorOccurred = false
                    binding.isLoading = false
                    binding.showProfileDetails = true
                    Log.i(TAG, state.data.name)
                    binding.profile = state.data
                }
                is State.Error -> {
                    binding.isLoading = false
                    binding.showProfileDetails = false
                    binding.isErrorOccurred = true
                    binding.errorMessage = state.errorMessage
                }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ProfileFragment()
    }

    override fun onRepoClick() {
        navigateToRepositoryScreen()
    }

    override fun onGistsClick() {
        navigateToGistsScreen()
    }

    override fun onFollowingClick() {
        navigateToFollowingScreen()
    }

    override fun onFollowersClick() {
        navigateToFollowersScreen()
    }

    private fun navigateToRepositoryScreen() {
        val direction = ProfileFragmentDirections.navigateToRepository()
        findNavController().navigate(direction)
    }

    private fun navigateToGistsScreen(){
        val direction=ProfileFragmentDirections.navigateToGists()
        findNavController().navigate(direction)
    }

    private fun navigateToFollowingScreen(){
        val direction=ProfileFragmentDirections.navigateToFollowings()
        findNavController().navigate(direction)
    }

    private fun navigateToFollowersScreen(){
        val direction=ProfileFragmentDirections.navigateToFollowers()
        findNavController().navigate(direction)
    }
}