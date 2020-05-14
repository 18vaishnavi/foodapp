package com.sagagroup.greedy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.sagagroup.greedy.*
import com.sagagroup.greedy.fragment.*

class HomeActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var navigationView: NavigationView
    lateinit var coordinateLayout: CoordinatorLayout
    lateinit var frameLayout: FrameLayout

    var previousmenuitem:MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navigationView)
        coordinateLayout = findViewById(R.id.coordinateLayout)
        frameLayout = findViewById(R.id.frameLayout)
        setUpToolbar()

        openHome()
        val actionbardrawertrogle = ActionBarDrawerToggle(
            this@HomeActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionbardrawertrogle)
        actionbardrawertrogle.syncState()
        navigationView.setNavigationItemSelectedListener {

           if(previousmenuitem != null){
                previousmenuitem?.isChecked = false
            }
            it.isCheckable = true
            it.isChecked = true
            previousmenuitem = it

            when(it.itemId)
            {

                R.id.Home -> {
                    openHome()
                    drawerLayout.closeDrawers()
                }
                R.id.profile -> {

                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            ProfileFragment()
                        )

                        .commit()
                    supportActionBar?.title = "profile"

                    drawerLayout.closeDrawers()


                }
                R.id.favpage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            FavrestaurantFragment()
                        )

                        .commit()
                    supportActionBar?.title = "favotite Restorents"

                    drawerLayout.closeDrawers()



                }
                R.id.faqpage ->
                {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            FaqFragment()
                        )

                        .commit()
                    supportActionBar?.title = "faq page"

                    drawerLayout.closeDrawers()

                }
                R.id.logout ->
                {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            LogoutFragment()
                        )

                        .commit()
                    supportActionBar?.title = "logout"

                    drawerLayout.closeDrawers()



                }

            }
            return@setNavigationItemSelectedListener true
        }

    }

    fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Toolbar title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)

    }

    fun  openHome()
    {
        val fragement = HomeFragment()
        val  transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,fragement)
        transaction.commit()
        supportActionBar?.title = "Home"
        navigationView.setCheckedItem(R.id.Home)
    }
  override  fun onBackPressed()
  {
      val frag = supportFragmentManager.findFragmentById(R.id.frameLayout)

      when(frag)
      {
          !is HomeFragment -> openHome()
          else -> super.onBackPressed()
      }
  }



}
