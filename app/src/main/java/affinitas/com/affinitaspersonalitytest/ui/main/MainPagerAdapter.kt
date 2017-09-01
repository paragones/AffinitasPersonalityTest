package affinitas.com.affinitaspersonalitytest.ui.main

import affinitas.com.affinitaspersonalitytest.R
import affinitas.com.affinitaspersonalitytest.model.AnswerKey
import affinitas.com.affinitaspersonalitytest.model.QuestionItem
import android.support.v4.view.PagerAdapter
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
class MainPagerAdapter(val questionItems: List<QuestionItem>,
                       val answerKeys: List<AnswerKey>?,
                       val itemListener: (it: AnswerKey) -> Unit) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val questionItem = questionItems[position]
        var answerIndex = -1

        val view = LayoutInflater.from(container.context).inflate(R.layout.questionnaire_item, container, false)
        view.txtQuestionNumber.text = container.context.getString(R.string.question_number, position + 1)
        view.txtQuestionItem.text = questionItem.question
        var radioGroup = RadioGroup(container.context)
        radioGroup.orientation = LinearLayout.VERTICAL

        answerKeys?.let {
            answerIndex = findAnswerKey(it, questionItem)
        }

        questionItem.options.mapIndexed { index, questionText ->
            val radioButton = RadioButton(container.context)
            radioButton.text = questionText
            radioButton.setOnClickListener {
                itemListener(AnswerKey(questionItem.id, index))
            }
            radioGroup.addView(radioButton)
            if (answerIndex == index) {
                radioGroup.check(radioButton.id)
            }
        }

        container.tag?.let {
            radioGroup.check(it as Int)
        }

        view.radioOptions.addView(radioGroup)
        container.addView(view)
        return view
    }

    private fun findAnswerKey(answerKeys: List<AnswerKey>, questionItem: QuestionItem): Int {
        val answerKey = answerKeys.find { it.questionItemId == questionItem.id }
        return answerKey?.optionSelected ?: -1
    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean = view?.equals(`object`) ?: false

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {}

    override fun getCount(): Int = questionItems.size

    override fun getItemPosition(`object`: Any?): Int = PagerAdapter.POSITION_NONE

}