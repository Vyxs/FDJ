package fr.vyxs.fdjapp.app.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.vyxs.fdjapp.domain.repository.AppRepository

class MainViewModelFactory(
    private val repository: AppRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AppRepository::class.java)
            .newInstance(repository)
    }
}