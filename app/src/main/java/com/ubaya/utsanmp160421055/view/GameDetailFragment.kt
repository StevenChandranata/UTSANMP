package com.ubaya.utsanmp160421055.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.ubaya.utsanmp160421055.databinding.FragmentGameDetailBinding
import com.ubaya.utsanmp160421055.viewmodel.GameDetailViewModel

class GameDetailFragment : Fragment() {
    private lateinit var gdViewModel: GameDetailViewModel
    private lateinit var binding: FragmentGameDetailBinding

    private var gameId = ""
    private var currentDescriptionIndex = 0
    private lateinit var descriptions: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Detail"
        binding = FragmentGameDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gdViewModel = ViewModelProvider(requireActivity()).get(GameDetailViewModel::class.java)

        gameId = arguments?.getString("gameId") ?: ""

        gdViewModel.gameLD.observe(viewLifecycleOwner) { game ->
            game?.let {
                binding.txtdetailTitleRead.text = it.title
                binding.txtdetailCreator.text = "@" + it.creatorUsername
                descriptions = it.descriptiondetail

                updateDescription(currentDescriptionIndex)

                binding.btnPrevious.setOnClickListener {
                    if (currentDescriptionIndex > 0) {
                        currentDescriptionIndex--
                        updateDescription(currentDescriptionIndex)
                    }
                }
                binding.btnNext.setOnClickListener {
                    if (currentDescriptionIndex < descriptions.size - 1) {
                        currentDescriptionIndex++
                        updateDescription(currentDescriptionIndex)
                    }
                }
                Picasso.get()
                    .load(game.imageUrl)
                    .into(binding.imagePhoto, object : Callback {
                        override fun onSuccess() {
                            binding.progressBar.visibility = View.INVISIBLE
                            binding.imagePhoto.visibility = View.VISIBLE
                        }
                        override fun onError(e: Exception?) {
                            Log.e("picasso_error", e.toString())
                        }
                    })
            }
        }
        gdViewModel.fetch(gameId)
    }
    private fun updateDescription(index: Int) {
        binding.txtdetailDescription.text = descriptions[index]
        binding.btnPrevious.isEnabled = index > 0
        binding.btnNext.isEnabled = index < descriptions.size - 1
    }
    override fun onDestroyView() {
        super.onDestroyView()
        gdViewModel.gameLD.removeObservers(viewLifecycleOwner)
    }
}
