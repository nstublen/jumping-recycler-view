package com.example.jumpingrv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jumpingrv.databinding.FragmentRecyclerBinding
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RecyclerFragment : Fragment() {

    private var _binding: FragmentRecyclerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CustomAdapter().apply {
                submitList(buildSampleList())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun buildSampleList(): List<ComposeViewState> {
        return MutableList(100) { index ->
            val text = if (index % 2 == 0) {
                "A single line of text"
            } else {
                "Multiple lines\nof text"
            }
            ComposeViewState(UUID.randomUUID(), text)
        }
    }
}
