package bes.max.tictactoe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import bes.max.tictactoe.R
import bes.max.tictactoe.databinding.FragmentGameBinding
import bes.max.tictactoe.model.GameViewModel

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val gameViewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = gameViewModel
            gameFragment = this@GameFragment
        }
        val cellsObserver = Observer<MutableMap<Int, Char>> {
            binding.first.text = it[1].toString()
            binding.second.text = it[2].toString()
            binding.third.text = it[3].toString()
            binding.fourth.text = it[4].toString()
            binding.fifth.text = it[5].toString()
            binding.sixth.text = it[6].toString()
            binding.seventh.text = it[7].toString()
            binding.eighth.text = it[8].toString()
            binding.ninth.text = it[9].toString()
        }
        gameViewModel.gameField.observe(viewLifecycleOwner, cellsObserver)
    }

    fun checkUserMove(cellNumber: Int) {
        if (gameViewModel.makeUserMove(cellNumber)) {
            Toast.makeText(activity, getString(R.string.move_ok), Toast.LENGTH_SHORT).show()
            if (!isGameOver()) {
                gameViewModel.makeComputerMove()
                isGameOver()
            }
        } else {
            Toast.makeText(activity, getString(R.string.move_nok), Toast.LENGTH_SHORT).show()
        }
    }

    private fun isGameOver(): Boolean {
        val result = gameViewModel.checkForGameToContinue()
        if (result) {
            findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
        }
        return result
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}