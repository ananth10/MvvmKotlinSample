package com.ananth.mvvmkotlinsample.features

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.ananth.mvvmkotlinsample.databinding.FragmentSearchBinding
import com.ananth.mvvmkotlinsample.utils.UserManager

class SearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=FragmentSearchBinding.inflate(inflater,container,false)
        context?:return binding.root
        binding.BtSubmit.setOnClickListener {
            val userName=binding.TetUserName.text.toString()
            if(userName.isNullOrEmpty()){
                Toast.makeText(requireActivity(), "Enter username", Toast.LENGTH_SHORT).show()
            }else {
                navigateToProfile(userName, it)
            }
        }
        return binding.root
    }

    private fun navigateToProfile(userName: String, view: View) {
        val direction = SearchFragmentDirections
            .navigateToProfile(userName)
        view.findNavController().navigate(direction)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = SearchFragment()
    }
}