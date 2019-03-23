package com.hfad.pokercombV2.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.hfad.pokercombV2.R
import com.hfad.pokercombV2.helpers.CardsHelper
import com.hfad.pokercombV2.helpers.ItemClickListener
import com.hfad.pokercombV2.models.Card
import com.hfad.pokercombV2.models.Combination

class CardsAdapter(private var values: List<Combination>, var context: Context, var deck: List<Card>): RecyclerView.Adapter<CardsAdapter.CardsViewHolder>() {


    var cardsHelper = CardsHelper()


    override fun onBindViewHolder(p0: CardsViewHolder, p1: Int) {

        val item = values[p1]


        cardsHelper.setPics(p0,cardsHelper.takePics(item.getPics(), deck),context)

        bindElements(p0,item)


    }

    private fun bindElements(p0: CardsViewHolder, item:Combination) {
        p0.comboTitle.text = item.getComboName()
        p0.comboDesc.text = item.getComboDesc()
        p0.comboProb.text = item.getProbability()

        p0.setItemClickListener(object: ItemClickListener {
            override fun onClick(v: View, position: Int, isLongClick: Boolean) {

                cardsHelper.setPics(p0,cardsHelper.takePics(item.getPics(), deck),context)

            }

        })
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }



    override fun getItemCount(): Int {
        return values.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardsViewHolder {

        val view:View = LayoutInflater.from(p0.context).inflate(R.layout.combo_item_view, p0, false)
        return CardsViewHolder(view)

    }

    class CardsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnLongClickListener, View.OnClickListener {

        fun setItemClickListener(itemClickListener: ItemClickListener) {

            this.itemClickListener = itemClickListener

        }

        override fun onClick(v: View) {

            itemClickListener.onClick(v, adapterPosition, false)
            //v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.tap))

        }

        override fun onLongClick(v: View): Boolean {

            return true

        }

        private var comboCard: CardView = itemView.findViewById(R.id.combo_card)
        var comboTitle: TextView = itemView.findViewById(R.id.combo_item_title)
        var comboDesc: TextView = itemView.findViewById(R.id.combo_item_desc)
        var comboProb: TextView = itemView.findViewById(R.id.combo_item_prob)
        var pic1: ImageView = itemView.findViewById(R.id.image1)
        var pic2: ImageView = itemView.findViewById(R.id.image2)
        var pic3: ImageView = itemView.findViewById(R.id.image3)
        var pic4: ImageView = itemView.findViewById(R.id.image4)
        var pic5: ImageView = itemView.findViewById(R.id.image5)

        private lateinit var itemClickListener: ItemClickListener


        init {
            comboCard.setOnClickListener(this)
            comboCard.setOnLongClickListener(this)
        }

    }

}