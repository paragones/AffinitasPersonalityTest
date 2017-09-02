package affinitas.com.affinitaspersonalitytest.ui.base

import affinitas.com.affinitaspersonalitytest.schedulers.ThreadScheduler
import rx.Observable
import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */

abstract class BasePresenter<T>(protected var scheduler: ThreadScheduler) {
    protected var view: T? = null

    fun attach(view: T) {
        this.view = view
    }

    fun detach() {
        this.view = null
    }

    protected fun <T> observeOn(): Observable.Transformer<T, T> {
        return scheduler.compose<T>()
    }
}