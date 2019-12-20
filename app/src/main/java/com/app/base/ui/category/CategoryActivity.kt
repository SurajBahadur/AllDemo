package com.app.base.ui.category

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.app.base.R
import com.app.base.ui.coupon.CouponsActivity
import com.app.base.ui.dashboard.SettingActivity
import com.squareup.picasso.Picasso
import com.thefinestartist.finestwebview.FinestWebView
import kotlinx.android.synthetic.main.category_entertainment.*
import kotlinx.android.synthetic.main.category_food.*
import kotlinx.android.synthetic.main.category_health.*
import kotlinx.android.synthetic.main.category_news.*
import kotlinx.android.synthetic.main.category_recharge.*
import kotlinx.android.synthetic.main.category_shopping.*
import kotlinx.android.synthetic.main.category_social.*
import kotlinx.android.synthetic.main.category_sports.*
import kotlinx.android.synthetic.main.category_utility.*
import kotlinx.android.synthetic.main.item_toolbar.*

class CategoryActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        FinestWebView.Builder(this).show(v!!.tag.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        //shopping
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_shopping_1mg.tag}").into(iv_shopping_1mg)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_shopping_ali.tag}").into(iv_shopping_ali)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_shopping_amazon.tag}").into(iv_shopping_amazon)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_shopping_firstcry.tag}").into(iv_shopping_firstcry)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_shopping_flipkart.tag}").into(iv_shopping_flipkart)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_shopping_jabong.tag}").into(iv_shopping_jabong)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_shopping_myntra.tag}").into(iv_shopping_myntra)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_shopping_paytm.tag}").into(iv_shopping_paytm)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_shopping_pepperfry.tag}").into(iv_shopping_pepperfry)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_shopping_shopclues.tag}").into(iv_shopping_shopclues)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_shopping_snapdeal.tag}").into(iv_shopping_snapdeal)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_shopping_tatacliq.tag}").into(iv_shopping_tatacliq)
        //social
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_social_fb.tag}").into(iv_social_fb)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_social_insta.tag}").into(iv_social_insta)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_social_linkedin.tag}").into(iv_social_linkedin)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_social_pinterest.tag}").into(iv_social_pinterest)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_social_quora.tag}").into(iv_social_quora)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_social_reddit.tag}").into(iv_social_reddit)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_social_skype.tag}").into(iv_social_skype)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_social_twitter.tag}").into(iv_social_twitter)
        //entertainment
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_entertainment_gaana.tag}").into(iv_entertainment_gaana)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_entertainment_hotstar.tag}").into(iv_entertainment_hotstar)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_entertainment_hungama.tag}").into(iv_entertainment_hungama)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_entertainment_saann.tag}").into(iv_entertainment_saann)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_entertainment_sharechat.tag}").into(iv_entertainment_sharechat)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_entertainment_sonyliv.tag}").into(iv_entertainment_sonyliv)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_entertainment_youtube.tag}").into(iv_entertainment_youtube)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_entertainment_zee5.tag}").into(iv_entertainment_zee5)
        //food
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_food_basket.tag}").into(iv_food_basket)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_food_basket.tag}").into(iv_food_basket)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_food_kfc.tag}").into(iv_food_kfc)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_food_panda.tag}").into(iv_food_panda)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_food_pizzahut.tag}").into(iv_food_pizzahut)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_food_swiggy.tag}").into(iv_food_swiggy)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_food_uber.tag}").into(iv_food_uber)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_food_zomato.tag}").into(iv_food_zomato)
        //utility
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_utility_bike.tag}").into(iv_utility_bike)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_utility_dict.tag}").into(iv_utility_dict)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_utility_jd.tag}").into(iv_utility_jd)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_utility_job.tag}").into(iv_utility_job)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_utility_map.tag}").into(iv_utility_map)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_utility_olx.tag}").into(iv_utility_olx)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_utility_train.tag}").into(iv_utility_train)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_utility_translate.tag}").into(iv_utility_translate)
        //sports
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_sports_cricbuzz.tag}").into(iv_sports_cricbuzz)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_sports_cricinfo.tag}").into(iv_sports_cricinfo)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_sports_cricnext.tag}").into(iv_sports_cricnext)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_sports_fifa.tag}").into(iv_sports_fifa)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_sports_football.tag}").into(iv_sports_football)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_sports_tennis.tag}").into(iv_sports_tennis)
        //recharge
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_recharge_airtel.tag}").into(iv_recharge_airtel)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_recharge_freechar.tag}").into(iv_recharge_freechar)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_recharge_jio.tag}").into(iv_recharge_jio)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_recharge_mobikwik.tag}").into(iv_recharge_mobikwik)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_recharge_paytm.tag}").into(iv_recharge_paytm)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_recharge_recharge.tag}").into(iv_recharge_recharge)
        //news
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_news_18.tag}").into(iv_news_18)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_news_aajtak.tag}").into(iv_news_aajtak)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_news_abv.tag}").into(iv_news_abv)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_news_ndtv.tag}").into(iv_news_ndtv)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_news_toi.tag}").into(iv_news_toi)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_news_zee.tag}").into(iv_news_zee)
        //health
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_health_1mg.tag}").into(iv_health_1mg)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_health_healthkart.tag}").into(iv_health_healthkart)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_health_himalaya.tag}").into(iv_health_himalaya)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_health_medlife.tag}").into(iv_health_medlife)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_health_nutrafy.tag}").into(iv_health_nutrafy)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_health_pharmeasy.tag}").into(iv_health_pharmeasy)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_health_pinhealth.tag}").into(iv_health_pinhealth)
        Picasso.get().load("https://www.google.com/s2/favicons?domain=${ll_health_netmeds.tag}").into(iv_health_netmeds)


        initClickListerns()
    }

    private fun initClickListerns() {
        //shopping
        ll_shopping_1mg.setOnClickListener(this)
        ll_shopping_ali.setOnClickListener(this)
        ll_shopping_amazon.setOnClickListener(this)
        ll_shopping_firstcry.setOnClickListener(this)
        ll_shopping_flipkart.setOnClickListener(this)
        ll_shopping_jabong.setOnClickListener(this)
        ll_shopping_myntra.setOnClickListener(this)
        ll_shopping_paytm.setOnClickListener(this)
        ll_shopping_pepperfry.setOnClickListener(this)
        ll_shopping_shopclues.setOnClickListener(this)
        ll_shopping_snapdeal.setOnClickListener(this)
        ll_shopping_tatacliq.setOnClickListener(this)
        //social
        ll_social_fb.setOnClickListener(this)
        ll_social_insta.setOnClickListener(this)
        ll_social_linkedin.setOnClickListener(this)
        ll_social_quora.setOnClickListener(this)
        ll_social_pinterest.setOnClickListener(this)
        ll_social_reddit.setOnClickListener(this)
        ll_social_twitter.setOnClickListener(this)
        ll_social_skype.setOnClickListener(this)
        //entertainment
        ll_entertainment_gaana.setOnClickListener(this)
        ll_entertainment_hotstar.setOnClickListener(this)
        ll_entertainment_hungama.setOnClickListener(this)
        ll_entertainment_saann.setOnClickListener(this)
        ll_entertainment_sharechat.setOnClickListener(this)
        ll_entertainment_sonyliv.setOnClickListener(this)
        ll_entertainment_youtube.setOnClickListener(this)
        ll_entertainment_zee5.setOnClickListener(this)
        //food
        ll_food_basket.setOnClickListener(this)
        ll_food_dominos.setOnClickListener(this)
        ll_food_kfc.setOnClickListener(this)
        ll_food_panda.setOnClickListener(this)
        ll_food_pizzahut.setOnClickListener(this)
        ll_food_swiggy.setOnClickListener(this)
        ll_food_uber.setOnClickListener(this)
        ll_food_zomato.setOnClickListener(this)
        //utility
        ll_utility_bike.setOnClickListener(this)
        ll_utility_dict.setOnClickListener(this)
        ll_utility_jd.setOnClickListener(this)
        ll_utility_job.setOnClickListener(this)
        ll_utility_map.setOnClickListener(this)
        ll_utility_olx.setOnClickListener(this)
        ll_utility_train.setOnClickListener(this)
        ll_utility_translate.setOnClickListener(this)
        //sports
        ll_sports_cricbuzz.setOnClickListener(this)
        ll_sports_cricinfo.setOnClickListener(this)
        ll_sports_cricnext.setOnClickListener(this)
        ll_sports_fifa.setOnClickListener(this)
        ll_sports_tennis.setOnClickListener(this)
        ll_sports_football.setOnClickListener(this)
        //recharge
        ll_recharge_airtel.setOnClickListener(this)
        ll_recharge_freechar.setOnClickListener(this)
        ll_recharge_jio.setOnClickListener(this)
        ll_recharge_mobikwik.setOnClickListener(this)
        ll_recharge_paytm.setOnClickListener(this)
        ll_recharge_recharge.setOnClickListener(this)
        //news
        ll_news_18.setOnClickListener(this)
        ll_news_aajtak.setOnClickListener(this)
        ll_news_abv.setOnClickListener(this)
        ll_news_ndtv.setOnClickListener(this)
        ll_news_toi.setOnClickListener(this)
        ll_news_zee.setOnClickListener(this)
        //health
        ll_health_1mg.setOnClickListener(this)
        ll_health_healthkart.setOnClickListener(this)
        ll_health_himalaya.setOnClickListener(this)
        ll_health_medlife.setOnClickListener(this)
        ll_health_netmeds.setOnClickListener(this)
        ll_health_nutrafy.setOnClickListener(this)
        ll_health_pharmeasy.setOnClickListener(this)
        ll_health_pinhealth.setOnClickListener(this)

    }

}
