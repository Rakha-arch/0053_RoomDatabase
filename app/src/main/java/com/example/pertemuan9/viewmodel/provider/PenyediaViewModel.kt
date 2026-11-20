package com.example.pertemuan9.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan9.AplikasiSiswa

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            _root_ide_package_.com.example.pertemuan9.viewmodel.HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        initializer {
            _root_ide_package_.com.example.pertemuan9.viewmodel.EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        //edit : tambah initializer untuk DetailViewModel dan EditViewModel
        initializer {
            _root_ide_package_.com.example.pertemuan9.viewmodel.DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }

        initializer {
            _root_ide_package_.com.example.pertemuan9.viewmodel.EditViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }

    }
}
/**
 * Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah instance dari
 * [AplikasiSiswa].
 */
fun CreationExtras.aplikasiSiswa():AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
