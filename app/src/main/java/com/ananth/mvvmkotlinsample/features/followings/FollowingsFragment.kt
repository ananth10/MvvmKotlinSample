package com.ananth.mvvmkotlinsample.features.followings

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
import com.ananth.mvvmkotlinsample.databinding.FragmentFollowingsBinding
import com.ananth.mvvmkotlinsample.model.local.FollowingsEntity
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import org.koin.android.viewmodel.ext.android.sharedViewModel


class FollowingsFragment : Fragment() {

    private lateinit var binding: FragmentFollowingsBinding
    private val viewModel:FollowingsViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFollowingsBinding.inflate(inflater,container,false)
        context?:return binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        viewModel.getUserFollowings()
        binding.viewModel=viewModel
        viewModel.followingsLiveData.observe(viewLifecycleOwner, Observer { state->
            when(state){
                is State.Loading -> {
                    binding.isErrorOccurred=false
                    binding.isLoading=true
                    binding.showFollowingList=false
                }
                is State.Success -> {
                    Handler().postDelayed({ // Added some delay, so we can see loader because it fetches data fast from database
                        binding.isErrorOccurred=false
                        binding.isLoading=false
                        binding.showFollowingList=true
                        val followingsList=state.data as ArrayList<FollowingsEntity>
                        if(followingsList.isNotEmpty()){
                            followingsList?.let { setFollowingsAdapterToRecyclerview(followingsList) }
                        }else{
                            binding.isErrorOccurred=true
                            binding.isLoading=false
                            binding.errorMessage = getString(R.string.no_following_found)
                        }
                    },1000)
                }
                is State.Error -> {
                    binding.isErrorOccurred=true
                    binding.isLoading=false
                    binding.showFollowingList=false
                    binding.errorMessage = state.errorMessage
                }
            }
        })
    }

    private fun setUpRecyclerView(){
        binding.RvFollowingList.setHasFixedSize(true)
        binding.RvFollowingList.addItemDecoration(DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))
        binding.RvFollowingList.itemAnimator=SlideInUpAnimator()
    }

    private fun setFollowingsAdapterToRecyclerview(followingsList:List<FollowingsEntity>){
        val followingsAdapter=FollowingsAdapter()
        binding.RvFollowingList.apply {
            adapter=followingsAdapter
            followingsAdapter.setData(followingsList)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = FollowingsFragment()
    }
}