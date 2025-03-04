package com.ananth.mvvmkotlinsample.features.gists

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
import com.ananth.mvvmkotlinsample.databinding.FragmentGistsBinding
import com.ananth.mvvmkotlinsample.model.local.GistsEntity
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import org.koin.android.viewmodel.ext.android.sharedViewModel

class GistsFragment : Fragment() {

    private lateinit var binding: FragmentGistsBinding
    private val viewModel:GistsViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentGistsBinding.inflate(inflater,container,false)
        context?:return binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        viewModel.getUserGists()
        binding.viewModel=viewModel
        viewModel.gistsLiveData.observe(viewLifecycleOwner, Observer { state->
            when(state){
                is State.Loading -> {
                    binding.isErrorOccurred=false
                    binding.isLoading=true
                    binding.showGistsList=false
                }
                is State.Success -> {
                    Handler().postDelayed({ // Added some delay, so we can see loader because it fetches data fast from database
                        binding.isErrorOccurred=false
                        binding.isLoading=false
                        binding.showGistsList=true
                        val gistsList=state.data as ArrayList<GistsEntity>
                        viewModel.gistsList.postValue(gistsList)
                        if(gistsList.isNotEmpty()){
                            gistsList?.let { setGistsAdapterToRecyclerView(gistsList) }
                        }else{
                            binding.isErrorOccurred = true
                            binding.showGistsList = false
                            binding.errorMessage = getString(R.string.no_gists_found)
                        }
                    },1000)
                }
                is State.Error -> {
                    binding.isErrorOccurred=true
                    binding.isLoading=false
                    binding.showGistsList=false
                    binding.errorMessage = state.errorMessage
                }
            }
        })
    }

    private fun setUpRecyclerView(){
      binding.RvGistsList.setHasFixedSize(true)
      binding.RvGistsList.addItemDecoration(DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))
      binding.RvGistsList.itemAnimator=SlideInUpAnimator()
    }

    private fun setGistsAdapterToRecyclerView(gistList:List<GistsEntity>){
        val gistsAdapter=GistsAdapter()
        binding.RvGistsList.apply {
            adapter=gistsAdapter
            gistsAdapter.setData(gistList)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = GistsFragment()
    }
}