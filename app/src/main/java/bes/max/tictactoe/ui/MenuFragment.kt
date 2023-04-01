package bes.max.tictactoe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import bes.max.tictactoe.R
import bes.max.tictactoe.databinding.FragmentMenuBinding
import bes.max.tictactoe.model.GameViewModel

class MenuFragment : Fragment() {

    private var binding: FragmentMenuBinding? = null
    private val gameViewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding =  FragmentMenuBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = gameViewModel
            menuFragment = this@MenuFragment
        }
    }

    fun chooseSymbol(symbol: Char) {
        gameViewModel.setSymbol(symbol)
    }

    fun play() {
        findNavController().navigate(R.id.action_menuFragment_to_gameFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}