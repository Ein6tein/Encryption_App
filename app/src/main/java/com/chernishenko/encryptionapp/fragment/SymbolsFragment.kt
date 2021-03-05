package com.chernishenko.encryptionapp.fragment

import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chernishenko.encryptionapp.databinding.FragmentSymbolsBinding
import com.chernishenko.encryptionlib.decryptor.Decryptor
import com.chernishenko.encryptionlib.encryptor.Encryptor

@ExperimentalStdlibApi
class SymbolsFragment : Fragment() {

    companion object {
        const val TAG = "SymbolsFragment"
    }

    private val encryptor = Encryptor()
    private val decryptor = Decryptor()

    private lateinit var binding: FragmentSymbolsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSymbolsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etText.filters = arrayOf(InputFilter.AllCaps())
        binding.etPassword.filters = arrayOf(InputFilter.AllCaps())

        binding.btnEncrypt.setOnClickListener {
            val text = binding.etText.text
            val password = binding.etPassword.text
            if (text.isNotEmpty() && password.isNotEmpty()) {
                binding.tvResult.text = encryptor.encryptText(text.toString(), password.toString())
            }
        }

        binding.btnDecrypt.setOnClickListener {
            val text = binding.tvResult.text
            val password = binding.etPassword.text
            if (text.isNotEmpty() && password.isNotEmpty()) {
                binding.tvDecryptResult.text = decryptor.decryptText(text.toString(), password.toString())
            }
        }
    }
}