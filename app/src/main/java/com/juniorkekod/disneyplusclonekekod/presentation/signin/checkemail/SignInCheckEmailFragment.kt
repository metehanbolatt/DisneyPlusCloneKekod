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
import com.juniorkekod.disneyplusclonekekod.presentation.common.invisible
import com.juniorkekod.disneyplusclonekekod.presentation.common.visible

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

        keyListeners()
        textWatchers()
        focusChangeListeners()
        clickListeners()

    }

    private fun keyListeners() {
        binding.apply {
            input2.setOnKeyListener { _, keyCode, _ ->
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    input2.setText("")
                    input1.requestFocus()
                }
                false
            }
            input3.setOnKeyListener { _, keyCode, _ ->
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    input3.setText("")
                    input2.requestFocus()
                }
                false
            }
            input4.setOnKeyListener { _, keyCode, _ ->
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    input4.setText("")
                    input3.requestFocus()
                }
                false
            }
            input5.setOnKeyListener { _, keyCode, _ ->
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    input5.setText("")
                    input4.requestFocus()
                }
                false
            }
            input6.setOnKeyListener { _, keyCode, _ ->
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    input6.setText("")
                    input5.requestFocus()
                }
                false
            }
        }
    }

    private fun textWatchers() {
        binding.apply {
            input1.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (!s.isNullOrBlank()) {
                        input2.requestFocus()
                    }
                }
            })
            input2.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (!s.isNullOrBlank()) {
                        input3.requestFocus()
                    } else {
                        input1.requestFocus()
                    }
                }
            })
            input3.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (!s.isNullOrBlank()) {
                        input4.requestFocus()
                    } else {
                        input2.requestFocus()
                    }
                }
            })
            input4.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (!s.isNullOrBlank()) {
                        input5.requestFocus()
                    } else {
                        input3.requestFocus()
                    }
                }
            })
            input5.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (!s.isNullOrBlank()) {
                        input6.requestFocus()
                    } else {
                        input4.requestFocus()
                    }
                }
            })
            input6.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (s.isNullOrBlank()) {
                        input5.requestFocus()
                    }
                }
            })
        }
    }

    private fun focusChangeListeners() {
        binding.apply {
            input1.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    allCursorInvisible()
                    cursor1.isVisible = true
                }
            }
            input2.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    allCursorInvisible()
                    cursor2.isVisible = true
                }
            }
            input3.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    allCursorInvisible()
                    cursor3.isVisible = true
                }
            }
            input4.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    allCursorInvisible()
                    cursor4.isVisible = true
                }
            }
            input5.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    allCursorInvisible()
                    cursor5.isVisible = true
                }
            }
            input6.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    allCursorInvisible()
                    cursor6.visible()
                }
            }
        }
    }

    private fun clickListeners() {
        binding.apply {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }
            focusControlView.setOnClickListener {
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
        binding.apply {
            cursor1.invisible()
            cursor2.invisible()
            cursor3.invisible()
            cursor4.invisible()
            cursor5.invisible()
            cursor6.invisible()
        }
    }
}