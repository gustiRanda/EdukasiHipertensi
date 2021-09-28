package com.gmind.edukasihipertensi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Html
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.gmind.edukasihipertensi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    private lateinit var tipsAdapter : TipsSliderAdapter
    private val tipsList = ArrayList<TipsKesehatan>()
    private lateinit var dots: ArrayList<TextView>

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    private lateinit var listItemAdapter: ListItemAdapter
    private val itemList = ArrayList<Hipertensi>()
    private lateinit var rvItem: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable{
            var index = 0
            override fun run() {
                if (index == tipsList.size)
                    index = 0
                Log.e("Runnable ", "$index")
                activityMainBinding.viewPager.currentItem = index
                index++
                handler.postDelayed(this, 2000)
            }
        }

        tipsList.addAll(TipsKesehatanData.listTips)

        tipsAdapter = TipsSliderAdapter(tipsList)
        activityMainBinding.viewPager.adapter = tipsAdapter
        dots = ArrayList()
        setDotIndicator()

        activityMainBinding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                selectedDots(position)
                super.onPageSelected(position)
            }
        })

        rvItem = activityMainBinding.rvItem
        rvItem.setHasFixedSize(true)

        itemList.addAll(HipertensiData.listData)

        rvItem.layoutManager = LinearLayoutManager(this)
        listItemAdapter = ListItemAdapter(itemList)
        rvItem.adapter = listItemAdapter
        activityMainBinding.scroll?.attachRecyclerView(rvItem)

        listItemAdapter.setOnItemClickCallback(object : ListItemAdapter.OnItemClickCallback{
            override fun onItemClicked(hipertensi: Hipertensi) {
                if (hipertensi.contentAsset == R.raw.test){

                    val intent = Intent(this@MainActivity, DetailVideoActivity::class.java)
                    intent.putExtra(DetailVideoActivity.EXTRA_HIPERTENSI, hipertensi)
                    startActivity(intent)

                } else {
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_HIPERTENSI, hipertensi)
                    startActivity(intent)
                }

            }

        })

    }

    private fun selectedDots(position: Int) {
        for (i in 0 until tipsList.size){
            if (i == position)
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.black))
            else
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.white))
        }
    }

    private fun setDotIndicator() {
        for (i in 0 until tipsList.size){
            dots.add(TextView(this))
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                dots[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()
            } else {
                dots[i].text = Html.fromHtml("&#9679")
            }
            dots[i].textSize = 18f
            activityMainBinding.dotIndicator.addView(dots[i])
        }
    }

    override fun onStart() {
        super.onStart()
        handler.post(runnable)
    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(runnable)
    }
}