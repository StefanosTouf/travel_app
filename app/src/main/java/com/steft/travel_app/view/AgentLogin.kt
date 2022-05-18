package com.steft.travel_app.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import com.steft.travel_app.R
import com.steft.travel_app.databinding.FragmentAgentLoginBinding
import com.steft.travel_app.viewmodel.LoginRegisterViewModel
import java.util.*


class AgentLogin : Fragment() {

    private val viewModel by activityViewModels<LoginRegisterViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //αν πατήσει login σε νέο activity
        val bind = FragmentAgentLoginBinding.inflate(layoutInflater)


        bind.loginButton.setOnClickListener {
            val username = bind.usernamelogin.text.toString()
            val password = bind.passowordlogin.text.toString()

            try {
                viewModel
                    .login(username,password)
                    .observe(viewLifecycleOwner) {
                            if(it){//(it!==null)
                                println("-------TEST---------True")
                                val intent = Intent(this@AgentLogin.requireContext(),LoginActivity::class.java)
                                startActivity(intent)
//                                val intent = Intent(this@AgentLogin.requireContext(), LoginActivity::class.java)
//                                val b = Bundle()
//                                b.putString("id", UUID.fromString(it)) //Your id
//                                intent.putExtras(b) //Put your id to your next Intent
//                                startActivity(intent)
                            }else{
                                Toast.makeText(context, "Wrong credentials", Toast.LENGTH_LONG).show()
                            }
                        }
            } catch (ex: Exception) {
                //Do something
                println(ex.message)
            }


        }

        //αν πατήσει register σε νέο fragment
        bind.gotoRegisterButton.setOnClickListener {
            findNavController().navigate(R.id.action_agentLogin_to_registerFragment)
            /*
                val register = RegisterFragment()
                val transaction : FragmentTransaction = requireFragmentManager().beginTransaction()
                transaction.replace(R.id.agentLoginLayout, register)
                transaction.commit()
            */
        }


        // Inflate the layout for this fragment
        return bind.root //inflater.inflate(R.layout.fragment_agent_login, container, false)
    }


}