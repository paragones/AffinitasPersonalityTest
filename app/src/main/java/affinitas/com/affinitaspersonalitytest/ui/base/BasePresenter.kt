package affinitas.com.affinitaspersonalitytest.ui.base

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */

abstract class BasePresenter<T> {
    protected var view: T? = null

    fun attach(view: T) {
        this.view = view
    }

    fun detach() {
        this.view = null
    }
}