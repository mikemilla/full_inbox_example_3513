package com.example.inboxbroken

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope
import com.courier.android.Courier
import com.courier.android.modules.signIn
import com.courier.android.modules.signOut
import com.example.inboxbroken.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Courier.initialize(this)

        refreshUser()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun refreshUser() {

        lifecycleScope.launch {

            // You should call this where you normally manage your users state
            // For this example, we are calling it now to ensure we have a fresh user
            Courier.shared.signOut()

            // Sign the user in
            // Again, this should be called where you manage your user's state
            Courier.shared.signIn(
                userId = "example_user",
                accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6InVzZXJfaWQ6ZXhhbXBsZV91c2VyIHdyaXRlOnVzZXItdG9rZW5zIGluYm94OnJlYWQ6bWVzc2FnZXMgaW5ib3g6d3JpdGU6ZXZlbnRzIHJlYWQ6cHJlZmVyZW5jZXMgd3JpdGU6cHJlZmVyZW5jZXMgcmVhZDpicmFuZHMiLCJ0ZW5hbnRfc2NvcGUiOiJwdWJsaXNoZWQvcHJvZHVjdGlvbiIsInRlbmFudF9pZCI6IjZhNTFiZjhjLWFkMmUtNDJiZi1iZTZhLTgzODViNWQ0YTBmNSIsImlhdCI6MTczMDMxODYwNiwiZXhwIjoxNzM4OTU4NjA2LCJqdGkiOiJkMDBlYzIxMS0xZDI4LTQ3YmItOGE2Ni0wZGMzNDBhNTU2OTQifQ.Za9-TOEanVSyJ3HhqM1b0IVFDlf1t4_-a6wOjWHXzow"
            )

        }

    }

}