package com.juniorkekod.disneyplusclonekekod.presentation.signin.checkemail

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.juniorkekod.disneyplusclonekekod.databinding.FragmentSignInCheckEmailBinding

class SignInCheckEmailFragment : Fragment() {

    private var _binding: FragmentSignInCheckEmailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInCheckEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.focusControlView.setOnClickListener {
            val input2 = binding.input2.text.isNullOrBlank()
            val input3 = binding.input3.text.isNullOrBlank()
            val input4 = binding.input4.text.isNullOrBlank()
            val input5 = binding.input5.text.isNullOrBlank()
            val input6 = binding.input6.text.isNullOrBlank()

            if (input2 && input3 && input4 && input5 && input6) {
                binding.input1.requestFocus()
                showKeyboard(binding.input1, it.context)
            }
        }

        binding.input2.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                binding.input2.setText("")
                binding.input1.requestFocus()
            }
            false
        }

        binding.input3.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                binding.input3.setText("")
                binding.input2.requestFocus()
            }
            false
        }

        binding.input4.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                binding.input4.setText("")
                binding.input3.requestFocus()
            }
            false
        }

        binding.input5.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                binding.input5.setText("")
                binding.input4.requestFocus()
            }
            false
        }

        binding.input6.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                binding.input6.setText("")
                binding.input5.requestFocus()
            }
            false
        }


        binding.input1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrBlank()) {
                    binding.input2.requestFocus()
                }
            }
        })

        binding.input2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrBlank()) {
                    binding.input3.requestFocus()
                } else {
                    binding.input1.requestFocus()
                }
            }
        })

        binding.input3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrBlank()) {
                    binding.input4.requestFocus()
                } else {
                    binding.input2.requestFocus()
                }
            }
        })

        binding.input4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrBlank()) {
                    binding.input5.requestFocus()
                } else {
                    binding.input3.requestFocus()
                }
            }
        })

        binding.input5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrBlank()) {
                    binding.input6.requestFocus()
                } else {
                    binding.input4.requestFocus()
                }
            }
        })

        binding.input6.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrBlank()) {
                    binding.input5.requestFocus()
                }
            }
        })

        binding.input1.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                allCursorInvisible()
                binding.cursor1.isVisible = true
            }
        }

        binding.input2.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                allCursorInvisible()
                binding.cursor2.isVisible = true
            }
        }

        binding.input3.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                allCursorInvisible()
                binding.cursor3.isVisible = true
            }
        }

        binding.input4.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                allCursorInvisible()
                binding.cursor4.isVisible = true
            }
        }

        binding.input5.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                allCursorInvisible()
                binding.cursor5.isVisible = true
            }
        }

        binding.input6.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                allCursorInvisible()
                binding.cursor6.isVisible = true
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showKeyboard(mEtSearch: View, context: Context) {
        val imm: InputMethodManager =
            context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(mEtSearch, 0)
    }

    private fun allCursorInvisible() {
        binding.cursor1.isVisible = false
        binding.cursor2.isVisible = false
        binding.cursor3.isVisible = false
        binding.cursor4.isVisible = false
        binding.cursor5.isVisible = false
        binding.cursor6.isVisible = false
    }
}