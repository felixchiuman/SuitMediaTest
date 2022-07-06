package com.felix.suitmedia.ui.third

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.felix.suitmedia.R
import com.felix.suitmedia.data.api.resource.Status
import com.felix.suitmedia.databinding.FragmentThirdPageBinding
import com.felix.suitmedia.model.userData
import com.felix.suitmedia.ui.base.BaseFragment
import com.felix.suitmedia.ui.first.FirstPageFragment
import com.felix.suitmedia.ui.second.SecondPageFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ThirdPageFragment : BaseFragment<FragmentThirdPageBinding>(FragmentThirdPageBinding::inflate) {

    private val thirdPageViewModel: ThirdPageViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        thirdPageViewModel.getUsers()

        user()
    }

    private fun user() {
        val name = arguments?.getString(SecondPageFragment.extraName)

        thirdPageViewModel.user.observe(viewLifecycleOwner){
            when(it.status){
                Status.SUCCESS -> {
                    val adapter = ThirdPageAdapter(object : ThirdPageAdapter.OnClickListener{
                        override fun onClickItem(data: userData) {
                            val actionToFragmentKedua = ThirdPageFragmentDirections.actionThirdPageFragmentToSecondPageFragment(
                                name.toString(),
                                data.firstName,
                                data.lastName)
                            findNavController().navigate(actionToFragmentKedua)
                        }

                    })
                    adapter.submitData(it.data?.body()?.data)
                    binding.rvList.adapter = adapter
                    binding.pbLoad.visibility = View.GONE
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_LONG).show()
                }
                Status.LOADING -> {
                    binding.pbLoad.visibility = View.VISIBLE
                }
            }
        }
    }
}