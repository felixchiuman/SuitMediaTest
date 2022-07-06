package com.felix.suitmedia.ui.second

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.felix.suitmedia.R
import com.felix.suitmedia.databinding.FragmentSecondPageBinding
import com.felix.suitmedia.ui.base.BaseFragment
import com.felix.suitmedia.ui.first.FirstPageFragment
import com.felix.suitmedia.ui.third.ThirdPageFragment

class SecondPageFragment : BaseFragment<FragmentSecondPageBinding>(FragmentSecondPageBinding::inflate){

    companion object {
        val extraName = "EXTRA_NAME"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString(FirstPageFragment.extraName)

        if (name != null) {
            binding.tvUser.text = name
        }else{
            val args: SecondPageFragmentArgs by navArgs()

            val username = args.name
            val first = args.first
            val last = args.last

            binding.tvUser.text = username
            binding.tvSelected.text = "$first $last"
        }

        binding.ivBack.setOnClickListener {
            it.findNavController().navigate(R.id.action_secondPageFragment_to_firstPageFragment)
        }

        binding.btnSelect.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(extraName, binding.tvUser.text.toString())
            it.findNavController()
                .navigate(R.id.action_secondPageFragment_to_thirdPageFragment, bundle)
        }
    }
}