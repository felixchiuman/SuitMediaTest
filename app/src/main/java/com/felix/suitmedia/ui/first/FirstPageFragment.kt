package com.felix.suitmedia.ui.first

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Path
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.felix.suitmedia.R
import com.felix.suitmedia.databinding.FragmentFirstPageBinding
import com.felix.suitmedia.ui.base.BaseFragment

class FirstPageFragment :
    BaseFragment<FragmentFirstPageBinding>(FragmentFirstPageBinding::inflate) {

    companion object {
        val extraName = "EXTRA_NAME"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCheck.setOnClickListener {
            val originalString = binding.etPalindrome.editText?.text.toString()
            var reverseString = ""
            var length = originalString.length
            val dialog = AlertDialog.Builder(requireContext())
            dialog.setTitle("Result")

            for (i in (length - 1) downTo 0) {
                reverseString += originalString[i]
            }

            if (originalString.equals(reverseString, ignoreCase = true)) {
                dialog.setMessage("$originalString is a palindrome")
            } else {
                dialog.setMessage("$originalString is not a palindrome")
            }
            dialog.setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
            })
            dialog.show()
        }

        binding.btnNext.setOnClickListener {
            if (binding.etName.editText?.text.toString().isEmpty()) {
                Toast.makeText(requireContext(), "Please enter your name", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val bundle = Bundle()
                bundle.putString(extraName, binding.etName.editText?.text.toString())
                it.findNavController().navigate(R.id.action_firstPageFragment_to_secondPageFragment, bundle)
            }
        }
    }
}

