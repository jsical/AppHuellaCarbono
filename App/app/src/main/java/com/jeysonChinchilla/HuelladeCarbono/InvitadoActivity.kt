package com.jeysonChinchilla.HuelladeCarbono

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth



enum class ProviderType{
    BASIC,
    GOOGLE
}

class InvitadoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invitado)

        //Setup
        setup()
    }

    private fun setup(){
        title = "Invitado"

        val botonClose = findViewById<Button>(R.id.botonCerrarSesion)
        botonClose.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            goToHome()
        }

        val botonElectricidad = findViewById<Button>(R.id.botonDatos)
        botonElectricidad.setOnClickListener{
            goToDatos()
        }
    }

    private fun goToDatos(){
        val i = Intent(this, ElectricidadActivity::class.java)
        startActivity(i)

    }

    private fun goToHome(){
        val i = Intent(this, HomeActivity::class.java)
        startActivity(i)
    }
}