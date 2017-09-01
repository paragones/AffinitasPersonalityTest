package affinitas.com.affinitaspersonalitytest.ui.main

import affinitas.com.affinitaspersonalitytest.R
import affinitas.com.affinitaspersonalitytest.model.Category
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.questionnaire_item.view.*


/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 9/1/2017.
 */
class MainPagerAdapter(val questionItems: List<QuestionItem>) : PagerAdapter() {
//    private var subQuestionItems: List<QuestionItem>
//
//    init {
//        subQuestionItems = questionItems.filter { it.category == category }
//    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val questionItem = questionItems[position]
        val view = LayoutInflater.from(container.context).inflate(R.layout.questionnaire_item, container, false)
        view.txtQuestionNumber.text = container.context.getString(R.string.question_number, position + 1)
        view.txtQuestionItem.text = questionItem.question
        val radioGroup = RadioGroup(container.context)
        radioGroup.orientation = LinearLayout.VERTICAL

        questionItem.options.map {
            val rdbtn = RadioButton(container.context)
            rdbtn.text = it
            rdbtn.setOnClickListener {
                Log.e("MainPagerAdapter", "text: $it")
            }
            radioGroup.addView(rdbtn)
        }

        view.radioOptions.addView(radioGroup)
        container.addView(view)
        return view
    }

//    fun changeCategory(category: Category) {
//        subQuestionItems = questionItems.filter { it.category == category }
//    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean = view?.equals(`object`) ?: false

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int = questionItems.size

    override fun getItemPosition(`object`: Any?): Int = PagerAdapter.POSITION_NONE

}