package com.chernishenko.encryptionapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chernishenko.encryptionapp.R
import com.chernishenko.encryptionapp.databinding.FragmentDigitsOnlyBinding
import com.chernishenko.encryptionlib.decryptor.Decryptor
import com.chernishenko.encryptionlib.encryptor.Encryptor

@ExperimentalStdlibApi
class DigitsOnlyFragment : Fragment() {

    companion object {
        const val TAG = "DigitsOnlyFragment"
    }

    private val encryptor = Encryptor()
    private val decryptor = Decryptor()

    private lateinit var binding: FragmentDigitsOnlyBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDigitsOnlyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEncrypt.setOnClickListener {
            val text = binding.etText.text
            val password = binding.etPassword.text
            if (text.isNotEmpty() && password.isNotEmpty()) {
                binding.tvResult.text = encryptor.encryptDigitsOnly(text.toString(), password.toString())
            }
        }

        binding.btnDecrypt.setOnClickListener {
            val text = binding.tvResult.text
            val password = binding.etPassword.text
            if (text.isNotEmpty() && password.isNotEmpty()) {
                binding.tvDecryptResult.text = decryptor.decryptDigitsOnly(text.toString(), password.toString())
            }
        }

        binding.btnSwitchToSymbols.setOnClickListener {
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fl_container, SymbolsFragment(), SymbolsFragment.TAG)
                ?.addToBackStack(SymbolsFragment.TAG)
                ?.commit()
        }
    }
}