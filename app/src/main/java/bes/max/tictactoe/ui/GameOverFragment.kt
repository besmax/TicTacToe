package bes.max.tictactoe.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import bes.max.tictactoe.R
import bes.max.tictactoe.databinding.FragmentGameOverBinding
import bes.max.tictactoe.model.GameViewModel

class GameOverFragment : Fragment() {

    private var _binding: FragmentGameOverBinding? = null
    val binding get() = _binding!!
    private val gameViewModel: GameViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameOverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = gameViewModel
            gameOverFragment = this@GameOverFragment
        }
        when (gameViewModel.winner.value) {
            "user" -> binding.textviewGameover.text = getString(R.string.gameover_win)
            "computer" -> binding.textviewGameover.text = getString(R.string.gameover_lost)
            else -> binding.textviewGameover.text = getString(R.string.gameover_draw)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}