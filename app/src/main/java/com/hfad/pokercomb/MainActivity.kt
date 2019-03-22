package com.hfad.pokercomb

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.google.android.gms.ads.MobileAds
import com.hfad.pokercomb.Adapter.CardsAdapter
import com.hfad.pokercomb.helper.Constants
import com.hfad.pokercomb.models.Card
import com.hfad.pokercomb.models.Combination
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var constants = Constants()


    var deck = mutableListOf<Card>()
    lateinit var cardsResyclerView: RecyclerView
    lateinit var cardsAdapter: CardsAdapter
    lateinit var layoutManager: LinearLayoutManager
    var iter = 0 //variable for iteration in cardPics array
    lateinit var intent1: Intent
    lateinit var config:YandexMetricaConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        intent1 = Intent(this, GameActivity::class.java)

        MobileAds.initialize(this, "ca-app-pub-9561253976720525~7609604274")

        config = YandexMetricaConfig.newConfigBuilder("bedffc2b-c76e-4cc7-bc50-336363641dd1").build()
        YandexMetrica.activate(this, config)
        YandexMetrica.enableActivityAutoTracking(this.application)

        fab.setOnClickListener { view ->
            deck.shuffle()
            cardsAdapter.notifyDataSetChanged()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        deck.clear()

        for (i in constants.cardSuit) {
            for (j in constants.cardRank) {
                deck.add(Card(constants.cardPics[iter],j,i))
                iter++
            }
        }




        cardsResyclerView = findViewById(R.id.combo_recycler_view)
        cardsResyclerView.isNestedScrollingEnabled = false
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        cardsResyclerView.layoutManager = layoutManager
        cardsAdapter = CardsAdapter(constants.comboList, this, deck)
        cardsResyclerView.adapter = cardsAdapter
        cardsAdapter.notifyDataSetChanged()

    }




    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_game -> {

                this.startActivity(intent1)

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
