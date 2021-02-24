package com.ananth.mvvmkotlinsample.features.repository

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.ananth.mvvmkotlinsample.R
import com.ananth.mvvmkotlinsample.data.remote.State
import com.ananth.mvvmkotlinsample.databinding.FragmentRepositoryBinding
import com.ananth.mvvmkotlinsample.model.local.RepositoryEntity
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import org.koin.android.viewmodel.ext.android.sharedViewModel
import java.util.ArrayList

class RepositoryFragment : Fragment() {

    private val TAG=RepositoryFragment::class.java.simpleName
    private lateinit var binding: FragmentRepositoryBinding
    private val viewModel:RepositoryViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding=FragmentRepositoryBinding.inflate(inflater,container,false)
        context?:return binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        viewModel.getUserRepository()
        binding.viewModel=viewModel
        viewModel.repositoryLiveData.observe(viewLifecycleOwner, Observer { state->
            when(state){
                is State.Loading -> {
                    binding.isErrorOccurred = false
                    binding.isLoading = true
                    binding.showReposList = false
                }
                is State.Success -> {
                    Handler().postDelayed({ // Added some delay, so we can see loader because it fetches data fast from database
                        binding.isErrorOccurred = false
                        binding.isLoading = false
                        binding.showReposList = true
                        val reposList=state.data as ArrayList<RepositoryEntity>
                        viewModel.repositoryList.postValue(reposList)
                        if(reposList.isNotEmpty()){
                            reposList?.let { setRepositoryAdapterToRecyclerView(it) }
                        }else{
                            binding.isErrorOccurred = true
                            binding.showReposList = false
                            binding.errorMessage = getString(R.string.no_repos_found)
                        }
                    }, 1000)

                }
                is State.Error -> {
                    binding.isLoading = false
                    binding.showReposList = false
                    binding.isErrorOccurred = true
                    binding.errorMessage = state.errorMessage
                }
            }
        })
    }

    private fun setUpRecyclerView(){
        binding.RvRepoList.setHasFixedSize(true)
        binding.RvRepoList.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        binding.RvRepoList.itemAnimator=SlideInUpAnimator()

    }

    private fun setRepositoryAdapterToRecyclerView(repositoryList:List<RepositoryEntity>){
        val repositoryAdapter=RepositoryAdapter()
        binding.RvRepoList.apply {
            adapter=repositoryAdapter
            repositoryAdapter.setData(repositoryList)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = RepositoryFragment()
    }
}