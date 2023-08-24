package fr.vyxs.fdjapp.app.ui.fragment

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import fr.vyxs.fdjapp.app.vm.MainViewModelFactory
import fr.vyxs.fdjapp.app.vm.MainViewModel
import fr.vyxs.fdjapp.app.ui.component.TeamBadgeGridAdapter
import fr.vyxs.fdjapp.R
import fr.vyxs.fdjapp.app.common.Navigation.ARG_TEAM_NAME
import fr.vyxs.fdjapp.app.common.debounceMap
import fr.vyxs.fdjapp.databinding.FragmentLeagueSearchBinding
import fr.vyxs.fdjapp.domain.database.Db
import fr.vyxs.fdjapp.domain.model.TeamBadge

class SearchLeagueFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels { MainViewModelFactory(Db.repository) }
    private var _binding: FragmentLeagueSearchBinding? = null
    private val binding get() = _binding
    private val debounce = debounceMap(
        consumer = { if (it.isNotEmpty()) viewModel.setLeagueName(it) },
        map = Editable::toString
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLeagueSearchBinding.inflate(inflater, container, false)
        binding?.autoCompleteTextViewSearchLeague?.addTextChangedListener { it?.let(debounce) }
        binding?.gridViewSearchResult?.adapter = TeamBadgeGridAdapter(::onTeamBadgeClick)
        binding?.cancel?.setOnClickListener { eraseSearchContent() }
        viewModel.getAllLeagueName().observe(viewLifecycleOwner, ::setSearchView)
        viewModel.getFilteredTeamBadges().observe(viewLifecycleOwner, ::setTeamBadges)
        return binding!!.root
    }

    private fun onTeamBadgeClick(teamBadge: TeamBadge) {
        findNavController().navigate(R.id.action_searchLeagueFragment_to_leagueDetailsFragment, Bundle().apply {
            putString(ARG_TEAM_NAME, teamBadge.teamName)
        })
    }

    private fun eraseSearchContent() {
        binding?.autoCompleteTextViewSearchLeague?.setText("")
    }

    private fun setSearchView(list: List<String>) {
        binding?.autoCompleteTextViewSearchLeague?.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                list
            )
        )
    }

    private fun setTeamBadges(teamBadges: List<TeamBadge>) {
        binding?.gridViewSearchResult?.adapter.let { adapter ->
            if (adapter is TeamBadgeGridAdapter) {
                adapter.submitList(teamBadges)
            }
        }
    }
}