package com.ananth.mvvmkotlinsample.features.followers

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.ananth.mvvmkotlinsample.R
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.databinding.FragmentFollowersBinding
import com.ananth.mvvmkotlinsample.model.local.FollowersEntity
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import org.koin.android.viewmodel.ext.android.sharedViewModel

class FollowersFragment : Fragment() {

    private lateinit var binding: FragmentFollowersBinding
    private val viewModel:FollowersViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentFollowersBinding.inflate(inflater,container,false)
        context?:return binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        viewModel.getUserFollowers()
        binding.viewModel=viewModel
        viewModel.followersLiveData.observe(viewLifecycleOwner, Observer { state->
            when(state){
                is State.Loading -> {
                    binding.isErrorOccurred=false
                    binding.isLoading=true
                    binding.showFollowersList=false
                }
                is State.Success -> {
                    Handler().postDelayed({
                        binding.isErrorOccurred=false
                        binding.isLoading=false
                        binding.showFollowersList=true
                        val followersList=state.data as ArrayList<FollowersEntity>
                        viewModel.followersList.postValue(followersList)
                        if(followersList.isNotEmpty()){
                            followersList?.let {
                                setFollowersAdapterToRecyclerview(followersList)
                            }
                        }else{
                            binding.isErrorOccurred=true
                            binding.showFollowersList=false
                            binding.errorMessage = getString(R.string.no_followers_found)
                        }
                    },1000) // Added some delay, so we can see loader because it fetches data fast from database
                }
                is State.Error -> {
                    binding.isErrorOccurred=true
                    binding.isLoading=false
                    binding.showFollowersList=false
                    binding.errorMessage = state.errorMessage
                }
            }
        })
    }

    private fun setUpRecyclerView(){
        binding.RvFollowersList.setHasFixedSize(true)
        binding.RvFollowersList.addItemDecoration(DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))
        binding.RvFollowersList.itemAnimator=SlideInUpAnimator()
    }

    private fun setFollowersAdapterToRecyclerview(followersList:List<FollowersEntity>){
        val followersAdapter=FollowersAdapter()
        binding.RvFollowersList.apply {
            adapter=followersAdapter
            followersAdapter.setData(followersList)
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) = FollowersFragment()
    }
}