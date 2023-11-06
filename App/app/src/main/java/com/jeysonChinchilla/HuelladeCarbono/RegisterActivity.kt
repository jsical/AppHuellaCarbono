package com.jeysonChinchilla.HuelladeCarbono

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Setup
        setup()
    }

    private fun setup(){
        title = "Autenticación"

        val singUpB = findViewById<Button>(R.id.singUpButton)
        val emailText = findViewById<EditText>(R.id.emailEditText)
        val passwordText = findViewById<EditText>(R.id.passwordEditText)
        singUpB.setOnClickListener{
            if (emailText.text.isNotEmpty() && passwordText.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(emailText.text.toString(), passwordText.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            showInvitado(it.result?.user?.email ?: "", ProviderType.BASIC)
                        }else{
                            showAlert()
                        }
                    }
            }

        }

        val singInB = findViewById<Button>(R.id.singInButton)
        singInB.setOnClickListener{
            if (emailText.text.isNotEmpty() && passwordText.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(emailText.text.toString(), passwordText.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            showElectricidad(it.result?.user?.email ?: "", ProviderType.BASIC)
                        }else{
                            showAlert()
                        }
                    }
            }

        }

    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showInvitado(email: String, provider: ProviderType){
        val invitadoIntent = Intent(this, InvitadoActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }

        startActivity(invitadoIntent)

    }

    private fun showElectricidad(email: String, provider: ProviderType){
        val electricidadIntent = Intent(this, ElectricidadActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }

        startActivity(electricidadIntent)

    }


}