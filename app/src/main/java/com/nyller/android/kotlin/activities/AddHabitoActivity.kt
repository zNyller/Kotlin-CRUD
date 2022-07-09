package com.nyller.android.kotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import com.nyller.android.kotlin.MainActivity
import com.nyller.android.kotlin.R
import com.nyller.android.kotlin.databinding.ActivityAddHabitoBinding

class AddHabitoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddHabitoBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddHabitoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSalvar.setOnClickListener(View.OnClickListener {

            val usuariosMap = hashMapOf(
                "nome" to binding.editNome.text.toString(),
                "turno" to binding.editTurno.text.toString(),
                "categoria" to binding.editCategoria.text.toString())

            db.collection("habitos").add(usuariosMap)
                .addOnCompleteListener {
                    Log.i("Db Firestore", "Sucesso ao salvar dados!")
                }.addOnFailureListener {
                    Log.i("Erro Firestore", "Erro ao salvar dados!")
                }
        })

        binding.btnAbrir.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        })

    }
}