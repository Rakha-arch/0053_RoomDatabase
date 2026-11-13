package com.example.pertemuan9.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pertemuan9.room.Siswa
import com.example.pertemuan9.uicontroller.DestinasiNavigasi
import com.example.pertemuan9.uicontroller.SiswaTopAppBar
import com.example.pertemuan9.viewmodel.HomeViewModel
import com.example.pertemuan9.viewmodel.PenyediaViewModel

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = com.example.pertemuan9.R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val uiStateSiswa by viewModel.homeUiState.collectAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            SiswaTopAppBar(title = "Daftar Siswa", canNavigateBack = false)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = navigateToItemEntry) {
                Icon(Icons.Default.Add, contentDescription = "Tambah siswa")
            }
        }
    ) { innerPadding ->
        BodyHome(
            itemSiswa = uiStateSiswa.listSiswa,
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        )
    }
}

@Composable
fun BodyHome(itemSiswa: List<Siswa>, modifier: Modifier = Modifier) {
    if (itemSiswa.isEmpty()) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Belum ada data siswa")
        }
    } else {
        ListSiswa(itemSiswa = itemSiswa, modifier = modifier)
    }
}

@Composable
fun ListSiswa(itemSiswa: List<Siswa>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = itemSiswa, key = { it.id }) { siswa ->
            DataSiswa(siswa = siswa, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun DataSiswa(siswa: Siswa, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(siswa.nama, style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.weight(1f))
                Icon(Icons.Default.Phone, contentDescription = null)
                Text(siswa.telpon, style = MaterialTheme.typography.titleMedium)
            }
            Text(siswa.alamat, style = MaterialTheme.typography.titleMedium)
        }
    }
}

