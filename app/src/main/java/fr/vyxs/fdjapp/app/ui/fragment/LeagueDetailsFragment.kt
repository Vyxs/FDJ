package fr.vyxs.fdjapp.app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import fr.vyxs.fdjapp.app.common.Navigation.ARG_TEAM_NAME
import fr.vyxs.fdjapp.app.vm.MainViewModel
import fr.vyxs.fdjapp.app.vm.MainViewModelFactory
import fr.vyxs.fdjapp.databinding.FragmentLeagueDetailsBinding
import fr.vyxs.fdjapp.domain.database.Db
import fr.vyxs.fdjapp.domain.model.Team


class LeagueDetailsFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(Db.repository)
    }
    private var _binding: FragmentLeagueDetailsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeagueDetailsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onStart() {
        super.onStart()
        val teamName = arguments?.getString(ARG_TEAM_NAME) ?: ""

        binding?.buttonTeamBack?.setOnClickListener{ findNavController().popBackStack() }
        viewModel.getTeamDetails(teamName).observe(viewLifecycleOwner, ::setTeam)
    }

    private fun setTeam(team: Team) {
        binding?.imageViewTeamBanner?.load(team.teamBanner)
        binding?.textViewTeamName?.text = team.name
        binding?.textViewTeamCountry?.text = team.country
        binding?.textViewTeamLeague?.text = team.teamBadge?.leagueName
        binding?.textViewTeamDetails?.text = team.description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}